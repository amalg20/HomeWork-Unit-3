package com.LibraryManagementSystem.demo.repository;

import com.LibraryManagementSystem.demo.model.Author;
import com.LibraryManagementSystem.demo.model.Book;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
class AuthorRepositoryTest {

    @Autowired
    AuthorRepository authorRepository;

    @Test
    void findByName() {
        Optional<Author> authorOptional = authorRepository.findByName("Alaa");
        assertTrue(authorOptional.isPresent());
        System.out.println(authorOptional.get());
    }

    @Test
    void findAll() {
        List<Author> authorList = authorRepository.findAll();
        System.out.println(authorList);
        assertEquals(5, authorList.size());
    }
}