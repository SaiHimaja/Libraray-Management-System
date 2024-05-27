/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.neu.csye6200.jframes;
import edu.neu.csye6200.JDBCConnectivity;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author Raveena
 */
public class DBConnection {
   
    static Connection con = null;
    
    public static Connection getConnection(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/library_ms","root","");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return con;
    }
}
