package com.example.booksellingwebsite.repository;

import com.example.booksellingwebsite.entity.BookType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookTypeRepository extends JpaRepository<BookType, Integer> {
}