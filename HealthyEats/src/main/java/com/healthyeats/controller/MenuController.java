
package com.healthyeats.controller;

import com.healthyeats.service.MenuItemService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MenuController {
    private final MenuItemService menuService;

    public MenuController(MenuItemService menuService) {
        this.menuService = menuService;
    }

    @GetMapping("/menu")
    public String menu(@RequestParam(value = "category", required = false) String category, Model model) {
        if (category == null || category.isEmpty()) {
            model.addAttribute("items", menuService.getAll());
        } else {
            model.addAttribute("items", menuService.getByCategory(category));
        }
        model.addAttribute("category", category);
        return "menu";
    }
}
