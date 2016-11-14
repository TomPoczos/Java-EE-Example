package surgery;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import surgery.Gp;
import surgery.Patient;
import surgery.Room;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-01-10T19:47:36")
@StaticMetamodel(Appointment.class)
public class Appointment_ { 

    public static volatile SingularAttribute<Appointment, Date> apptime;
    public static volatile SingularAttribute<Appointment, String> appointmentid;
    public static volatile SingularAttribute<Appointment, Patient> patient;
    public static volatile SingularAttribute<Appointment, Gp> gp;
    public static volatile SingularAttribute<Appointment, Room> room;

}