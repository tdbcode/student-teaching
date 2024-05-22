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
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

/**
 * FXML Controller class
 */
public class FXMLPermanentstockController implements Initializable {

    @FXML
    private Button BTPermanentcreate;
    
    @FXML
    private Button BTPermanentdelete;
    
    @FXML
    private TableView<Stock> TblStock;
    
    @FXML
    public TableColumn<Stock, String> ColName;

    @FXML
    public TableColumn<Stock, String> ColStock;

    @FXML
    public TableColumn<Stock, String> ColDanger;  
    
    @FXML
    private Button BTBack;
    
    @FXML
    private TextField TBDanger;
    
    @FXML
    private TextField TBStock;
    
    @FXML
    private TextField TBName;
    
    public final ObservableList<Stock> data = FXCollections.observableArrayList();
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    
     public void getAllstudentInfo() throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException {
        Connection conn=null;
        Statement stmt = null;

        String SQL = "SELECT * from StockT";
        
        
        TblStock.getItems().clear();
    
        
        try{
         Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").newInstance();
         conn = DriverManager.getConnection("jdbc:sqlserver://FS1;databaseName=DB3", "Db3User", "w5`/9gBS");
            stmt = conn.createStatement();
            if(conn!=null)
                System.out.println("Database Successfully connected");
                ResultSet rs = stmt.executeQuery(SQL);
                
                while(rs.next()){
                    ObservableList<String> row = FXCollections.observableArrayList();
                    for (int i= 1; i<=rs.getMetaData().getColumnCount();i++){
                        row.add(rs.getString(i));
                    }
                    System.out.println(row);
                    data.add(new Stock(rs.getString("Name"), rs.getInt("Stock"), rs.getInt("DangerStock")));
               }
                
           }
          catch(Exception ex){
            System.out.println("SQL Error! " + ex);
        }
        
      
        
        ColName.setCellValueFactory(new PropertyValueFactory<Stock, String>("Name"));
        ColStock.setCellValueFactory(new PropertyValueFactory<Stock, String>("Stock"));
        ColDanger.setCellValueFactory(new PropertyValueFactory<Stock, String>("DangerStock"));
        
        try{
            TblStock.setItems(data);
        }
        catch(Exception ex){
            System.out.println("Error! " + ex);
        }
      //  ObservableList data = FXCollections.observableArrayList(new Stock("Hari", 11, 1));
        /*
        
*/    
        
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
    
        @FXML
        public void CreatePermanent() throws ClassNotFoundException{
            String name = TBName.getText();
            int Stock = Integer.parseInt(TBStock.getText());
            int DangerStock = Integer.parseInt(TBDanger.getText());
             Connection conn=null;
             Statement stmt = null;
            String AddStock;
            
            try{
                Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").newInstance();
                conn = DriverManager.getConnection("jdbc:sqlserver://FS1;databaseName=DB3", "Db3User", "w5`/9gBS");
                stmt = conn.createStatement();
            
            if(conn!=null)
                System.out.println("Database Successfully connected");
            
            AddStock = "INSERT INTO StockT (Name, Stock, DangerStock) VALUES ('" + name + "', '" + Stock + "', '" + DangerStock +"')";
           stmt.executeUpdate(AddStock);
            
            
            } catch(Exception ex){
                System.out.println(ex);
            }
            
            
        }
        
        @FXML
        public void DeletePermanent(){
            String name = TBName.getText();
            
            Connection conn=null;
            Statement stmt = null;
            String DeleteStock;
            
            try{
                Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").newInstance();
                conn = DriverManager.getConnection("jdbc:sqlserver://FS1;databaseName=DB3", "Db3User", "w5`/9gBS");
                stmt = conn.createStatement();
            
            if(conn!=null)
                System.out.println("Database Successfully connected");
            
            DeleteStock = "delete from StockT where Name= '" + name + "'";
            stmt.executeUpdate(DeleteStock);
            
            
            } catch(Exception ex){
                System.out.println(ex);
            }
        }
        
     
     
}


