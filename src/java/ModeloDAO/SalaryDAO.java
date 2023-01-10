package ModeloDAO;

import Config.ConDatabase;
import Intefaces.SalaryCRUD;
import Models.Salary;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class SalaryDAO implements SalaryCRUD{
    
    ConDatabase cn=new ConDatabase();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    Salary staff=new Salary();

    @Override
    public List list_array() {
        
        // Create Array List with type of Event
        ArrayList<Salary>list=new ArrayList<>();
        
        String sql="select * from salaries";
        
        try{
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            
            while(rs.next()){
                Salary st=new Salary();
                st.setSalaryId(rs.getInt("salary_id"));
                st.setMemberCode(rs.getString("member_code"));
                st.setSalary(rs.getInt("salary"));

                list.add(st);
            }
        }catch(Exception e){
            
        }
        
        return list;
    }

    @Override
    public Salary list(int id) {
        String sql="select * from salaries where salary_id="+id;
        
        try {
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            
            while(rs.next()){                
                staff.setSalaryId(rs.getInt("salary_id"));
                staff.setMemberCode(rs.getString("member_code"));
                staff.setSalary(rs.getInt("salary"));
               
            }
        } catch (Exception e) {
        }
        return staff;
    }

    @Override
    public boolean add(Salary st) {
        String sql = "INSERT INTO salaries(member_code, salary) VALUES ('"+st.getMemberCode()+"','"+st.getSalary()+"')";
        try {
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {
        }
       return false;
    }

    @Override
    public boolean edit(Salary st) {
        String sql="update salaries set member_code='"+st.getMemberCode()+"',salary='"+st.getSalary()+"'where salary_id="+st.getSalaryId();
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
        String sql="delete from salaries where salary_id="+id;
        try {
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {
        }
        return false;
    }

}
