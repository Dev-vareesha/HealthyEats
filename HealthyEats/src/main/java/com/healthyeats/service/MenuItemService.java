
package com.healthyeats.service;

import com.healthyeats.model.MenuItem;
import com.healthyeats.repository.MenuItemRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MenuItemService {
    private final MenuItemRepository repo;

    public MenuItemService(MenuItemRepository repo) {
        this.repo = repo;
    }

    public List<MenuItem> getAll() { return repo.findAll(); }

    public List<MenuItem> getByCategory(String category) { return repo.findByCategory(category); }

    public MenuItem save(MenuItem item) { return repo.save(item); }
}
