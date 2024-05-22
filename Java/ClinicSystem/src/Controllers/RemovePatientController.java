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
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class
 */
public class RemovePatientController implements Initializable {

    @FXML
    private TextField inp_ID;
    @FXML
    private Button but_remove;
    @FXML
    private Label errorMessage;
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
        if (event.getSource()== but_remove){
            removePatient(idValid(), inp_ID.getText().toString());
        }    
    }
    public boolean idValid(){
        ControllerManager c1 = new ControllerManager();
        boolean flag = false; 
        try {
            Connection con = c1.getConnection();
            ResultSet rs = con.createStatement().executeQuery("select * from patient");
            int id=Integer.parseInt(inp_ID.getText());  
            
            while(rs.next()){
                if (id == rs.getInt("idpatient")){
                    flag = true; 
                }
            }
            
        } catch (Exception exc) {
             exc.printStackTrace();
        }
        
        return flag; 
        
    }
    
    public void removePatient(boolean valid, String patientID){
        
        if (valid == true){
            ControllerManager c1 = new ControllerManager(); 
            try{
                Connection myConn=c1.getConnection();
                Statement myStmt = myConn.createStatement();
                int ID = Integer.parseInt(inp_ID.getText().toString());  
                String upd=String.format("delete from patient where idpatient = '%d'",ID);  
                myStmt.executeUpdate(upd);
                    
                 } catch (Exception exc) {
                    exc.printStackTrace();
                 }
            errorMessage.setText("Removed");
        }
        if (valid == false){
            errorMessage.setText("Please enter valid patientID");
        }         
    
    }

    @FXML
    public void handleMenuAction(ActionEvent event) throws IOException {
        MenuController menu = new MenuController(myMenuBar, patientPanel, schPanel, CAPanel, homePanel); 
        menu.handleMenuAction(event);
    }
  
}
        
        
        
        
    
    

