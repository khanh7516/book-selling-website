package com.example.booksellingwebsite.entity;

import com.example.booksellingwebsite.enums.BookItemStatus;
import com.example.booksellingwebsite.enums.UserStatus;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "tbl_book_item")
public class BookItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private Integer quantity;

    @Column(nullable = false)
    private String type;

    @Column(nullable = false)
    private Float price;

    @Column
    private String thumbnail;

    @ManyToOne
    @JoinColumn(name = "book_id")
    private Book book;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "order_id")
    private Order order;


    @Column(name = "status", nullable = false)
    @Enumerated(EnumType.STRING)
    private BookItemStatus status;

    @Column(name = "created_at", columnDefinition = "TIMESTAMP")
    private LocalDateTime createdAt;

    @Column(name = "updated_at", columnDefinition = "TIMESTAMP")
    private LocalDateTime updatedAt;

    @Column(name = "deleted_at", columnDefinition = "TIMESTAMP")
    private LocalDateTime deletedAt;




    @PrePersist
    public void prePersist() {
        createdAt = LocalDateTime.now();
        updatedAt = createdAt;
        status = BookItemStatus.ACTIVE;
    }

    @PreUpdate
    public void preUpdate() {
        updatedAt = LocalDateTime.now();
    }
}
