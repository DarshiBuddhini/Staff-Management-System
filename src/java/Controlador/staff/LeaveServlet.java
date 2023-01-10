package Controlador.staff;

import Models.Leave;
import ModeloDAO.LeaveDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "UserLeaveServlet", urlPatterns = {"/UserLeaveServlet"})
public class LeaveServlet extends HttpServlet {
    
    // Get url patterns to variables
    String list="staff/leave/list.jsp";
    String add="staff/leave/add.jsp";
    String edit="staff/leave/edit.jsp";    
    
    Leave st=new Leave();
    LeaveDAO dao=new LeaveDAO();
    int id;
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet StaffServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet StaffServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String url="";
        String action=request.getParameter("action");
        
        if(action.equalsIgnoreCase("list")){
            url=list;            
        }else if(action.equalsIgnoreCase("add")){
            url=add;
        }else if(action.equalsIgnoreCase("addrow")){
            int member_id=Integer.parseInt(request.getParameter("txtMemberId"));
            Date date=Date.valueOf(request.getParameter("txtLeaveDate"));
            
            st.setMemberId(member_id);
            st.setDate(date);
           
            dao.add(st);
            url=list;
        }
        
        RequestDispatcher event=request.getRequestDispatcher(url);
        event.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}