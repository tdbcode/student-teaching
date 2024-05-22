package electricityusagetracker;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.MenuButton;
import javafx.scene.layout.AnchorPane;


public class MainController implements Initializable {
    
    @FXML
    public AnchorPane rootPane;
    /*
    @FXML
    private MenuButton homesButton;
      */  
    @FXML
    private void loadOverview(ActionEvent event) throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("Overview.fxml"));
        rootPane.getChildren().setAll(pane);
    }
    
    @FXML
    private void loadAccount(ActionEvent event) throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("Account.fxml"));
        rootPane.getChildren().setAll(pane);
    }
         
    @FXML
    private void loadLog(ActionEvent event) throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("Log.fxml"));
        rootPane.getChildren().setAll(pane);
    }
    
    @FXML
    private void loadHomes (ActionEvent event)throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("Homes.fxml"));
        rootPane.getChildren().setAll(pane);
    }
     
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        AnchorPane pane = null;
        try {
            pane = FXMLLoader.load(getClass().getResource("Overview.fxml"));
        } catch (IOException ex) {
            Logger.getLogger(MainController.class.getName()).log(Level.SEVERE, null, ex);
        }
        rootPane.getChildren().setAll(pane);
       
    } 
    
}
