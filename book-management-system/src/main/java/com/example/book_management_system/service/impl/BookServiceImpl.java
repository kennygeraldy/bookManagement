package com.example.book_management_system.service.impl;

import com.example.book_management_system.entity.BookEntity;
import com.example.book_management_system.repository.BookRepository;
import com.example.book_management_system.service.BookService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class BookServiceImpl implements BookService {

    @Autowired
    private BookRepository bookRepository;

    public List<BookEntity> getAllBooks() {
        return bookRepository.findAll();
    }

    public BookEntity getBookById(Long id) {
        return bookRepository.findById(id).orElse(null);
    }

    public BookEntity saveBook(BookEntity book) {
        return bookRepository.save(book);
    }

    public void deleteBook(Long id) {
        bookRepository.deleteById(id);
    }

    public BookEntity getBookByTitleOrAuthorOrGenre(String title, String author, String genre){
        return bookRepository.findByTitleOrAuthorOrGenre(title, author, genre);
    }

    @Override
    public Page<BookEntity> getBooks(Pageable pageable) { return bookRepository.findAll(pageable); }

}