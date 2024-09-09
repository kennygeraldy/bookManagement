package com.example.book_management_system.controller;


import com.example.book_management_system.entity.BookEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.awt.print.Book;

@RestController
@RequestMapping("/api/books")
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping()
    public List<BookEntity> getAllBooks() {
        return bookService.getAllBooks();
    }

    @GetMapping("/{id}")
    public ResponseEntity<BookEntity> getBookById(
            @PathVariable Long id
    ){
        BookEntity book = bookService.getBookById(id);
        if (book != null) {
            return ResponseEntity.ok(book);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

//  Create Employee
    @PostMapping
    public BookEntity createEmployee(@RequestBody BookEntity employee) {
        return bookService.saveBook(book);
    }

//   Put Books
    @PutMapping("/{id}")
    public ResponseEntity<BookEntity> updateEmployee(@PathVariable Long id, @RequestBody BookEntity bookDetails) {
        BookEntity book = bookService.getBookById(id);
        if (book != null) {
            book.setTitle(bookDetails.getTitle());
            book.setGenre(bookDetails.getGenre());
            book.setAuthor(bookDetails.getAuthor());
            book.setIsbn(bookDetails.getIsbn());
            book.setPublish_date(bookDetails.getPublish_date());
            BookEntity updatedEmployee = bookService.saveBook(book);
            return ResponseEntity.ok(updatedEmployee);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

// Search book by title
    @GetMapping("/search")
    public ResponseEntity<Book> getBookByTitle(@RequestParam(name = "title") String title) {
        BookEntity book = bookService.getBookByTitle(title);
        if (book != null) {
            return ResponseEntity.ok(book);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

//   Get all books with pagination
    @GetMapping("/page")
    public Page<BookEntity> getAllBooks(Pageable pageable) {
        return bookService.getBooks(pageable);
    }

}
