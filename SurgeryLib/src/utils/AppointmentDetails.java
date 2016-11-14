/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package utils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Tom Poczos
 */
public class AppointmentDetails implements java.io.Serializable {

    private String appointmentid;
    private Date apptime;

    public AppointmentDetails(String appointmentid, Date apptime) {
        this.appointmentid = appointmentid;
        this.apptime = apptime;
    }

    public String getAppointmentid() {
        return appointmentid;
    }

    public Date getApptime() {
        return apptime;
    }

    public void setAppointmentid(String appointmentid) {
        this.appointmentid = appointmentid;
    }

    public void setApptime(Date apptime) {
        this.apptime = apptime;
    }

    @Override
    public String toString() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        
        return "Appointment\t\tID: " + appointmentid + "\t\tTime of Appointment: " + dateFormat.format(apptime);
    }
    
    
}
