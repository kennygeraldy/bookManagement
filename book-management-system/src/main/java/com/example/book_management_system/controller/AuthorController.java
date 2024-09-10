package com.example.book_management_system.controller;

import com.example.book_management_system.entity.AuthorEntity;
import com.example.book_management_system.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/authors")
public class AuthorController{

    @Autowired
    private AuthorService authorService;

    @GetMapping()
    public List<AuthorEntity> getAllAuthors() {
        return authorService.getAllAuthors();
    }

    //  Get Author By Id
    @GetMapping("/{id}")
    public ResponseEntity<AuthorEntity> getAuthorById(
            @PathVariable Long id
    ){
        AuthorEntity author = authorService.getAuthorById(id);
        if (author != null) {
            return ResponseEntity.ok(author);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    //  Create Author
    @PostMapping
    public AuthorEntity createAuthor(@RequestBody AuthorEntity author) {
        return authorService.saveAuthor(author);
    }

    //   Put Author
    @PutMapping("/{id}")
    public ResponseEntity<AuthorEntity> updateAuthor(
            @PathVariable Long id,
            @RequestBody AuthorEntity authorDetails) {
        AuthorEntity author = authorService.getAuthorById(id);
        if (author != null) {
            author.setAuthor(authorDetails.getAuthor());
            author.setBio(authorDetails.getBio());
            author.setBook(authorDetails.getBook());
            AuthorEntity updatedAuthor = authorService.saveAuthor(author);
            return ResponseEntity.ok(updatedAuthor);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    //   Get all genres with pagination
    @GetMapping("/page")
    public Page<AuthorEntity> getAllAuthors(Pageable pageable) {
        return authorService.getAuthors(pageable);
    }


    //  Delete genre by id
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAuthor(
            @PathVariable Long id
    ) {
        AuthorEntity author = authorService.getAuthorById(id);
        if (author != null) {
            authorService.deleteAuthor(id);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
