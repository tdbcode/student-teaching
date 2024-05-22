
package electricityusagetracker;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import static electricityusagetracker.user1.Currentuser;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class AccountController implements Initializable {
        
    @FXML
    private Label usernameLabel;
    
    @FXML
    private JFXTextArea homesTextArea;
    
    @FXML
    private JFXTextField removeHomeUser;
    
    @FXML
    private Label labelRemoveHome;
    
    @FXML
    private Label labelRemoveHomeRed;
    
    @FXML
    private JFXButton logout;
    
    String current_user = Currentuser.getUsername(); 
    
    @FXML
    public void searchHomes(TextArea homesTextArea) {
  
        Connection conn=null;
        try {
                    Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").newInstance();
                    conn = DriverManager.getConnection("jdbc:sqlserver://FS1;databaseName=DB5", "Db5User", ":8qmztC7");
                    
                    Statement stmt = null;
                    String getRoom = "SELECT DISTINCT Home FROM Homes WHERE Username = '" + current_user + "' "; 
                    stmt = conn.createStatement();
                    ResultSet rs = stmt.executeQuery(getRoom);

                    homesTextArea.setText("");
                    
                    while (rs.next()) 
                    { // this outputs the tables contents in the text area
                        homesTextArea.appendText(rs.getObject(1) + " \t");
                        homesTextArea.appendText("\n");
                    }
                }
         catch (Exception ex)
                {
                    ex.printStackTrace();
                }
    }
    
    
      @FXML
    public void removeHome(ActionEvent event) throws Exception {
                String deleteHome = removeHomeUser.getText();
                Connection conn=null;
                try {
                    Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").newInstance();
                    conn = DriverManager.getConnection("jdbc:sqlserver://FS1;databaseName=DB5", "Db5User", ":8qmztC7");
                                       
                    Statement stmt = null;
                                    
                    String getData = "SELECT Home FROM Homes WHERE Username = '" + current_user + "'";
                    stmt = conn.createStatement();
                    ResultSet rs = stmt.executeQuery(getData);
                    
                    stmt = conn.createStatement();
                    ResultSet rs2 = stmt.executeQuery(getData);
                    String homeDB;
                                      
                    boolean loop = false; 
                    
                    if (!rs2.next()) {
                        System.out.println("");

                    }
                    
                    else 
                    {
                    boolean home_notexists = false;
                        while (rs.next()) 
                        {
                            homeDB = rs.getString("Home").trim();

                            //Making sure username does not exist in table
                            if (deleteHome.equals(homeDB)) 
                            {
                                
                            PreparedStatement st = conn.prepareStatement("DELETE FROM Homes WHERE Home = '" + deleteHome + "' AND Username = '" + current_user + "'; DELETE FROM MainTable WHERE Home = '" + deleteHome + "' AND Username = '" + current_user + "'; DELETE FROM LogTable WHERE Home = '" + deleteHome + "' AND Username = '" + current_user + "'");

                            st.executeUpdate();
                            labelRemoveHome.setTextFill(Color.web("#019713"));
                            labelRemoveHome.setText("Room Removed"); 
                            home_notexists = true;
                            searchHomes(homesTextArea);

                            break;
                            }
                        }
                        
                        if (!home_notexists) 
                        {
                                labelRemoveHome.setTextFill(Color.web("#c90202"));
                                labelRemoveHome.setText("Room does not exist");  
                                //room_notexists = true;}
                        }
                    }
                }
                    catch (Exception e)
                {
                    throw e;
                }
                
    }
    
    
    public void logOut(ActionEvent event) throws IOException {
        Stage stage = (Stage) logout.getScene().getWindow();
        stage.close(); 
        
        stage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("Login.fxml"));
        Scene scene = new Scene(root);    
        stage.setScene(scene);
        stage.show();
        
            
    }
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        usernameLabel.setText(current_user);
        
        searchHomes(homesTextArea);

        // TODO
    }    
    
}
