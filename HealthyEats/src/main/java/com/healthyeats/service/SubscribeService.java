
package com.healthyeats.service;

import com.healthyeats.model.Subscription;
import com.healthyeats.repository.SubscriptionRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubscribeService {
    private final SubscriptionRepository repo;

    public SubscribeService(SubscriptionRepository repo) {
        this.repo = repo;
    }

    public List<Subscription> all() { return repo.findAll(); }
}
