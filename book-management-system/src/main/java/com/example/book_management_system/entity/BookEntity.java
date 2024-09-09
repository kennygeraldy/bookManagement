package com.example.book_management_system.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Setter
@Getter
@Table(name = "books")
public class BookEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "title", nullable = false)
    @JsonProperty("title")
    private String title;

    @Column(name = "isbn", nullable = false)
    @JsonProperty("isbn")
    private String isbn;

    @ManyToOne(fetch =  FetchType.LAZY)
    @JoinColumn(name = "author_id", referencedColumnName = "id")
    @JsonProperty("author")
    private AuthorEntity author;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "genre_id", referencedColumnName = "id")
    @JsonProperty("genre")
    private GenreEntity genre;

    @Column(name = "publish_date", nullable = false)
    @JsonProperty("publish_date")
    private LocalDate publish_date;
}