package com.example.book_management_system.controller;


import com.example.book_management_system.entity.AuthorEntity;
import com.example.book_management_system.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

<<<<<<< HEAD:book-management-system/src/main/java/com/example/book_management_system/controller/AuthorsCotroller.java

=======
>>>>>>> 44487ccbd6b3207b2dd9adca6068f7a2be1d1a8b:book-management-system/src/main/java/com/example/book_management_system/controller/AuthorController.java
import java.util.*;

@RestController
@RequestMapping("/api/author")
public class AuthorController {

    @Autowired
    private AuthorService authorService;

    @GetMapping()
    public List<AuthorEntity> getAllAuthors() {
        return authorService.getAllAuthors();
    }

    @GetMapping("/{id}")
<<<<<<< HEAD:book-management-system/src/main/java/com/example/book_management_system/controller/AuthorsCotroller.java
    public ResponseEntity<AuthorEntity> getAuhtorById(
=======
    public ResponseEntity<AuthorEntity> getAuthorById(
>>>>>>> 44487ccbd6b3207b2dd9adca6068f7a2be1d1a8b:book-management-system/src/main/java/com/example/book_management_system/controller/AuthorController.java
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
<<<<<<< HEAD:book-management-system/src/main/java/com/example/book_management_system/controller/AuthorsCotroller.java
    public ResponseEntity<AuthorEntity> updateAuhtor(@PathVariable Long id, @RequestBody AuthorEntity authorDetails) {
=======
    public ResponseEntity<AuthorEntity> updateAuthor(@PathVariable Long id, @RequestBody AuthorEntity authorDetails) {
>>>>>>> 44487ccbd6b3207b2dd9adca6068f7a2be1d1a8b:book-management-system/src/main/java/com/example/book_management_system/controller/AuthorController.java
        AuthorEntity author = authorService.getAuthorById(id);
        if (author != null) {
            author.setAuthor(authorDetails.getAuthor());
            author.setId(authorDetails.getId());
            author.setBio(authorDetails.getBio());
            AuthorEntity updatedAuthor = authorService.saveAuthor(author);
            return ResponseEntity.ok(updatedAuthor);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Delete Author
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAuthor(@PathVariable Long id) {
        AuthorEntity author = authorService.getAuthorById(id);
        if (author != null) {
            authorService.deleteAuthor(id);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
