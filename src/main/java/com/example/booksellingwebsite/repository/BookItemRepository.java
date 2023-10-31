package com.example.booksellingwebsite.repository;

import com.example.booksellingwebsite.entity.BookItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookItemRepository extends JpaRepository<BookItem, Integer> {
}