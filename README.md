
                                                        Library Management System

Team:

Nikitha Kambhampati 
Anusha Kadali
Patil Raveena Chidambar 
Hasini Muvva
Janaki Rama Raju Vadapalli
Kurapati Saihimaja Chowdary
Venkata Surya Saran Teja Dadi


Individual Contributions:

Nikitha Kambhampati -  Developed Login.java which consists of login page contents and authentication.

Anusha Kadali - Developed Home.java which consists of Menu options and students list and book list.

Patil Raveena Chidambar - Developed SignupPage.java, consists of registration/signup page that redirects to login page after successful entries.

Hasini Muvva - Developed ManageBooks.java, consits of Total book list along with CRUD operations.

Janaki Rama Raju Vadapalli - Worked on IssuedBookDetails.java,consists of the list that are previously issued and displays the message in the Tabelmodel

Kurapati Saihimaja Chowdary - Worked on ReturnBook.java, consists functionality for returning the book and updating the booklist.

Venkata Surya Saran Teja Dadi - Worked on ViewAllRecords.java, consists of all issued books,and sorting by book name and student name.


Instructions:

1- src/main/java/edu/neu/csye6200 - Load these jars which are present in this link "https://northeastern-my.sharepoint.com/:f:/g/personal/dadi_v_northeastern_edu/EjkgnRhYzolPlAn9JvtL71MBlMGVGZSZ9fK--2jPQuklMg?e=tXbjW8" in a new jars folder in csye6200. <br/>
2- Load the project in the Netbeans IDE and build the dependencies.<br/>
3- Run the Driver class "Driver.java". And the project runs and will be setup.<br/>
4- Download MySQL work bench and execute the following commands

CREATE TABLE `book_details` (
  `book_id` int NOT NULL AUTO_INCREMENT,
  `book_name` varchar(255) DEFAULT NULL,
  `author` varchar(255) DEFAULT NULL,
  `quantity` int DEFAULT NULL,
  PRIMARY KEY (`book_id`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
 
 
CREATE TABLE `issue_book_details` (
  `issue_id` int NOT NULL AUTO_INCREMENT,
  `book_id` int DEFAULT NULL,
  `book_name` varchar(255) DEFAULT NULL,
  `student_id` int DEFAULT NULL,
  `student_name` varchar(255) DEFAULT NULL,
  `issue_date` date DEFAULT NULL,
  `due_date` date DEFAULT NULL,
  `status` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`issue_id`),
  KEY `book_id` (`book_id`),
  CONSTRAINT `issue_book_details_ibfk_1` FOREIGN KEY (`book_id`) REFERENCES `book_details` (`book_id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `student_details` (
  `student_id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `course` varchar(255) DEFAULT NULL,
  `branch` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`student_id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `users` (
  `id` int NOT NULL AUTO_INCREMENT,
  `userName` varchar(50) DEFAULT NULL,
  `userPassword` varchar(50) DEFAULT NULL,
  `userEmail` varchar(100) DEFAULT NULL,
  `userContactNumber` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

so that necessary tables will be set up.                         

This Java project implements a library management system efficiently. It consists of a registration page, login page,Adding,updating and deleting books in the library, and also issue date and due dates in books inventory, and provides a user-friendly interface for library staff.


Features:
  - Book and Student CRUD operations
  - Signup and login
  - Sorting 
  
 Concepts used: Inheritance, Swings, Exception Handling, Comparator, Swings, Multithreading, Lambda Expressions, Collections, Models.
 
 Implemented using Apache Netbeans, MySql.

* We used MySql as our database and connected to our java application in Netbeans in “JDBCConnectivity.java” file by creating a static method as “connect()”


* We have included all the media,placeholders,images,text fonts,buttons,menu,tables methods under the “edu.neu.csye6200.jars” package.

* Java Abstract Window Toolkit (AWT) package and is used to represent colors in Java applications

“JCTextField.java”:
		
		-- file extension class in swing for text field with placeholder text.
		-- RSButtonHover, extends the JButton class in Swing and provides additional features for button customization. 																								
		-- RSButtonPane, which is a custom JPanel designed to function as a button with hover effects

*** In every java file the JDBC connectivity is mentioned to perform operations according to the methods defined in a class.Establishes a connection to a MySQL database using JDBC.

*** Also the AWT GUI functions are added by default to every java file to ensure and enhance the page responsiveness with images,mouse click events, tables,placeholders etc.

"DBConnection.java":

		-- Defines a Java class for database connection with a static method “getConnection()” that establishes a connection to a MySQL database using JDBC, loading the MySQL JDBC driver and providing connection details (URL, username, password). The Connection object is returned, and any exceptions during the process are retrieved.

"DefaulterList.java":

		-- Defines a Swing Graphical User Interface application for a "Defaulter List" in the Library management system. JDBC is used to connect to a MySQL database and retrieve information about books that are overdue. 
		
		-- edu.neu.csye6200.jframes package. -  Imports classes related to JDBC connectivity, Swing components, and a custom table component 
		
	class DefaulterList: 
		-- extends javax.swing.JFrame and includes a constructor DefaulterList() and a method setIssueBookDetailsToTable().
		-- Establishes a connection to a MySQL database using JDBC.
		-- SQL query to retrieve details of books that are overdue and pending.
		-- Executes the query, retrieves the result set, and displays in the table model. 
		-- The table model is used to update a table (tbl_issueBookDetails) with information like book ID, book name, student name, issue date, due date, and status.
		-- The main method initializes an instance of DefaulterList and sets it to be visible.

"Homepage.java":

		-- Exception handlers are used in this code to handle errors. It is a basic home page that displays the menu options, total no of books and students also the no of books issued. It displays the book list and student list.

	setBookDetailsToTable(): 
		-- To add new books into the table.

	setDataToCards():
		-- This method is used to result and display the total no of books,students, issued books and defaulter list. 

	public static void demo():

		--	java.awt.EventQueue.invokeLater:
		--	This method is a static utility method provided by Swing to enqueue a task to be executed on the Event Despatch Thread. A Runnable object is processed by the EDT.
	   
	    new Runnable() { ... }:
			-- This creates an anonymous inner class that implements the Runnable interface. The Runnable interface has a single method called run(), which contains the code to be executed.
		
		public void run() { ... }:
			-- The run() method is overridden to define the code that will be executed on the EDT.

	new HomePage().setVisible(true):
		-- Inside the run() method, a new instance of the HomePage class is created, and its setVisible(true) method is called. This sets the visibility of the HomePage window to true, making it visible on the screen.

	javax.swing.JLabel 
		-- is a class that represents a label or a piece of text that can be displayed on a Swing component, such as a JFrame

"IssueBook.java":

	getBookDetails() and getStudentDetails():
	    --  To Fetch book and student details from the database based on user input (book ID and student ID).
	issueBook():
		-- Inserts issue book details into the database.
		-- Uses java.sql.Date for issue and due dates.
	updateBookCount():
		-- Updates the quantity of the issued book in the database.
	isAlreadyIssued():
	    -- Checks if the book is already issued to the student.

"Login.java":

	This code is for a simple login page in a Java Swing application. It performs user authentication against a MySQL database and opens a new frame (HomePage) if the credentials are correct.

	validateLogin():
	 	-- Validates user input (username and password).
	 	-- Displays an error message if the username or password is empty.


	login():
		-- Retrieves the username and password from the text fields.
		-- Establishes a connection to a MySQL database using JDBC.
		-- Executes a query to check if the provided username and password match a record in the users table.
		-- If a match is found, displays a "login successful" message, opens a new HomePage frame, and closes off the current login frame.
		-- If no match is found, it displays an "incorrect username or password" message.

	public void login(): This method is used for validations and verifies the user login details using exception handlers.

"ManageBooks.java":

	setBookDetailsToTable():
		-- Retrieves book details from the book_details table in the MySQL database and updates them into a JTable (tbl_bookDetails).
		-- Uses a DefaultTableModel to manage the table data.

	addBook():
		-- Retrieves book details from text fields and inserts a new record into the book_details table in the database.
		-- Returns true if the book is added successfully, false otherwise.

	updateBook():
		-- Retrieves book details from text fields and updates the corresponding record in the book_details table in the database.
		-- Returns true if the book is updated successfully, false otherwise.

	d. deleteBook():
		-- Retrieves the book ID from a text field and deletes the corresponding record from the book_details table in the database.
		-- Returns true if the book is deleted successfully, false otherwise.

	e. clearTable():
		-- Clears all rows from the JTable (tbl_bookDetails).

"ManageStudents.java":

	setStudentDetailsToTable():
		-- Retrieves student details from the student_details table in the MySQL database and populates them into a JTable (tbl_studentDetails).
		-- Uses a DefaultTableModel to manage the table data.
 	addStudent():
		-- Retrieves student details from text fields and combo boxes and inserts a new record into the student_details table in the database.
		-- Returns true if the student is added successfully, false otherwise.
 	updateStudent():
		-- Retrieves student details from text fields and combo boxes and updates the corresponding record in the student_details table in the database.
		-- Returns true if the student is updated successfully, false otherwise.
	deleteStudent():
		-- Retrieves the student ID from a text field and deletes the corresponding record from the student_details table in the database.
		-- Returns true if the student is deleted successfully, false otherwise.
	clearTable():
		-- Clears all rows from the JTable (tbl_studentDetails).


"ReadFromFile.java":
		This Java code defines a class named ReadFromFile, which is responsible for reading book data from a file, checking if the book already exists in a database, and adding the book to the database if it doesn't exist. Let's break down the code:
	
	bookExists(String bookName, String author):
		-- Checks whether a book with the specified name and author already exists in the database.
		-- Executes a SQL query using a prepared statement to select records from the book_details table based on the given book name and author.
		-- Returns true if the book exists, false otherwise.
	addBook(String bookName, String author, int quantity):
		--	Adds a new book to the book_details table in the database.
		--	Calls bookExists to check if the book already exists.
		--	If the book doesn't exist, retrieves the maximum book_id from the table, increments it, and inserts the new book with the incremented book_id.
		--	Returns true if the book is added successfully, false otherwise.
		
	readDataFromFile(String filePath, String delimiter):
		--	Reads data from a file specified by filePath using a BufferedReader.
		--	Splits each line into an array using the specified delimiter.
		--	If the array has three elements, it extracts the book name, author, and quantity and calls addBook to add the book to the database.
		--	Returns the count of new records added to the database.
	fileCount():
		--	Specifies the file path (filePath) and delimiter (delimiter) for reading data from the file.
		--	Calls readDataFromFile to read and insert data from the file into the database.
		--	Returns the count of new records added to the database.


"ReturnBook.java":

	getIssueBookDetails():
		-- Retrieves details of an issued book from the issue_book_details table based on the provided book ID, student ID, and status ("pending").
		-- If a record is found, it updates the corresponding labels on the GUI with the book and student details.
		-- If no record is found, it displays an error message and clears the labels.
	returnBook():
		-- Updates the status of an issued book in the issue_book_details table from "pending" to "returned" based on the provided book ID, student ID, and status.
		-- Returns true if the book is successfully marked as returned, and false otherwise.
	updateBookCount():
		-- Updates the quantity (book count) in the book_details table by incrementing it for the specified book ID.
		-- Displays a message dialog indicating whether the book count was successfully updated.

"Signup.java":

	insertSignupDetails():
	  -- Inserts user registration details into the users table in the database.
	  -- Retrieves user details (username, password, email, contact) from the corresponding text fields in the GUI.
	  -- Opens a database connection, prepares an SQL statement, sets parameters, and executes the update.
	  -- Displays a success message and opens the login page if the record is successfully inserted.
	  
	validateSignup():
	 --	Performs client-side validation of the user input for username, password, email, and contact.
	 --	Displays appropriate error messages using JOptionPane if any of the validation criteria fail.
	 --	Returns true if the input is valid and false otherwise.
	 
	checkDuplicateUser():
	--	Checks if the entered username already exists in the users table to avoid duplicate entries.
	--	Opens a database connection, prepares an SQL statement to check for the existence of the username, and executes the query.
	--	Returns true if the username already exists and false otherwise.

"ViewAllRecord.java":

	--	ViewAllRecord, which appears to be associated with displaying and managing records related to issued books in a library management system. Let's break down the code:

	--  Used Comparator to sort out the list according to the student name and book name.

	setIssueBookDetailsToTable():
	--	Retrieves records from the issue_book_details table and populates them into the tbl_issueBookDetails table in the GUI.
	--	Uses JDBC to connect to a MySQL database and execute an SQL query to fetch records.
	
	clearTable():
	--	Clears the contents of the tbl_issueBookDetails table in the GUI.
	
	search():
	--	Fetches records from the issue_book_details table based on a date range specified by the user.
	--	Uses JDBC to execute an SQL query with a date range condition.
	--	Updates the table in the GUI with the search results.
	
	sortTableByBookName():
	--	Fetches all records from the issue_book_details table and sorts them based on the book name.
	--	Updates the tbl_issueBookDetails table in the GUI with the sorted results.
	
	sortTableByStudentName():
	--	Fetches all records from the issue_book_details table and sorts them based on the student name.
	--	Updates the tbl_issueBookDetails table in the GUI with the sorted results.






