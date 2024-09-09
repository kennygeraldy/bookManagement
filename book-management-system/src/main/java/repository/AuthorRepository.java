package repository;

import entitiy.AuthorEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AuthorRepository extends JpaRepository<AuthorEntity, Long> {

//    Optional<AuthorEntity> findByfirstName(String firstName);
    Optional<AuthorEntity> findByfirstNameIgnoreCase(String firstName);
    // Find all employees with pagination
    Page<AuthorEntity> findAll(Pageable pageable);
}
