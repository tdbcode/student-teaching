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
public class SchedulerPanelController implements Initializable {

    @FXML
    private Button but_sch;
    @FXML
    private Button but_view;
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
        // TODO
    }    

    @FXML
    private void handleButtonAction(MouseEvent event) throws IOException {
        if (event.getSource() == but_sch){
            String FXMLn = "/FXML_Files/Scheduler.fxml";
            ControllerManager manager = new ControllerManager(); 
            manager.changePage(FXMLn, event); 
        }
        if (event.getSource() == but_view){
            String FXMLn = "/FXML_Files/ViewAppointments.fxml";
            ControllerManager manager = new ControllerManager(); 
            manager.changePage(FXMLn, event); 
        }
        
    }

    @FXML
    public void handleMenuAction(ActionEvent event) throws IOException {
        MenuController menu = new MenuController(myMenuBar, patientPanel, schPanel, CAPanel, homePanel); 
        menu.handleMenuAction(event);
    }
    
}
