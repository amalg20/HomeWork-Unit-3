package com.LibraryManagementSystem.demo.repository;

import com.LibraryManagementSystem.demo.model.Author;
import com.LibraryManagementSystem.demo.model.Book;
import com.LibraryManagementSystem.demo.model.Issue;
import com.LibraryManagementSystem.demo.model.Student;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class IssueRepositoryTest {
    @Autowired
    IssueRepository issueRepository;
    @Autowired
    StudentRepository studentRepository;
    @Autowired
    BookRepository bookRepository;

    Student student1 = new Student("1234", "nuha" );
    @BeforeEach
    public void SetUp(){
        studentRepository.save(student1);
        Book book = new Book("1272", "Read me", "Romance", 3);
        bookRepository.save(book);
        Issue newIssue = new Issue("2023-10-16 16:30:22", "2023-10-23 16:30:22", student1, book);
        issueRepository.save(newIssue);
    }


    @Test
    void findByIssueStudent() {
        List<Issue> issueList = issueRepository.findByIssueStudentUsn(student1.getUsn());
        System.out.println(issueList);
        assertEquals(1, issueList.size());
    }

    @Test
    void testFindAllByReturnDate() {
        List<Issue> findAllByReturnDateList = issueRepository.findAllByReturnDate("2023-10-23 16:30:22");
        System.out.println(findAllByReturnDateList);
        assertEquals(1, findAllByReturnDateList.size());
    }
}