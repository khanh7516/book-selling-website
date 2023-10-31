package com.example.booksellingwebsite.repository;

import com.example.booksellingwebsite.entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author, Integer> {
}