package surgery;

import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import surgery.Appointment;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-01-10T19:47:36")
@StaticMetamodel(Room.class)
public class Room_ { 

    public static volatile SingularAttribute<Room, String> roomnumber;
    public static volatile SingularAttribute<Room, Boolean> hasfirstaidkit;
    public static volatile SingularAttribute<Room, String> roomid;
    public static volatile CollectionAttribute<Room, Appointment> appointmentCollection;

}