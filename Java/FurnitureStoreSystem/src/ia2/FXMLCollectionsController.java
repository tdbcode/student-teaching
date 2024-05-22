/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ia2;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import java.util.Scanner;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;


public class FXMLCollectionsController implements Initializable {

    @FXML
    private Button BTCreate;
    
    @FXML
    private Button BTDelete;
    
    @FXML
    private TextField CollectionInput;
    
    @FXML
    private TextField FurnitureName;
    
    @FXML
    private TextField FurnitureType;
    
    @FXML
    private TextField FurnitureStock; 
    
    @FXML
    private Button BTCreateFurniture;
    
    @FXML
    private Button BTDeleteFurniture;
    
    @FXML
    private TextField CollectionInputFurniture;
    
    @FXML
    private Button BTBack;
    
     @FXML
    public void CreateCollection (ActionEvent event) throws SQLException {
        String collectionName = CollectionInput.getText();
        
         Connection conn=null;
         String CollectionTableName;
             
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").newInstance();
            conn = DriverManager.getConnection("jdbc:sqlserver://FS1;databaseName=DB3", "Db3User", "w5`/9gBS");
            
            if(conn!=null)
                System.out.println("Database Successfully connected");
            
            Statement stmt = conn.createStatement();
            
            CollectionTableName = "CREATE TABLE " +collectionName+ "(Name VARCHAR(25), Type VARCHAR(25), stock int)";
           stmt.executeUpdate(CollectionTableName);
            System.out.println("Table Created!");
           
        }
        catch(Exception ex){
             System.out.println("Execute Query Error!");
           
        }
    }
    @FXML
    public void DeleteColletion (ActionEvent event) throws SQLException {
         String collectionName = CollectionInput.getText();
        
         Connection conn=null;
         String CollectionTableName;
             
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").newInstance();
            conn = DriverManager.getConnection("jdbc:sqlserver://FS1;databaseName=DB3", "Db3User", "w5`/9gBS");
            
            if(conn!=null)
                System.out.println("Database Successfully connected");
            
            Statement stmt = conn.createStatement();
            
            CollectionTableName = "DROP TABLE " +collectionName;
           stmt.executeUpdate(CollectionTableName);
            System.out.println("Table Deleted!");
           
        }
        catch(Exception ex){
             System.out.println("Execute Query Error!");
           
        }
    }
     @FXML
    public void CreateFurniture (ActionEvent event) throws SQLException {
        String AddFurniture;
        
         Connection conn=null;
         String CollectionTableName;
             
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").newInstance();
            conn = DriverManager.getConnection("jdbc:sqlserver://FS1;databaseName=DB3", "Db3User", "w5`/9gBS");
            
            if(conn!=null)
                System.out.println("Database Successfully connected");
            
            Statement stmt = conn.createStatement();
            
            CollectionTableName = CollectionInputFurniture.getText();
            String FName = FurnitureName.getText();
            String FType = FurnitureType.getText();
            int FStock = Integer.parseInt(FurnitureStock.getText());
            AddFurniture = "INSERT INTO " + CollectionTableName + " (Name, Type, stock) VALUES ('" + FName + "', '" + FType + "', '" + FStock +"')";
           stmt.executeUpdate(AddFurniture);
            System.out.println("Furniture Added!");
           
        }
        catch(Exception ex){
             System.out.println("Execute Query Error!");
           
        }
    }
     @FXML
    public void DeleteFurniture (ActionEvent event) throws SQLException {
        String DeleteFurniture;
        
         Connection conn=null;
         String CollectionTableName;
             
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").newInstance();
            conn = DriverManager.getConnection("jdbc:sqlserver://FS1;databaseName=DB3", "Db3User", "w5`/9gBS");
            
            if(conn!=null)
                System.out.println("Database Successfully connected");
            
            Statement stmt = conn.createStatement();
            
            CollectionTableName = CollectionInputFurniture.getText();
            String FName = FurnitureName.getText();
            String FType = FurnitureType.getText();          
            
            DeleteFurniture = "DELETE FROM " + CollectionTableName + " WHERE Name='" + FName + "'";
            stmt.executeUpdate(DeleteFurniture);
            System.out.println("Furniture Deleted!");
           
        }
        catch(Exception ex){
             System.out.println("Execute Query Error!");
           
        }
    }
    
     public void LoadBack (ActionEvent event) throws SQLException, IOException {
         loadBoss();
     }
     
     public void loadBoss() throws IOException {
        Stage stage;
        Parent root;
        try{
            stage=(Stage) BTBack.getScene().getWindow();
                 
        
        root = FXMLLoader.load(getClass().getResource("FXMLBoss.fxml"));
        
        
        Scene scene = new Scene(root);
        
        stage.setScene(scene);
        stage.show();
        }
        catch(IOException ex){
            System.out.println("Error!");
        }
    }
        
   

           
    
    public void initialize(URL url, ResourceBundle rb) {
      
    }    
    
}
