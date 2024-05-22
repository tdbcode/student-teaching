/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myia;

import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;


/**
 *
 * @author thomas.brady
 */
public class FXMLLoginController implements Initializable {
       Connection conn=null;
    @FXML
    private Label label;
    
    @FXML
    private TextField TBUsername;
   
    @FXML
    private PasswordField TBPassword;
    
    @FXML
    private void handleButtonAction(ActionEvent event) throws SQLException, ClassNotFoundException {
        String username = TBUsername.getText();
        String password = TBPassword.getText();
        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            conn = DriverManager.getConnection("jdbc:sqlserver://FS1;databaseName=DBTEST", "tom", "DbTest147");

           if(conn!=null){
                System.out.println("Database Successfully connected");
           }
        
            Statement stmt = null;
            String query = "select username, password from Login";
  
             stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query);
        
             String usernameDB;
             String passwordDB;
             boolean loggedin = false;
                     
             while (rs.next()) {
                usernameDB = rs.getString("username").trim();
                passwordDB = rs.getString("password").trim();
                System.out.println(usernameDB + " " + passwordDB);
        
                 if (username.equals(usernameDB) && password.equals(passwordDB)){
                    label.setText("Logged in");
                    loggedin = true;
                    break;
                }
                else{
                    label.setText("Login Failed!");
                }
        
            }
             
             if(loggedin){
                 
             }
        }
        catch(Exception ex){
            
        }
    }
    

    @Override
    public void initialize(URL url, ResourceBundle rb) {
       
          /*   try {
       
                Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").newInstance();
                conn = DriverManager.getConnection("jdbc:sqlserver://FS1;databaseName=DBTEST", "tom", "DbTest147");

                if(conn!=null)
                    System.out.println("Database Successfully connected"); 
                
                
             // Statement stmt = conn.createStatement();
                
           //    stmt.executeUpdate(CREATE_TABLE_SQL);

          //      System.out.println("Table created");
         
            } catch (Exception e) {
                e.printStackTrace();
            } */
    }
}
