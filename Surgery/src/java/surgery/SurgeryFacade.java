/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package surgery;

import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJBException;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import utils.AppointmentDetails;
import utils.GpDetails;
import utils.PatientDetails;
import utils.PrescriptionDetails;
import utils.RoomDetails;

/**
 *
 * @author Tom Poczos
 */
@Stateless(mappedName = "surgeryfacade")
public class SurgeryFacade implements SurgeryFacadeRemote {

    @PersistenceContext(unitName = "SurgeryPU")
    private EntityManager em;

    public void persist(Object object) {
        em.persist(object);
    }

////////////////////////////////////////////////////////////////////////////////
// Lists of entity class objects to lists of data transfer objects
////////////////////////////////////////////////////////////////////////////////
    private List<AppointmentDetails> copyAppointmentsToDetails(List<Appointment> appointments) {
        List<AppointmentDetails> appointmentdeatilsList = new ArrayList<>();
        for (Appointment appointment : appointments) {
            appointmentdeatilsList.add(
                    new AppointmentDetails(appointment.getAppointmentid(), appointment.getApptime()));
        }
        return appointmentdeatilsList;
    }

    private List<GpDetails> copyGpDetails(List<Gp> gps) {
        List<GpDetails> gpDetailsList = new ArrayList<>();
        for (Gp gp : gps) {
            gpDetailsList.add(
                    new GpDetails(gp.getGpid(), gp.getFirstname(), gp.getLastname(), gp.getEmployeesince()));
        }
        return gpDetailsList;
    }

    private List<PrescriptionDetails> copyPrescriptionDetails(List<Prescription> prescriptions) {
        List<PrescriptionDetails> prescriptionDetailsList = new ArrayList<>();
        for (Prescription prescription : prescriptions) {
            prescriptionDetailsList.add(
                    new PrescriptionDetails(prescription.getPrescriptionid(), prescription.getSubstance()));
        }
        return prescriptionDetailsList;
    }

    private List<PatientDetails> copyPatientDetails(List<Patient> patients) {
        List<PatientDetails> patientDetailsList = new ArrayList<>();
        for (Patient patient : patients) {
            patientDetailsList.add(
                    new PatientDetails(patient.getPatientid(), patient.getFirstname(), patient.getLastname(), patient.getDob()));
        }
        return patientDetailsList;
    }

    private List<RoomDetails> copyRoomDetails(List<Room> rooms) {
        List<RoomDetails> roomDetailsList = new ArrayList<>();
        for (Room room : rooms) {
            roomDetailsList.add(
                    new RoomDetails(room.getRoomid(), room.getRoomnumber(), room.getHasfirstaidkit()));
        }
        return roomDetailsList;
    }

////////////////////////////////////////////////////////////////////////////////
// Create and persist entity classes from DTOs
////////////////////////////////////////////////////////////////////////////////
    @Override
    public void createAppointment(AppointmentDetails details) {
        try {
            em.persist(
                    new Appointment(details.getAppointmentid(), details.getApptime()));
        } catch (Exception ex) {
            throw new EJBException(ex);
        }
    }

    @Override
    public void createGp(GpDetails details) {
        try {
            em.persist(
                    new Gp(details.getGpid(), details.getFirstname(), details.getLastname(), details.getEmployeesince()));
        } catch (Exception ex) {
            throw new EJBException(ex);
        }
    }

    @Override
    public void createPrescription(PrescriptionDetails details) {
        try {
            em.persist(
                    new Prescription(details.getPrescriptionid(), details.getSubstance()));
        } catch (Exception ex) {
            throw new EJBException(ex);
        }
    }

    @Override
    public void createPatient(PatientDetails details) {
        try {
            em.persist(
                    new Patient(details.getPatientid(), details.getFirstname(), details.getLastname(), details.getDob()));
        } catch (Exception ex) {
            throw new EJBException(ex);
        }
    }

    @Override
    public void createRoom(RoomDetails details) {
        try {
            em.persist(
                    new Room(details.getRoomid(), details.getRoomnumber(), details.getHasfirstaidkit()));
        } catch (Exception ex) {
            throw new EJBException(ex);
        }
    }

////////////////////////////////////////////////////////////////////////////////
// Persist changes to existing entities
////////////////////////////////////////////////////////////////////////////////
    @Override
    public void editAppointment(AppointmentDetails details) {
        try {
            em.merge(
                    new Appointment(details.getAppointmentid(), details.getApptime()));
        } catch (Exception ex) {
            throw new EJBException(ex);
        }
    }

    @Override
    public void editGp(GpDetails details) {
        try {
            em.merge(
                    new Gp(details.getGpid(), details.getFirstname(), details.getLastname(), details.getEmployeesince()));
        } catch (Exception ex) {
            throw new EJBException(ex);
        }
    }

    @Override
    public void editPrescription(PrescriptionDetails details) {
        try {
            em.merge(
                    new Prescription(details.getPrescriptionid(), details.getSubstance()));
        } catch (Exception ex) {
            throw new EJBException(ex);
        }
    }

    @Override
    public void editPatient(PatientDetails details) {
        try {
            em.merge(
                    new Patient(details.getPatientid(), details.getFirstname(), details.getLastname(), details.getDob()));
        } catch (Exception ex) {
            throw new EJBException(ex);
        }
    }

    @Override
    public void editRoom(RoomDetails details) {
        try {
            em.merge(
                    new Room(details.getRoomid(), details.getRoomnumber(), details.getHasfirstaidkit()));
        } catch (Exception ex) {
            throw new EJBException(ex);
        }
    }

////////////////////////////////////////////////////////////////////////////////
// Remove entities
////////////////////////////////////////////////////////////////////////////////
    @Override
    public void removeAppointment(String id) {
        try {
            Appointment appointment = em.find(Appointment.class, id);
            em.remove(appointment);
        } catch (Exception ex) {
            throw new EJBException(ex);
        }
    }

    @Override
    public void removeGp(String id) {
        try {
            Gp gp = em.find(Gp.class, id);
            em.remove(gp);
        } catch (Exception ex) {
            throw new EJBException(ex);
        }
    }

    @Override
    public void removePrescription(String id) {
        try {
            Prescription prescription = em.find(Prescription.class, id);
            em.remove(prescription);
        } catch (Exception ex) {
            throw new EJBException(ex);
        }
    }

    @Override
    public void removePatient(String id) {
        try {
            Patient patient = em.find(Patient.class, id);
            em.remove(patient);
        } catch (Exception ex) {
            throw new EJBException(ex);
        }
    }

    @Override
    public void removeRoom(String id) {
        try {
            Room room = em.find(Room.class, id);
            em.remove(room);
        } catch (Exception ex) {
            throw new EJBException(ex);
        }
    }

////////////////////////////////////////////////////////////////////////////////
// Adding Appointments and Prescriptions (getting the relationships right)
////////////////////////////////////////////////////////////////////////////////
    @Override
    public void addAppointment(String appointmentId, String gpId, String patientId, String roomId) {
        try {
            Appointment appointment = em.find(Appointment.class, appointmentId);
            Gp gp = em.find(Gp.class, gpId);
            Patient patient = em.find(Patient.class, patientId);
            Room room = em.find(Room.class, roomId);

            appointment.setGpid(gp);
            appointment.setPatientid(patient);
            appointment.setRoomid(room);

            gp.addAppointment(appointment);

            patient.addAppointment(appointment);

            room.addAppointment(appointment);

        } catch (Exception ex) {
            throw new EJBException(ex);
        }
    }

    @Override
    public void addPrescription(String prescriptionId, String gpId, String patientId) {
        try {
            Prescription prescription = em.find(Prescription.class, prescriptionId);
            Gp gp = em.find(Gp.class, gpId);
            Patient patient = em.find(Patient.class, patientId);

            prescription.setGpid(gp);
            prescription.setPatientid(patient);

            gp.addPrescription(prescription);

            patient.addPrescription(prescription);
        } catch (Exception ex) {
            throw new EJBException(ex);
        }
    }

    @Override
    public List<PrescriptionDetails> getAllPrescriptions() {
        List<Prescription> prescriptions = em.createNamedQuery("Prescription.findAll").getResultList();
        return copyPrescriptionDetails(prescriptions);
    }

    @Override
    public List<GpDetails> getAllGps() {
        List<Gp> gps = em.createNamedQuery("Gp.findAll").getResultList();
        return copyGpDetails(gps);
    }

    @Override
    public List<PatientDetails> getAllPatients() {
        List<Patient> patients = em.createNamedQuery("Patient.findAll").getResultList();
        return copyPatientDetails(patients);
    }

    @Override
    public List<AppointmentDetails> getAllAppointments() {
        List<Appointment> prescriptions = em.createNamedQuery("Appointment.findAll").getResultList();
        return copyAppointmentsToDetails(prescriptions);
    }

    @Override
    public List<RoomDetails> getAllRooms() {
        List<Room> prescriptions = em.createNamedQuery("Room.findAll").getResultList();
        return copyRoomDetails(prescriptions);
    }

    @Override
    public List<PatientDetails> getAllPatientsWhoGot(String substance) {
        List<Patient> patients = em
                .createNamedQuery("Patient.findBySubstance")
                .setParameter("substance", substance)
                .getResultList();
        return copyPatientDetails(patients);
    }

    @Override
    public List<GpDetails> getAllGpsWhoPrecribed(String substance) {
        List<Gp> gps = em
                .createNamedQuery("Gp.findBySubstance")
                .setParameter("substance", substance)
                .getResultList();
        return copyGpDetails(gps);
    }

    @Override
    public List<AppointmentDetails> getAllAppointmentsInRoom(boolean hasFirstAidKit) {
        List<Appointment> appointments = em
                .createNamedQuery("Appointment.byRoomEquipment")
                .setParameter("hasKit", hasFirstAidKit)
                .getResultList();

        return copyAppointmentsToDetails(appointments);
    }

    @Override
    public List<PatientDetails> getAllPatientsThathadAppointmentsInRoom(boolean hasFirstAidKit) {
        List<Patient> patients = em
                .createNamedQuery("Patient.findByAppointmentRoom")
                .setParameter("hasKit", hasFirstAidKit)
                .getResultList();
        return copyPatientDetails(patients);
    }
    
    @Override
    public List<PatientDetails> getAllPatientsWhoGotPrescribedSubstanceBy(String substance, String gpFirstName, String gpLastName) {
        List<Patient> patients = em
                .createNamedQuery("Patient.findByGpPerscribedSubstance")
                .setParameter("substance", substance)
                .setParameter("gpfirstname", gpFirstName)
                .setParameter("gpLastName", gpLastName)
                .getResultList();
        return copyPatientDetails(patients);
    }
}
