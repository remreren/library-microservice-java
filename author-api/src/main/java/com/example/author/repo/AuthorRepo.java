package com.example.author.repo;

import com.example.author.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AuthorRepo extends JpaRepository<Author, Long> {
    @Query("select author from Author author where lower(concat(author.name, ' ', author.surname)) like %:name%")
    List<Author> getAuthorsByName(@Param("name") String name);
    Optional<Author> getAuthorById(Long id);
}
