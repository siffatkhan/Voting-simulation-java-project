///*
// * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
// * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
// */
//package voting;
//
///**
// *
// * @author cosmo
// */
//
//
//
//
//
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//
//public class for_constituency_candidates {
//    
//    
//        public static Connection getConnection() throws ClassNotFoundException, SQLException {
//        Class.forName("com.mysql.cj.jdbc.Driver");
//        return DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/VotingProjectDB", "root", "siffatullah.1");
//    }
//    
//    // Method to execute the query and retrieve data from the database
//    public static void retrieveCandidates_Party(Connection con) throws SQLException {
////        String sql = "SELECT Name, Party FROM " + tableName;
//        String sql = "SELECT Name, Party FROM " + "NA35_Bannu";
//        
//        PreparedStatement p = con.prepareStatement(sql);
//        ResultSet rs = p.executeQuery();
//        while (rs.next()) {
//              String candidateName = rs.getString("Name");
//                String party = rs.getString("Party");
//                System.out.println(candidateName + "\t" + party);
//            }
//            }
// 
//    // Main method to test the functionality
//    public static void main(String[] args) throws ClassNotFoundException {
//        try {
//            Connection con = getConnection();
//            retrieveCandidates_Party(con);
//            con.close();
//        } catch (SQLException e) {
//            System.out.println(e);
//        }
//    }
//}
//
//
//    
//
//    
//
