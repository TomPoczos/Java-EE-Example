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
@Table(name = "PATIENT")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Patient.findByGpPerscribedSubstance", 
    query = "SELECT DISTINCT p FROM Patient p, in (p.prescriptionCollection) t WHERE t.substance = :substance AND t.gpid.firstname = :gpfirstname AND t.gpid.lastname = :gpLastName"),
    @NamedQuery(name = "Patient.findBySubstance", query = "SELECT DISTINCT p FROM Patient p, in (p.prescriptionCollection) t WHERE t.substance = :substance"),
    @NamedQuery(name = "Patient.findByAppointmentRoom", query = "SELECT DISTINCT p FROM Patient p, in (p.appointmentCollection) a WHERE a.room.hasfirstaidkit = :hasKit"),
    @NamedQuery(name = "Patient.findAll", query = "SELECT p FROM Patient p"),
    @NamedQuery(name = "Patient.findByPatientid", query = "SELECT p FROM Patient p WHERE p.patientid = :patientid"),
    @NamedQuery(name = "Patient.findByFirstname", query = "SELECT p FROM Patient p WHERE p.firstname = :firstname"),
    @NamedQuery(name = "Patient.findByLastname", query = "SELECT p FROM Patient p WHERE p.lastname = :lastname"),
    @NamedQuery(name = "Patient.findByDob", query = "SELECT p FROM Patient p WHERE p.dob = :dob")})
public class Patient implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 7)
    @Column(name = "PATIENTID")
    private String patientid;
    @Size(max = 24)
    @Column(name = "FIRSTNAME")
    private String firstname;
    @Size(max = 24)
    @Column(name = "LASTNAME")
    private String lastname;
    @Column(name = "DOB")
    @Temporal(TemporalType.DATE)
    private Date dob;
    @OneToMany(mappedBy = "patientid")
    private Collection<Prescription> prescriptionCollection;
    @OneToMany(mappedBy = "patient")
    private Collection<Appointment> appointmentCollection;

    public Patient() {
    }

    public Patient(String patientid) {
        this.patientid = patientid;
    }
    
    public Patient(String patientid, String firstname, String lastname, Date dob) {
        this.patientid = patientid;
        this.firstname = firstname;
        this.lastname = lastname;
        this.dob = dob;
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

    public String getPatientid() {
        return patientid;
    }

    public void setPatientid(String patientid) {
        this.patientid = patientid;
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

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
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
        hash += (patientid != null ? patientid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Patient)) {
            return false;
        }
        Patient other = (Patient) object;
        if ((this.patientid == null && other.patientid != null) || (this.patientid != null && !this.patientid.equals(other.patientid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "surgery.Patient[ patientid=" + patientid + " ]";
    }

}
