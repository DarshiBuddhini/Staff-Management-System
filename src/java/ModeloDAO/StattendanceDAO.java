package ModeloDAO;

import Config.ConDatabase;
import Intefaces.StattendanceCRUD;
import Models.Stattendance;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class StattendanceDAO implements StattendanceCRUD{
    
    ConDatabase cn=new ConDatabase();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    Stattendance stattendance=new Stattendance();

    @Override
    public List list_array() {
        
        // Create Array List with type of Event
        ArrayList<Stattendance>list=new ArrayList<>();
        
        String sql="select * from staff_attendance";
        
        try{
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            
            while(rs.next()){
                Stattendance sa=new Stattendance();
                sa.setMemberId(rs.getInt("member_id"));
                sa.setDate(Date.valueOf(rs.getString("date")));
                sa.setAttendance(rs.getString("attendance"));
                
                
                list.add(sa);
            }
        }catch(Exception e){
            
        }
        
        return list;
    }

    @Override
    public Stattendance list(int id) {
        String sql="select * from staff_attendance where member_id="+id;
        
        try {
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            
            while(rs.next()){                
                stattendance.setMemberId(rs.getInt("member_id"));
                stattendance.setDate(Date.valueOf(rs.getString("date")));
                stattendance.setAttendance(rs.getString("attendance"));
               
            }
        } catch (Exception e) {
        }
        return stattendance;
    }

    @Override
    public boolean add(Stattendance sa) {
        String sql = "INSERT INTO staff_attendance(member_id,date, attendance) VALUES ('"+sa.getMemberId()+"','"+sa.getDate()+"','"+sa.getAttendance()+"')";
        try {
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {
        }
       return false;
    }

    @Override
    public boolean edit(Stattendance sa) {
        String sql="update staff_attendance set date='"+sa.getDate()+"',attendance='"+sa.getAttendance()+"'where student_id="+sa.getMemberId();
        try {
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {
        }
        return false;
    }

    @Override
    public boolean delete(int id) {
        String sql="delete from staff_attendance where member_id="+id;
        try {
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {
        }
        return false;
    }

}
