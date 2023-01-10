package Models;

import java.sql.Date;

public class Stattendance {
    
    // Define VAriables  
    int member_id;
    Date date;
    String attendance;

    public Stattendance() {
    }

    public Stattendance(Date date, String attendance) {
        this.date = date;
        this.attendance = attendance;
    }

    public int getMemberId() {
        return member_id;
    }

    public void setMemberId(int member_id) {
        this.member_id = member_id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getAttendance() {
        return attendance;
    }

    public void setAttendance(String attendance) {
        this.attendance = attendance;
    }

    
    
}
