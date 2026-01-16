package com.glowcart.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.glowcart.api.entity.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {
}