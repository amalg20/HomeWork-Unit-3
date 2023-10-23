package com.LibraryManagementSystem.demo.repository;

import com.LibraryManagementSystem.demo.model.Book;
import com.LibraryManagementSystem.demo.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public interface BookRepository extends JpaRepository<Book,String> {
    Optional<Book> findByTitle(String title);
    List<Book> findByCategory(String category);
    List<Book> findAll();
    Optional<Book> findById(String bookIsbn);

}
