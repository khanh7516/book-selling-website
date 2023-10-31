package com.example.booksellingwebsite.repository;

import com.example.booksellingwebsite.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, Integer> {
}