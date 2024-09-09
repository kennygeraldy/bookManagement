package com.example.book_management_system.service;

import com.example.book_management_system.entity.AuthorEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface AuthorService {

    List<AuthorEntity> getAllAuthors();

    AuthorEntity getAuthorById(Long id) ;

    AuthorEntity saveAuthor(AuthorEntity author) ;

    void deleteAuthor(Long id);

    Page<AuthorEntity> getAuthors(Pageable pageable) ;
}

