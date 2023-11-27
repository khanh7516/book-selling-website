package com.example.booksellingwebsite.repository;

import com.example.booksellingwebsite.entity.ImageFile;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ImageFileRepository extends JpaRepository<ImageFile, Integer> {

    List<ImageFile> findByUser_IdOrderByCreatedAtDesc(Integer userId);
}