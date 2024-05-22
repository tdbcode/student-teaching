/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ia2;


import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class FXMLLoginController implements Initializable {

    private void handleButtonAction(ActionEvent event) throws SQLException {
  
        Connection conn=null;
             
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").newInstance();
            conn = DriverManager.getConnection("jdbc:sqlserver://FS1;databaseName=DB3", "Db3User", "w5`/9gBS");
            
            if(conn!=null)
                System.out.println("Database Successfully connected");
            
            Statement stmt = conn.createStatement();
            
            String query = "select * from LoginC";
            ResultSet rs = stmt.executeQuery(query);
            
            String UsernameDB;
            String PasswordDB;
            int priority;
            String username = TBusername.getText();
            String password = TBpassword.getText();
            
            while(rs.next()){
                UsernameDB = rs.getString("username").trim();
                PasswordDB = rs.getString("password").trim();
                priority=rs.getInt("priority");
                System.out.println(UsernameDB + " " + PasswordDB + " " + priority);
                
                 if ((username.equals(UsernameDB)) & (password.equals(PasswordDB))) {
                    label1.setText("Log in");
                    if(priority==1){
                        loadBoss();
                        break;
                    }
                    else if (priority==2){
                        loadEmployee();
                        break;
                    }
                    else {
                        loadCatalogue();
                        break;
                    }
                }
                else {
                     label1.setText("Wrong Try again");
                }
            }
        }
            
        catch(Exception ex){
           System.out.println(ex);   
        }            
    }
    
   
    public void loadBoss() throws IOException {
        Stage stage;
        Parent root;
        try{
            stage=(Stage) button.getScene().getWindow();
            root = FXMLLoader.load(getClass().getResource("FXMLBoss.fxml"));
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }
        catch(IOException ex){
            System.out.println("Error!");
        }
    }
    
    public void loadEmployee() throws IOException {
        Stage stage;
        Parent root;
        try{
            stage=(Stage) button.getScene().getWindow();
                 
        
        root = FXMLLoader.load(getClass().getResource("FXMLEmployepermanent.fxml"));
        
        Scene scene = new Scene(root);
        
        stage.setScene(scene);
        stage.show();
        }
        catch(IOException ex){
            System.out.println("Error!");
        }
    }
    
    
    public void loadCatalogue() throws IOException {
        Stage stage;
        Parent root;
        try{
            stage=(Stage) button.getScene().getWindow();
                 
        
        root = FXMLLoader.load(getClass().getResource("FXMLCatalogueC.fxml"));
        
        Scene scene = new Scene(root);
        
        stage.setScene(scene);
        stage.show();
        }
        catch(IOException ex){
            System.out.println("Error!");
        }
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
    
   
      
    



