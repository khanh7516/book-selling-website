package com.example.booksellingwebsite.repository;

import com.example.booksellingwebsite.entity.Chapter;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChapterRepository extends JpaRepository<Chapter, Integer> {
}