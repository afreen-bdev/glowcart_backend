package com.glowcart.api.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.glowcart.api.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findByCategoryIgnoreCase(String category);
}
