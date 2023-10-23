package com.LibraryManagementSystem.demo.repository;

import com.LibraryManagementSystem.demo.model.Book;
import com.LibraryManagementSystem.demo.model.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class StudentRepositoryTest {
    @Autowired
    StudentRepository studentRepository;

    @Test
    void findById() {
        Optional<Student> studentOptional = studentRepository.findById("12");
        assertTrue(studentOptional.isPresent());
        System.out.println(studentOptional.get());
    }
}