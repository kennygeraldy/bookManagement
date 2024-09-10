package com.example.book_management_system.repository;

import com.example.book_management_system.entity.BookEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BookRepository extends JpaRepository<BookEntity, Long> {
    Optional<BookEntity> findByTitleIgnoreCase (String title);

//    Optional<BookEntity> findByAuthorIgnoreCase (String author);
//
//    Optional<BookEntity> findByGenreIgnoreCase (String genre);

    Page<BookEntity> findAll(Pageable pageable);
}