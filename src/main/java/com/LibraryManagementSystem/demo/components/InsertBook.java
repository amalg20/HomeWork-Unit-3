package com.LibraryManagementSystem.demo.components;

import com.LibraryManagementSystem.demo.model.Author;
import com.LibraryManagementSystem.demo.model.Book;
import com.LibraryManagementSystem.demo.model.Issue;
import com.LibraryManagementSystem.demo.model.Student;
import com.LibraryManagementSystem.demo.repository.AuthorRepository;
import com.LibraryManagementSystem.demo.repository.BookRepository;
import com.LibraryManagementSystem.demo.repository.IssueRepository;
import com.LibraryManagementSystem.demo.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.*;

@Component
public class InsertBook {
    @Autowired
    BookRepository bookRepository;
    @Autowired
    AuthorRepository authorRepository;
    @Autowired
    StudentRepository studentRepository;
    @Autowired
    IssueRepository issueRepository;

    public void ScreenDisplay() {
        Scanner scanner = new Scanner(System.in);
        int choice;
        do {
            System.out.println();
            System.out.println("  ****  SELECT FROM MENU  ****  ");
            System.out.println();
            System.out.println("  1. Add a book");
            System.out.println("  2. Search book by title");
            System.out.println("  3. Search book by category");
            System.out.println("  4. Search book by Author");
            System.out.println("  5. List all books along with author");
            System.out.println("  6. Issue book to student");
            System.out.println("  7. List books by usn");
            System.out.println("  8. List books to be returned today");
            System.out.println("  9. Exit");
            System.out.println("  Enter your choice: ");
            choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    addBook();
                    break;
                case 2:
                    findByTitle();
                    break;
                case 3:
                    findByCategory();
                    break;
                case 4:
                    findByName();
                    break;
                case 5:
                    findAll();
                    break;
                case 6:
                    issueBookToStudent();
                    break;
                case 7:
                    listBooksByUsn();
                    break;
                case 8:
                    listStudentByReturnedDate();
                    break;
                case 9:
                    System.out.println("Exiting the system...");
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a number between 1 and 9.");
            }
        }
        while (choice != 9);
    }

    /*  1- Add a book    */
    public void addBook() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("      ********************       ");
        System.out.println();
        String isbn = "s";
        while (true) {
            try {
                System.out.println("Enter isbn : ");
                isbn = scanner.nextLine();
                if (isbn.isEmpty()) {
                    throw new InputMismatchException("isbn must be not null ");
                }
                break;
            } catch (InputMismatchException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }

        System.out.println("Enter title : ");
        String title = scanner.nextLine();
        System.out.println("Enter category : ");
        String category = scanner.nextLine();
        System.out.println("Enter Author name : ");
        String authorName = scanner.nextLine();
        System.out.println("Enter Author mail : ");
        String authorMail = scanner.nextLine();
        int numberOfBooks = 0;

        while (true) {
            try {
                System.out.println("Enter number of books : ");
                numberOfBooks = scanner.nextInt();
                System.out.println();
                break;
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number.");
                scanner.nextLine();
            }
        }
        Book book = new Book(isbn, title, category, numberOfBooks);
        bookRepository.save(book);
        Author author = new Author(authorName, authorMail, book);
        authorRepository.save(author);
    }

    /*  2- Search book by title  */
    public void findByTitle() {
        Scanner scanner = new Scanner(System.in);
        System.out.println();
        System.out.print("Enter the title to search: ");
        String searchTitle = scanner.nextLine();
        System.out.println();
        try {
            Optional<Book> title = bookRepository.findByTitle(searchTitle);
            if (title.isPresent()) {
                Book book = title.get();
                displayBookDetails(book);
            } else {
                System.out.println("Book not found");
            }
        } catch (NullPointerException e) {
            System.out.println("Error:  " + e.getMessage());
        }
    }

    /*  3- Search book by category  */
    private void findByCategory() {
        Scanner scanner = new Scanner(System.in);
        System.out.println();
        System.out.print("Enter the category to search: ");
        String searchCategory = scanner.next();
        System.out.println();
        try {
            List<Book> category = bookRepository.findByCategory(searchCategory);
            if (category.isEmpty()) {
                System.out.println("Book not found");
            } else {
                for (Book book : category) {
                    System.out.println("*** Book Details ***");
                    System.out.println("  Book Title: " + book.getTitle());
                    System.out.println("  Category: " + book.getCategory());
                    System.out.println("  Quantity: " + book.getQuantity());
                    System.out.println("  *********  ");
                    System.out.println("    ");
                }
            }
        } catch (NullPointerException e) {
            System.out.println("Error:  " + e.getMessage());
        }
    }

    /*  4- Search book by author  */
    private void findByName() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the author name to search: ");
        String searchAuthorName = scanner.next();
        try {
            Optional<Author> authorBook = authorRepository.findByName(searchAuthorName);
            if (authorBook.isPresent()) {
                Author book = authorBook.get();
                displayBookDetails(book.getAuthorBook());
            } else {
                System.out.println("Book not found");
            }
        } catch (NullPointerException e) {
            System.out.println("Error:  " + e.getMessage());
        }
    }

    /*  5- List all books along with author  */
    private void findAll() {
        System.out.println();
        System.out.println("List of all books along with authors:");
        List<Author> authors = authorRepository.findAll();
        for (Author author : authors) {
            System.out.println("*** Book Details ***");
            System.out.println("  Book Title: " + author.getAuthorBook().getTitle());
            System.out.println("  Category: " + author.getAuthorBook().getCategory());
            System.out.println("  Quantity: " + author.getAuthorBook().getQuantity());
            System.out.println("  Author Name: " + author.getName());
            System.out.println("  Author Email: " + author.getEmail());
            System.out.println("  *********  ");
            System.out.println("    ");
        }
    }

    /*  6- Issue book to student   */
    private void issueBookToStudent() {
        Scanner scanner = new Scanner(System.in);
        System.out.println();
        String studentUsn = "a";
        String studentName = "s";
        while (true) {
            try {
                System.out.print("Enter USN: ");
                studentUsn = scanner.nextLine();
                if (studentUsn.isEmpty()) {
                    throw new InputMismatchException("USN must be more 0 characters long");
                }
                System.out.print("Enter name: ");
                studentName = scanner.nextLine();
                if (studentName.length() < 3) {
                    throw new InputMismatchException("Name must be at least 3 characters long");
                }
                break;

            } catch (InputMismatchException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }

        Optional<Student> studentOptional = studentRepository.findById(studentUsn);

        Student student1;
        if (studentOptional.isEmpty()) {
            student1 = new Student(studentUsn, studentName);
            studentRepository.save(student1);
        } else {
            student1 = studentOptional.get();
        }
        System.out.print("Enter book ISBN: ");
        String bookISBN = scanner.nextLine();


        Book book1 = null;

        while (book1 == null) {
            Optional<Book> bookOptional = bookRepository.findById(bookISBN);
            if (bookOptional.isEmpty()) {
                System.out.println("name is not correct enter name again");
                System.out.print("Enter book ISBN: ");
                bookISBN = scanner.nextLine();
            } else {
                book1 = bookOptional.get();
            }
        }
        Calendar calendar = Calendar.getInstance();
        Date issueDate = calendar.getTime();
        calendar.add(Calendar.DAY_OF_MONTH, 7);
        Date returnDate = calendar.getTime();

        Issue newIssue = new Issue(formatDate(issueDate), formatDate(returnDate), student1, book1);

        issueRepository.save(newIssue);


        System.out.println("Book issued.Return Date: " + formatDate(returnDate));
        System.out.println();
    }

    public String formatDate(Date date) {
        Format formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return formatter.format(date);
    }

    /*  7- List books by usn */
    private void listBooksByUsn() {
        Scanner scanner = new Scanner(System.in);
        System.out.println();
        System.out.print("Enter usn : ");
        String usn = scanner.next();
        Optional<Student> studentOptional = studentRepository.findById(usn);
        List<Issue> issueByStudent = issueRepository.findByIssueStudentUsn(studentOptional.get().getUsn());

        System.out.println("\n  Books to be returned today:");
        for (Issue issue : issueByStudent) {
            System.out.println(" Name: " + issue.getIssueStudent().getName());
            System.out.println(" Book ISBN: " + issue.getIssueBook().getIsbn());
            System.out.println(" Return Date: " + issue.getReturnDate());
            System.out.println("  ****  ");
        }
    }

    /*   8- List books to be returned today   */
    public void listStudentByReturnedDate() {

        Calendar calendar = Calendar.getInstance();
        Date returnedDate = calendar.getTime();

        List<Issue> issuesToReturnToday = issueRepository.findAllByReturnDate(formatDate(returnedDate));

        System.out.println("\nBooks to be returned today:");
        for (Issue issue : issuesToReturnToday) {
            System.out.println(" USN: " + issue.getIssueStudent().getUsn());
            System.out.println(" Name: " + issue.getIssueStudent().getName());
            System.out.println(" Book ISBN: " + issue.getIssueBook().getIsbn());
            System.out.println(" Return Date: " + issue.getReturnDate());
        }
    }

    /*  Display Method */
    public void displayBookDetails(Book book) {
        System.out.println();
        System.out.println("*** Book Details ***");
        System.out.println("  ISBN: " + book.getIsbn());
        System.out.println("  Title: " + book.getTitle());
        System.out.println("  Category: " + book.getCategory());
        System.out.println("  Quantity: " + book.getQuantity());
        System.out.println("    ********");
        System.out.println();
    }

}
