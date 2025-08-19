
package com.healthyeats.service;

import com.healthyeats.model.CartItem;
import com.healthyeats.repository.CartItemRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartItemService {
    private final CartItemRepository repo;

    public CartItemService(CartItemRepository repo) {
        this.repo = repo;
    }

    public CartItem add(String name, double price, int qty) {
        return repo.save(new CartItem(name, price, qty));
    }

    public List<CartItem> list() { return repo.findAll(); }

    public void delete(Long id) { repo.deleteById(id); }

    public void clear() { repo.deleteAll(); }
}
