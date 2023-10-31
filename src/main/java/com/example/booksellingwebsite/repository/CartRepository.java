package com.example.booksellingwebsite.repository;

import com.example.booksellingwebsite.entity.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartRepository extends JpaRepository<Cart, Integer> {
}