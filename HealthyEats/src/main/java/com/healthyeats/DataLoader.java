package com.healthyeats;

import com.healthyeats.model.Subscription;
import com.healthyeats.repository.SubscriptionRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class DataLoader implements CommandLineRunner {

    private final SubscriptionRepository subscriptionRepository;

    public DataLoader(SubscriptionRepository subscriptionRepository) {
        this.subscriptionRepository = subscriptionRepository;
    }

    @Override
    public void run(String... args) {
        if (subscriptionRepository.count() == 0) {
            Subscription basic = new Subscription();
            basic.setName("Basic Plan");
            basic.setDescription("Affordable healthy meals");
            basic.setPrice(2499);
            basic.setMeals(12);
            basic.setFeatures(Arrays.asList("Weekly delivery", "Choice of salad or juice", "Basic customization", "Email support"));

            Subscription premium = new Subscription();
            premium.setName("Premium Plan");
            premium.setDescription("More meals and flexibility");
            premium.setPrice(3999);
            premium.setMeals(20);
            premium.setFeatures(Arrays.asList("Bi-weekly delivery", "Full customization", "Priority support", "Free delivery"));

            Subscription family = new Subscription();
            family.setName("Family Plan");
            family.setDescription("Meals for the whole family");
            family.setPrice(5999);
            family.setMeals(30);
            family.setFeatures(Arrays.asList("Weekly delivery", "Full customization", "24/7 support", "Family nutritionist consultation"));

            subscriptionRepository.saveAll(Arrays.asList(basic, premium, family));
        }
    }
}
