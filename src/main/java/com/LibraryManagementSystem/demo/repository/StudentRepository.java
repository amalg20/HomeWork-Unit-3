package com.LibraryManagementSystem.demo.repository;

import com.LibraryManagementSystem.demo.model.Author;
import com.LibraryManagementSystem.demo.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface StudentRepository extends JpaRepository<Student, String> {
    Optional<Student> findById(String usn);
}
