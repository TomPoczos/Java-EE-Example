/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package surgery;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Tom Poczos
 */
@Entity
@Table(name = "PRESCRIPTION")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Prescription.findAll", query = "SELECT p FROM Prescription p"),
    @NamedQuery(name = "Prescription.findByPrescriptionid", query = "SELECT p FROM Prescription p WHERE p.prescriptionid = :prescriptionid"),
    @NamedQuery(name = "Prescription.findBySubstance", query = "SELECT p FROM Prescription p WHERE p.substance = :substance")})
public class Prescription implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "PRESCRIPTIONID")
    private String prescriptionid;
    @Size(max = 30)
    @Column(name = "SUBSTANCE")
    private String substance;
    @JoinColumn(name = "GPID", referencedColumnName = "GPID")
    @ManyToOne
    private Gp gpid;
    @JoinColumn(name = "PATIENTID", referencedColumnName = "PATIENTID")
    @ManyToOne
    private Patient patientid;

    public Prescription() {
    }

    public Prescription(String prescriptionid) {
        this.prescriptionid = prescriptionid;
    }

    public Prescription(String prescriptionid, String substance) {
        this.prescriptionid = prescriptionid;
        this.substance = substance;
    }

    public String getPrescriptionid() {
        return prescriptionid;
    }

    public void setPrescriptionid(String prescriptionid) {
        this.prescriptionid = prescriptionid;
    }

    public String getSubstance() {
        return substance;
    }

    public void setSubstance(String substance) {
        this.substance = substance;
    }

    public Gp getGpid() {
        return gpid;
    }

    public void setGpid(Gp gpid) {
        this.gpid = gpid;
    }

    public Patient getPatientid() {
        return patientid;
    }

    public void setPatientid(Patient patientid) {
        this.patientid = patientid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (prescriptionid != null ? prescriptionid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Prescription)) {
            return false;
        }
        Prescription other = (Prescription) object;
        if ((this.prescriptionid == null && other.prescriptionid != null) || (this.prescriptionid != null && !this.prescriptionid.equals(other.prescriptionid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "surgery.Prescription[ prescriptionid=" + prescriptionid + " ]";
    }

}
