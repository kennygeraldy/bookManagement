package com.example.book_management_system.service;

import com.example.book_management_system.entity.GenreEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface GenreService {

    List<GenreEntity> getAllGenres();

    GenreEntity getGenreById (Long id);

    GenreEntity saveGenre (GenreEntity genre);

    void deleteGenre(Long id);

    GenreEntity getGenreByName (String genre);

    Page<GenreEntity> getGenres(Pageable pageable);
}
