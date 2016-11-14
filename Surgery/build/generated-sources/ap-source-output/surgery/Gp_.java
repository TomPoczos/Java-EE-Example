package surgery;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import surgery.Appointment;
import surgery.Prescription;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-01-10T19:47:36")
@StaticMetamodel(Gp.class)
public class Gp_ { 

    public static volatile SingularAttribute<Gp, String> firstname;
    public static volatile SingularAttribute<Gp, Date> employeesince;
    public static volatile SingularAttribute<Gp, String> gpid;
    public static volatile CollectionAttribute<Gp, Prescription> prescriptionCollection;
    public static volatile SingularAttribute<Gp, String> lastname;
    public static volatile CollectionAttribute<Gp, Appointment> appointmentCollection;

}