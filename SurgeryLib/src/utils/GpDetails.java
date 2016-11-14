/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package utils;

import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;

/**
 *
 * @author Tom Poczos
 */
public class GpDetails implements java.io.Serializable {

    private String gpid;
    private String firstname;
    private String lastname;
    private Date employeesince;

    public GpDetails(String gpid, String firstname, String lastname, Date employeesince) {
        this.gpid = gpid;
        this.firstname = firstname;
        this.lastname = lastname;
        this.employeesince = employeesince;
    }

    public String getGpid() {
        return gpid;
    }

    public String getFirstname() {
        return firstname;
    }

    @Override
    public String toString() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        return "GP\t\t" + "ID: " + gpid + "\t\tFirst Name: " + firstname + "\t\tLast Name: " + lastname + "\t\tEmployee Since: " + dateFormat.format(employeesince);
    }

    public String getLastname() {
        return lastname;
    }

    public Date getEmployeesince() {
        return employeesince;
    }

    public void setGpid(String gpid) {
        this.gpid = gpid;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public void setEmployeesince(Date employeesince) {
        this.employeesince = employeesince;
    }
}
