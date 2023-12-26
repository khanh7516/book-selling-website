package com.example.booksellingwebsite.repository;

import com.example.booksellingwebsite.entity.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Set;

public interface BookRepository extends JpaRepository<Book, Integer> {
    Long countById(Integer id);


        List<Book> searchBookByNameContainingIgnoreCase(String name);

        @Query("SELECT b FROM Book b " +
                "LEFT JOIN b.categories c " +
                "WHERE (:name IS NULL OR LOWER(b.name) LIKE LOWER(CONCAT('%', :name, '%'))) " +
                "AND (:authorId IS NULL OR b.author.id = :authorId) " +
                "AND (:minPrice IS NULL OR b.price >= :minPrice) " +
                "AND (:maxPrice IS NULL OR b.price <= :maxPrice) " +
                "AND (:categoryIds IS NULL OR c.id IN :categoryIds) " +
                "ORDER BY b.createdAt ASC")
        List<Book> searchAndSortByCreatedAtAsc(@Param("name") String name,
                                               @Param("authorId") Integer authorId,
                                               @Param("minPrice") Integer minPrice,
                                               @Param("maxPrice") Integer maxPrice,
                                               @Param("categoryIds") Set<Integer> categoryIds
                                                );

        @Query("SELECT b FROM Book b " +
                "LEFT JOIN b.categories c " +
                "WHERE (:name IS NULL OR LOWER(b.name) LIKE LOWER(CONCAT('%', :name, '%'))) " +
                "AND (:authorId IS NULL OR b.author.id = :authorId) " +
                "AND (:minPrice IS NULL OR b.price >= :minPrice) " +
                "AND (:maxPrice IS NULL OR b.price <= :maxPrice) " +
                "AND (:categoryIds IS NULL OR c.id IN :categoryIds) " +
                "ORDER BY b.createdAt DESC")
        List<Book> searchAndSortByCreatedAtDesc(@Param("name") String name,
                                                @Param("authorId") Integer authorId,
                                                @Param("minPrice") Integer minPrice,
                                                @Param("maxPrice") Integer maxPrice,
                                                @Param("categoryIds") Set<Integer> categoryIds
                                                 );

        @Query("SELECT b FROM Book b " +
                "LEFT JOIN b.categories c " +
                "WHERE (:name IS NULL OR LOWER(b.name) LIKE LOWER(CONCAT('%', :name, '%'))) " +
                "AND (:authorId IS NULL OR b.author.id = :authorId) " +
                "AND (:minPrice IS NULL OR b.price >= :minPrice) " +
                "AND (:maxPrice IS NULL OR b.price <= :maxPrice) " +
                "AND (:categoryIds IS NULL OR c.id IN :categoryIds) " +
                "ORDER BY b.price ASC")
        List<Book> searchAndSortByPriceAsc(@Param("name") String name,
                                           @Param("authorId") Integer authorId,
                                           @Param("minPrice") Integer minPrice,
                                           @Param("maxPrice") Integer maxPrice,
                                           @Param("categoryIds") Set<Integer> categoryIds
                                            );

        @Query("SELECT b FROM Book b " +
                "LEFT JOIN b.categories c " +
                "WHERE (:name IS NULL OR LOWER(b.name) LIKE LOWER(CONCAT('%', :name, '%'))) " +
                "AND (:authorId IS NULL OR b.author.id = :authorId) " +
                "AND (:minPrice IS NULL OR b.price >= :minPrice) " +
                "AND (:maxPrice IS NULL OR b.price <= :maxPrice) " +
                "AND (:categoryIds IS NULL OR c.id IN :categoryIds) " +
                "ORDER BY b.price DESC")
        List<Book> searchAndSortByPriceDesc(@Param("name") String name,
                                            @Param("authorId") Integer authorId,
                                            @Param("minPrice") Integer minPrice,
                                            @Param("maxPrice") Integer maxPrice,
                                            @Param("categoryIds") Set<Integer> categoryIds
                                             );
    }

