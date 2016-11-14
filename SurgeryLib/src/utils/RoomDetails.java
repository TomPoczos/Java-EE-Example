/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

/**
 *
 * @author Tom Poczos
 */
public class RoomDetails implements java.io.Serializable {

    private String roomid;
    private String roomnumber;
    private Boolean hasfirstaidkit;

    public RoomDetails(String roomid, String roomnumber, Boolean hasfirstaidkit) {
        this.roomid = roomid;
        this.roomnumber = roomnumber;
        this.hasfirstaidkit = hasfirstaidkit;
    }

    public String getRoomid() {
        return roomid;
    }

    public String getRoomnumber() {
        return roomnumber;
    }

    public Boolean getHasfirstaidkit() {
        return hasfirstaidkit;
    }

    public void setRoomid(String roomid) {
        this.roomid = roomid;
    }

    public void setRoomnumber(String roomnumber) {
        this.roomnumber = roomnumber;
    }

    public void setHasfirstaidkit(Boolean hasfirstaidkit) {
        this.hasfirstaidkit = hasfirstaidkit;
    }

    @Override
    public String toString() {
        
        String hasKit = this.hasfirstaidkit ? "yes" : "no";
        
        return "Room\t" + "ID: " + roomid + "\tRoom Number: " + roomnumber + "\thas firstaid Kit: " + hasKit;
    }
    
    
}
