package com.example.booksellingwebsite.repository;

import com.example.booksellingwebsite.entity.BookSeller;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookSellerRepository extends JpaRepository<BookSeller, Integer> {
}