/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import Classes.*;

/**
 * FXML Controller class
 */
public class DashboardController implements Initializable {
    
    @FXML
    private Button patientPButton; 
    @FXML
    private Button schedulerButton; 
    @FXML
    private Button createAccountButton;
    @FXML
    private Button financeTool;
    
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    @FXML
    public void handleButtonAction(MouseEvent event) throws IOException {
        if (event.getSource() == patientPButton){
            String FXMLn = "/FXML_Files/PatientPanel.fxml";
            ControllerManager manager = new ControllerManager(); 
            manager.changePage(FXMLn, event); 
        }
        if (event.getSource() == schedulerButton){
            String FXMLn = "/FXML_Files/SchedulerPanel.fxml";
            ControllerManager manager = new ControllerManager(); 
            manager.changePage(FXMLn, event); 
        }
        if (event.getSource() == createAccountButton){
            String FXMLn = "/FXML_Files/CreateAccount.fxml"; 
            ControllerManager manager = new ControllerManager(); 
            manager.changePage(FXMLn, event); 
        }
        if (event.getSource() == financeTool){
            String FXMLn = "/FXML_Files/BE_Input.fxml"; 
            ControllerManager manager = new ControllerManager(); 
            manager.changePage(FXMLn, event); 
        }
        
    }
    
    
}    

