/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Classes.ControllerManager;
import Classes.MenuController;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class
 */
public class AddPatientController implements Initializable {
    
    ObservableList<String> doctors = FXCollections.observableArrayList();
    ObservableList<String> genders = FXCollections.observableArrayList();
    ObservableList<TextField> textFields = FXCollections.observableArrayList();
    ObservableList<Object> otherFields = FXCollections.observableArrayList();

    @FXML
    private TextField inp_firstName;
    @FXML
    private TextField inp_lastName;
    @FXML
    private TextField inp_email;
    @FXML
    private TextField inp_phoneNumber;
    @FXML
    private TextField inp_address;
    @FXML
    private ComboBox inp_doctor;
    @FXML
    private Button but_add;
    @FXML
    private ComboBox inp_gender;
    @FXML
    private DatePicker inp_DOB;
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
        doctors.add("Carollo");
        doctors.add("Angelo");
        inp_doctor.setItems(doctors);
        
        textFields.addAll(inp_firstName, inp_lastName, inp_email, inp_address, inp_phoneNumber); 
        otherFields.addAll(inp_DOB, inp_gender, inp_doctor); 
        
        genders.add("Female");
        genders.add("Male"); 
        inp_gender.setItems(genders);
    }    
    
    @FXML
    public void handleMenuAction(ActionEvent event) throws IOException {
        MenuController menu = new MenuController(myMenuBar, patientPanel, schPanel, CAPanel, homePanel); 
        menu.handleMenuAction(event);
    }
    
    public void addPatient(){
            try {
                    ControllerManager c1 = new ControllerManager();  
                    Connection myConn = c1.getConnection(); 
                    String sql = "insert into patient " + " (firstname, lastname, gender, DOB, email, address, "
                            + "phonenumber, currentDoctor)"
                            + " values (?,?,?,?,?,?,?,?)";

                    PreparedStatement myStmt = myConn.prepareStatement(sql);   
                    LocalDate localDate = inp_DOB.getValue();
                    java.util.Date date = Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
                    java.sql.Date sqlDate = new java.sql.Date(date.getTime());

                    myStmt.setString(1, inp_firstName.getText());
                    myStmt.setString(2, inp_lastName.getText());
                    myStmt.setString(3, inp_gender.getValue().toString());
                    myStmt.setDate(4, sqlDate);
                    myStmt.setString(5, inp_email.getText());
                    myStmt.setString(6, inp_address.getText());
                    myStmt.setString(7, inp_phoneNumber.getText());
                    myStmt.setString(8, inp_doctor.getValue().toString());

                    myStmt.execute();
                    errorMessage.setText("patient added"); 

                } catch (SQLException exc) {
                }
        }   
    
    public boolean checkTextFieldNull(ObservableList<TextField> fields){
        boolean flag = true; 
        for (int i = 0; i < fields.size(); i++) 
        {
            if ((fields.get(i).getText().equals(""))){
                return false; 
            }
        }  
        return flag; 
    }
    
    public boolean checkObjectFieldNull(ObservableList<Object> fields){
        boolean flag = true; 
        for (int i = 0; i < fields.size(); i++)
        {
            if ((fields.get(i).equals(null))){
                return false; 
            }
        }  
        return flag; 
    }
    
    @FXML
    public void handleButtonAction(MouseEvent event) throws IOException {
        if (checkTextFieldNull(textFields) && checkObjectFieldNull(otherFields)){
            addPatient();
        }
        else{
            errorMessage.setText("Make sure all fields are filled up");
        }
    }       
}