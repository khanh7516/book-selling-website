package com.example.booksellingwebsite.repository;

import com.example.booksellingwebsite.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Integer> {
}