package com.glowcart.api.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.*;

import com.glowcart.api.dto.CategoryDTO;
import com.glowcart.api.repository.CategoryRepository;

@RestController
@RequestMapping("/api/categories")
@CrossOrigin(origins = "*")
public class CategoryController {

    private final CategoryRepository repo;

    public CategoryController(CategoryRepository repo) {
        this.repo = repo;
    }

    @GetMapping
    public List<CategoryDTO> getAllCategories() {

        String baseUrl = "http://10.0.2.2:8080"; // emulator

        return repo.findAll().stream().map(c -> {
            CategoryDTO dto = new CategoryDTO();
            dto.id = c.getId();
            dto.name = c.getName();

            // ✅ springboot static hosted
            dto.imageUrl = baseUrl + "/images/" + c.getImageUrl();

            return dto;
        }).collect(Collectors.toList());
    }
}