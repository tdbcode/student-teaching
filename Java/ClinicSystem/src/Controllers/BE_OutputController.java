/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Classes.BE_Info;
import Classes.MenuController;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import javafx.stage.Stage;


/**
 * FXML Controller class
 */
public class BE_OutputController implements Initializable {

    
    private int fixedCosts, variableCosts, price; 
    @FXML
    private LineChart<String, Number> BE_chart;
    @FXML
    private Button but_Load;
    @FXML
    private Text BE_Value;
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
    

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        
    } 
    
    @FXML
    public void handleButtonAction(MouseEvent event) throws IOException {
        
        if (event.getSource().equals(but_Load)){
            buildChart(); 
        }
        
    }
    
    public void buildChart(){
        
        int BE_Point = fixedCosts/(price - variableCosts);
        String endPointString = Integer.toString(BE_Point*2); 
    
        int totalCostsEnd = variableCosts * (BE_Point*2) + fixedCosts; 
        int revenue = price * BE_Point*2;
        
        XYChart.Series<String, Number> fixedCostsL = new XYChart.Series<>();
        
        fixedCostsL.getData().add(new XYChart.Data<>("0", fixedCosts));
        fixedCostsL.getData().add(new XYChart.Data<>(endPointString, fixedCosts));
        
        BE_chart.getData().add(fixedCostsL);
        
        XYChart.Series<String, Number> totalCostsL = new XYChart.Series<>();
        totalCostsL.getData().add(new XYChart.Data<>("0", fixedCosts));
        totalCostsL.getData().add(new XYChart.Data<>(endPointString, totalCostsEnd));
        
        BE_chart.getData().add(totalCostsL);
        
        XYChart.Series<String, Number> revenueL = new XYChart.Series<>();
        revenueL.getData().add(new XYChart.Data<>("0", 0));
        revenueL.getData().add(new XYChart.Data<>(endPointString, revenue));
        
        BE_chart.getData().add(revenueL);
        
        BE_Value.setText("The break even value is: " + Integer.toString(BE_Point));
    }

    
    public void receivedData(BE_Info breakEven){
        
        fixedCosts = breakEven.getFixedCosts(); 
        variableCosts = breakEven.getVariableCosts();
        price = breakEven.getPrice(); 
      
    } 

    @FXML
    public void handleMenuAction(ActionEvent event) throws IOException {
        MenuController menu = new MenuController(myMenuBar, patientPanel, schPanel, CAPanel, homePanel); 
        menu.handleMenuAction(event);
    }
    
    
        
}
