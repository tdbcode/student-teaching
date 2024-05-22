/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Classes.ControllerManager;
import Classes.MenuController;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import java.sql.PreparedStatement;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;


/**
 * FXML Controller class
 */
public class CreateAccountController implements Initializable {
    
    ObservableList<TextField> textFields = FXCollections.observableArrayList();
    ObservableList<Object> otherFields = FXCollections.observableArrayList();
    
    @FXML
    private TextField firstName; 
    @FXML
    private TextField lastName; 
    @FXML
    private TextField username;
    @FXML
    private PasswordField password; 
    @FXML 
    private PasswordField confirm; 
    @FXML
    private Button createButton;
    @FXML
    private Label errorText;
    @FXML
    private MenuBar myMenuBar;
    @FXML
    private MenuItem homePanel;
    @FXML
    private MenuItem patientPanel;
    @FXML
    private MenuItem schPanel;
    @FXML
    private MenuItem CAPanel;
    
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        textFields.addAll(firstName, lastName, username); 
    }    
    
    boolean valid = false;
    
    @FXML
    public void handleButtonAction(MouseEvent event) throws IOException {
        
        if (event.getSource() == createButton){
            createAccount(passwordValid()); 
        }
        
    }
    @FXML
    public void handleMenuAction(ActionEvent event) throws IOException {
        MenuController menu = new MenuController(myMenuBar, patientPanel, schPanel, CAPanel, homePanel); 
        menu.handleMenuAction(event);
    }

    public boolean passwordValid(){

        String password1 = password.getText();
        String password2 = confirm.getText();

        if (password1.equals(password2)){
            errorText.setText("Account created");
            valid = true; 
        }
        
        else{
            
            errorText.setText("Passwords don't match");
            
        }

        return valid; 
    }
        
    public void createAccount (boolean valid){
        if (valid == true && checkTextFieldNull(textFields)){
            try {
                ControllerManager c1 = new ControllerManager();  
                Connection myConn = c1.getConnection(); 
                String sql = "insert into users " + " (firstname, lastname, username, password)"
                        + " values (?,?,?,?)";
                
                PreparedStatement myStmt = myConn.prepareStatement(sql);
                
                myStmt.setString(1, firstName.getText());
                myStmt.setString(2, lastName.getText());
                myStmt.setString(3, username.getText());
                myStmt.setString(4, password.getText());
                
                myStmt.execute();
            
            } catch (Exception exc) {
            exc.printStackTrace();
            }    
        }
        
        else if (valid == true && !checkTextFieldNull(textFields) ){
            errorText.setText("Please fill in all the fields");
        }
        
        else if (valid != true && checkTextFieldNull(textFields) ){
            errorText.setText("Please enter the right password ");
        }
        else{
            errorText.setText("yo"); 
        }
    }
    
    public boolean checkTextFieldNull(ObservableList<TextField> fields){
        boolean flag = true; 
        for (int i = 0; i < fields.size(); i++)
        {
            if ((fields.get(i).getText().equals(""))){
                return false; 
            }
        }  
        return flag; 
    } 
    
    
    
}

    