package com.example.book_management_system.repository;

import com.example.book_management_system.entity.GenreEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface GenreRepository extends JpaRepository<GenreEntity, Long> {

    Optional<GenreEntity> findByNameIgnoreCase(String genre);

    Page<GenreEntity> findAll(Pageable pageable);
}
