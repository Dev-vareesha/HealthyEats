
package com.healthyeats.controller;

import com.healthyeats.service.CartItemService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class CustomizeController {
    private final CartItemService cartService;

    public CustomizeController(CartItemService cartService) {
        this.cartService = cartService;
    }

    @GetMapping("/customize")
    public String customizePage() {
        return "customize";
    }

    @PostMapping("/customize/add")
    public String addCustom(@RequestParam String base,
                            @RequestParam(required = false) String protein,
                            @RequestParam(required = false) String extra,
                            @RequestParam double price) {
        String name = base + (protein != null && !protein.isBlank() ? " + " + protein : "") +
                (extra != null && !extra.isBlank() ? " + " + extra : "");
        cartService.add(name, price, 1);
        return "redirect:/cart";
    }
}
