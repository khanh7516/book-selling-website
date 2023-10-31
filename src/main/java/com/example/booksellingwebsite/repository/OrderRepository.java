package com.example.booksellingwebsite.repository;

import com.example.booksellingwebsite.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Integer> {
}