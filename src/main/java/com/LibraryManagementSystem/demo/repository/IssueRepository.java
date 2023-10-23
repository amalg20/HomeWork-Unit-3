package com.LibraryManagementSystem.demo.repository;

import com.LibraryManagementSystem.demo.model.Book;
import com.LibraryManagementSystem.demo.model.Issue;
import com.LibraryManagementSystem.demo.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface IssueRepository extends JpaRepository<Issue,Integer> {
    List<Issue> findByIssueStudentUsn(String usn);
    List<Issue> findAllByReturnDate(String returnDate);

}
