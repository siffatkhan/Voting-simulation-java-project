/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package voting;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
//import javafx.scene.Node;
//import javafx.scene.Parent;
import javafx.scene.*;
import javafx.stage.Stage;



import javafx.fxml.FXML;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javafx.scene.control.ComboBox;
import javafx.scene.input.MouseEvent;

public class ResultController {
    private String voter_constituency;
    private Stage stage;
    private Scene scene;
    private Parent parent;
    
    
    @FXML
    private ComboBox<String> result_combobox;
    @FXML
    private BarChart<String, Number> barChart;

    @FXML
    private CategoryAxis xAxis;

    @FXML
    private NumberAxis yAxis;

    // Other existing methods and actions

    
    

    
        public void SwitchBackToProjectFirstPage(ActionEvent event) throws IOException{
        Parent root= FXMLLoader.load(getClass().getResource("ProjectFirstPage.fxml"));
        stage =(Stage)((Node)event.getSource()).getScene().getWindow();
        scene=new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Voting Simulator");
        stage.show();
        
    }
    
    @FXML
private void Switch_To_ResultShowingPage(ActionEvent event) throws IOException {
    try {
        voter_constituency=result_combobox.getValue();
        System.out.println("heelo resulttt"+voter_constituency);
        FXMLLoader loader = new FXMLLoader(getClass().getResource("ResultShowing.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();

        // Get controller and call loadData method
        ResultController controller = loader.getController();
        controller.loadData(voter_constituency);

    } catch (IOException e) {
        e.printStackTrace();
    }
}

    private void loadData(String voter_constituency) {
        Connection con = null;
        try {
            // Load the MySQL JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Establish a Connection
            con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/VotingProjectDB", "root", "siffatullah.1");
            System.out.println("Connected To The Database Successfully");

            String sql = "SELECT Name, Party, Votes FROM "+ voter_constituency; // Adjust table name if necessary
            PreparedStatement p = con.prepareStatement(sql);
            ResultSet rs = p.executeQuery();
            ArrayList<String> names = new ArrayList<>();
            ArrayList<Integer> votes = new ArrayList<>();
            while (rs.next()) {
                String nameParty = rs.getString(1) + "\n" + rs.getString(2);
                names.add(nameParty);
                votes.add(rs.getInt(3));
            }
            rs.close();

            xAxis.setLabel("Names and Parties");
            yAxis.setLabel("Votes");

            XYChart.Series<String, Number> dataSeries1 = new XYChart.Series<>();
            dataSeries1.setName("Voting Table");

            for (int i = 0; i < names.size(); i++) {
                dataSeries1.getData().add(new XYChart.Data<>(names.get(i), votes.get(i)));
            }
            barChart.getData().add(dataSeries1);
        } catch (Exception e) {
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
    
    
       public void Result_ChoiceBox(MouseEvent event)throws IOException
        {
            result_combobox.getItems().add("NA123_Lahore_I");
            result_combobox.getItems().add("NA244_Karachi");
            result_combobox.getItems().add("NA130_Lahore_XIV");
            result_combobox.getItems().add("NA262_Quetta_I");
            result_combobox.getItems().add("NA30_Peshawar");
            result_combobox.getItems().add("NA35_Bannu");
            result_combobox.getItems().add("NA35_Kohat");
            result_combobox.getItems().add("NA41_LakkiMarwat");
            result_combobox.getItems().add("NA52_Islamabad");
        }
    
}



    
    

