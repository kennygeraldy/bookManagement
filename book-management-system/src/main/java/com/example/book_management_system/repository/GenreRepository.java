package com.example.book_management_system.repository;

import com.example.book_management_system.entity.GenreEntity;
import org.springframework.stereotype.Repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import java.util.Optional;

@Repository
public interface GenreRepository {
    Optional<GenreEntity> findByGenre(String genre);
    Optional<GenreEntity> findByGenreIgnoreCase(String genre);

    Page<GenreEntity> findAll(Pageable pageable);
}
