/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cliclient;

import static cliclient.CliCreate.ctx;
import static cliclient.CliDelete.surgeryFacade;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import surgery.SurgeryFacadeRemote;

/**
 *
 * @author tom
 */
public class CliQueries {
    
    
    static SurgeryFacadeRemote surgeryFacade;
    
    public static void main(String[] args) {
        connect();
        
        System.out.println("\nPrinting all appointments that occurred in a room that has a first aid kit:\n");
        
        surgeryFacade.getAllAppointmentsInRoom(true).forEach(room -> System.out.println(room.toString()));
        
        System.out.println("\nPrinting all GPs who prescribed Oxycodone\n");
        
        surgeryFacade.getAllGpsWhoPrecribed("Oxycodone").forEach(gp -> System.out.println(gp.toString()));
        
        System.out.println("\nPrinting all patients who received Paracetamol\n");
        
        surgeryFacade.getAllPatientsWhoGot("Paracetamol").forEach(patient -> System.out.println(patient.toString()));
        
        System.out.println("\nPrinting all patients who ever had at least one appointment in a room without a first aid kit\n");
        
        surgeryFacade.getAllPatientsThathadAppointmentsInRoom(false).forEach(patient -> System.out.println(patient.toString()));
        
        System.out.println("\nPrinting all patients who ever received Oxycodone from Hannah Yates\n");
        
        surgeryFacade.getAllPatientsWhoGotPrescribedSubstanceBy("Oxycodone", "Hannah", "Yates").forEach(patient -> System.out.println(patient.toString()));
    }
    
        private static void connect() {
        System.out.println("Connecting...");
        try {
            ctx = new InitialContext();
            surgeryFacade = (SurgeryFacadeRemote) ctx.lookup("surgeryfacade");
            System.out.println("Connected!");
        } catch (NamingException ex) {
            Logger.getLogger(CliCreate.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
