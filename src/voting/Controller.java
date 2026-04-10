package voting;


import com.sun.javafx.logging.PlatformLogger.Level;
import java.io.IOException;
import java.lang.System.Logger;
import java.net.URL;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
//import javafx.scene.control.Button;
import javafx.scene.control.*;
//import javafx.scene.control.RadioButton;
//import javafx.scene.control.TextField;
//import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.AnchorPane;
import java.sql.*;
import java.util.*;
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
//import voting.Insertion_To_Database;
//import static voting.Insertion_To_Database.getConnection;
import static voting.Insertion_To_Database.insertRegistrationData;
//import voting.Receiving_From_Database;
//import static voting.Receiving_From_Database.retrieveCandidates_Party;

/**
 *
 * @author Siffat
 */

public class Controller implements Initializable {
    private Stage stage;
    private Scene scene;
    private Parent parent;
    
    private ArrayList<String> names_party_List;
    private String voter_cnic;
    
//    test feild 
    static String voter_constituency;
    
    
//  REGISTRATION_PAGE FIX:IDS
    @FXML
    private Label menulabel;
    @FXML
    private TextField firstnameinput;
    @FXML
    private ComboBox<String> citycombo;
    @FXML
    private TextField emailinput;
    @FXML
    private RadioButton maleradio;
    @FXML
    private RadioButton femaleradio;
    @FXML
    private RadioButton otherradio;
    @FXML
    private TextField lastnameinput;
    @FXML
    private TextField cnicinput;
    @FXML
    private TextField passwordinput;
    @FXML
    private TextField familyinput;
    @FXML
    private Button submitbutton;
    
    
//  VOTER_LOGIN_PAGE FIX:IDS
    @FXML
    private Button loginbutton;
    @FXML
    private TextField VoterPasswordInput;
    @FXML
    private TextField VoterCnicInput;
    @FXML
    private TextField VoterFamilyInput;
    @FXML
    private ComboBox<String> combobox;
    
    
//  VOTE_CASTING_PAGE FIX:IDS
    @FXML
    private Label Show_Constituency;
    @FXML
    private Label Candidate_1;
    @FXML
    private Label Candidate_2;
    @FXML
    private Label Candidate_3;
    @FXML
    private Label Candidate_4;
    @FXML
    private Label Candidate_5;
    @FXML
    private Label Candidate_6;
    @FXML
    private ImageView SymbolPic_1;
    @FXML
    private ImageView SymbolPic_2;
    @FXML
    private ImageView SymbolPic_3;
    @FXML
    private ImageView SymbolPic_4;
    @FXML
    private ImageView SymbolPic_5;
    @FXML
    private ImageView SymbolPic_6;
    @FXML
    private RadioButton radio_1;
    @FXML
    private RadioButton radio_2;
    @FXML
    private RadioButton radio_3;
    @FXML
    private RadioButton radio_4;
    @FXML
    private RadioButton radio_5;
    @FXML
    private RadioButton radio_6;
    @FXML
    private ToggleGroup Candidate;
    
    //THANK YOU PAGE FIX ID
    @FXML
    private Label output_1;
    
//    REsult constituency page fixids'
    @FXML
    private ComboBox<String> result_combobox;
    
    
  
    

    public void SwitchToAdminRegistrationPage(ActionEvent event) throws IOException {
        Parent root= FXMLLoader.load(getClass().getResource("AdminPage(Registration).fxml"));
        stage =(Stage)((Node)event.getSource()).getScene().getWindow();
        scene=new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Voting Simulator");
        stage.show();
    }
    
    public void SwitchToAdminRegSuccessOrUnsuccess(ActionEvent event) throws IOException{
        String firstname="", lastname="", cnic="", familyno="", contact="", pass="", city="";
        String genderr=null;
        int checker;
        
        firstname =firstnameinput.getText();
        lastname  =lastnameinput.getText();
        cnic      =cnicinput.getText();
        familyno  =familyinput.getText();
        contact   =emailinput.getText();
        pass      =passwordinput.getText();
//        city      =cityinput.getText();
        city=citycombo.getValue();
        
        if (citycombo != null) {
            String value = citycombo.getValue();
            System.out.println("ComboBox value: " + value);
        } else {
            System.err.println("ComboBox is not initialized.");
        }
        
        
        if (maleradio.isSelected())
            genderr="Male";
        else if (femaleradio.isSelected())
            genderr="Female";
        else if (otherradio.isSelected())
            genderr="Others";
        
        if (firstname.isEmpty() || lastname.isEmpty() || cnic.isEmpty() || familyno.isEmpty() || pass.isEmpty() || city.isEmpty()) 
        {checker=0;}
        else {checker=1;}
        
        
//      INSERTING REGISTRATION_INFO TO THE DATABASE 

        Connection con = Insertion_To_Database.getConnection();
        if (con != null) {
            insertRegistrationData(con, firstname, lastname, cnic, familyno, genderr, contact, pass, city);
            try {
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        
        if (checker==0) {
            Parent root= FXMLLoader.load(getClass().getResource("AdminPage(UnSuccesFullRegistration).fxml"));
            stage =(Stage)((Node)event.getSource()).getScene().getWindow();
            scene=new Scene(root);
            stage.setScene(scene);
            stage.setTitle("Voting Simulator");
            stage.show();
        }
        else if (checker==1) {   
            Parent root= FXMLLoader.load(getClass().getResource("AdminPage(RegisteredSuccesFully).fxml"));
            stage =(Stage)((Node)event.getSource()).getScene().getWindow();
            scene=new Scene(root);
            stage.setScene(scene);
            stage.setTitle("Voting Simulator");
            stage.show();
            

            
        }  
        
    }
    
    public void SwitchBackToProjectFirstPage(ActionEvent event) throws IOException{
        Parent root= FXMLLoader.load(getClass().getResource("ProjectFirstPage.fxml"));
        stage =(Stage)((Node)event.getSource()).getScene().getWindow();
        scene=new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Voting Simulator");
        stage.show();
        
    }
    
    public void SwitchToVoterLoginPage(ActionEvent event) throws IOException{
        Parent root= FXMLLoader.load(getClass().getResource("VoterLoginPage.fxml"));
        stage =(Stage)((Node)event.getSource()).getScene().getWindow();
        scene=new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Voting Simulator");
        stage.show();
        
    }
    
    public void SwitchBackToVoteCasting_OR_VoteAlreadyCasted(ActionEvent event) throws IOException, SQLException{
        
//        String  voter_cnic="", voter_familyno="", voter_pass="", voter_city="",voter_constituency="";
        String   voter_familyno="", voter_pass="", voter_city="";
//        voter_cnic="",
//        made voter_cnic global for last method of vote record update
        int checker;

        voter_cnic      =VoterCnicInput.getText();
        voter_familyno  =VoterFamilyInput.getText();
        voter_pass      =VoterPasswordInput.getText();
//      voter_city      =VoterCityInput.getText();
        voter_constituency=combobox.getValue();
        System.out.println(voter_constituency);
        
//        making voter constituency on filed level to check when will it get populated and can we use later in 
        
        if (voter_cnic.isEmpty() || voter_familyno.isEmpty() || voter_pass.isEmpty() || voter_constituency.isEmpty() ) 
        { checker=0;}
        else {checker=1;}
        
        
        
//        IT WILL RETRIVE SAME DATA FOR EVERY CITY
        Connection con = Insertion_To_Database.getConnection();
        try {
//              Connection con = Insertion_To_Database.getConnection();
//              Connection con = Receiving_From_Database.getConnection();
            names_party_List=Receiving_From_Database.retrieveCandidates_Party(con,voter_constituency);
            
//            TESTING START 
            if (names_party_List != null) {
            System.out.println("names_party_List populated successfully.");
        } else {
            System.out.println("Failed to populate names_party_List.");
        }
            
            if (names_party_List != null && !names_party_List.isEmpty()) {
            int size = names_party_List.size();
            // Proceed with your logic
        } else {
            System.out.println("names_party_List is not initialized or empty.");
        }
//            TESTING DONE
            for(String name:names_party_List)
                System.out.println("1" + name);
//            con.close();
        } catch (SQLException e) {
            System.out.println(e);
        }
        
//      CHECK METHOD FOR VALIDATING LOGIN INFO WITH THE DATABASE REGISTRATION

        boolean loginValid=false;
        try {
//            
            loginValid = Receiving_From_Database.checkLogin(con, voter_cnic, voter_familyno, voter_pass, voter_constituency);
            if (loginValid) {
                System.out.println("Login successful.");
            } else {
                System.out.println("Login failed. Invalid credentials.");
            }
            con.close();
        } catch (SQLException e) {
            System.out.println(e);
        }

        
//    LAST TEST CLASSES CHECKING FOR CNIC WHETHER VOTE CASTED OR NOT
      try {
            if (hasUserVoted(voter_cnic)) {
//                messageLabel.setText("You have already cast your vote.");
                  System.out.println("You have already cast your vote.");
            }

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("ou have already cast your vote.");
//            messageLabel.setText("An error occurred while processing your vote.");
        }
        
        
        
         if (hasUserVoted(voter_cnic)){
             Parent root= FXMLLoader.load(getClass().getResource("VoteAlreadyCasted.fxml"));
                stage =(Stage)((Node)event.getSource()).getScene().getWindow();
                scene=new Scene(root);
                stage.setScene(scene);
                stage.setTitle("Voting Simulator");
                stage.show();
             
             
             
         }
         else if (checker==0 || loginValid==false)
        {
                 Parent root= FXMLLoader.load(getClass().getResource("Not_Registered.fxml"));
                stage =(Stage)((Node)event.getSource()).getScene().getWindow();
                scene=new Scene(root);
                stage.setScene(scene);
                stage.setTitle("Voting Simulator");
                stage.show();
                
        }
        
        
        
        

        else if (checker==1 && loginValid==true)
        {  
            FXMLLoader loader = new FXMLLoader(getClass().getResource("VoteCastingPage.fxml"));
            Parent root = loader.load();

            // Get the controller of the next scene
            Controller nextSceneController = loader.getController();

            // Pass data to the next scene
            nextSceneController.setData(names_party_List);

            // Show the next scene
            Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.show();
            
          }
}   
        
    public void SwitchTo_Result_Constituency(ActionEvent event) throws IOException 
    {
        
        Parent root= FXMLLoader.load(getClass().getResource("Result(Constituency).fxml"));
        stage =(Stage)((Node)event.getSource()).getScene().getWindow();
        scene=new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Voting Simulator");
        stage.show();
    }
            
//    make an class level array here & then through loop class method put information in it and then access same array detail in setdata  
       
        public void Vote_Records_Updated(ActionEvent event) throws IOException{
            
             RadioButton selectedRadioButton = (RadioButton) Candidate.getSelectedToggle();
    if (selectedRadioButton == null) {
        // No candidate selected, show an error message
        
        showAlert("Error", "Please select a candidate before submitting your vote.");
        return;
    }

            String selectedCandidate = selectedRadioButton.getText();
            incrementVote(selectedCandidate);

            showAlert("Success", "Your vote has been successfully cast for " + selectedCandidate + ".");
    
    
    
        
            FXMLLoader loader = new FXMLLoader(getClass().getResource("ThankYou.fxml"));
            Parent root = loader.load();

            // Get the controller of the next scene
            Controller nextSceneController = loader.getController();

            // Pass data to the next scene
            nextSceneController.setRecord("heello world");

            // Show the next scene
            Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.show();
         
            
           Connection con = Insertion_To_Database.getConnection();
            try {

            // Prepare an SQL statement to insert data
            String sql = "UPDATE Registration SET has_voted =? WHERE CNIC = ?";
            PreparedStatement statement = con.prepareStatement(sql);
            
            // Assign values to the placeholders
            
            statement.setBoolean(1, true);
            statement.setString(2, voter_cnic);

            // Execute the statement
            int rowsInserted = statement.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("Vote casted susseccfully by"+voter_cnic);
            }
            con.close();
        } catch (SQLException e) {
            System.out.println("Data insertion failed");
            e.printStackTrace();
        }  
        }
        
    public void setRecord(String yes ) {
//      output_1.setText(yes);

       
}

    
//    ANOTHER SETDATA METHOD FOR TEST 2 EVEN THOUGH FIRST ONE WORK FINE    TEST BETA
    
    public void setData(ArrayList<String> names_party_List1) {
        
    Image JI_image = new Image(getClass().getResourceAsStream("JI.png"));
    Image JUI_image = new Image(getClass().getResourceAsStream("JUI.png"));
    Image PTI_image = new Image(getClass().getResourceAsStream("PTI.png"));
    Image PPP_image = new Image(getClass().getResourceAsStream("PPP.png"));
    Image MQM_image = new Image(getClass().getResourceAsStream("MQM.png"));
    Image PML_image = new Image(getClass().getResourceAsStream("PML.png"));
    Image TLP_image = new Image(getClass().getResourceAsStream("TLP.png"));
    Image IND_image = new Image(getClass().getResourceAsStream("IND.png"));
    Image ANP_image = new Image(getClass().getResourceAsStream("ANP.png"));

    List<Label> candidateLabels = List.of(Candidate_1, Candidate_2, Candidate_3, Candidate_4, Candidate_5, Candidate_6);
    List<ImageView> symbolPics = List.of(SymbolPic_1, SymbolPic_2, SymbolPic_3, SymbolPic_4, SymbolPic_5, SymbolPic_6);
    List<RadioButton> radioButtons = List.of(radio_1, radio_2, radio_3, radio_4, radio_5, radio_6);

    Show_Constituency.setText(voter_constituency);
    Map<String, Image> partyImages = new HashMap<>();
    partyImages.put("PTI", PTI_image);
    partyImages.put("PPP", PPP_image);
    partyImages.put("PML(N)", PML_image);
    partyImages.put("ANP", ANP_image);
    partyImages.put("JI", JI_image);
    partyImages.put("JUI", JUI_image);
    partyImages.put("MQM", MQM_image);
    partyImages.put("TLP", TLP_image);
    partyImages.put("IND", IND_image);

    int labelIndex = 0;

    for (int index = 0; index < names_party_List1.size(); index++) {
        String party = names_party_List1.get(index);
        if (partyImages.containsKey(party)) {
            String candidate = names_party_List1.get(index - 1);
            candidateLabels.get(labelIndex).setText(candidate);
            symbolPics.get(labelIndex).setImage(partyImages.get(party));
            radioButtons.get(labelIndex).setText(candidate);          
            labelIndex++;
            if (labelIndex >= candidateLabels.size()) {
                break; 
            }
        }
    }

 
    // Clear remaining labels and images if any
    for (int i = labelIndex; i < candidateLabels.size(); i++) {
        candidateLabels.get(i).setText("");
        symbolPics.get(i).setImage(null);
        radioButtons.get(i).setText("");        
    }
}






    
    public void handleSubmit(ActionEvent event)throws IOException {
//    RadioButton selectedRadioButton = (RadioButton) Candidate.getSelectedToggle();
//    if (selectedRadioButton == null) {
//        // No candidate selected, show an error message
//        
//        showAlert("Error", "Please select a candidate before submitting your vote.");
//        return;
//    }
//
//    String selectedCandidate = selectedRadioButton.getText();
//    incrementVote(selectedCandidate);
//
//    showAlert("Success", "Your vote has been successfully cast for " + selectedCandidate + ".");
//    
}



//}
    
        public void incrementVote(String candidateName) {
            Connection con = Insertion_To_Database.getConnection();
//                System.out.println(voter_constituency+"****");
//                System.out.println(candidateName);
                
            // Validate input parameters
            if (candidateName == null || candidateName.isEmpty()) {
                throw new IllegalArgumentException("Candidate name cannot be null or empty");
            }
            if (voter_constituency == null || voter_constituency.isEmpty()) {
                throw new IllegalArgumentException("Table name cannot be null or empty");
            }

            // Construct the SQL update query
            String updateQuery = "UPDATE " + voter_constituency + " SET Votes = Votes + 1 WHERE Name = ?";
//            System.out.println("Executing query: " + updateQuery);

            try (PreparedStatement preparedStatement = con.prepareStatement(updateQuery)) {
                // Set the candidate name parameter
                preparedStatement.setString(1, candidateName);

                int rowsAffected = preparedStatement.executeUpdate();
                System.out.println("Rows affected: " + rowsAffected);
            } catch (SQLException e) {
                e.printStackTrace();
                throw new RuntimeException("Error incrementing vote", e);
            }
        }

        public void showAlert(String title, String message) 
        {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
        }


    
//    test beta end here 
    
        public void set_LoginCity_ChoiceBox(MouseEvent event)throws IOException
        {
            combobox.getItems().add("NA123_Lahore_I");
            combobox.getItems().add("NA244_Karachi");
            combobox.getItems().add("NA130_Lahore_XIV");
            combobox.getItems().add("NA262_Quetta_I");
            combobox.getItems().add("NA30_Peshawar");
            combobox.getItems().add("NA35_Bannu");
            combobox.getItems().add("NA35_Kohat");
            combobox.getItems().add("NA41_LakkiMarwat");
            combobox.getItems().add("NA52_Islamabad");      
        }

        public void set_CityRegistration_ChoiceBox(MouseEvent event)throws IOException
        {
            citycombo.getItems().add("NA123_Lahore_I");
            citycombo.getItems().add("NA244_Karachi");
            citycombo.getItems().add("NA130_Lahore_XIV");
            citycombo.getItems().add("NA262_Quetta_I");
            citycombo.getItems().add("NA30_Peshawar");
            citycombo.getItems().add("NA35_Bannu");
            citycombo.getItems().add("NA35_Kohat");
            citycombo.getItems().add("NA41_LakkiMarwat");
            citycombo.getItems().add("NA52_Islamabad");
         }
        
        
 
        
    @Override
    public void initialize(URL url,ResourceBundle rb){
//        TESTING FOR NULL EXCEPTION ERROR
        names_party_List = new ArrayList<>();
    }
    
//    LAST TEST CLASSES CHECKING FOR CNIC WHETHER VOTE CASTED OR NOT
    
    public boolean hasUserVoted(String cnic) throws SQLException {
        String sql = "SELECT has_voted FROM Registration WHERE CNIC = ?";
        try (Connection conn = Insertion_To_Database.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, voter_cnic);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                return rs.getBoolean("has_voted");
            }
        }
        return false;
    }
    
    }

  

    

