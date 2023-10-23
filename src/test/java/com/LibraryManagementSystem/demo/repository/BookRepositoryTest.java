package com.LibraryManagementSystem.demo.repository;

import static org.junit.jupiter.api.Assertions.*;


import com.LibraryManagementSystem.demo.model.Author;
import com.LibraryManagementSystem.demo.model.Book;
import com.LibraryManagementSystem.demo.repository.AuthorRepository;
import com.LibraryManagementSystem.demo.repository.BookRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class BookRepositoryTest {
    @Autowired
    BookRepository bookRepository;

    @Test
    public void findByTitle() {
        Optional<Book> bookOptional = bookRepository.findByTitle("be");
        assertTrue(bookOptional.isPresent());
        System.out.println(bookOptional.get());
    }

    @Test
    public void findByCategory() {
        List<Book> bookList = bookRepository.findByCategory("action");
        System.out.println(bookList);
        assertEquals(2, bookList.size());
    }

    @Test
    public void findById() {
        Optional<Book> bookOptional = bookRepository.findById("12-121");
        assertTrue(bookOptional.isPresent());
        System.out.println(bookOptional.get());
    }

    @Test
    public void findAll() {
        List<Book> bookList = bookRepository.findAll();
        System.out.println(bookList);
        assertEquals(5, bookList.size());
    }
}