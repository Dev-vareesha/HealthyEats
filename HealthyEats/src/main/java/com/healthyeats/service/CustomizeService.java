package com.healthyeats.service;

import com.healthyeats.model.CustomizeOption;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Arrays;

@Service
public class CustomizeService {

    public List<CustomizeOption> getAllOptions() {
        return Arrays.asList(
            new CustomizeOption("Extra Cheese", 50),
            new CustomizeOption("Extra Dressing", 20),
            new CustomizeOption("Protein Boost", 100)
        );
    }
}
