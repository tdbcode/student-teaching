
package electricityusagetracker;

import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextArea;
import static electricityusagetracker.user1.Currentuser;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.temporal.WeekFields;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;


public class OverviewController implements Initializable {

// 20cents per kWh
   
    @FXML
    private JFXComboBox comboBox_homes;
    
    @FXML
    private TableView<ApplianceModel> mainTable;
    
    @FXML
    private TableColumn<ApplianceModel, String> appliance;

    @FXML
    private TableColumn<ApplianceModel, String> room;

    @FXML
    private TableColumn<ApplianceModel, String> home;

    @FXML
    private TableColumn<ApplianceModel, String> user;

    @FXML
    private TableColumn<ApplianceModel, String> consumption;

    @FXML
    private TableColumn<ApplianceModel, String> cost;

    @FXML
    private TableColumn<ApplianceModel, String> time;

    @FXML
    private TableColumn<ApplianceModel, String> date;
            
    @FXML
    private JFXDatePicker dateUser;
     
    @FXML
    private JFXTextArea detailsTextArea;
    
    @FXML
    private Label dayLabel;
    
    @FXML
    private Label weekLabel;
    
    @FXML
    private Label monthLabel;
    
    String homeSelected;
        
    LocalDate dailyDate;
    

    LocalDate weeklyDate;
    String monthlyDate;
    double temptestsum = 0;
    public final ObservableList<ApplianceModel> data = FXCollections.observableArrayList();



    @FXML
    public void findHome() throws SQLException, Exception {
        Connection conn=null;
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").newInstance();
            conn = DriverManager.getConnection("jdbc:sqlserver://FS1;databaseName=DB5", "Db5User", ":8qmztC7");
    
        String current_user = Currentuser.getUsername();

        Statement stmt = null;
        
        String homesquery = "SELECT DISTINCT Home FROM MainTable WHERE Username = '" + current_user +"'";
        
        stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(homesquery);
        String homeDB;
        ObservableList<String> homes = FXCollections.observableArrayList();

        while (rs.next()) {
            
            homeDB = rs.getString("Home").trim();
            homes.add(homeDB);
        } 
        comboBox_homes.setItems(homes);         
    }
                    
         catch (Exception e)
                {
                    throw e;
                }
    }
        
    @FXML
    public void getHome(ActionEvent event) throws SQLException, Exception {
            homeSelected = comboBox_homes.getValue().toString();
            loadTable();

    }    
    
    @FXML
    public void loadTable() throws Exception {
        
        Connection conn=null;
            try 
            {
                Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").newInstance();
                conn = DriverManager.getConnection("jdbc:sqlserver://FS1;databaseName=DB5", "Db5User", ":8qmztC7");

                String current_user = Currentuser.getUsername();

                Statement stmt = null;

                String select = "SELECT Room, Appliance, LogUser, Time, Date FROM LogTable WHERE Username = '" + current_user + "' AND Home = '" + homeSelected + "' ";

                stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(select);

                String applianceDB;
                String roomDB;
                String userDB;
                double consumptionDB;
                double timeDB;
                String dateDB;
                double cost_DB;

                    while (rs.next()) 
                    {
                            roomDB = rs.getString("Room").trim();
                            applianceDB = rs.getString("Appliance").trim();
                            userDB = rs.getString("LogUser").trim();
                            timeDB = rs.getDouble("Time");
                            dateDB = rs.getString("Date").trim();
                            String select2 = "SELECT Consumption FROM MainTable WHERE Username = '" + current_user + "' AND Home = '" + homeSelected + "' AND Room = '" + roomDB + "' AND Appliance = '" + applianceDB + "'";         

                            stmt = conn.createStatement();
                            ResultSet rs2 = stmt.executeQuery(select2);

                            while (rs2.next()) {

                                consumptionDB = rs2.getDouble("Consumption"); 
                                cost_DB = consumptionDB * timeDB *0.20; 
                                
                                data.add(new ApplianceModel(applianceDB,roomDB,userDB,consumptionDB,Math.round(cost_DB*100.0)/100.0,timeDB,dateDB));
                            }
                    }

                appliance.setCellValueFactory(new PropertyValueFactory<>("applianceName"));
                room.setCellValueFactory(new PropertyValueFactory<>("roomName"));
                user.setCellValueFactory(new PropertyValueFactory<>("userName"));
                consumption.setCellValueFactory(new PropertyValueFactory<>("electricityConsumption"));
                cost.setCellValueFactory(new PropertyValueFactory<>("costValue"));
                time.setCellValueFactory(new PropertyValueFactory<>("timeValue"));
                date.setCellValueFactory(new PropertyValueFactory<>("dateValue"));

                mainTable.setItems(data);

                } 
        catch (Exception e)
            {
                throw e;
            } 
    }
    
    
    @FXML
    public void searchDailyDate(ActionEvent event) throws Exception {
        dailyDate = dateUser.getValue();
        System.out.println(dailyDate);
        
        Connection conn=null;
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").newInstance();
            conn = DriverManager.getConnection("jdbc:sqlserver://FS1;databaseName=DB5", "Db5User", ":8qmztC7");
    
        String current_user = Currentuser.getUsername();

        Statement stmt = null;
        
        String datequery = "SELECT Date, Time, Home, Room, Appliance FROM LogTable WHERE Username = '" + current_user + "' AND Date = '" + dailyDate + "'";
        
        stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(datequery);
        
        String dateDB;
        double timeDB;
        String roomDB;
        String homeDB;
        String applianceDB;
        
        double dailyConsumptionSum = 0;
        double dailyConsumption = 0;
        double dailyCost = 0;
        double dailyCostSum = 0;
        
        while (rs.next()) {
            dateDB = rs.getString("Date").trim();
            timeDB = rs.getDouble("Time");
            homeDB = rs.getString("Home");
            roomDB = rs.getString("Room");
            applianceDB = rs.getString("Appliance");
            String datequery2 = "SELECT Consumption FROM MainTable WHERE Username = '" + current_user + "' AND Home = '" + homeDB + "' AND Room = '" + roomDB + "' AND Appliance = '" + applianceDB + "'";
            stmt = conn.createStatement();
            ResultSet rs2 = stmt.executeQuery(datequery2);

            double consumptionDB;
            while (rs2.next()) 
            {
                consumptionDB = rs2.getDouble("Consumption");
                dailyConsumption = consumptionDB * timeDB;
                dailyConsumptionSum = dailyConsumptionSum + dailyConsumption;             
                dailyCost = dailyConsumption * 0.20;
                dailyCostSum = dailyCostSum + dailyCost;
            } 
        }
        

        detailsTextArea.setText("");
        dayLabel.setText("Day");
        detailsTextArea.appendText("\nConsumption: " + Math.round((dailyConsumptionSum)*100.0)/100.0 + " kWh");
 
        detailsTextArea.appendText("\nCost: €"+ Math.round((dailyCostSum)*100.0)/100.0);
       
    }
                    
         catch (Exception e)
                {
                    throw e;
                }
        
        LocalDate fulldate = dateUser.getValue();
        WeekFields weekFields = WeekFields.of(Locale.getDefault()); 
        int week = fulldate.get(weekFields.weekOfWeekBasedYear());
        int year = fulldate.getYear();
               
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").newInstance();
            conn = DriverManager.getConnection("jdbc:sqlserver://FS1;databaseName=DB5", "Db5User", ":8qmztC7");
    
        String current_user = Currentuser.getUsername();

        Statement stmt = null;
        String datequery = "SELECT Time, Home, Room, Appliance FROM LogTable WHERE Username = '" + current_user + "' AND DATEPART(wk, Date) = '" + week + "' AND YEAR(Date) = '" + year + "' ";
        
        stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(datequery);

        double timeDB;

        String roomDB;
        String homeDB;
        String applianceDB;
        
        double weeklyConsumptionSum = 0;

        double weeklyConsumption = 0;
        double weeklyCost = 0;
        double weeklyCostSum = 0;
                
        while (rs.next()) {
            homeDB = rs.getString("Home");
            roomDB = rs.getString("Room");
            timeDB = rs.getDouble("Time");
            
            applianceDB = rs.getString("Appliance");
            
            String datequery2 = "SELECT Consumption FROM MainTable WHERE Username = '" + current_user + "' AND Home = '" + homeDB + "' AND Room = '" + roomDB + "' AND Appliance = '" + applianceDB + "'";
            stmt = conn.createStatement();
            ResultSet rs2 = stmt.executeQuery(datequery2);


            double consumptionDB;
            while (rs2.next()) 
            {
                consumptionDB = rs2.getDouble("Consumption");
                
                weeklyConsumption = consumptionDB * timeDB;
                weeklyConsumptionSum = weeklyConsumptionSum + weeklyConsumption;
                weeklyCost = weeklyConsumption * 0.20;
                weeklyCostSum = weeklyCostSum + weeklyCost;
                weeklyConsumption = 0;
            } 
                  
        }
        weekLabel.setText("Week");

        detailsTextArea.appendText("\n\n ");
        detailsTextArea.appendText("\nConsumption: " + Math.round((weeklyConsumptionSum)*100.0)/100.0 + " kWh");
        detailsTextArea.appendText("\nCost: €"+ Math.round((weeklyCostSum)*100.0)/100.0);
       
          
        }
                     
         catch (Exception e)
                {
                    throw e;
                }
        
        int month = fulldate.getMonthValue();
               
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").newInstance();
            conn = DriverManager.getConnection("jdbc:sqlserver://FS1;databaseName=DB5", "Db5User", ":8qmztC7");
    
        String current_user = Currentuser.getUsername();

        Statement stmt = null;
        

        
        String datequery = "SELECT Time, Home, Room, Appliance FROM LogTable WHERE Username = '" + current_user + "' AND MONTH(Date) = '" + month + "' AND YEAR(Date) = '" + year + "' ";

        stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(datequery);
        
        double timeDB;
        String roomDB;
        String homeDB;
        String applianceDB;
        double monthlyConsumptionSum = 0;
        double monthlyConsumption = 0;
        double monthlyCost = 0;
        double monthlyCostSum = 0;


        while (rs.next()) {
            homeDB = rs.getString("Home");
            roomDB = rs.getString("Room");
            timeDB = rs.getDouble("Time");

            applianceDB = rs.getString("Appliance");
            
            String datequery2 = "SELECT Consumption FROM MainTable WHERE Username = '" + current_user + "' AND Home = '" + homeDB + "' AND Room = '" + roomDB + "' AND Appliance = '" + applianceDB + "'";
            stmt = conn.createStatement();
            ResultSet rs2 = stmt.executeQuery(datequery2);
            double consumptionDB;


            while (rs2.next()) 
            {
                consumptionDB = rs2.getDouble("Consumption");
                monthlyConsumption = consumptionDB * timeDB;
                monthlyConsumptionSum = monthlyConsumptionSum + monthlyConsumption;
                monthlyCost = monthlyConsumption * 0.20;
                monthlyCostSum = monthlyCostSum + monthlyCost;
            } 
                  
        }
        monthLabel.setText("Month");
        detailsTextArea.appendText("\n\n ");
        detailsTextArea.appendText("\nConsumption: " + Math.round((monthlyConsumptionSum)*100.0)/100.0 + " kWh");
        detailsTextArea.appendText("\nCost: €"+ Math.round((monthlyCostSum)*100.0)/100.0);          
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
            findHome(); 
                    detailsTextArea.setStyle("-fx-font-size: 20");
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