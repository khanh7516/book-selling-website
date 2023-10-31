package com.example.booksellingwebsite.repository;

import com.example.booksellingwebsite.entity.PurchasedEbook;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PurchasedEbookRepository extends JpaRepository<PurchasedEbook, Integer> {
}