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
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Stage;

/**
 * FXML Controller class
 */
public class FXMLCatalogueCController extends FXMLCatalogueController implements Initializable  {
    
    @FXML
    private Button BTBack;
    
    

     @Override
    public void loadBoss() throws IOException {
        Stage stage;
        Parent root;
        try{
            stage=(Stage) BTBack.getScene().getWindow();
                 
        root = FXMLLoader.load(getClass().getResource("FXMLLogin.fxml"));
        
        Scene scene = new Scene(root);
        
        stage.setScene(scene);
        stage.show();
        }
        catch(IOException ex){
            System.out.println("Error!");
        }
}
}
