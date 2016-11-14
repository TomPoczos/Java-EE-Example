/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package surgery;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Tom Poczos
 */
@Entity
@Table(name = "GP")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Gp.findBySubstance", query = "SELECT DISTINCT g FROM Gp g, in (g.prescriptionCollection) t WHERE t.substance = :substance"),
    @NamedQuery(name = "Gp.findAll", query = "SELECT g FROM Gp g"),
    @NamedQuery(name = "Gp.findByGpid", query = "SELECT g FROM Gp g WHERE g.gpid = :gpid"),
    @NamedQuery(name = "Gp.findByFirstname", query = "SELECT g FROM Gp g WHERE g.firstname = :firstname"),
    @NamedQuery(name = "Gp.findByLastname", query = "SELECT g FROM Gp g WHERE g.lastname = :lastname"),
    @NamedQuery(name = "Gp.findByEmployeesince", query = "SELECT g FROM Gp g WHERE g.employeesince = :employeesince")})
public class Gp implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 3)
    @Column(name = "GPID")
    private String gpid;
    @Size(max = 24)
    @Column(name = "FIRSTNAME")
    private String firstname;
    @Size(max = 24)
    @Column(name = "LASTNAME")
    private String lastname;
    @Column(name = "EMPLOYEESINCE")
    @Temporal(TemporalType.DATE)
    private Date employeesince;
    @OneToMany(mappedBy = "gpid")
    private Collection<Prescription> prescriptionCollection;
    @OneToMany(mappedBy = "gp")
    private Collection<Appointment> appointmentCollection;

    public Gp() {
    }

    public Gp(String gpid) {
        this.gpid = gpid;
    }

    public Gp(String gpid, String firstname, String lastname, Date employeesince) {
        this.gpid = gpid;
        this.firstname = firstname;
        this.lastname = lastname;
        this.employeesince = employeesince;
    }

    public void addPrescription(Prescription prescription) {
        if (prescription != null) {
            this.prescriptionCollection.add(prescription);
        }
    }

    public void removePrescription(Prescription prescription) {
        this.prescriptionCollection.remove(prescription);
    }

    public void addAppointment(Appointment appointment) {
        if (appointment != null) {
            this.appointmentCollection.add(appointment);
        }
    }

    public void removeAppointment(Appointment appointment) {
        this.appointmentCollection.remove(appointment);
    }

    public String getGpid() {
        return gpid;
    }

    public void setGpid(String gpid) {
        this.gpid = gpid;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public Date getEmployeesince() {
        return employeesince;
    }

    public void setEmployeesince(Date employeesince) {
        this.employeesince = employeesince;
    }

    @XmlTransient
    public Collection<Prescription> getPrescriptionCollection() {
        return prescriptionCollection;
    }

    public void setPrescriptionCollection(Collection<Prescription> prescriptionCollection) {
        this.prescriptionCollection = prescriptionCollection;
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
        hash += (gpid != null ? gpid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Gp)) {
            return false;
        }
        Gp other = (Gp) object;
        if ((this.gpid == null && other.gpid != null) || (this.gpid != null && !this.gpid.equals(other.gpid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "surgery.Gp[ gpid=" + gpid + " ]";
    }

}
