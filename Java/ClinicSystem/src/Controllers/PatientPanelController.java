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
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.input.MouseEvent;


/**
 * FXML Controller class
 */
public class PatientPanelController implements Initializable {

    @FXML
    private Button but_viewPatients;
    @FXML
    private Button but_updatePatient;
    @FXML
    private Button but_addPatient;
    @FXML
    private Button but_removePatient;
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
        
    }  
    
    @FXML
    public void handleButtonAction(MouseEvent event) throws IOException {
        ControllerManager manager = new ControllerManager();
        if (event.getSource() == but_viewPatients){
            String FXMLn = "/FXML_Files/ViewPatient.fxml"; 
            manager.changePage(FXMLn, event); 
        }
        if (event.getSource() == but_addPatient){
            String FXMLn = "/FXML_Files/AddPatient.fxml"; 
            manager.changePage(FXMLn, event); 
        }   
        if (event.getSource() == but_updatePatient){
            String FXMLn = "/FXML_Files/UpdatePatient.fxml"; 
            manager.changePage(FXMLn, event); 
        }  
        
        if (event.getSource() == but_removePatient){
            String FXMLn = "/FXML_Files/RemovePatient.fxml"; 
            manager.changePage(FXMLn, event); 
        }  
    }

    @FXML
    public void handleMenuAction(ActionEvent event) throws IOException {
        MenuController menu = new MenuController(myMenuBar, patientPanel, schPanel, CAPanel, homePanel); 
        menu.handleMenuAction(event);
    }
    
}
