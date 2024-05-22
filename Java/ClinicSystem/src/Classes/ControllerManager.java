/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class ControllerManager {
    
    public void changePage(String FXMLname, MouseEvent event) throws IOException{
        Parent dashboard = FXMLLoader.load(getClass().getResource(FXMLname));
        Scene scene = new Scene(dashboard);

        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();

        window.setScene(scene);
        window.show();   
    }
    
    public Connection getConnection() throws SQLException{
        String url = "jdbc:mysql://localhost:3306/ClinicDatabase?useSSL=false";
        String SQLuser = "root";
        String SQLpassword = "RicSofLondon07";
        return DriverManager.getConnection(url, SQLuser, SQLpassword);
    }

    
    
    
}
