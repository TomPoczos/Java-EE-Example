/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package surgery;

import java.util.List;
import javax.ejb.Remote;
import utils.AppointmentDetails;
import utils.GpDetails;
import utils.PatientDetails;
import utils.PrescriptionDetails;
import utils.RoomDetails;

/**
 *
 * @author Tom Poczos
 */
@Remote
public interface SurgeryFacadeRemote extends java.io.Serializable{

    public void createAppointment(AppointmentDetails details);

    public void createGp(GpDetails details);

    public void createPrescription(PrescriptionDetails details);

    public void createPatient(PatientDetails details);

    public void createRoom(RoomDetails details);

    public void editAppointment(AppointmentDetails details);

    public void editGp(GpDetails details);

    public void editPrescription(PrescriptionDetails details);

    public void editPatient(PatientDetails details);

    public void editRoom(RoomDetails details);

    public void removeAppointment(String id);

    public void removeGp(String id);

    public void removePrescription(String id);

    public void removePatient(String id);

    public void removeRoom(String id);

    public void addAppointment(String appointmentId, String gpId, String patientId, String roomId);

    public void addPrescription(String prescriptionId, String gpId, String patientId);

    public List<PrescriptionDetails> getAllPrescriptions();

    public List<GpDetails> getAllGps();

    public List<PatientDetails> getAllPatients();

    public List<AppointmentDetails> getAllAppointments();

    public List<RoomDetails> getAllRooms();

    public List<PatientDetails> getAllPatientsWhoGot(String substance);

    public List<AppointmentDetails> getAllAppointmentsInRoom(boolean hasFirstAidKit);

    public List<GpDetails> getAllGpsWhoPrecribed(String substance);

    public List<PatientDetails> getAllPatientsThathadAppointmentsInRoom(boolean hasFirstAidKit);

    public List<PatientDetails> getAllPatientsWhoGotPrescribedSubstanceBy(String substance, String gpFirstName, String gpLastName);
    
}
