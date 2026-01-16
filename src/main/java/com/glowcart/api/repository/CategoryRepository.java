package com.glowcart.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.glowcart.api.entity.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}