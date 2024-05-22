/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ia2;

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
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class FXMLEmployepermanentController implements Initializable {
    @FXML
    private TableView<Stock> TblStock;

    @FXML
    public TableColumn<Stock, String> ColName;

    @FXML
    public TableColumn<Stock, String> ColStock;

    @FXML
    public TableColumn<Stock, String> ColDanger;

    @FXML
    private Button BTChange;

    @FXML
    private Button BTLoad;
    
    @FXML
    private TextField Stockname;
    
    @FXML
    private TextField Changestock;

    public final ObservableList<Stock> data = FXCollections.observableArrayList();
      
public void Loadingtable() throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException {
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
        
     
        TblStock.setItems(data);
       
    }

public void ChangeStock(ActionEvent Action){
    
     String StockName = Stockname.getText();
     int Stock = Integer.parseInt(Changestock.getText());
     String sql = "update StockT set Stock=" + Stock + " where Name='" + StockName + "'";
     
     Connection conn = null;
     Statement stmt = null;
        
     TblStock.getItems().clear();
        
        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").newInstance();
            conn = DriverManager.getConnection("jdbc:sqlserver://FS1;databaseName=DB3", "Db3User", "w5`/9gBS");
            stmt = conn.createStatement();
            
            if(conn!=null)
                System.out.println("Database Successfully connected");
                                 
            stmt.executeUpdate(sql);
                
          }
          catch(Exception ex){
            System.out.println("SQL Error! " + ex);
          }
     
}


    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
