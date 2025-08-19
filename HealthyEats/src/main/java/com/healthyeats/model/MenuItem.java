
package com.healthyeats.model;

import jakarta.persistence.*;

@Entity
@Table(name = "menu_items")
public class MenuItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String category; // Fresh Salads, Energy Bowls, Cold-Pressed Juices, Detox Smoothies, Healthy Wraps
    private String description;
    private String imageUrl;
    private double price;

    public MenuItem() {}

    public MenuItem(String name, String category, String description, String imageUrl, double price) {
        this.name = name;
        this.category = category;
        this.description = description;
        this.imageUrl = imageUrl;
        this.price = price;
    }

    public Long getId() { return id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getCategory() { return category; }
    public void setCategory(String category) { this.category = category; }
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
    public String getImageUrl() { return imageUrl; }
    public void setImageUrl(String imageUrl) { this.imageUrl = imageUrl; }
    public double getPrice() { return price; }
    public void setPrice(double price) { this.price = price; }
}
