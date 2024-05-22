/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ia2;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;


public class FXMLBossController implements Initializable {
    @FXML
    private Button BTCollect;
    
    @FXML
    private Button BTStock;
    
    @FXML
    private Button BTCatalogue;
   
    public void BTCollectpress (ActionEvent event) throws SQLException, IOException {
        
        loadCollections();
        
    }
    @FXML
    public void BTStockpress (ActionEvent event) throws SQLException, IOException {
        loadStock();
    }
    
    @FXML
    public void BTCataloguepress (ActionEvent event) throws SQLException, IOException {
       Stage stage;
        Parent root;
        try{
            stage=(Stage) BTCatalogue.getScene().getWindow();
                 
        
        root = FXMLLoader.load(getClass().getResource("FXMLCatalogue.fxml"));
        
        
        Scene scene = new Scene(root);
        
        stage.setScene(scene);
        stage.show();
        }
        catch(IOException ex){
        
    }
    }
    

    public void loadCollections() throws IOException {
        Stage stage;
        Parent root;
        try{
            stage=(Stage) BTCollect.getScene().getWindow();
                 
        
        root = FXMLLoader.load(getClass().getResource("FXMLCollections.fxml"));
        
        
        Scene scene = new Scene(root);
        
        stage.setScene(scene);
        stage.show();
        }
        catch(IOException ex){
        
    }
    }
    
 
     public void loadStock() throws IOException {
        Stage stage;
        Parent root;
        try{
            stage=(Stage) BTCollect.getScene().getWindow();
                 
        
        root = FXMLLoader.load(getClass().getResource("FXMLPermanentstock.fxml"));
        
        
        Scene scene = new Scene(root);
        
        stage.setScene(scene);
        stage.show();
        }
        catch(IOException ex){
        
    }
    }
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       
    }    
    
}
