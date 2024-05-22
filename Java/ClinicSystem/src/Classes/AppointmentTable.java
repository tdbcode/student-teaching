/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

// imports for date and time classes
import java.sql.Date;
import java.sql.Time;

//  Class for appointment table containing user appointments

public class AppointmentTable {
    
    private int patientID; 
    private Date date;
    private Time time; 

    public AppointmentTable(int patientID, Date date, Time time) {
        this.patientID = patientID;
        this.date = date;
        this.time = time;
    }

    public int getPatientID() {
        return patientID;
    }

    public void setPatientID(int patientID) {
        this.patientID = patientID;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Time getTime() {
        return time;
    }

    public void setTime(Time time) {
        this.time = time;
    }
    
}
