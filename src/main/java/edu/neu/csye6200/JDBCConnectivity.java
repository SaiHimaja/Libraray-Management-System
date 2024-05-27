/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.neu.csye6200;
import java.sql.Connection;
import java.sql.DriverManager;
import java.io.*;

/**
 *
 * @author nikithakambhampati
 */
public class JDBCConnectivity {
    static Connection con = null;
    public static Connection connect(){
        try{
            // Establishing MYSQL JDBC 
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/library_system","root","shiny1206");
            return con;
        } catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
