package ModeloDAO;

import Config.ConDatabase;
import Intefaces.FeedbackCRUD;
import Models.Feedback;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class FeedbackDAO implements FeedbackCRUD{
    
    ConDatabase cn=new ConDatabase();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    Feedback feed=new Feedback();

    @Override
    public List list_array() {
        
        // Create Array List with type of Event
        ArrayList<Feedback>list=new ArrayList<>();
        
        String sql="select * from feedbacks";
        
        try{
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            
            while(rs.next()){
                Feedback st=new Feedback();
                st.setFeedbackId(rs.getInt("feedback_id"));
                st.setMemberCode(rs.getString("member_code"));
                st.setFeedback(rs.getString("feedback"));

                list.add(st);
            }
        }catch(Exception e){
            
        }
        
        return list;
    }

    @Override
    public Feedback list(int id) {
        String sql="select * from feedbacks where feedback_id="+id;
        
        try {
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            
            while(rs.next()){                
                feed.setFeedbackId(rs.getInt("feedback_id"));
                feed.setMemberCode(rs.getString("member_code"));
                feed.setFeedback(rs.getString("feedback"));
               
            }
        } catch (Exception e) {
        }
        return feed;
    }

    @Override
    public boolean add(Feedback st) {
        String sql = "INSERT INTO feedbacks(member_code, feedback) VALUES ('"+st.getMemberCode()+"','"+st.getFeedback()+"')";
        try {
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {
        }
       return false;
    }

    @Override
    public boolean edit(Feedback st) {
        String sql="update feedbacks set member_code='"+st.getMemberCode()+"',feedback='"+st.getFeedback()+"'where feedback_id="+st.getFeedbackId();
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
        String sql="delete from feedbacks where feedback_id="+id;
        try {
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {
        }
        return false;
    }

}
