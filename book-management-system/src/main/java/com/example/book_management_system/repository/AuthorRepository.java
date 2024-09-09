package com.example.book_management_system.repository;

import com.example.book_management_system.entity.AuthorEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface AuthorRepository extends JpaRepository<AuthorEntity, Long> {

//    Optional<AuthorEntity> findByName(String firstName);
    Optional<AuthorEntity> findByNameIgnoreCase(String firstName);
    // Find all employees with pagination
    Page<AuthorEntity> findAll(Pageable pageable);
}
