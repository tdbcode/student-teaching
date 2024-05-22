/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Classes.*;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.Date;
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
public class ViewPatientController implements Initializable {

    @FXML
    private TableColumn<PatientTable, Integer> col_id;
    @FXML
    private TableColumn<PatientTable, String> col_firstName;
    @FXML
    private TableColumn<PatientTable, String> col_lastName;
    @FXML
    private TableColumn<PatientTable, String> col_email;
    @FXML
    private TableColumn<PatientTable, String> col_phoneNumber;
    @FXML
    private TableColumn<PatientTable, String> col_address;
    @FXML
    private TableColumn<PatientTable, String> col_doctor;
    @FXML
    private TableColumn<PatientTable, String> col_gender;
    @FXML
    private TableColumn<PatientTable, Date> col_DOB;
    @FXML
    private TableView<PatientTable> table;
    
    ObservableList<PatientTable> oblist = FXCollections.observableArrayList(); 
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
     * initialises the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        viewTable(); 
        
    }    
    
    public void viewTable(){ //method used to view all patient information in a table 
                
        ControllerManager c1 = new ControllerManager();
        try {
            Connection con = c1.getConnection();
            ResultSet rs = con.createStatement().executeQuery("select * from patient");
            
            // while loop that iterates through the SQL table, creating instances of each patient 
            while (rs.next()){
                oblist.add(new PatientTable(rs.getInt("idpatient"), rs.getString("firstname"),
                        rs.getString("lastName"), rs.getString("gender"), rs.getString("currentdoctor"), 
                        rs.getString("email"), rs.getString("phoneNumber"), rs.getString("address"),
                        rs.getDate("DOB")));   
            }
  
            
        } catch (Exception exc) {
            exc.printStackTrace();
        }

        //setting each of the values to the table
        col_id.setCellValueFactory(new PropertyValueFactory<>("id"));
        col_firstName.setCellValueFactory(new PropertyValueFactory<>("firstName"));
        col_lastName.setCellValueFactory(new PropertyValueFactory<>("lastName"));
        col_gender.setCellValueFactory(new PropertyValueFactory<>("gender"));
        col_DOB.setCellValueFactory(new PropertyValueFactory<>("DOB"));
        col_phoneNumber.setCellValueFactory(new PropertyValueFactory<>("phoneNumber"));
        col_email.setCellValueFactory(new PropertyValueFactory<>("email"));
        col_address.setCellValueFactory(new PropertyValueFactory<>("address"));
        col_doctor.setCellValueFactory(new PropertyValueFactory<>("doctor"));

        table.setItems(oblist); 
    }

    @FXML
    public void handleMenuAction(ActionEvent event) throws IOException {
        MenuController menu = new MenuController(myMenuBar, patientPanel, schPanel, CAPanel, homePanel); 
        menu.handleMenuAction(event);
    }
}
