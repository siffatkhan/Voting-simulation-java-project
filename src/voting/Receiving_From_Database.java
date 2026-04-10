/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package voting;
/**
 *
 * @author Siffat
 */

import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import javafx.scene.Scene;
import javafx.scene.chart.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
//import javafx.scene.chart.CategoryAxis;
//import javafx.scene.chart.NumberAxis;
//import javafx.scene.chart.XYChart;

public class Receiving_From_Database {  
    private Stage primaryStage;

    
    
    public static Connection getConnection() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        return DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/VotingProjectDB", "root", "siffatullah.1");
    }
    
    // Method to execute the query and retrieve data from the database
    public static void Registered_Login_Data(Connection con) throws SQLException {
        String sql = "SELECT * FROM Registration";
        PreparedStatement p = con.prepareStatement(sql);
        ResultSet rs = p.executeQuery();
        while (rs.next()) {
            String cnic = rs.getString("CNIC");
            String familyNo = rs.getString("family_no");
            String Password = rs.getString("password");
            String City = rs.getString("city");
            // Do something with the data
//            System.out.println("Cnic: " + cnic + ", Family_No: " + familyNo + ", PASSWORD: " + Password+", CITY: "+City);
              System.out.println( cnic +" | "+ familyNo +" | "+ Password+" | "+City);
        }
    }
    
    
//    CHECKING FOR THE CORRECT MATCH OF INFORMATION
    
    public static boolean checkLogin(Connection con, String voterCnic, String voterFamilyNo, String voterPassword, String voterCity) throws SQLException {
        String sql = "SELECT COUNT(*) FROM Registration WHERE CNIC = ? AND family_no = ? AND password = ? AND city = ?";
        PreparedStatement p = con.prepareStatement(sql);
        p.setString(1, voterCnic);
        p.setString(2, voterFamilyNo);
        p.setString(3, voterPassword);
        p.setString(4, voterCity);
        ResultSet rs = p.executeQuery();
        rs.next();
        int count = rs.getInt(1);
        return count > 0;
    }
    
    
    public static ArrayList<String> retrieveCandidates_Party(Connection con,String voter_constituency) throws SQLException {
            
        ArrayList<String> names_and_party=new ArrayList<>();
        
        String sql = "SELECT Name, Party FROM " + voter_constituency;
        PreparedStatement p = con.prepareStatement(sql);
        ResultSet rs = p.executeQuery();
        while (rs.next()) {
              String candidateName = rs.getString("Name");
              String party = rs.getString("Party");
//                System.out.println(candidateName + "\t" + party);
                
//                ADDED RETRIVE CONSTITUENCY INFO FROM DATABASE & ADD IT ARRAYLIST
                names_and_party.add(candidateName);
                names_and_party.add(party);
                
            }
   
        // List of target party names
        ArrayList<String> targetParties = new ArrayList<>(Arrays.asList(
            "PTI", "PPP", "PML(N)", "ANP", "IND", "JUI", "TLP", "MQM"));

        // Loop through the ArrayList and find all occurrences of the target party names
        for (int i = 0; i < names_and_party.size(); i++) {
            String current = names_and_party.get(i);
            if (targetParties.contains(current)) {
                if (i > 0) {
//                    // Print the current index, party name, and the preceding name
//                    System.out.println("Index: " + i + ", Party: " + current + ", Name: " + names_and_party.get(i - 1));
                } else {
//                    // Handle the case where the party name is at the first index
                    System.out.println("Index: " + i + ", Party: " + current + ", No previous name");
                }
            }
        }   
    return names_and_party;
    }
    
    
    
    public void barchart() throws Exception{
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
        
        try{
            String sql = "SELECT Name, Votes FROM NA35_Kohat" ;
        PreparedStatement p = con.prepareStatement(sql);
        ResultSet rs = p.executeQuery();
        ArrayList<String> names=new ArrayList<>();
        ArrayList<Integer> votes=new ArrayList<>();
        while(rs.next()){
            names.add(rs.getString(1));
            votes.add(rs.getInt(2));
            
        }
        rs.close();
        CategoryAxis xAxis=new CategoryAxis();
        xAxis.setLabel("Names");
        
        NumberAxis yAxis=new NumberAxis();
        yAxis.setLabel("Votes");
        
        BarChart barChart= new BarChart(xAxis,yAxis);
        XYChart.Series dataSeries1=new XYChart.Series();
        dataSeries1.setName("Voting Table");
        
        for (int i=0; i<names.size();i++){
            dataSeries1.getData().add(new XYChart.Data(names.get(i),votes.get(i)));
        }
        barChart.getData().add(dataSeries1);
        
        VBox vbox =new VBox(barChart);
        
        Scene scene = new Scene(vbox,400,200);
        primaryStage.setScene(scene);
        primaryStage.setHeight(500);
        primaryStage.setWidth(450);
        
        primaryStage.show();
        }
    catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (con != null) {
                try {
                    con.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
         }
    }
    
    
//    public static void main(String[] args) throws Exception {
//        Receiving_From_Database obj=new Receiving_From_Database();
//        obj.barchart();
//    }
}

