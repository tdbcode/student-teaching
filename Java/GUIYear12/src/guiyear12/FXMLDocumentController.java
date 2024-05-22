/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guiyear12;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 *
 * @author thomas.brady
 */
public class FXMLDocumentController implements Initializable {
    
    @FXML
    private Label label;
    
    @FXML
    private TextField TBUsername;
    
    @FXML
    private TextField TBPassword;
    
    @FXML 
    private Button button;
    
    
    @FXML
    private void handleButtonAction(ActionEvent event) throws IOException {
         String Username = TBUsername.getText();
         String Password = TBPassword.getText();
         
         if(Username.equals("Tristan") && Password.equals("IsAGreatStudent")){
             label.setText("You have logged in!");
        Stage stage=(Stage)  button.getScene().getWindow();
             Parent root = FXMLLoader.load(getClass().getResource("FXMLLoggedIn.fxml"));
        
        Scene scene = new Scene(root);
        
        stage.setScene(scene);
        stage.show();
         } else{
             label.setText("Login failed!");
         }
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
