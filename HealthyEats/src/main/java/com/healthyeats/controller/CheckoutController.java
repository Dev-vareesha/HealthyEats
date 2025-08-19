package com.healthyeats.controller;

import com.healthyeats.model.OrderDetails;
import com.healthyeats.repository.OrderDetailsRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Controller
@RequestMapping("/checkout")
public class CheckoutController {

    private final OrderDetailsRepository orderDetailsRepository;

    public CheckoutController(OrderDetailsRepository orderDetailsRepository) {
        this.orderDetailsRepository = orderDetailsRepository;
    }

    @GetMapping
    public String checkoutPage() {
        return "checkout"; // checkout.jsp
    }

    @PostMapping("/confirm")
    public String confirmOrder(@ModelAttribute OrderDetails orderDetails, Model model) {
        // Generate random Order ID
        String orderId = UUID.randomUUID().toString().substring(0, 8);
        orderDetails.setOrderId(orderId);

        orderDetailsRepository.save(orderDetails);

        model.addAttribute("orderId", orderId);
        return "orderConfirmation"; // orderConfirmation.jsp
    }
}
