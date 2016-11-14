/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cliclient;

import static cliclient.CliCreate.ctx;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import surgery.SurgeryFacadeRemote;
import utils.GpDetails;

/**
 *
 * @author tom
 */
public class CliDelete {

    static SurgeryFacadeRemote surgeryFacade;

    public static void main(String[] args) {
        connect();
        removeData();
    }

    private static void removeData() {
        System.out.println("Removing data...");
        
        surgeryFacade.getAllAppointments() .stream().forEach((appointment)  -> surgeryFacade.removeAppointment (appointment .getAppointmentid()));
        surgeryFacade.getAllPrescriptions().stream().forEach((prescription) -> surgeryFacade.removePrescription(prescription.getPrescriptionid()));
        surgeryFacade.getAllGps()          .stream().forEach((gp)           -> surgeryFacade.removeGp          (gp          .getGpid()));
        surgeryFacade.getAllPatients()     .stream().forEach((patient)      -> surgeryFacade.removePatient     (patient     .getPatientid()));
        surgeryFacade.getAllRooms()        .stream().forEach((room)         -> surgeryFacade.removeRoom        (room        .getRoomid()));
        
        System.out.println("All data has been removed");
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
