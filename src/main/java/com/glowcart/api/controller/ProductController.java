package com.glowcart.api.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.*;

import com.glowcart.api.dto.ProductDTO;
import com.glowcart.api.repository.ProductRepository;

@RestController
@RequestMapping("/api/products")
@CrossOrigin(origins = "*")
public class ProductController {

    private final ProductRepository repo;

    public ProductController(ProductRepository repo) {
        this.repo = repo;
    }

    @GetMapping
    public List<ProductDTO> getAll(@RequestParam(required = false) String category) {

        String baseUrl = "http://10.0.2.2:8080";

        // ✅ filter by category if passed
        var products = (category == null || category.trim().isEmpty())
                ? repo.findAll()
                : repo.findByCategoryIgnoreCase(category);

        return products.stream().map(p -> {

            ProductDTO dto = new ProductDTO();
            dto.id = p.getId();
            dto.name = p.getName();
            dto.brand = p.getBrand();
            dto.price = p.getPrice();
            dto.oldPrice = p.getOldPrice();
            dto.rating = p.getRating();
            dto.description = p.getDescription();
            dto.category = p.getCategory();

            String file = p.getImageUrl();
            if (file == null || file.trim().isEmpty()) file = "prod1.jpg";

            dto.imageUrl = baseUrl + "/images/" + file;
            return dto;

        }).collect(Collectors.toList());
    }
}
