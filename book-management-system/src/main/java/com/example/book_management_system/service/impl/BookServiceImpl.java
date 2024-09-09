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

    public BookEntity getBookByTitle(String title) {
        return bookRepository.findByTitleIgnoreCase(title).orElse(null);
    }

    public BookEntity getBookByAuthor(String author) {
        return bookRepository.findByAuthorIgnoreCase(author).orElse(null);
    }

    public BookEntity getBookByGenre(String genre) {
        return bookRepository.findByGenreIgnoreCase(genre).orElse(null);
    }

    @Override
    public Page<BookEntity> getBooks(Pageable pageable) { return bookRepository.findAll(pageable); }

}