package com.healthyeats.controller;

import com.healthyeats.model.OrderDetails;
import com.healthyeats.repository.OrderDetailsRepository;
import com.razorpay.Order;
import com.razorpay.RazorpayClient;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Base64;

@Controller
@RequestMapping("/payment")
public class PaymentController {

    @Value("${razorpay.key_id}")
    private String razorpayKeyId;

    @Value("${razorpay.key_secret}")
    private String razorpayKeySecret;

    private final OrderDetailsRepository orderRepo;

    public PaymentController(OrderDetailsRepository orderRepo) {
        this.orderRepo = orderRepo;
    }

    @PostMapping("/create-order")
    @ResponseBody
    public String createOrder(@RequestParam double amount) {
        try {
            RazorpayClient client = new RazorpayClient(razorpayKeyId, razorpayKeySecret);

            JSONObject orderRequest = new JSONObject();
            int amountInPaise = BigDecimal.valueOf(amount)
                    .setScale(2, RoundingMode.HALF_UP)
                    .multiply(BigDecimal.valueOf(100))
                    .intValue();

            orderRequest.put("amount", amountInPaise);
            orderRequest.put("currency", "INR");
            orderRequest.put("payment_capture", 1);

            Order order = client.orders.create(orderRequest);
            return order.toString();

        } catch (Exception e) {
            e.printStackTrace();
            return "{\"error\":\"" + e.getMessage() + "\"}";
        }
    }

    @PostMapping("/verify")
    @ResponseBody
    public String verifyPayment(@RequestParam String orderId,
                                @RequestParam String paymentId,
                                @RequestParam String signature,
                                @RequestParam double amount) {
        try {
            String payload = orderId + "|" + paymentId;

            Mac mac = Mac.getInstance("HmacSHA256");
            SecretKeySpec secretKey = new SecretKeySpec(razorpayKeySecret.getBytes(), "HmacSHA256");
            mac.init(secretKey);
            byte[] digest = mac.doFinal(payload.getBytes());
            String generatedSignature = new String(Base64.getEncoder().encode(digest));

            boolean isValid = signature.equals(generatedSignature);

            OrderDetails orderDetails = new OrderDetails();
            orderDetails.setOrderId(orderId);
            orderDetails.setPaymentId(paymentId);
            orderDetails.setSignature(signature);
            orderDetails.setAmount(amount);
            orderDetails.setStatus(isValid ? "SUCCESS" : "FAILED");

            orderRepo.save(orderDetails);

            return isValid ? "Payment verified and saved!" : "Payment verification failed!";

        } catch (Exception e) {
            e.printStackTrace();
            return "Error verifying payment: " + e.getMessage();
        }
    }
}
