package com.example.booksellingwebsite.repository;

import com.example.booksellingwebsite.entity.Rating;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Rating, Integer> {
}