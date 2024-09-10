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

//    Optional<BookEntity> findByAuthorIgnoreCase (String author);

    Page<BookEntity> findAll(Pageable pageable);

    @Query(
            value = "select b.* " +
                    "from book b " +
                    "join author a on a.id = b.author_id " +
                    "join genre g on g.id = b.genre_id " +
                    "where b.title like :title or " +
                    "a.name like :author or " +
                    "g.name like :genre;",
            nativeQuery = true
    )
    BookEntity findByTitleOrAuthorOrGenre(@Param("title") String title, @Param("author") String author, @Param("genre") String genre);
}