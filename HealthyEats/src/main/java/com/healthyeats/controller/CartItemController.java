
package com.healthyeats.controller;

import com.healthyeats.service.CartItemService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/cart")
public class CartItemController {
    private final CartItemService cartService;

    public CartItemController(CartItemService cartService) {
        this.cartService = cartService;
    }

    @GetMapping
    public String viewCart(Model model) {
        model.addAttribute("cartItems", cartService.list());
        double total = cartService.list().stream().mapToDouble(ci -> ci.getPrice() * ci.getQuantity()).sum();
        model.addAttribute("totalPrice", total);
        return "cart";
    }

    @PostMapping("/add")
    public String addToCart(@RequestParam String name, @RequestParam double price, @RequestParam(defaultValue = "1") int quantity) {
        cartService.add(name, price, quantity);
        return "redirect:/cart";
    }

    @PostMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        cartService.delete(id);
        return "redirect:/cart";
    }
}
