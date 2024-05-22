/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Classes.ControllerManager;
import Classes.MenuController;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTimePicker;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneId;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;


/**
 * FXML Controller class
 */
public class SchedulerController implements Initializable {

    @FXML
    private TextField inp_patientID;
    
    @FXML
    private JFXTimePicker inp_time; 
    
    @FXML 
    private JFXDatePicker inp_date; 
    
    @FXML
    private Button but_confirm;
    
    @FXML
    private Label errorMessage;
    @FXML
    private MenuBar myMenuBar;
    @FXML
    private MenuItem homePanel;
    @FXML
    private MenuItem patientPanel;
    @FXML
    private MenuItem schPanel;
    @FXML
    private MenuItem CAPanel;

    /**
     * Initializes the controller class.
     */
    @Override
    
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }  
    
    ControllerManager c1 = new ControllerManager();
    
    @FXML
    public void handleButtonAction(MouseEvent event){
        if (event.getSource() == but_confirm){
            addAppointment(inp_patientID.getText(), idValid()); 
        }
    }
    public boolean idValid(){
        boolean flag = false; 
        try {
            Connection con = c1.getConnection();
            ResultSet rs = con.createStatement().executeQuery("select * from patient");
            int id=Integer.parseInt(inp_patientID.getText());  
            
            while(rs.next()){
                if (id == rs.getInt("idpatient")){
                    flag = true; 
                }
            }
            
        } catch (Exception exc) {
             exc.printStackTrace();
        }
        
        return flag; 
        
    }
    
    public void addAppointment(String ID, boolean IDValid){
        
        if (IDValid){
            try { 
                Connection myConn = c1.getConnection(); 
                String sql = "insert into appointments " + " (Idpatient, date, time)"
                        + " values (?,?,?)";
                
                PreparedStatement myStmt = myConn.prepareStatement(sql);  
                LocalDate localDate1 = inp_date.getValue();
                java.util.Date date = Date.from(localDate1.atStartOfDay(ZoneId.systemDefault()).toInstant());
                java.sql.Date sqlDate = new java.sql.Date(date.getTime());
                
                LocalTime localDate2 = inp_time.getValue();
                Time sqlTime = Time.valueOf(localDate2);
                
                
                myStmt.setString(1, inp_patientID.getText());
                myStmt.setDate(2, sqlDate);
                myStmt.setTime(3, sqlTime);
                
                myStmt.execute();
                errorMessage.setText("appointment added");
            
            } catch (Exception exc) {
            exc.printStackTrace();
            }
                        
        }
        else{
            errorMessage.setText("invalid patient ID");
            
        }
    }

    @FXML
    public void handleMenuAction(ActionEvent event) throws IOException {
        MenuController menu = new MenuController(myMenuBar, patientPanel, schPanel, CAPanel, homePanel); 
        menu.handleMenuAction(event);
    }
}
        

    

