package com.example.book_management_system.service.impl;

import com.example.book_management_system.entity.AuthorEntity;
import com.example.book_management_system.entity.GenreEntity;
import com.example.book_management_system.repository.GenreRepository;
import com.example.book_management_system.service.GenreService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class GenreServiceImpl implements GenreService {


    @Autowired
    private GenreRepository genreRepository;

    public List<GenreEntity> getAllGenres() {
        return genreRepository.findAll();
    }

    public GenreEntity getGenreById(Long id) {
        return genreRepository.findById(id).orElse(null);
    }

    public GenreEntity saveGenre(GenreEntity genre) {
        return genreRepository.save(genre);
    }

    public void deleteGenre(Long id) {
        genreRepository.deleteById(id);
    }

//    public GenreEntity getGenreByName(String genre) {
//        return genreRepository.findByNameIgnoreCase(genre).orElse(null);
//    }

    @Override
    public Page<GenreEntity> getGenres(Pageable pageable) { return genreRepository.findAll(pageable); }

}