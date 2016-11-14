package surgery;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import surgery.Gp;
import surgery.Patient;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-01-10T19:47:36")
@StaticMetamodel(Prescription.class)
public class Prescription_ { 

    public static volatile SingularAttribute<Prescription, String> prescriptionid;
    public static volatile SingularAttribute<Prescription, Gp> gpid;
    public static volatile SingularAttribute<Prescription, Patient> patientid;
    public static volatile SingularAttribute<Prescription, String> substance;

}