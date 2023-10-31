package com.example.booksellingwebsite.repository;

import com.example.booksellingwebsite.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Integer> {
}