/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package surgery;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Tom Poczos
 */
@Entity
@Table(name = "ROOM")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Room.findAll", query = "SELECT r FROM Room r"),
    @NamedQuery(name = "Room.findByRoomid", query = "SELECT r FROM Room r WHERE r.roomid = :roomid"),
    @NamedQuery(name = "Room.findByRoomnumber", query = "SELECT r FROM Room r WHERE r.roomnumber = :roomnumber"),
    @NamedQuery(name = "Room.findByHasfirstaidkit", query = "SELECT r FROM Room r WHERE r.hasfirstaidkit = :hasfirstaidkit")})
public class Room implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 3)
    @Column(name = "ROOMID")
    private String roomid;
    @Size(max = 3)
    @Column(name = "ROOMNUMBER")
    private String roomnumber;
    @Column(name = "HASFIRSTAIDKIT")
    private Boolean hasfirstaidkit;
    @OneToMany(mappedBy = "room")
    private Collection<Appointment> appointmentCollection;

    public Room() {
    }

    public Room(String roomid) {
        this.roomid = roomid;
    }

    public Room(String roomid, String roomnumber, Boolean hasfirstaidkit) {
        this.roomid = roomid;
        this.roomnumber = roomnumber;
        this.hasfirstaidkit = hasfirstaidkit;
    }

    public void addAppointment(Appointment appointment) {
        if (appointment != null) {
            this.appointmentCollection.add(appointment);
        }
    }

    public void removeAppointment(Appointment appointment) {
        this.appointmentCollection.remove(appointment);
    }

    public String getRoomid() {
        return roomid;
    }

    public void setRoomid(String roomid) {
        this.roomid = roomid;
    }

    public String getRoomnumber() {
        return roomnumber;
    }

    public void setRoomnumber(String roomnumber) {
        this.roomnumber = roomnumber;
    }

    public Boolean getHasfirstaidkit() {
        return hasfirstaidkit;
    }

    public void setHasfirstaidkit(Boolean hasfirstaidkit) {
        this.hasfirstaidkit = hasfirstaidkit;
    }

    @XmlTransient
    public Collection<Appointment> getAppointmentCollection() {
        return appointmentCollection;
    }

    public void setAppointmentCollection(Collection<Appointment> appointmentCollection) {
        this.appointmentCollection = appointmentCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (roomid != null ? roomid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Room)) {
            return false;
        }
        Room other = (Room) object;
        if ((this.roomid == null && other.roomid != null) || (this.roomid != null && !this.roomid.equals(other.roomid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "surgery.Room[ roomid=" + roomid + " ]";
    }

}
