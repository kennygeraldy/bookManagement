package com.example.book_management_system.repository;

import com.example.book_management_system.entity.BookEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BookRepository extends JpaRepository<BookEntity, Long> {
    Optional<BookEntity> findByTitleIgnoreCase (String title);

    Page<BookEntity> findAll(Pageable pageable);

    @Query(
            value = "select b.* " +
                    "from books b " +
                    "join authors a on a.id = b.author_id " +
                    "join genres g on g.id = b.genre_id " +
                    "where b.title like :title or " +
                    "a.author like :author or " +
                    "g.genre like :genre;",
            nativeQuery = true
    )
    BookEntity findByTitleOrAuthorOrGenre(@Param("title") String title, @Param("author") String author, @Param("genre") String genre);
}