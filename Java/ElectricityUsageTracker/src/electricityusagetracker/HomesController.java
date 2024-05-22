package electricityusagetracker;

import com.jfoenix.controls.JFXCheckBox;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import static electricityusagetracker.user1.Currentuser;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.paint.Color;

public class HomesController implements Initializable {
    
    @FXML
    private JFXTextField houseInput;
    
    @FXML
    private JFXTextField homeTextField;
        
    @FXML 
    private Label labelHome;
    
    @FXML
    private JFXTextField removeRoomUser;
           
    @FXML
    private Label labelRoom;
    
    @FXML
    private Label labelRemoveRoom;
    
    @FXML
    private JFXTextField addRoom;
    
    @FXML
    private Label labelAddHome;
        
    @FXML
    private JFXTextArea roomsTextArea;
    
    @FXML
    private JFXCheckBox checkBox;
    
    @FXML
    private JFXTextField applianceName;
    
    @FXML
    private JFXTextField consumption;
    
    @FXML
    private JFXComboBox comboBox_Room;
        
    @FXML
    private Label labelAppliance;
    
    @FXML
    private Label labelApplianceRemove;
       
    @FXML
    private Label labelConsumption;
    
    @FXML
    private JFXTextArea appliancesTextArea;
    
    @FXML
    private JFXTextField removeAppliance;
    
    String home_User;
    String newRoom;
    String deleteRoom;
    String current_user = Currentuser.getUsername();
    String appliance_user;
    String consumption_user;
    String roomSelected;
    String applianceDB;
    String removeAppliance_user;
    float consumptionDB;
    ObservableList<String> textAreafromRooms = FXCollections.observableArrayList();

         
    @FXML
    public void searchRoom(ActionEvent event) throws Exception {
        String current_user = Currentuser.getUsername();
        home_User = homeTextField.getText();

    Connection conn=null;
                try {
                    Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").newInstance();
                    conn = DriverManager.getConnection("jdbc:sqlserver://FS1;databaseName=DB5", "Db5User", ":8qmztC7");
                    
                    Statement stmt = null;
                    String getHome = "SELECT * FROM Homes";
                    stmt = conn.createStatement();
                    ResultSet rs = stmt.executeQuery(getHome);
                                        
                    String userDB;
                    String homesDB;
                    boolean homeexists;
                    
                    homeexists = false;

                    while (rs.next()) 
                        {
                            userDB = rs.getString("Username").trim();
                            homesDB = rs.getString("Home").trim(); 
                            
                            if(current_user.equals(userDB) && home_User.equals(homesDB)) 
                            {
                                labelHome.setTextFill(Color.web("#019713"));
                                labelHome.setText("Home exists");
                                searchDB(roomsTextArea);
                                                                                           
                                homeexists = true;
                                break;
                            }                           
                        }
                    homeTextField.setOnMouseClicked(e -> {checkBox.setSelected(false);});

                    if (homeexists == false) 
                    {
                        labelHome.setTextFill(Color.web("#c90202"));
                        labelHome.setText("Home does not exist");
                        checkBox.setSelected(false);
                    }        
                }
                catch (Exception e)
                {
                    throw e;
                }
                
    }
    
    @FXML
    public void addRoom(ActionEvent event) throws Exception {
        newRoom = addRoom.getText();

        
        Connection conn=null;
                try 
                {
                    Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").newInstance();
                    conn = DriverManager.getConnection("jdbc:sqlserver://FS1;databaseName=DB5", "Db5User", ":8qmztC7");
                                        
                    Statement stmt = null;
                                    
                    String getData = "SELECT Room FROM MainTable WHERE Username = '" + current_user + "' AND Home = '" + home_User + "'";
                                                      
                    stmt = conn.createStatement();
                    ResultSet rs = stmt.executeQuery(getData);
                    
                    stmt = conn.createStatement();
                    ResultSet rs2 = stmt.executeQuery(getData);
                                                            
                    String usernameDB;
                    String roomDB;
                                      
                    boolean loop = false; 

                    if (!rs2.next()) {
                        String addData = "INSERT INTO MainTable (Username, Home, Room)"
                                    + "VALUES ('" + current_user + "', '"+ home_User +"','"+ newRoom+"')";
                            stmt.executeUpdate(addData);
                            searchDB(roomsTextArea);
                                  
                    }
                    
                    else 
                    {
                    boolean room_exists = false;
                        while (rs.next()) 
                        {
                            roomDB = rs.getString("Room").trim();

                            //Making sure username does not exist in table
                            if (newRoom.equals(roomDB)) 
                            {
                                labelRoom.setTextFill(Color.web("#c90202"));
                                labelRoom.setText("Room already exists");  
                                room_exists = true;
                                break;
                            }

                        }
                        
                        if (room_exists == false) 
                        {
                            String addData = "INSERT INTO MainTable (Username, Home, Room)"
                                    + "VALUES ('" + current_user + "', '" + home_User + "','" + newRoom + "')";
                            stmt.executeUpdate(addData);
                            labelRoom.setTextFill(Color.web("#019713"));
                            labelRoom.setText("Room Added"); 
                            searchDB(roomsTextArea);

                        }
                       
                    }
                }
                catch (Exception e)
                {
                    throw e;
                }  
    }
    
    @FXML
    public void removeRoom(ActionEvent event) throws Exception {
                deleteRoom = removeRoomUser.getText();
                Connection conn=null;
                try {
                    Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").newInstance();
                    conn = DriverManager.getConnection("jdbc:sqlserver://FS1;databaseName=DB5", "Db5User", ":8qmztC7");
                                       
                    //SELECT ROOMS FROM DATABASE AND IF THE SAME DELETE 
                     Statement stmt = null;
                                    
                    String getData = "SELECT Room FROM MainTable WHERE Username = '" + current_user + "' AND Home = '" + home_User + "'";
                                                      
                    stmt = conn.createStatement();
                    ResultSet rs = stmt.executeQuery(getData);
                    
                    stmt = conn.createStatement();
                    ResultSet rs2 = stmt.executeQuery(getData);
                    String roomDB;
                                      
                    boolean loop = false; 
                    
                    if (!rs2.next()) {
                        System.out.println("");
                    }
                    
                    else 
                    {
                    boolean room_notexists = false;
                        while (rs.next()) 
                        {
                            roomDB = rs.getString("Room").trim();

                            //Making sure username does not exist in table
                            if (deleteRoom.equals(roomDB)) 
                            {
                                
                                
                            PreparedStatement st = conn.prepareStatement("DELETE FROM MainTable WHERE Room = '" + deleteRoom + "' AND Username = '" + current_user + "' AND Home = '" + home_User + "'");
                            st.executeUpdate();
                            labelRemoveRoom.setTextFill(Color.web("#019713"));

                            labelRemoveRoom.setText("Room Removed"); 
                            room_notexists = true;
                            searchDB(roomsTextArea);

                            break;
                            }
                        }
                        
                        if (!room_notexists) 
                        {
                                labelRemoveRoom.setTextFill(Color.web("#c90202"));

                                labelRemoveRoom.setText("Room does not exist");  
                                //room_notexists = true;}
                        }
                    }
                }
                    catch (Exception e)
                {
                    throw e;
                }
                
    }
    
    @FXML
    public void searchDB(TextArea roomsTextArea) {
        
        //establishes a connection
        Connection conn=null;
        try {
                    Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").newInstance();
                    conn = DriverManager.getConnection("jdbc:sqlserver://FS1;databaseName=DB5", "Db5User", ":8qmztC7");
                    Statement stmt = null;
                    //Selects distinct rooms from MainTable
                    String getRoom = "SELECT DISTINCT Room FROM MainTable WHERE Username = '" + current_user + "' AND Home = '" + home_User + "'"; 
                    stmt = conn.createStatement();
                    //query is run and the results are stored in a result set
                    ResultSet rs = stmt.executeQuery(getRoom);

                    roomsTextArea.setText("");
                    //loops through the whole result set
                    while (rs.next()) 
                    { // this outputs the tables contents in the text area
                        roomsTextArea.appendText(rs.getObject(1) + " \t");
                        roomsTextArea.appendText("\n");
                    }
                   //runs the comboRoom method to output the rooms in the text area                   
                   comboRoom(roomsTextArea);
                }
        //catches any exceptions
         catch (Exception ex)
                {
                    ex.printStackTrace();
                }
    }
    
    @FXML
    public void comboRoom(TextArea roomsTextArea) throws Exception {
        
        Connection conn=null;
        try 
        {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").newInstance();
            conn = DriverManager.getConnection("jdbc:sqlserver://FS1;databaseName=DB5", "Db5User", ":8qmztC7");

            Statement stmt = null;
            String getRoom = "SELECT DISTINCT Room FROM MainTable WHERE Username = '" + current_user + "' AND Home = '" + home_User + "'"; 

            stmt = conn.createStatement();
            ResultSet rs2 = stmt.executeQuery(getRoom);
            boolean homeexists;

            textAreafromRooms.clear();

            while (rs2.next()) 
            {
                textAreafromRooms.add(rs2.getObject(1).toString().trim());
            }

            comboBox_Room.setItems(textAreafromRooms);
        }
         catch (Exception ex)
                {
                    ex.printStackTrace();
                }      
    }
    
    @FXML
    public void addAppliance(ActionEvent event) throws Exception {
        appliance_user = applianceName.getText();
        
         Connection conn=null;
                try 
                {
                    Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").newInstance();
                    conn = DriverManager.getConnection("jdbc:sqlserver://FS1;databaseName=DB5", "Db5User", ":8qmztC7");
                                        
                    Statement stmt = null;      
                    String getData = "SELECT Appliance FROM MainTable WHERE Username = '" + current_user + "' AND Home = '" + home_User + "'AND Room = '" + roomSelected + "'";
                                                      
                    stmt = conn.createStatement();
                    ResultSet rs = stmt.executeQuery(getData);
                    stmt = conn.createStatement();
                    ResultSet rs2 = stmt.executeQuery(getData);
                                                           
     
                    if (!rs2.next()) {
                        String addData = "UPDATE MainTable SET Appliance = '" + appliance_user + "', Room = '" + roomSelected + "', WHERE Username = '" + current_user + "' AND Home = '" + home_User + "'AND Room = '" + roomSelected + "'";
                              stmt.executeUpdate(addData);
                    }
                    
                    else 
                    {
                    boolean appliance_exists = false;
                        while (rs.next()) 
                        {
                            try
                            {
                            applianceDB = rs.getString("Appliance").trim();
                            }   
                            
                            catch(NullPointerException e)
                            {
                                applianceDB = "";
                                //break;
                            }
                           
                            if (appliance_user.equals(applianceDB) && !applianceDB.equals("")) 
                            {
                                labelAppliance.setTextFill(Color.web("#c90202"));
                                labelAppliance.setText("Appliance already exists");  
                                appliance_exists = true;
                                break;
                            } 
                        }
                        

                        if (appliance_exists == false && applianceDB.equals("")) {
                            String addData = "UPDATE MainTable SET Appliance = '" + appliance_user + "', Room = '" + roomSelected + "' WHERE Username = '" + current_user + "' AND Home = '" + home_User + "'AND Room = '" + roomSelected + "'";
                            stmt.executeUpdate(addData);
                            labelAppliance.setTextFill(Color.web("#019713"));
                            labelAppliance.setText("Appliance Added"); 
                            searchAppliances(appliancesTextArea);
                            appliance_exists = true;

                        }
                        
                        if (appliance_exists == false) 
                        {
                            String addData = "INSERT INTO MainTable (Username, Home, Room, Appliance) VALUES ('" + current_user + "', '" + home_User + "', '"  + roomSelected + "', '" + appliance_user + "')";
                            stmt.executeUpdate(addData);
                            labelAppliance.setTextFill(Color.web("#019713"));
                            labelAppliance.setText("Appliance Added"); 
                            searchAppliances(appliancesTextArea);                            
                        }                       
                    }
                }
                catch (Exception e)
                {
                    throw e;
                }  
    }
            
    @FXML
    public void addConsumption(ActionEvent event) throws Exception {
        consumption_user = consumption.getText();
        Connection conn=null;
                try 
                {
                    
                    Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").newInstance();
                    conn = DriverManager.getConnection("jdbc:sqlserver://FS1;databaseName=DB5", "Db5User", ":8qmztC7");
                                        
                    Statement stmt = null;      
                    String getData = "SELECT Consumption FROM MainTable WHERE Username = '" + current_user + "' AND Home = '" + home_User + "'AND Room = '" + roomSelected + "' AND Appliance = '" + appliance_user + "'";
                                                      
                    stmt = conn.createStatement();
                    ResultSet rs = stmt.executeQuery(getData);
                    stmt = conn.createStatement();
                    ResultSet rs2 = stmt.executeQuery(getData);
                                                           
                    try {
                    
                        if (!rs2.next()) {
                            String addData = "UPDATE MainTable SET Appliance = '" + appliance_user + "', Room = '" + roomSelected + "' WHERE Username = '" + current_user + "' AND Home = '" + home_User + "'AND Room = '" + roomSelected + "'";
                            stmt.executeUpdate(addData);
                        }

                        else 
                        {
                        boolean consumption_exists = false;
                            while (rs.next()) 
                            {
                                try
                                {
                                consumptionDB = rs.getFloat("Consumption");
                                }

                                catch(NullPointerException e)
                                {
                                    consumption_exists = true;
                                }

                                if (consumption_exists == false) {
                                    String addData = "UPDATE MainTable SET Consumption = '" + consumption_user + "' WHERE Username = '" + current_user + "' AND Home = '" + home_User + "'AND Room = '" + roomSelected + "' AND Appliance = '" + appliance_user+"'";
                                    stmt.executeUpdate(addData);
                                    labelConsumption.setTextFill(Color.web("#019713"));
                                    labelConsumption.setText("Consumption Added");  
                                    consumption_exists = true;

                                }

                                else if (consumption_exists == true) 
                                {
                                    String addData = "UPDATE MainTable SET Consumption = '" + consumption_user + "' WHERE Username = '" + current_user + "' AND Home = '" + home_User + "'AND Room = '" + roomSelected + "' AND Appliance = '" + appliance_user+"'";
                                    stmt.executeUpdate(addData);
                                    labelConsumption.setTextFill(Color.web("#019713"));
                                    labelConsumption.setText("Consumption has been updated");  

                                }
                            }
                        }
                        
                    }
                    catch (Exception e)
                    {
                        throw e;
                    }
                }
                catch(SQLException e) {    
                            labelConsumption.setTextFill(Color.web("#c90202"));
                            labelConsumption.setText("Consumption must be a number");
                            System.out.println(e);
                        }         
    }   
    
    @FXML
    public void removeAppliance(ActionEvent event) throws Exception {
        removeAppliance_user = removeAppliance.getText();

        Connection conn=null;
                try {
                    Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").newInstance();
                    conn = DriverManager.getConnection("jdbc:sqlserver://FS1;databaseName=DB5", "Db5User", ":8qmztC7");
                                       
                    //SELECT ROOMS FROM DATABASE AND IF THE SAME DELETE 
                     Statement stmt = null;
                                    
                    String getData = "SELECT Appliance FROM MainTable WHERE Username = '" + current_user + "' AND Home = '" + home_User + "'";
                                                      
                    stmt = conn.createStatement();
                    ResultSet rs = stmt.executeQuery(getData);
                    
                    stmt = conn.createStatement();
                    ResultSet rs2 = stmt.executeQuery(getData);
                    String applianceDB;
                                      
                    
                    if (!rs2.next()) 
                    {
                        System.out.println("");
                    }
                    
                    else 
                    {
                    boolean appliance_notexists = false;
                        while (rs.next()) 
                        {
                            try
                            {
                            applianceDB = rs.getString("Appliance").trim();
                            }
                            
                            catch(NullPointerException e) 
                            {
                                applianceDB = "";
                                appliance_notexists = true;
                            }
                            
                            if (removeAppliance_user.equals(applianceDB)) 
                            {
                            PreparedStatement st = conn.prepareStatement("DELETE FROM MainTable WHERE Username = '" + current_user + "' AND Home = '" + home_User + "' AND Room = '" + roomSelected + "' AND Appliance = '" + removeAppliance_user +"'");
                            st.executeUpdate();
                            labelApplianceRemove.setTextFill(Color.web("#019713"));
                            labelApplianceRemove.setText("Appliance Removed");
                            searchAppliances(appliancesTextArea);
                            appliance_notexists = true;
                            break;
                            }
                            
                            if (!appliance_notexists) 
                            {
                                    labelApplianceRemove.setTextFill(Color.web("#c90202"));
                                    labelApplianceRemove.setText("Appliance does not exist");  
                            }
                        }
                        
                        
                    }
                }
                    catch (Exception e)
                {
                    throw e;
                }
     
        
    }
    
    @FXML
    public void roomOptions(ActionEvent event) throws Exception {
        
        roomSelected = comboBox_Room.getValue().toString();
        searchAppliances(appliancesTextArea);          
    }
    
    @FXML 
    public void createHome(ActionEvent event) throws Exception {

        String current_user = Currentuser.getUsername();
        String newHouse = houseInput.getText();
           Connection conn=null;
                try {
                    Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").newInstance();
                    conn = DriverManager.getConnection("jdbc:sqlserver://FS1;databaseName=DB5", "Db5User", ":8qmztC7");
                  
                    Statement stmt = null;
                    String getHomes = "SELECT * FROM Homes";
                    stmt = conn.createStatement();
                    ResultSet rs = stmt.executeQuery(getHomes);
                    
                    stmt = conn.createStatement();
                    ResultSet rs2 = stmt.executeQuery(getHomes);
                 
                                        
                    String userDB;
                    String homesDB;
                    
                    boolean loop = false; 
                                               
                    if (!rs2.next()) 
                    {
                        String copyUsers = "INSERT INTO Homes (Username, Home)"
                                + "VALUES ('" + current_user + "','" + newHouse + "')";
                        stmt.executeUpdate(copyUsers);
                        labelAddHome.setTextFill(Color.web("#019713"));
                        labelAddHome.setText("Home Added");
                    }
                    
                    else 
                    {
                        boolean house_exists = false;
                        while (rs.next()) 
                        {
                            userDB = rs.getString("Username").trim();
                            homesDB = rs.getString("Home").trim(); 
                            
                            if(current_user.equals(userDB) && newHouse.equals(homesDB)) 
                            {
                                labelAddHome.setTextFill(Color.web("#c90202"));
                                labelAddHome.setText("");
                                labelAddHome.setText("House already exists");
                                house_exists = true;
                                break;
                            }
                        }    

                            
                            if (!house_exists) 
                            {
                            
                                String copyUsers2 = "INSERT INTO Homes (Username, Home)"
                                        + "VALUES ('" + current_user + "','" + newHouse + "')";
                                stmt.executeUpdate(copyUsers2);
                                labelAddHome.setTextFill(Color.web("#019713"));
                                labelAddHome.setText("Home Added");
                               
                            }
                    }
         
                }
                catch (Exception e)
                {
                    throw e;
                }
        
    }
     
    @FXML
    public void searchAppliances (TextArea appliancesTextArea) {
        Connection conn=null;
        try {
                Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").newInstance();
                conn = DriverManager.getConnection("jdbc:sqlserver://FS1;databaseName=DB5", "Db5User", ":8qmztC7");

                Statement stmt = null;
                String getRoom = "SELECT DISTINCT Appliance FROM MainTable WHERE Username = '" + current_user + "' AND Home = '" + home_User + "' AND Room = '" + roomSelected + "'"; 
                stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(getRoom);
                appliancesTextArea.setText("");
                while (rs.next()) 
                { // this outputs the tables contents
                   
                    if (rs.getObject(1) == null) {
                        appliancesTextArea.setText("");
                    }
                    
                    else {
                    appliancesTextArea.appendText(rs.getObject(1) + " \t");
                    appliancesTextArea.appendText("\n");
                    }
                }
                
                
            }
         catch (Exception ex)
                {
                    ex.printStackTrace();
                }
    }
        
    @Override
    public void initialize(URL url, ResourceBundle rb) 
    {
              
        
    }    
    
    }


/*
*
*/