package com.example.book_management_system.service.impl;

import com.example.book_management_system.entity.AuthorEntity;
import com.example.book_management_system.repository.AuthorRepository;
import com.example.book_management_system.service.AuthorService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j

public class AuthorServiceImpl implements AuthorService {

    @Autowired
    private AuthorRepository authorRepository;

    public List<AuthorEntity> getAllAuthors() {

        return authorRepository.findAll();
    }

    public AuthorEntity getAuthorById(Long id) {

        return authorRepository.findById(id).orElse(null);
    }

    public AuthorEntity saveAuthor(AuthorEntity author) {

        return authorRepository.save(author);
    }

    public void deleteAuthor(Long id) {

        authorRepository.deleteById(id);
    }

    // case in-sensitive search
//    public AuthorEntity getAuthorByName(String author) {
//        return authorRepository.findByNameIgnoreCase(author).orElse(null);
//    }


    @Override
    public Page<AuthorEntity> getAuthors(Pageable pageable) {
        return authorRepository.findAll(pageable);
    }
}
