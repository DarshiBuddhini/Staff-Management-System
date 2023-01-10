package Models;

import java.sql.Date;

public class Leave {
    
    // Define VAriables  
    int leave_id;
    int member_id;
    Date date;

    public Leave() {
    }

    public Leave(int member_id, Date date) {
        this.member_id = member_id;
        this.date = date;
    }

    public int getLeaveId() {
        return leave_id;
    }

    public void setLeaveId(int leave_id) {
        this.leave_id = leave_id;
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

    
}
