package Controlador.admin;

import Models.Stattendance;
import ModeloDAO.StattendanceDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "StattendanceServlet", urlPatterns = {"/StattendanceServlet"})
public class StattendanceServlet extends HttpServlet {
    
    // Get url patterns to variables
    String list="admin/stattendance/list.jsp";
    String add="admin/stattendance/add.jsp";
    String edit="admin/stattendance/edit.jsp";    
    
    Stattendance sa=new Stattendance();
    StattendanceDAO dao=new StattendanceDAO();
    int id;
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet StattendanceServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet StattendanceServlet at " + request.getContextPath() + "</h1>");
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
            Date date=Date.valueOf(request.getParameter("txtStdate"));
            String attendance=request.getParameter("txtAttendance");
            
            sa.setMemberId(member_id);
            sa.setDate(date);
            sa.setAttendance(attendance);
           
            dao.add(sa);
            url=list;
        }else if(action.equalsIgnoreCase("edit")){
            request.setAttribute("stAttendanceId",request.getParameter("id"));
            url=edit;
        }else if(action.equalsIgnoreCase("editrow")){
            id=Integer.parseInt(request.getParameter("txtStudentId"));
            Date date=Date.valueOf(request.getParameter("txtStdate"));
            String attendance=request.getParameter("txtAttendance");
            
            sa.setMemberId(id);
            sa.setDate(date);
            sa.setAttendance(attendance);
            dao.edit(sa);
            url=list;
        }else if(action.equalsIgnoreCase("delete")){
            id=Integer.parseInt(request.getParameter("id"));
            sa.setMemberId(id);
            dao.delete(id);
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