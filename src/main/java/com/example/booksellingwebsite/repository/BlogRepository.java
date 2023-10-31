package com.example.booksellingwebsite.repository;

import com.example.booksellingwebsite.entity.Blog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BlogRepository extends JpaRepository<Blog, Integer> {
}