package com.example.book_management_system.controller;

import com.example.book_management_system.entity.BookEntity;
import com.example.book_management_system.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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


//  Create Book
    @PostMapping
    public BookEntity createBook(@RequestBody BookEntity book) {
        return bookService.saveBook(book);
    }

//   Put Books
//    @PutMapping("/{id}")
//    public ResponseEntity<BookEntity> updateBook(@PathVariable Long id, @RequestBody BookEntity bookDetails) {
//        BookEntity book = bookService.getBookById(id);
//        if (book != null) {
//            book.setTitle(bookDetails.getTitle());
//            book.setGenre(bookDetails.getGenre());
//            book.setAuthor(bookDetails.getAuthor());
//            book.setIsbn(bookDetails.getIsbn());
//            book.setPublish_date(bookDetails.getPublish_date());
//            BookEntity updatedBook = bookService.saveBook(book);
//            return ResponseEntity.ok(updatedBook);
//        } else {
//            return ResponseEntity.notFound().build();
//        }
//    }

// Search book by title
    @GetMapping("/search")
    public ResponseEntity<BookEntity> getBookByTitle(@RequestParam(name = "title") String title) {
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

//   Delete book by id
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBook(@PathVariable Long id) {
        BookEntity genre = bookService.getBookById(id);
        if (genre != null) {
            bookService.deleteBook(id);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
