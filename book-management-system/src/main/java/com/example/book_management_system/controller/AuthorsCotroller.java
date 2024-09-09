package com.example.book_management_system.controller;


import com.example.book_management_system.entity.AuthorEntity;
import com.example.book_management_system.entity.BookEntity;
import com.example.book_management_system.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.awt.print.Book;
import java.util.*;

@RestController
@RequestMapping("/api/author")
public class AuthorsCotroller {

    @Autowired
    private AuthorService authorService;

    @GetMapping()
    public List<AuthorEntity> getAllAuthors() {
        return authorService.getAllAuthors();
    }

    @GetMapping("/{id}")
    public ResponseEntity<AuthorEntity> getBookById(
            @PathVariable Long id
    ){
        AuthorEntity author = authorService.getAuthorById(id);
        if (author != null) {
            return ResponseEntity.ok(author);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    //  Create Employee
    @PostMapping
    public AuthorEntity createEmployee(@RequestBody AuthorEntity author) {
        return authorService.saveAuthor(author);
    }

    //   Put Books
    @PutMapping("/{id}")
    public ResponseEntity<AuthorEntity> updateEmployee(@PathVariable Long id, @RequestBody BookEntity bookDetails) {
        AuthorEntity author = authorService.getAuthorById(id);
        if (author != null) {
            author.setAuthor(author.getAuthor());
            author.setId(author.getId());
            author.setBio(author.getBio());
            AuthorEntity updatedAuthor = authorService.saveAuthor(author);
            return ResponseEntity.ok(updatedAuthor);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Search book by title
    @GetMapping("/search")
    public ResponseEntity<AuthorEntity> getAuthorByName(@RequestParam(name = "author") String name) {
        AuthorEntity author = authorService.getAuthorByName(name);
        if (author != null) {
            return ResponseEntity.ok(author);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    //   Get all books with pagination
    @GetMapping("/page")
    public Page<AuthorEntity> getAllBooks(Pageable pageable) {
        return authorService.getAuthors(pageable);
    }

}
