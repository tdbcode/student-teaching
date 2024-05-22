package electricityusagetracker;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import com.jfoenix.controls.JFXPasswordField;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;


//Database imports
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class LoginController extends user1 implements Initializable {
   
    
    @FXML
    private JFXTextField user;
    
    @FXML
    private JFXPasswordField pass;
    
    @FXML
    private Label label;
    
    @FXML
    private JFXButton signin;
                
    @FXML
    public void signInButtonAction(ActionEvent event) throws IOException, Exception
    {
        String input_username = user.getText();
        String input_password = pass.getText();
                                  

        Connection conn=null;
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").newInstance();
            conn = DriverManager.getConnection("jdbc:sqlserver://FS1;databaseName=DB5", "Db5User", ":8qmztC7");
                    
                    Statement stmt = null;
                                    
                    String searchData = "SELECT Username, Password FROM Users";
                    
                    stmt = conn.createStatement();
                    ResultSet rs = stmt.executeQuery(searchData);
                                                            
                    String usernameDB_search;
                    String passwordDB_search;
                    
                    boolean loggedin = false;
                    
                    while (rs.next()) {
                        usernameDB_search = rs.getString("Username").trim();
                        passwordDB_search = rs.getString("Password").trim();
                                               
                        if (input_username.equals(usernameDB_search) && input_password.equals(passwordDB_search)) {
                            Currentuser.setUsername(usernameDB_search);
                            //Open Main
                            label.setText("");
                            
                            Stage stage2 = new Stage();
                            Parent root = FXMLLoader.load(getClass().getResource("Main.fxml"));
                            
                            Scene scene = new Scene(root);
                            stage2.setScene(scene);
                            stage2.show();
                                                        
                            Stage stage1 = (Stage) signin.getScene().getWindow();
                            stage1.close();
                            break;
                                                                                    
                        }
                        
                        else
                            {
                                label.setText("Incorrect username or password");

                            }
                    }   
                        
                    
                }
                catch (Exception e){
                        throw e;
                    } 
    }



    @FXML
    public void createAccountButtonAction(ActionEvent event) throws IOException
    {
        
            Stage stage = new Stage();
            Parent root = FXMLLoader.load(getClass().getResource("CreateAccount.fxml"));
            Scene scene = new Scene(root);    
            stage.setScene(scene);
            stage.show();
            
            //Close Current Login Scene
    }
          
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}