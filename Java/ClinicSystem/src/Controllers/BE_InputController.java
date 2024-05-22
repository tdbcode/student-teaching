/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Classes.BE_Info;
import Classes.MenuController;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 * FXML Controller class
 */
public class BE_InputController implements Initializable {


    @FXML
    private TextField inp_FC;
    @FXML
    private TextField inp_VC;
    @FXML
    private TextField inp_price;
    @FXML
    private Button createButton;
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
    public void handleMenuAction(ActionEvent event) throws IOException {
        MenuController menu = new MenuController(myMenuBar, patientPanel, schPanel, CAPanel, homePanel); 
        menu.handleMenuAction(event);
    }
        

    @FXML
    public void sendDataChange(MouseEvent event) throws IOException {
      // Step 1
      if (event.getSource() == createButton){ 
            int fixedCosts = Integer.parseInt(inp_FC.getText());
            int variableCosts = Integer.parseInt(inp_VC.getText());
            int price = Integer.parseInt(inp_price.getText());
            
            BE_Info breakEvenInfo = new BE_Info(fixedCosts, variableCosts, price);
            
            FXMLLoader loader = new FXMLLoader(); 
            loader.setLocation(getClass().getResource("/FXML_Files/BE_Output.fxml"));
            
            Parent root = (Parent)loader.load(); 
            
            BE_OutputController controller = loader.<BE_OutputController>getController();   
            controller.receivedData(breakEvenInfo);
            
            Scene scene = new Scene(root);
            Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
            
            window.setScene(scene);
            window.show();   
        }
    }  
    
}