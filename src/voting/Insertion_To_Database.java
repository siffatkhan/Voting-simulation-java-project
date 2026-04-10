/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package voting;

/**
 *
 * @author cosmo
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Insertion_To_Database {
    
    // Method to establish a database connection
    public static Connection getConnection() {
        Connection con = null;
        try {
            // Load the MySQL JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            // Establish a Connection
            con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/VotingProjectDB", "root", "siffatullah.1");
            System.out.println("Connected To The Database Successfully");
            }
        
        catch (ClassNotFoundException e) {
            System.out.println("MySQL JDBC Driver Not Found.");
            e.printStackTrace();
        } 
        catch (SQLException e) {
            System.out.println("Connection Failed.");
            e.printStackTrace();
        }
        return con;
    }
    
    // Method to insert data into the Registration table
    public static void insertRegistrationData(Connection con, String firstname, String lastname, String CNIC, String family_no, String gender, String contact, String password, String city) 
    {
        try {
            // Prepare an SQL statement to insert data
            String sql = "INSERT INTO Registration (firstname, lastname, CNIC, family_no, gender, contact, password, city, has_voted) VALUES (?, ?, ?, ?, ?, ?, ?, ?,?)";
            PreparedStatement statement = con.prepareStatement(sql);
            
            // Assign values to the placeholders
            statement.setString(1, firstname);
            statement.setString(2, lastname);
            statement.setString(3, CNIC);
            statement.setString(4, family_no);
            statement.setString(5, gender);
            statement.setString(6, contact);
            statement.setString(7, password);
            statement.setString(8, city);
            statement.setBoolean(9, false);

            // Execute the statement
            int rowsInserted = statement.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("A new user was inserted successfully!");
            }
        } catch (SQLException e) {
            System.out.println("Data insertion failed");
            e.printStackTrace();
        }
    }
//    I dont think we need it again bcx same is done in registration phase
//    public static void insertLoginData(Connection con, String cnic_no, String family_no, String password, String constituency) 
//    {
//        try {
//            // Prepare an SQL statement to insert data
//            String sql = "INSERT INTO Login (cnic_no, family_no, password, constituency) VALUES (?, ?, ?, ?)";
//            PreparedStatement statement = con.prepareStatement(sql);
//            
//            // Assign values to the placeholders
//            
//            statement.setString(1, cnic_no);
//            statement.setString(2, family_no);
//            statement.setString(3, password);
//            statement.setString(4, constituency);
//
//            // Execute the statement
//            int rowsInserted = statement.executeUpdate();
//            if (rowsInserted > 0) {
//                System.out.println("A new user was inserted successfully!");
//            }
//        } catch (SQLException e) {
//            System.out.println("Data insertion failed");
//            e.printStackTrace();
//        }
//    }
    
  
    
}


    

