package electricityusagetracker;

import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

public class LogController extends user1 implements Initializable {
        
    @FXML
    private JFXComboBox comboBox_Home;
    
    @FXML
    private JFXComboBox comboBox_Room;
    
    @FXML
    private JFXComboBox comboBox_Appliance;
    
    @FXML
    private Label label;
    
    @FXML
    private Label label2;
    
    @FXML
    private Label labelLog;
    
    
    @FXML
    private JFXTextField timeLogged;
    
    @FXML
    private JFXTextField userLogged;
    
    @FXML
    private JFXDatePicker datePicked;
    
    String homeSelected;
    String roomSelected;
    String applianceSelected;
    String log_user;
    String log_time;
    LocalDate dateSelected;
    float timeEntered;
            
    @FXML
    public void homeCombo() throws SQLException, Exception {
        Connection conn=null;
        try 
        {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").newInstance();
            conn = DriverManager.getConnection("jdbc:sqlserver://FS1;databaseName=DB5", "Db5User", ":8qmztC7");
    
            String current_user = Currentuser.getUsername();

            Statement stmt = null;

            String homesquery = "SELECT DISTINCT Home FROM MainTable WHERE Username = '" + current_user +"'";

            stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(homesquery);
            String homeDB;
            ObservableList<String> homes = FXCollections.observableArrayList();

            while (rs.next()) 
            {
                homeDB = rs.getString("Home").trim();
                homes.add(homeDB);
            } 
            comboBox_Home.setItems(homes);         
        }
                    
         catch (Exception e)
            {
                throw e;
            }
    }
    
    @FXML
    public void roomCombo() throws SQLException, Exception {
        Connection conn=null;
        try 
        {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").newInstance();
            conn = DriverManager.getConnection("jdbc:sqlserver://FS1;databaseName=DB5", "Db5User", ":8qmztC7");                    

        String current_user = Currentuser.getUsername();
        Statement stmt = null;
        String getRooms = "SELECT DISTINCT Room FROM MainTable WHERE Username = '" + current_user + "'AND Home = '" + homeSelected + "' "; 
        stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(getRooms);
        String roomDB;
        ObservableList<String> rooms = FXCollections.observableArrayList();

        while (rs.next()) 
        {
            roomDB = rs.getString("Room").trim();
            rooms.add(roomDB);
        } 
            comboBox_Room.setItems(rooms);
        }
                    
        catch (Exception e)
        {
            throw e;
        }
    }
    
    @FXML
    public void applianceCombo() throws SQLException, Exception {
        
        Connection conn=null;
        try 
        {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").newInstance();
            conn = DriverManager.getConnection("jdbc:sqlserver://FS1;databaseName=DB5", "Db5User", ":8qmztC7");                    

            String current_user = Currentuser.getUsername();
            Statement stmt = null;
            String getAppliances = "SELECT DISTINCT Appliance FROM MainTable WHERE Username = '" + current_user + "'AND Home = '" + homeSelected + "' AND Room = '" + roomSelected + "'"; 
            stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(getAppliances);
            String applianceDB;
            ObservableList<String> appliances = FXCollections.observableArrayList();

            while (rs.next()) 
            {
                applianceDB = rs.getString("Appliance").trim();
                appliances.add(applianceDB);
            }
            comboBox_Appliance.setItems(appliances);
        }
                    
        catch (Exception e)
        {
            throw e;
        }
    }
         
    @FXML
    public void homeOptions(ActionEvent event) throws SQLException, Exception {
        homeSelected = comboBox_Home.getValue().toString();
        roomCombo();
    }
       
    @FXML
    public void roomOptions(ActionEvent event) throws SQLException, Exception {
        roomSelected = comboBox_Room.getValue().toString();
        applianceCombo();
    }
    
    @FXML
    public void applianceOptions(ActionEvent event) throws SQLException {
        applianceSelected = comboBox_Appliance.getValue().toString();
    }
    
    @FXML
    public void getDate(ActionEvent event) {
        dateSelected = datePicked.getValue();     
    }
    
    @FXML
    public void log(ActionEvent event) throws Exception {
        labelLog.setText("");
                 Connection conn=null;
               
        try 
            {
                Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").newInstance();
                conn = DriverManager.getConnection("jdbc:sqlserver://FS1;databaseName=DB5", "Db5User", ":8qmztC7");

                Statement stmt = null;      
                String current_user = Currentuser.getUsername();
                
                log_user = userLogged.getText();
                log_time = timeLogged.getText();
                
                timeEntered = Float.parseFloat(log_time);
                           
                PreparedStatement stmt2 = conn.prepareStatement("INSERT INTO LogTable (Username, Home, Room, Appliance, LogUser, Time, Date) VALUES ('" + current_user + "', '" + homeSelected + "', '"  + roomSelected + "', '" + applianceSelected + "', '" + log_user + "','" + timeEntered + "','" + dateSelected + "')");

                stmt2.executeUpdate();
                
                labelLog.setText("Log Sucesseful");                            
            }
        catch (Exception e)
            {
                throw e;
            } 
        
        
    }
    
       
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try
        {
            homeCombo(); 
        }
        catch(SQLException ex)
        {
            System.out.println(ex);
        } 
        catch (Exception ex) 
        {
            Logger.getLogger(LogController.class.getName()).log(Level.SEVERE, null, ex);
        }             
    }
    
}
                 