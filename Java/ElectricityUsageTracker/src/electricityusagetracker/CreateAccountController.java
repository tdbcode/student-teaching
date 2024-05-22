package electricityusagetracker;

import javafx.fxml.Initializable;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class CreateAccountController implements Initializable {
    
    @FXML
    private JFXTextField newuser;   

    @FXML
    private JFXPasswordField newpass;

    @FXML
    private JFXPasswordField newpass1;
        
    @FXML
    private JFXButton signup;
    
    @FXML
    private Label label;

    @FXML
    public void signUpButtonAction(ActionEvent event) throws IOException, Exception {
        
        //User Input
        String new_user = newuser.getText();
        String new_password = newpass.getText();
        String new_password1 = newpass1.getText();
        
        //connection to database
        Connection conn=null;
                try 
                {
                    Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").newInstance();
                    conn = DriverManager.getConnection("jdbc:sqlserver://FS1;databaseName=DB5", "Db5User", ":8qmztC7");
                    if(conn!=null){
                        System.out.println("Database Successfully connected");
                    }
                    
                    Statement stmt = null;
                    //selecting all the users from the database                
                    String getData = "SELECT * FROM Users";
                                                      
                    stmt = conn.createStatement();
                    ResultSet rs = stmt.executeQuery(getData);
                    
                    stmt = conn.createStatement();
                    ResultSet rs2 = stmt.executeQuery(getData);
                                                            
                    String usernameDB_temp;
                    String passwordDB_temp;
                    
                    boolean loggedin = false;
                    
                    if (!rs2.next()) {
                        String addData = "INSERT INTO Users (Username, Password)"
                                    + "VALUES ('"+new_user+"', '"+ new_password+"')";
                            stmt.executeUpdate(addData);
                            
                            //Close window after signup button pressed
                            Stage stage = (Stage) signup.getScene().getWindow();
                            stage.close(); 
                    }
                    
                    else 
                    {
                    boolean username_exists = false;
                        while (rs.next()) 
                        {
                            usernameDB_temp = rs.getString("Username").trim();
                            passwordDB_temp = rs.getString("Password").trim();

                            //Making sure username does not exist in table
                            if (new_user.equals(usernameDB_temp)) 
                            {
                                label.setText("Username already exists");  
                                username_exists = true;
                                break;
                            }
                        }
                        //Making sure that both passwords entered are equal
                        if (new_password1.equals(new_password))
                        {
                            if (!username_exists) {
                           //Add user input to new row in table
                            String addData2 = "INSERT INTO Users (Username, Password)"
                                    + "VALUES ('"+new_user+"', '"+ new_password+"')";
                            stmt.executeUpdate(addData2);

                            //Close window after signup button pressed
                            Stage stage = (Stage) signup.getScene().getWindow();
                            stage.close(); 
                            
                            }
                            //break;
                        }

                        //Passwords do not match
                        else
                        {
                            label.setText("Password do not match");
                        }    
                       
                }
                }
                catch (Exception e)
                {
                    throw e;
                }
        
                
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }    
    
}
    
