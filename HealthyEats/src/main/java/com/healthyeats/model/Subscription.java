package com.healthyeats.model;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class Subscription {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;        // e.g. Basic, Premium, Family
    private String description; // short description
    private double price;
    private int meals;          // number of meals

    @ElementCollection
    private List<String> features; // plan features

    // Getters & Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public double getPrice() { return price; }
    public void setPrice(double price) { this.price = price; }

    public int getMeals() { return meals; }
    public void setMeals(int meals) { this.meals = meals; }

    public List<String> getFeatures() { return features; }
    public void setFeatures(List<String> features) { this.features = features; }
}
