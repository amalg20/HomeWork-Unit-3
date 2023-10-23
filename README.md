# HomeWork_Unit3
# Library Management System

![photo_5870748646549601902_x](https://github.com/AlaaM-8/HomeWork_Unit3/assets/84860359/2bae7bfd-e173-4b1b-9f43-d005a4baf5c7)

## 1. Describe the System :
The system will help managing and acquiring data about the books that are being used by students.

## 2. Details of the Model System : 
For the model, we created 4 main classes called Author, Book, Student and Issue.

### a. Book class
This class had :
1. variables such as :isbn of data type string , title of data type string, category of data type string and quantity of data type integer. 
2. Empty constructor
3. A parameterized constructor that takes isbn, title, category and a quantity
4. Public Getter, Setter and toString

### b. Author class
This class had :
1. Variable such as : authorId of data type integer , name of data type string , email of data type string and authorBook of data type Book, representing a One-to-One relationship with Book.
2. Empty constructor
3. A parameterized constructor that takes name, email and authorBook
4. Public Getter, Setter and toString

### c. Student class
This class had :
1. Variable such as usn of data type string and name of data type string .
2. Empty constructor
3. A parameterized constructor that takes usn and name
4. Public Getter ,Setter and toString
### d. Issue class
This class had :
1. Variable such as issueId of data type integer, issueDate of data type string, returnDate of data type string , issueStudent of data type Student, representing a One-to-One relationship with Student and issueBook of data type Book, representing a One-to-One relationship with Book.
2. Empty constructor
3. A parameterized constructor that takes issueDate, returnDate, issueStudent and issueBook
4. Public Getter ,Setter and toString

## 3. Details of the Repository System :

We created 4 repository such as :AuthorRepository , BookRepository , IssueRepository , and StudentRepository

## 4. ER Diagram for the System :

![photo_5870748646549601901_y](https://github.com/AlaaM-8/HomeWork_Unit3/assets/84860359/824a4962-55b4-42f8-a879-9f5e458d8dd6)


## 5. How the application works :
After starting this application, a list of options will pop up for the user. The user will be asked to input a number based on the list of options displayed, such as adding a book, searching for a book, issuing a book for a student, etc. After a certain action is executed, the menu is re-displayed for the user automatically.

## 6. Some Requirements for the System :

 In this system we achieved the following:
 
1. Navigate through a text-based menu using Standard Input and Output.
2. Create unit tests for every method we had.
3. Handle all exceptions using exception methods.
4. All data we stored in a normalized SQL database.

## 7. Refernces :

1. http://www.finalyearcollegeprojects.in/LibraryManagement.aspx




