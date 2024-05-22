package electricityusagetracker;

import javafx.beans.property.SimpleStringProperty;


public class CurrentUser {
    
    private SimpleStringProperty Username;
    
    CurrentUser(String user){
        this.Username = new SimpleStringProperty(user);
    }
    
    public String getUsername(){
        return Username.get();
    }
    
    public void setUsername(String user){
        this.Username.set(user);
    }
    
}
