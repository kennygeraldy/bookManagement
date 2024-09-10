package com.example.book_management_system.service;

import com.example.book_management_system.entity.BookEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface BookService {

    List<BookEntity> getAllBooks();

    BookEntity getBookById (Long id);

    BookEntity saveBook (BookEntity book);

    void deleteBook(Long id);

    BookEntity getBookByTitleOrAuthorOrGenre (String title, String author, String genre);

    Page<BookEntity> getBooks(Pageable pageable);
}
