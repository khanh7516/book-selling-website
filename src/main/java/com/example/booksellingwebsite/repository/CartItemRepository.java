package com.example.booksellingwebsite.repository;

import com.example.booksellingwebsite.entity.CartItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartItemRepository extends JpaRepository<CartItem, Integer> {
}