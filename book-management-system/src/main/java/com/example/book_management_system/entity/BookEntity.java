package com.example.book_management_system.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Setter
@Getter
public class BookEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonProperty("title")
    private String isbn;

    @JoinColumn(name = "author_id", referencedColumnName = "Id")
    @JsonProperty("author")
    private BookEntity author;

    @JoinColumn(name = "genre_id", referencedColumnName = "Id")
    @JsonProperty("genre")
    private BookEntity genre;

    @Column(name = "publish_date", nullable = false)
    @JsonProperty("publish_date")
    private LocalDate publish_date;
}