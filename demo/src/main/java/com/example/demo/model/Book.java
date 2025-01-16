package com.example.demo.model;

import lombok.Data;

import jakarta.persistence.*;

@Entity
@Data
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String author;
    private String isbn;
    private String description;
}
