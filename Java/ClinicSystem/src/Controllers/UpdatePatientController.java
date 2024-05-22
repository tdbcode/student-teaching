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
import java.sql.Statement;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent; 
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;


/**
 * FXML Controller class
 */
public class UpdatePatientController implements Initializable {
    
    ObservableList<String> doctors = FXCollections.observableArrayList();
    ObservableList<String> genders = FXCollections.observableArrayList();
    
    @FXML
    private Label errorMessage;
    @FXML
    private Button but_update;
    @FXML
    private MenuItem patientPanel;
    @FXML
    private MenuItem schPanel;
    @FXML
    private MenuItem CAPanel;
    @FXML
    private MenuItem homePanel;
    @FXML
    private MenuBar myMenuBar;
    @FXML
    private TextField inp_ID;
    @FXML
    private TextField upd_firstName;
    @FXML
    private TextField upd_lastName;
    @FXML
    private ChoiceBox upd_gender;
    @FXML
    private DatePicker upd_DOB;
    @FXML
    private TextField upd_email;
    @FXML
    private TextField upd_address;
    @FXML
    private TextField upd_phoneNumber;
    @FXML
    private ChoiceBox upd_doctor;
    
    ObservableList<TextField> textfields = FXCollections.observableArrayList(); 
    ObservableList<ChoiceBox> choiceboxes = FXCollections.observableArrayList();

    @Override
    public void initialize(URL url, ResourceBundle rb) {    
        doctors.add("Carollo");
        doctors.add("Angelo");
        upd_doctor.setItems(doctors);
        
        genders.add("Female");
        genders.add("Male"); 
        upd_gender.setItems(genders);
        
        
    }   

    public int getInp_ID() {
        int id=Integer.parseInt(inp_ID.getText());  
        return id;
    }
    
    
    
    @FXML
    public void handleButtonAction(MouseEvent event) throws IOException {
        if (event.getSource() == but_update && !inp_ID.getText().equals("")){
            if (idValid(getInp_ID())){
                fieldisNull(upd_firstName);
                fieldisNull(upd_lastName); 
                fieldisNull(upd_email); 
                fieldisNull(upd_address); 
                fieldisNull(upd_phoneNumber); 
                fieldisNull(upd_gender); 
                fieldisNull(upd_doctor);  

                String fieldName = ""; 
                for (int i = 0; i < textfields.size(); i++) {
                    if (textfields.get(i) ==  upd_firstName){
                        fieldName = "firstname"; 
                    } 
                    if (textfields.get(i) ==  upd_lastName){
                        fieldName = "lastname"; 
                    } 
                    if (textfields.get(i) ==  upd_address){
                        fieldName = "address"; 
                    } 
                    if (textfields.get(i) ==  upd_phoneNumber){
                        fieldName = "phonenumber"; 
                    } 
                    if (textfields.get(i) ==  upd_email){
                        fieldName = "email"; 
                    } 
                    updateField(getInp_ID(), textfields.get(i), fieldName);
                }

                String choiceName = ""; 
                for (int x = 0; x < choiceboxes.size(); x++) {
                    if (choiceboxes.get(x) ==  upd_gender){
                        choiceName = "gender"; 
                    }
                    if (choiceboxes.get(x) ==  upd_doctor){
                        choiceName = "currentdoctor"; 
                    }
                    updateField(getInp_ID(), choiceboxes.get(x), choiceName);
                }            
                if (upd_DOB.getValue() != null){
                    LocalDate localDate = upd_DOB.getValue();
                    java.util.Date date = Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
                    java.sql.Date sqlDate = new java.sql.Date(date.getTime());
                    updateDate(getInp_ID(), sqlDate); 
                }
                errorMessage.setText("field(s) updated");
            }
            else{
                errorMessage.setText("invalid ID");    
            }   
        }
        else{
            errorMessage.setText("Please enter a patient ID"); 
        }
    }    


    @FXML
    public void handleMenuAction(ActionEvent event) throws IOException {
        MenuController menu = new MenuController(myMenuBar, patientPanel, schPanel, CAPanel, homePanel); 
        menu.handleMenuAction(event);
    }
     
    public void fieldisNull(TextField textfield){  
        if (!textfield.getText().equals("")){
            textfields.add(textfield); 
        }
    }    
    public void fieldisNull(ChoiceBox choicebox){
        if (choicebox.getValue() != null){
            choiceboxes.add(choicebox);
        }
    }    
    
        
    
    public void updateDate(int patientID, Date date){
        ControllerManager c1 = new ControllerManager(); 
        try{
            Connection myConn=c1.getConnection();
            Statement myStmt = myConn.createStatement();
            String newUpd = upd_DOB.getValue().toString(); 
            date=Date.valueOf(newUpd);
            String upd=String.format("update patient set DOB = '%s' where idpatient = %d", date, patientID); 
            myStmt.executeUpdate(upd);
            errorMessage.setText("updated");
        } catch (Exception exc) {
         exc.printStackTrace();
        }
    }
        
    public void updateField(int patientID, TextField field, String fieldName){
        ControllerManager c1 = new ControllerManager(); 
        try{
            Connection myConn=c1.getConnection();
            Statement myStmt = myConn.createStatement();
            String upd=String.format("update patient set %s = '%s' where idpatient = %d", fieldName, field.getText(), patientID); 
            myStmt.executeUpdate(upd);
            errorMessage.setText("updated");
        } catch (Exception exc) {
         exc.printStackTrace();
        }
    }
    
    public void updateField(int patientID, ChoiceBox field, String choiceName){
        ControllerManager c1 = new ControllerManager(); 
        try{
            Connection myConn=c1.getConnection();
            Statement myStmt = myConn.createStatement();
            String upd=String.format("update patient set %s = '%s' where idpatient = %d", choiceName, field.getValue().toString(), patientID); 
            myStmt.executeUpdate(upd);
            errorMessage.setText("updated");
        } catch (Exception exc) {
         exc.printStackTrace();
        }
    }
        
    public boolean idValid(int id){
        ControllerManager c1 = new ControllerManager();
        boolean flag = false; 
        try {
            Connection con = c1.getConnection();
            ResultSet rs = con.createStatement().executeQuery("select * from patient");
            
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


}
