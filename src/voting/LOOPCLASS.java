/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package voting;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;


/**
 *
 * @author Siffat Khan
 */
public class LOOPCLASS {
//    static ArrayList<String> names_and_party=new ArrayList<>();
    
    // Method to execute the query and retrieve data from the database
//    public static ArrayList<String> retrieveCandidates_Party(Connection con,String voter_constituency) throws SQLException {
//        ArrayList<String> names_and_party=new ArrayList<>();
//        
////        String sql = "SELECT Name, Party FROM " + tableName;        
////                                    HAVE TO USE PARAMETER HERE INSTEAD OF NA35_BANNU
//        String sql = "SELECT Name, Party FROM " + voter_constituency;
//        
//        PreparedStatement p = con.prepareStatement(sql);
//        ResultSet rs = p.executeQuery();
//        while (rs.next()) {
//              String candidateName = rs.getString("Name");
//              String party = rs.getString("Party");
////                System.out.println(candidateName + "\t" + party);
//                
////                ADDED RETRIVE CONSTITUENCY INFO FROM DATABASE & ADD IT ARRAYLIST
//                names_and_party.add(candidateName);
//                names_and_party.add(party);
//                
//            }
//   
//        // List of target party names
//        ArrayList<String> targetParties = new ArrayList<>(Arrays.asList(
//            "PTI", "PPP", "PML(N)", "ANP", "IND", "JUI", "TLP", "MQM"));
//
//        // Loop through the ArrayList and find all occurrences of the target party names
//        for (int i = 0; i < names_and_party.size(); i++) {
//            String current = names_and_party.get(i);
//            if (targetParties.contains(current)) {
//                if (i > 0) {
////                    // Print the current index, party name, and the preceding name
////                    System.out.println("Index: " + i + ", Party: " + current + ", Name: " + names_and_party.get(i - 1));
//                } else {
////                    // Handle the case where the party name is at the first index
//                    System.out.println("Index: " + i + ", Party: " + current + ", No previous name");
//                }
//            }
//        }
//        
////        for (String names:names_and_party)
////                System.out.println(names);
////        Controller.setData();    
//    return names_and_party;
//    }
//    public static void main(String[] args) {
//        try {
//            Connection  con = Receiving_From_Database.getConnection();
//            ArrayList<String> names_and_party=retrieveCandidates_Party(con,"NA35_BANNU");
//            con.close();
//        } catch (ClassNotFoundException | SQLException e) {
//            System.out.println(e);
//        }
//    }
}






    

