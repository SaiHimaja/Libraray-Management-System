/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.neu.csye6200.jframes;

import java.io.BufferedReader;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

/**
 *
 * @author Raveena 
 */

public class ReadFromFile  {

    /**
     * Creates new form ReadBookFromFile
     */
   
        public boolean bookExists(String bookName, String author) {
        boolean exists = false;

        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/library_system", "root", "root");

            String checkBookSql = "SELECT * FROM book_details WHERE book_name = ? AND author = ?";
            PreparedStatement checkBookStmt = con.prepareStatement(checkBookSql);
            checkBookStmt.setString(1, bookName);
            checkBookStmt.setString(2, author);

            ResultSet resultSet = checkBookStmt.executeQuery();
            exists = resultSet.next();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return exists;
    }

    public boolean addBook(String bookName, String author, int quantity) {
        boolean isAdded = false;

        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/library_system", "root", "root");

            if (!bookExists(bookName, author)) {
                // Retrieve the max book_id
                String getMaxBookIdSql = "SELECT MAX(book_id) AS max_book_id FROM book_details";
                PreparedStatement getMaxBookIdStmt = con.prepareStatement(getMaxBookIdSql);
                ResultSet resultSet = getMaxBookIdStmt.executeQuery();

                int maxBookId = 0;
                if (resultSet.next()) {
                    maxBookId = resultSet.getInt("max_book_id");
                }

                // Increment the max book_id for the new book
                int newBookId = maxBookId + 1;

                // Insert the new book
                String addBookSql = "INSERT INTO book_details VALUES (?, ?, ?, ?)";
                PreparedStatement pst = con.prepareStatement(addBookSql);
                pst.setInt(1, newBookId);
                pst.setString(2, bookName);
                pst.setString(3, author);
                pst.setInt(4, quantity);

                int rowCount = pst.executeUpdate();
                if (rowCount > 0) {
                    isAdded = true;
                } else {
                    isAdded = false;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return isAdded;
    }
    public int readDataFromFile(String filePath, String delimiter) 
    {
        int newRecordsCount = 0;

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(delimiter);
                if (data.length == 3) {
                    String bookName = data[0];
                    String author = data[1];
                    int quantity = Integer.parseInt(data[2]);

                    // Call the addBook method to insert the record into the database
                    if (addBook(bookName, author, quantity)) {
                        newRecordsCount++;
                    }
                } else {
                    System.out.println("Invalid data: " + line);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return newRecordsCount;

       
    }
   
    public int fileCount() {
    int newRecordsCount = 0;

    try {
        // Specify the path to your text file and the delimiter
        String filePath = "C:\\GIT\\OOD final\\final-project-final-group-8\\Book.txt";
        String delimiter = ",";

        // Create an instance of ReadBookFromFile
        ReadFromFile readBookFromFile = new ReadFromFile();
       

        // Call the readDataFromFile method to read and insert data from the file
        newRecordsCount = readBookFromFile.readDataFromFile(filePath, delimiter);
    } catch (Exception e) {
        e.printStackTrace();
    }

    return newRecordsCount;
}

                      
}
