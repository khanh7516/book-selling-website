package com.example.booksellingwebsite.entity;


import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
@Entity
@Table(name = "tbl_book")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name", nullable = false, unique = true)
    private String name;

    @Column(name = "alias", nullable = false, unique = true)
    private String alias;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String shortDescription;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String fullDescription;

    private boolean enabled;

    private float cost;

    @Column(name = "price", nullable = false)
    private float price;

    @Column(name = "discount_percent")
    private float discountPercent;

    @Column(length = 128)
    private String image;

    @Column(name = "quantity_in_stock", nullable = false)
    private Integer quantityInStock;


//    @Embedded
//    @ElementCollection
//    @Column(name = "covers")
//    private Set<BookCover> bookCovers = new HashSet<>();

    @ManyToOne
    @JoinColumn(name = "author_id")
    private Author author;


    @Column
    private Integer numRatings;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name="tbl_book_category",
            joinColumns = @JoinColumn(name = "book_id"),
            inverseJoinColumns = @JoinColumn(name = "catgory_id")
    )
    private Set<Category> categories = new HashSet<>();

    @OneToMany(mappedBy = "book", fetch = FetchType.EAGER ,cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Rating> ratings = new ArrayList<>();

    @OneToMany(mappedBy = "book", fetch = FetchType.EAGER ,cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Review> reviews = new ArrayList<>();

    @OneToMany(mappedBy = "book",  fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<BookImage> images = new ArrayList<>();



    @Column(name = "created_at", columnDefinition = "TIMESTAMP")
    private LocalDateTime createdAt;

    @Column(name = "updated_at", columnDefinition = "TIMESTAMP")
    private LocalDateTime updatedAt;

    @PrePersist
    public void prePersist() {
        createdAt = LocalDateTime.now();
        updatedAt = createdAt;
    }




    @PreUpdate
    public void preUpdate() {
        updatedAt = LocalDateTime.now();
    }


    public void addCategory(Category category) {
        this.categories.add(category);
    }

    public void addImages(String url) {
        this.images.add(new BookImage(url, this));
    }
    public void removeImages(BookImage bookImage) {
        this.images.remove(bookImage);
    }


}
