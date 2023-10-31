package com.example.booksellingwebsite.repository;

import com.example.booksellingwebsite.entity.ImageFile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ImageFileRepository extends JpaRepository<ImageFile, Integer> {
}