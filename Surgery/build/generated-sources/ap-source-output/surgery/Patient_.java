package surgery;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import surgery.Appointment;
import surgery.Prescription;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-01-10T19:47:36")
@StaticMetamodel(Patient.class)
public class Patient_ { 

    public static volatile SingularAttribute<Patient, String> firstname;
    public static volatile SingularAttribute<Patient, String> patientid;
    public static volatile SingularAttribute<Patient, Date> dob;
    public static volatile CollectionAttribute<Patient, Prescription> prescriptionCollection;
    public static volatile SingularAttribute<Patient, String> lastname;
    public static volatile CollectionAttribute<Patient, Appointment> appointmentCollection;

}