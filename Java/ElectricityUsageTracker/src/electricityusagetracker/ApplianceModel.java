
package electricityusagetracker;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;


public class ApplianceModel {
    
    private SimpleStringProperty applianceName;
    private SimpleStringProperty roomName;
    private SimpleStringProperty userName;
    private SimpleDoubleProperty electricityConsumption;
    private SimpleDoubleProperty costValue;
    private SimpleDoubleProperty timeValue;
    private SimpleStringProperty dateValue;


    public ApplianceModel(String applianceName, String roomName, String userName, double electricityConsumption, double costValue, double timeValue, String dateValue) {
        this.applianceName = new SimpleStringProperty(applianceName);
        this.roomName = new SimpleStringProperty(roomName);
        this.userName = new SimpleStringProperty(userName);
        this.electricityConsumption = new SimpleDoubleProperty(electricityConsumption);
        this.costValue = new SimpleDoubleProperty(costValue);
        this.timeValue = new SimpleDoubleProperty(timeValue);
        this.dateValue = new SimpleStringProperty(dateValue);
                
    }

    public String getApplianceName() {
        return applianceName.get();
    }

    public void setApplianceName(String applianceName) {
        this.applianceName = new SimpleStringProperty(applianceName);
    }

    public String getRoomName() {
        return roomName.get();
    }

    public void setRoomName(String roomName) {
        this.roomName = new SimpleStringProperty(roomName);
    }

    public String getUserName() {
        return userName.get();
    }

    public void setUserName(String userName) {
        this.userName = new SimpleStringProperty(userName);
    }
    
    public double getElectricityConsumption() {
        return electricityConsumption.get();
    }

    public void setElectricityConsumption(double electricityConsumption) {
        this.electricityConsumption = new SimpleDoubleProperty(electricityConsumption);
    }
    
    public double getCostValue() {
        return costValue.get();
    }

    public void setCostValue(double costValue) {
        this.costValue = new SimpleDoubleProperty(costValue);
    }
    
    public double getTimeValue() {
        return timeValue.get();
    }

    public void setTimeValue(double timeValue) {
        this.timeValue = new SimpleDoubleProperty(timeValue);
    }
    
    public String getDateValue() {
        return dateValue.get();
    }

    public void setDateValue(String dateValue) {
        this.dateValue = new SimpleStringProperty(dateValue);
    }
    
    
}
