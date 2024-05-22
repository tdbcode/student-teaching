/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ia2;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
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
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;


public class FXMLCatalogueController implements Initializable {

    ObservableList<String> TestList = FXCollections.<String>observableArrayList();
    
    @FXML
    ListView ListCollection = new ListView();
    
     @FXML
    private TableView<Catalog> TableCollection;
    
    @FXML
    public TableColumn<Catalog, String> ColName;

    @FXML
    public TableColumn<Catalog, String> ColType;  
        
    @FXML
    public TableColumn<Catalog, String> ColStock;
    
    @FXML
    private Button button;
    
    @FXML
    private Button BTBack;
    
      public final ObservableList<Catalog> data = FXCollections.observableArrayList();
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
         Connection conn=null;
        Statement stmt = null;
        ListCollection.getItems().clear();
   
        
           try{
                Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").newInstance();
                conn = DriverManager.getConnection("jdbc:sqlserver://FS1;databaseName=DB3", "Db3User", "w5`/9gBS");
                ResultSet rs = null;
                DatabaseMetaData meta = (DatabaseMetaData) conn.getMetaData();
                rs = meta.getTables(null, null, null, new String[] {"TABLE"});
                int count = 0;
                System.out.println("All table names are in test database:");
      
                while (rs.next()) {
                    String tblName = rs.getString("TABLE_NAME");
                    System.out.println(tblName);
                    if (!tblName.equals("LoginC") && !tblName.equals("StockT") && !tblName.equals("trace_xe_action_map")&& !tblName.equals("trace_xe_event_map")){
                        TestList.add(tblName);
                    }

                count++;
            }
      
                System.out.println(count + " Rows in set ");
            stmt = conn.createStatement();
            if(conn!=null)
                System.out.println("Database Successfully connected");

           }
          catch(Exception ex){
            System.out.println("SQL Error! " + ex);
        }
        
       ListCollection.getItems().addAll(TestList);
    }
    
    @FXML
    public void buttonLoad(ActionEvent Action){
     String selectedItem = ListCollection.getSelectionModel().getSelectedItem().toString();
     Connection conn=null;
     Statement stmt = null;
     
     TableCollection.getItems().clear();
     
        String SQL = "SELECT * from " + selectedItem;
        
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
                    data.add(new Catalog(rs.getString("Name"), rs.getString("Type"), rs.getInt("Stock")));
               }
                
           }
          catch(Exception ex){
            System.out.println("SQL Error! " + ex);
        }
        
        ColName.setCellValueFactory(new PropertyValueFactory<Catalog, String>("Name"));
        ColType.setCellValueFactory(new PropertyValueFactory<Catalog, String>("Type"));
        ColStock.setCellValueFactory(new PropertyValueFactory<Catalog, String>("Stock"));
        
        try{
            TableCollection.setItems(data);
        }
        catch(Exception ex){
            System.out.println("Error! " + ex);
        }
        
}
    @FXML
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

        
    }
    

 

    

