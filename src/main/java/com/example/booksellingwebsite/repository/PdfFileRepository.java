package com.example.booksellingwebsite.repository;

import com.example.booksellingwebsite.entity.PdfFile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PdfFileRepository extends JpaRepository<PdfFile, Integer> {
}