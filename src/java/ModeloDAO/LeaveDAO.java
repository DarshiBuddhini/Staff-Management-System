package ModeloDAO;

import Config.ConDatabase;
import Intefaces.LeaveCRUD;
import Models.Leave;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class LeaveDAO implements LeaveCRUD{
    
    ConDatabase cn=new ConDatabase();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    Leave leave=new Leave();

    @Override
    public List list_array() {
        
        // Create Array List with type of Event
        ArrayList<Leave>list=new ArrayList<>();
        
        String sql="select * from leaves";
        
        try{
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            
            while(rs.next()){
                Leave st=new Leave();
                st.setLeaveId(rs.getInt("leave_id"));
                st.setMemberId(rs.getInt("member_id"));
                st.setDate(rs.getDate("date"));

                list.add(st);
            }
        }catch(Exception e){
            
        }
        
        return list;
    }

    @Override
    public Leave list(int id) {
        String sql="select * from staff where member_id="+id;
        
        try {
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            
            while(rs.next()){                
                leave.setLeaveId(rs.getInt("leave_id"));
                leave.setMemberId(rs.getInt("member_id"));
                leave.setDate(rs.getDate("date"));
               
            }
        } catch (Exception e) {
        }
        return leave;
    }

    @Override
    public boolean add(Leave st) {
        String sql = "INSERT INTO leaves(member_id, date) VALUES ('"+st.getMemberId()+"','"+st.getDate()+"')";
        try {
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {
        }
       return false;
    }

}
