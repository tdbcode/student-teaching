/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class MenuController {
    
    @FXML
    private MenuBar menuBar;

    @FXML
    private MenuItem patientPanel, schPanel, CAPanel, homePanel;

    public MenuController(MenuBar menuBar, MenuItem patientPanel, MenuItem schPanel, MenuItem CAPanel, MenuItem homePanel) {
        this.menuBar = menuBar;
        this.patientPanel = patientPanel;
        this.schPanel = schPanel;
        this.CAPanel = CAPanel;
        this.homePanel = homePanel;
    }

    public MenuBar getMenuBar() {
        return menuBar;
    }

    public void setMenuBar(MenuBar menuBar) {
        this.menuBar = menuBar;
    }

    public MenuItem getPatientPanel() {
        return patientPanel;
    }

    public void setPatientPanel(MenuItem patientPanel) {
        this.patientPanel = patientPanel;
    }

    public MenuItem getSchPanel() {
        return schPanel;
    }

    public void setSchPanel(MenuItem schPanel) {
        this.schPanel = schPanel;
    }

    public MenuItem getCAPanel() {
        return CAPanel;
    }

    public void setCAPanel(MenuItem CAPanel) {
        this.CAPanel = CAPanel;
    }

    public MenuItem getHomePanel() {
        return homePanel;
    }

    public void setHomePanel(MenuItem homePanel) {
        this.homePanel = homePanel;
    }

    
    public void handleMenuAction(ActionEvent event) throws IOException {
        if( ( (MenuItem) (event.getSource())).getId().equals("homePanel")){ 
            handleHomeAction(); 
        }
        if( ( (MenuItem) (event.getSource())).getId().equals("patientPanel")){ 
            handlePatientAction(); 
        }
        if( ( (MenuItem) (event.getSource())).getId().equals("schPanel")){ 
            handleSchedulerAction(); 
        }
        if( ( (MenuItem) (event.getSource())).getId().equals("CAPanel")){ 
            handleCreateAccountAction(); 
        }
    }
    
    public void handleHomeAction() throws IOException {
        String FXMLn = "/FXML_Files/Dashboard.fxml"; 
        changeMenuPage(FXMLn); 
    }
    public void handlePatientAction() throws IOException {
        String FXMLn = "/FXML_Files/PatientPanel.fxml"; 
        changeMenuPage(FXMLn); 
    }
    public void handleCreateAccountAction() throws IOException {
        String FXMLn = "/FXML_Files/CreateAccount.fxml";
        changeMenuPage(FXMLn); 
    }
    public void handleSchedulerAction() throws IOException {
        String FXMLn = "/FXML_Files/SchedulerPanel.fxml"; 
        changeMenuPage(FXMLn); 
    }        
    public void changeMenuPage(String FXMLname) throws IOException{
        Parent dashboard = FXMLLoader.load(getClass().getResource(FXMLname));
        Scene scene = new Scene(dashboard);
        Stage stage = (Stage) menuBar.getScene().getWindow();
        stage.setScene(scene);
        stage.show();   
    }
}
