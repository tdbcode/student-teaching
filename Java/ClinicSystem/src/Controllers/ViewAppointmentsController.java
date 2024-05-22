/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Classes.AppointmentTable;
import Classes.ControllerManager;
import Classes.MenuController;
import Classes.PatientTable;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 */
public class ViewAppointmentsController implements Initializable {
    
    ObservableList<AppointmentTable> oblist = FXCollections.observableArrayList(); 
    
    @FXML
    private TableColumn<AppointmentTable, String> col_appID;
    @FXML
    private TableColumn<AppointmentTable, String> col_patID;
    @FXML
    private TableColumn<AppointmentTable, String> col_date;
    @FXML
    private TableColumn<AppointmentTable, String> col_time;
    @FXML
    private TableView table; 
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
       viewTable();
    }   
    
    public void viewTable(){
        ControllerManager c1 = new ControllerManager();
        try {
            Connection con = c1.getConnection();
            ResultSet rs = con.createStatement().executeQuery("select * from appointments");
            
            while (rs.next()){
                oblist.add(new AppointmentTable(rs.getInt("idpatient"),
                        rs.getDate("date"), rs.getTime("time")));
                
            }
            
        } catch (Exception exc) {
            exc.printStackTrace();
        }
        
        table.setItems(oblist);
        
        col_patID.setCellValueFactory(new PropertyValueFactory<>("patientID"));
        col_date.setCellValueFactory(new PropertyValueFactory<>("date"));
        col_time.setCellValueFactory(new PropertyValueFactory<>("time"));
    }


    @FXML
    public void handleMenuAction(ActionEvent event) throws IOException {
        MenuController menu = new MenuController(myMenuBar, patientPanel, schPanel, CAPanel, homePanel); 
        menu.handleMenuAction(event);
    }
    
}
