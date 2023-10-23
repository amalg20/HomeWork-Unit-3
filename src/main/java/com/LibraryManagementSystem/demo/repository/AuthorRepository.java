package com.LibraryManagementSystem.demo.repository;

import com.LibraryManagementSystem.demo.model.Author;
import com.LibraryManagementSystem.demo.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface AuthorRepository extends JpaRepository<Author,Integer> {
    Optional<Author> findByName(String author);
    List<Author> findAll();

}
