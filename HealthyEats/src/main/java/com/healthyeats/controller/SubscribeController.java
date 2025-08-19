package com.healthyeats.controller;

import com.healthyeats.model.Subscription;
import com.healthyeats.repository.SubscriptionRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class SubscribeController {

    private final SubscriptionRepository subscriptionRepository;

    public SubscribeController(SubscriptionRepository subscriptionRepository) {
        this.subscriptionRepository = subscriptionRepository;
    }

    @GetMapping("/subscribe")
    public String showSubscriptions(Model model) {
        List<Subscription> plans = subscriptionRepository.findAll();
        model.addAttribute("subscriptions", plans);
        return "subscribe"; // subscribe.jsp
    }
}
