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
public class PatientDetails implements java.io.Serializable {

    private String patientid;
    private String firstname;
    private String lastname;
    private Date dob;

    public PatientDetails(String patientid, String firstname, String lastname, Date dob) {
        this.patientid = patientid;
        this.firstname = firstname;
        this.lastname = lastname;
        this.dob = dob;
    }

    public String getPatientid() {
        return patientid;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public Date getDob() {
        return dob;
    }

    public void setPatientid(String patientid) {
        this.patientid = patientid;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    @Override
    public String toString() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        return "Patient\t" + "ID: " + patientid + "\tFirst Name: " + firstname + "\tLast Name: " + lastname + "\tDate of Birth: " + dateFormat.format(dob);
    }
    
    
}
