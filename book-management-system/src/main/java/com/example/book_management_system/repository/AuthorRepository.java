package com.example.book_management_system.repository;

import com.example.book_management_system.entity.AuthorEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<AuthorEntity, Long> {

    Page<AuthorEntity> findAll(Pageable pageable);
}
