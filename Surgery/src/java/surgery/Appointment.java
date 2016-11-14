/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package surgery;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Tom Poczos
 */
@Entity
@Table(name = "APPOINTMENT")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Appointment.byRoomEquipment", query = "SELECT a FROM Appointment a WHERE a.room.hasfirstaidkit = :hasKit"),
    @NamedQuery(name = "Appointment.findAll", query = "SELECT a FROM Appointment a"),
    @NamedQuery(name = "Appointment.findByAppointmentid", query = "SELECT a FROM Appointment a WHERE a.appointmentid = :appointmentid"),
    @NamedQuery(name = "Appointment.findByApptime", query = "SELECT a FROM Appointment a WHERE a.apptime = :apptime")})
public class Appointment implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "APPOINTMENTID")
    private String appointmentid;
    @Column(name = "APPTIME")
    @Temporal(TemporalType.TIMESTAMP)
    private Date apptime;
    @JoinColumn(name = "GPID", referencedColumnName = "GPID")
    @ManyToOne
    private Gp gp;
    @JoinColumn(name = "PATIENTID", referencedColumnName = "PATIENTID")
    @ManyToOne
    private Patient patient;
    @JoinColumn(name = "ROOMID", referencedColumnName = "ROOMID")
    @ManyToOne
    private Room room;

    public Appointment() {
    }

    public Appointment(String appointmentid) {
        this.appointmentid = appointmentid;
    }

    public Appointment(String appointmentid, Date apptime) {
        this.appointmentid = appointmentid;
        this.apptime = apptime;
    }

    public String getAppointmentid() {
        return appointmentid;
    }

    public void setAppointmentid(String appointmentid) {
        this.appointmentid = appointmentid;
    }

    public Date getApptime() {
        return apptime;
    }

    public void setApptime(Date apptime) {
        this.apptime = apptime;
    }

    public Gp getGpid() {
        return gp;
    }

    public void setGpid(Gp gpid) {
        this.gp = gpid;
    }

    public Patient getPatientid() {
        return patient;
    }

    public void setPatientid(Patient patientid) {
        this.patient = patientid;
    }

    public Room getRoomid() {
        return room;
    }

    public void setRoomid(Room roomid) {
        this.room = roomid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (appointmentid != null ? appointmentid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Appointment)) {
            return false;
        }
        Appointment other = (Appointment) object;
        if ((this.appointmentid == null && other.appointmentid != null) || (this.appointmentid != null && !this.appointmentid.equals(other.appointmentid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "surgery.Appointment[ appointmentid=" + appointmentid + " ]";
    }

}
