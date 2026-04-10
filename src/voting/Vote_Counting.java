///*
// * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
// * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
// */
//package voting;
//    import javafx.fxml.FXML;
//import javafx.scene.control.Label;
//import javafx.scene.control.RadioButton;
//import javafx.scene.control.ToggleGroup;
//import javafx.scene.image.Image;
//import javafx.scene.image.ImageView;
//import javafx.scene.input.MouseEvent;
//
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.PreparedStatement;
//import java.sql.SQLException;
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
///**
// *
// * @author cosmo
// */
//public class Vote_Counting {
//    
//
//
//
//
//    @FXML
//    private ToggleGroup Candidate;
//    
//    @FXML
//    private RadioButton radio_1;
//    
//    @FXML
//    private RadioButton radio_2;
//    
//    @FXML
//    private RadioButton radio_3;
//    
//    @FXML
//    private RadioButton radio_4;
//    
//    @FXML
//    private RadioButton radio_5;
//    
//    @FXML
//    private RadioButton radio_6;
//
//    @FXML
//    private Label Candidate_1;
//    
//    @FXML
//    private Label Candidate_2;
//    
//    @FXML
//    private Label Candidate_3;
//    
//    @FXML
//    private Label Candidate_4;
//    
//    @FXML
//    private Label Candidate_5;
//    
//    @FXML
//    private Label Candidate_6;
//
//    @FXML
//    private ImageView SymbolPic_1;
//    
//    @FXML
//    private ImageView SymbolPic_2;
//    
//    @FXML
//    private ImageView SymbolPic_3;
//    
//    @FXML
//    private ImageView SymbolPic_4;
//    
//    @FXML
//    private ImageView SymbolPic_5;
//    
//    @FXML
//    private ImageView SymbolPic_6;
//
//    private Connection connection;
//
//    public Vote_Counting {
//        // Initialize the database connection
//        try {
//            connection = DriverManager.getConnection("jdbc:your_database_url", "username", "password");
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }
//
//    @FXML
//    public void handleSubmit(MouseEvent event) {
//        RadioButton selectedRadioButton = (RadioButton)Candidate.getSelectedToggle();
//        if (selectedRadioButton != null) {
//            String selectedCandidate = selectedRadioButton.getText();
//            incrementVote(selectedCandidate);
//        }
//    }
//
//    private void incrementVote(String candidateName) {
//        String updateQuery = "UPDATE candidates SET votes = votes + 1 WHERE name = ?";
//        try (PreparedStatement preparedStatement = connection.prepareStatement(updateQuery)) {
//            preparedStatement.setString(1, candidateName);
//            preparedStatement.executeUpdate();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }
//
//    public void setData(ArrayList<String> names_party_List1) {
//        Image JI_image = new Image(getClass().getResourceAsStream("JI.png"));
//        Image JUI_image = new Image(getClass().getResourceAsStream("JUI.png"));
//        Image PTI_image = new Image(getClass().getResourceAsStream("PTI.png"));
//        Image PPP_image = new Image(getClass().getResourceAsStream("PPP.png"));
//        Image MQM_image = new Image(getClass().getResourceAsStream("MQM.png"));
//        Image PML_image = new Image(getClass().getResourceAsStream("PML.png"));
//        Image TLP_image = new Image(getClass().getResourceAsStream("TLP.png"));
//        Image IND_image = new Image(getClass().getResourceAsStream("IND.png"));
//        Image ANP_image = new Image(getClass().getResourceAsStream("ANP.png"));
//
//        List<Label> candidateLabels = List.of(Candidate_1, Candidate_2, Candidate_3, Candidate_4, Candidate_5, Candidate_6);
//        List<ImageView> symbolPics = List.of(SymbolPic_1, SymbolPic_2, SymbolPic_3, SymbolPic_4, SymbolPic_5, SymbolPic_6);
//        List<RadioButton> radioButtons = List.of(candidateRadioButton_1, candidateRadioButton_2, candidateRadioButton_3, candidateRadioButton_4, candidateRadioButton_5, candidateRadioButton_6);
//
//        Map<String, Image> partyImages = new HashMap<>();
//        partyImages.put("PTI", PTI_image);
//        partyImages.put("PPP", PPP_image);
//        partyImages.put("PML(N)", PML_image);
//        partyImages.put("ANP", ANP_image);
//        partyImages.put("JI", JI_image);
//        partyImages.put("JUI", JUI_image);
//        partyImages.put("MQM", MQM_image);
//        partyImages.put("TLP", TLP_image);
//        partyImages.put("IND", IND_image);
//
//        int labelIndex = 0;
//
//        for (int index = 0; index < names_party_List1.size(); index++) {
//            String party = names_party_List1.get(index);
//            if (partyImages.containsKey(party)) {
//                String candidate = names_party_List1.get(index - 1);
//                candidateLabels.get(labelIndex).setText(candidate);
//                symbolPics.get(labelIndex).setImage(partyImages.get(party));
//                radioButtons.get(labelIndex).setText(candidate);
//                labelIndex++;
//                if (labelIndex >= candidateLabels.size()) {
//                    break; // Break if all labels are filled
//                }
//            }
//        }
//
//        // Clear remaining labels and images if any
//        for (int i = labelIndex; i < candidateLabels.size(); i++) {
//            candidateLabels.get(i).setText("");
//            symbolPics.get(i).setImage(null); // Assuming null clears the image
//            radioButtons.get(i).setText("");
//        }
//    }
//}
//
//    
//
