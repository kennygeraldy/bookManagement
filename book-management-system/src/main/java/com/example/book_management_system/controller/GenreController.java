package com.example.book_management_system.controller;

import com.example.book_management_system.entity.GenreEntity;
import com.example.book_management_system.service.GenreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/genres")
public class GenreController {

    @Autowired
    private GenreService genreService;

    @GetMapping()
    public List<GenreEntity> getAllGenres() {
        return genreService.getAllGenres();
    }

//  Get Genre By Id
    @GetMapping("/{id}")
    public ResponseEntity<GenreEntity> getGenreById(
            @PathVariable Long id
    ){
        GenreEntity genre = genreService.getGenreById(id);
        if (genre != null) {
            return ResponseEntity.ok(genre);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

//  Create Genre
    @PostMapping
    public GenreEntity createGenre(@RequestBody GenreEntity genre) {
        return genreService.saveGenre(genre);
    }

    //   Put Genres
    @PutMapping("/{id}")
    public ResponseEntity<GenreEntity> updateGenre(@PathVariable Long id, @RequestBody GenreEntity genreDetails) {
        GenreEntity genre = genreService.getGenreById(id);
        if (genre != null) {
            genre.setBook(genreDetails.getBook());
            genre.setGenre(genreDetails.getGenre());
            GenreEntity updatedGenre = genreService.saveGenre(genre);
            return ResponseEntity.ok(updatedGenre);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    //   Get all genres with pagination
    @GetMapping("/page")
    public Page<GenreEntity> getAllGenres(Pageable pageable) {
        return genreService.getGenres(pageable);
    }


//  Delete genre by id
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteGenre(
            @PathVariable Long id
    ) {
        GenreEntity genre = genreService.getGenreById(id);
        if (genre != null) {
            genreService.deleteGenre(id);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
