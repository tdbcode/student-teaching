/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Classes.ControllerManager;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;




/**
 * FXML Controller class
 */
public class LoginController implements Initializable{
    // All buttons to be used
    @FXML 
    private TextField usernameText; 
    
    @FXML
    private TextField passwordText; 
    
    @FXML
    private Button loginButton;
    
    
    @FXML
    private Label errorText;
    
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }
    
    


//login method that checks if input password is in database and acts accoridnly 
    public String login(){
        String ableLogin = ""; 
        

        //Get a connection to database
        try {       
            
            String username = usernameText.getText(); 
            String password = passwordText.getText();
            ControllerManager c1 = new ControllerManager(); 
            Connection myConn = c1.getConnection();
            String sqlString = "SELECT * from users WHERE username=? and password=?";
            PreparedStatement login = myConn.prepareStatement(sqlString);
            login.setString(1, username);
            login.setString(2, password);
            ResultSet rs = login.executeQuery();
            
            if (!rs.next()) {
                    errorText.setText("Enter Correct Username/Password");
                    ableLogin = "Error";
                } else {
                    errorText.setText("Login Successful..Redirecting..");
                    ableLogin = "success";
                }

        } catch (Exception exc) {
            exc.printStackTrace();
        }
        
        return ableLogin; 
    }

    //method that opens screens 
    @FXML
    public void handleButtonAction(MouseEvent event) throws IOException {
        if (event.getSource() == loginButton){
            if (login().equals("success")){
                
                String FXMLn = "/FXML_Files/Dashboard.fxml"; 
                ControllerManager manager = new ControllerManager(); 
                manager.changePage(FXMLn, event); 
            }
            
        }            
                
    }
            
}

       

    
