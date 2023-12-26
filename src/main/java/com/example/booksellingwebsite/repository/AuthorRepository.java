package com.example.booksellingwebsite.repository;

import com.example.booksellingwebsite.entity.Author;
import com.example.booksellingwebsite.model.dto.AuthorDTO;
import com.example.booksellingwebsite.model.dto.CategoryDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AuthorRepository extends JpaRepository<Author, Integer> {
    Long countById(Integer id);

    @Query("SELECT NEW com.example.booksellingwebsite.model.dto.AuthorDTO(a.id, a.name) from Author a")
    List<AuthorDTO> findAllAuthorsDTO();


}