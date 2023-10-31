package com.example.booksellingwebsite.repository;

import com.example.booksellingwebsite.entity.Blogger;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BloggerRepository extends JpaRepository<Blogger, Integer> {
}