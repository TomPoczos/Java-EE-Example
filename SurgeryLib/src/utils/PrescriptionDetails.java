/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

/**
 *
 * @author Tom Poczos
 */
public class PrescriptionDetails implements java.io.Serializable {

    private String prescriptionid;
    private String substance;

    public PrescriptionDetails(String prescriptionid, String substance) {
        this.prescriptionid = prescriptionid;
        this.substance = substance;
    }

    public String getPrescriptionid() {
        return prescriptionid;
    }

    public String getSubstance() {
        return substance;
    }

    public void setPrescriptionid(String prescriptionid) {
        this.prescriptionid = prescriptionid;
    }

    public void setSubstance(String substance) {
        this.substance = substance;
    }

    @Override
    public String toString() {
        return "Prescription\t" + "ID: " + prescriptionid + "\tSubstance: " + substance;
    }
    
    
}
