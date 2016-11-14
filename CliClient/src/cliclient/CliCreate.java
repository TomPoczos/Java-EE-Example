/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cliclient;

import com.sun.javafx.scene.control.skin.VirtualFlow;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import surgery.SurgeryFacadeRemote;
import utils.AppointmentDetails;
import utils.GpDetails;
import utils.PatientDetails;
import utils.PrescriptionDetails;
import utils.RoomDetails;

/**
 *
 * @author tom
 */
public class CliCreate {

    /* 
     * ALL NAMES HAVE BEEN GENERATED USING https://www.fakenamegenerator.com/gen-random-en-uk.php
     * ALL DATES HAVE BEEN GENERATED USING https://www.random.org
     */
    static SimpleDateFormat dateFormat;
    static Context ctx;
    static SurgeryFacadeRemote surgeryFacade;
    static List<RoomDetails> rooms;
    static List<GpDetails> gps;
    static List<PatientDetails> patients;
    static List<AppointmentDetails> appointments;
    static List<String> substances;
    static List<PrescriptionDetails> prescriptions;

    public static void main(String[] args) {
        init();
        connect();
        createSubstances();
        createRooms();
        createGps();
        createPatients();
        createAppointments(500, 2010, 2015);
        createPrescriptions(500);
        uploadData();
        linkAppointmentsAtServer();
        linkPrescriptionsAtServer();
    }

    private static void init() {
        dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        rooms = new ArrayList<>();
        gps = new ArrayList<>();
        patients = new ArrayList<>();
        substances = new ArrayList<>();
        prescriptions = new ArrayList<>();
        appointments = new ArrayList<>();
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

    private static void createRooms() {
        System.out.println("Creating rooms...");
        rooms.add(new RoomDetails("1", "1A", true));
        rooms.add(new RoomDetails("2", "1B", false));
        rooms.add(new RoomDetails("3", "2A", true));
        rooms.add(new RoomDetails("4", "2B", false));
        rooms.add(new RoomDetails("5", "3A", true));
        rooms.add(new RoomDetails("6", "3B", false));
        rooms.add(new RoomDetails("7", "4A", true));
        rooms.add(new RoomDetails("8", "4B", false));
        rooms.add(new RoomDetails("9", "5A", true));
        rooms.add(new RoomDetails("10", "5B", false));
        rooms.add(new RoomDetails("11", "6A", true));
        rooms.add(new RoomDetails("12", "6B", false));
        rooms.add(new RoomDetails("13", "7A", true));
        rooms.add(new RoomDetails("14", "7B", false));
        rooms.add(new RoomDetails("15", "8A", true));
        rooms.add(new RoomDetails("16", "8B", false));
        rooms.add(new RoomDetails("17", "9A", true));
        rooms.add(new RoomDetails("18", "9B", false));
        rooms.add(new RoomDetails("19", "10A", true));
        rooms.add(new RoomDetails("20", "10B", false));
        System.out.println("Rooms created");

    }

    private static void createGps() {
        try {
            System.out.println("Creating GPs...");
            gps.add(new GpDetails("1", "Danielle", "Perry", dateFormat.parse("11/02/1993")));
            gps.add(new GpDetails("2", "Harry", "Craig", dateFormat.parse("21/10/1994")));
            gps.add(new GpDetails("3", "Georgia", "Dawson", dateFormat.parse("06/12/1996")));
            gps.add(new GpDetails("4", "Charlie", "Bennett", dateFormat.parse("10/09/2001")));
            gps.add(new GpDetails("5", "Nicole", "Gilbert", dateFormat.parse("07/04/2003")));
            gps.add(new GpDetails("6", "Hannah", "Yates", dateFormat.parse("29/12/2006")));
            gps.add(new GpDetails("7", "Louis", "Mahmood", dateFormat.parse("03/04/2007")));
            gps.add(new GpDetails("8", "Rhys", "Payne", dateFormat.parse("15/04/2008")));
            gps.add(new GpDetails("9", "Abbie", "Stevenson", dateFormat.parse("21/09/2009")));
            gps.add(new GpDetails("10", "Hannah", "Weston", dateFormat.parse("22/05/2013")));
            System.out.println("GPs created");
        } catch (ParseException ex) {
            Logger.getLogger(CliCreate.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private static void createPatients() {
        try {
            System.out.println("Creating patients...");
            patients.add(new PatientDetails("1", "Anthony", "Tomlinson", dateFormat.parse("01/02/1938")));
            patients.add(new PatientDetails("2", "Evie", "Welch", dateFormat.parse("20/06/1940")));
            patients.add(new PatientDetails("3", "Lucas", "Hopkins", dateFormat.parse("01/01/1947")));
            patients.add(new PatientDetails("4", "Patrick", "Leonard", dateFormat.parse("24/03/1947")));
            patients.add(new PatientDetails("5", "Megan", "Noble", dateFormat.parse("12/04/1951")));
            patients.add(new PatientDetails("6", "Holly", "Carr", dateFormat.parse("04/03/1952")));
            patients.add(new PatientDetails("7", "Morgan", "Mason", dateFormat.parse("25/12/1952")));
            patients.add(new PatientDetails("8", "Harry", "Hayward", dateFormat.parse("29/07/1953")));
            patients.add(new PatientDetails("9", "Holly", "Lowe", dateFormat.parse("14/04/1958")));
            patients.add(new PatientDetails("10", "Gabriel", "Baxter", dateFormat.parse("04/06/1958")));
            patients.add(new PatientDetails("11", "Isobel", "Morley", dateFormat.parse("21/05/1964")));
            patients.add(new PatientDetails("12", "Alexandra", "Harris", dateFormat.parse("25/08/1967")));
            patients.add(new PatientDetails("13", "Caitlin", "Bevan", dateFormat.parse("04/04/1977")));
            patients.add(new PatientDetails("14", "Evie", "Coleman", dateFormat.parse("02/11/1977")));
            patients.add(new PatientDetails("15", "Amelia", "Storey", dateFormat.parse("05/08/1985")));
            patients.add(new PatientDetails("16", "Cameron", "Moss", dateFormat.parse("31/10/1985")));
            patients.add(new PatientDetails("17", "Harriet", "Cooper", dateFormat.parse("07/04/1988")));
            patients.add(new PatientDetails("18", "Victoria", "Kirk", dateFormat.parse("29/11/1988")));
            patients.add(new PatientDetails("19", "Samantha", "Connolly", dateFormat.parse("09/04/1990")));
            patients.add(new PatientDetails("20", "Isabella", "Todd", dateFormat.parse("02/12/1996")));
            patients.add(new PatientDetails("21", "Maya", "Fox", dateFormat.parse("30/01/1997")));
            patients.add(new PatientDetails("22", "Gracie", "Ball", dateFormat.parse("23/04/1999")));
            patients.add(new PatientDetails("23", "Edward", "Lowe", dateFormat.parse("01/05/2001")));
            patients.add(new PatientDetails("24", "Riley", "Campbell", dateFormat.parse("28/11/2003")));
            patients.add(new PatientDetails("25", "Reece", "Moran", dateFormat.parse("01/10/2004")));
            patients.add(new PatientDetails("26", "Thomas", "Poole", dateFormat.parse("15/09/2006")));
            patients.add(new PatientDetails("27", "Chloe", "Chambers", dateFormat.parse("07/11/2007")));
            patients.add(new PatientDetails("28", "Luke", "Lambert", dateFormat.parse("06/02/2008")));
            patients.add(new PatientDetails("29", "Thomas", "Lucas", dateFormat.parse("17/07/2009")));
            patients.add(new PatientDetails("30", "Nicole", "Palmer", dateFormat.parse("22/04/2011")));
            System.out.println("Patients created");
        } catch (ParseException ex) {
            Logger.getLogger(CliCreate.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private static void createSubstances() {

        // https://en.wikipedia.org/wiki/List_of_antibiotics
        // https://en.wikipedia.org/wiki/Analgesic
        System.out.println("Creating substances...");

        substances.add("Paracetamol");
        substances.add("Ibuprofen");
        substances.add("Cocaine");
        substances.add("Gentamicin");
        substances.add("Netilmicin");
        substances.add("Doripenem");
        substances.add("Cefadroxil");
        substances.add("Cefalexin");
        substances.add("Cefprozil");
        substances.add("Vancomycin");
        substances.add("Dalbavancin");
        substances.add("Oritavancin");
        substances.add("Clindamycin");
        substances.add("Azithromycin");
        substances.add("Aztreonam");
        substances.add("Furazolidone");
        substances.add("Amoxicillin");
        substances.add("Ampicillin");
        substances.add("Polymyxin B");
        substances.add("Moxifloxacin");
        substances.add("Sulfacetamide");
        substances.add("Sulfasalazine");
        substances.add("Doxycycline");
        substances.add("Oxytetracycline");
        substances.add("Clofazimine");
        substances.add("Cycloserine");
        substances.add("Rifabutin");
        substances.add("Metronidazole");
        substances.add("Mupirocin");
        substances.add("Tinidazole");
        substances.add("Aspirine");
        substances.add("Benzydamine");
        substances.add("Aceclofenac");
        substances.add("Aminophenazone");
        substances.add("Ampiroxicam");
        substances.add("Clonixin");
        substances.add("Dexibuprofen");
        substances.add("Diclofenac");
        substances.add("Epirizole");
        substances.add("Ethenzamide");
        substances.add("Felbinac");
        substances.add("Fenbufen");
        substances.add("Fenoprofen");
        substances.add("Fentiazac");
        substances.add("Feprazone");
        substances.add("Indometacin");
        substances.add("Ketoprofen");
        substances.add("Ketorolac");
        substances.add("Mofezolac");
        substances.add("Nabumetone");
        substances.add("Naproxen");
        substances.add("Oxaprozin");
        substances.add("Oxyphenbutazone");
        substances.add("Phenazone");
        substances.add("Piroxicam");
        substances.add("Salol");
        substances.add("Salicylamide");
        substances.add("Tolmetin");
        substances.add("Etoricoxib");
        substances.add("Meloxicam");
        substances.add("Parecoxib");
        substances.add("Buprenorphine");
        substances.add("Diamorphine");
        substances.add("Hydrocodone");
        substances.add("Hydromorphone");
        substances.add("Oxycodone");

        System.out.println("Substances created");
    }

    private static void createPrescriptions(int amount) {
        System.out.println("Creating prescriptions...");
        for (int i = 0; i < amount; i++) {
            prescriptions.add(new PrescriptionDetails(
                    Integer.toString(i + 1),
                    substances.get(getRndNmrInRangeInclusive(0, substances.size() - 1))
            ));
        }

        prescriptions.add(new PrescriptionDetails("100000", "Oxycodone"));
        prescriptions.add(new PrescriptionDetails("100001", "Oxycodone"));
        prescriptions.add(new PrescriptionDetails("100002", "Oxycodone"));
        System.out.println("perscriptions created");
    }

    private static void linkPrescriptionsAtServer() {
        System.out.println("Linking prescriptions...");
        prescriptions.forEach((prescription)
                -> {
            if (!prescription.getPrescriptionid().equals("100000") || !prescription.getPrescriptionid().equals("100001") || !prescription.getPrescriptionid().equals("100002") ) {
                surgeryFacade.addPrescription(
                        prescription.getPrescriptionid(),
                        Integer.toString(getRndNmrInRangeInclusive(1, gps.size())),
                        Integer.toString(getRndNmrInRangeInclusive(1, patients.size())));
            }
            surgeryFacade.addPrescription("100000", "6", "5");
            surgeryFacade.addPrescription("100001", "6", "15");
            surgeryFacade.addPrescription("100002", "6", "25");
        });
        System.out.println("Prescriptions linked");
    }

    private static void createAppointments(int amount, int minYear, int maxYear) {
        System.out.println("Creating appointments...");
        for (int i = 0; i < amount; i++) {
            String day = Integer.toString(getRndNmrInRangeInclusive(1, 30));
            String month = Integer.toString(getRndNmrInRangeInclusive(1, 12));
            String year = Integer.toString(getRndNmrInRangeInclusive(minYear, maxYear));

            try {
                Date dateOfAppointment = dateFormat.parse(day + "/" + month + "/" + year);
                appointments.add(new AppointmentDetails(Integer.toString(i + 1), dateOfAppointment));
            } catch (ParseException ex) {
                Logger.getLogger(CliCreate.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        System.out.println("Appointments created");
    }

    private static void linkAppointmentsAtServer() {
        System.out.println("Linking appointments at server...");
        appointments.stream()
                .forEach((Appointment) -> surgeryFacade.addAppointment(
                        Appointment.getAppointmentid(),
                        Integer.toString(getRndNmrInRangeInclusive(1, gps.size())),
                        Integer.toString(getRndNmrInRangeInclusive(1, patients.size())),
                        Integer.toString(getRndNmrInRangeInclusive(1, rooms.size()))));
        System.out.println("Appointments linked");
    }

    private static int getRndNmrInRangeInclusive(int min, int max) {
        return ThreadLocalRandom.current().nextInt(min, max + 1);
    }

    private static void uploadData() {
        System.out.println("Uploading rooms...");

        rooms.stream().forEach((room) -> surgeryFacade.createRoom(room));

        System.out.println("Rooms uploaded");
        System.out.println("Uploading GPs...");

        gps.stream().forEach((gp) -> surgeryFacade.createGp(gp));

        System.out.println("GPs uploaded");
        System.out.println("Uploading patients...");

        patients.stream().forEach((patient) -> surgeryFacade.createPatient(patient));

        System.out.println("Patients uploaded");
        System.out.println("Uploading appointments...");

        appointments.stream().forEach((appointment) -> surgeryFacade.createAppointment(appointment));

        System.out.println("Appointments uploaded");
        System.out.println("Uploading prescriptions...");

        prescriptions.stream().forEach((prescription) -> surgeryFacade.createPrescription(prescription));

        System.out.println("Prescriptions uploaded");
    }
}
