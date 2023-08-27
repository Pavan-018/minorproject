package com.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.beans.ParameterBean;
import com.dao.DBConnection;

/**
 * Servlet implementation class AddParameter
 */
@WebServlet("/AddParameter")
public class AddParameter extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddParameter() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter pw=response.getWriter();
		HttpSession session =request.getSession();
		String fid=request.getParameter("fid");
		String doid=request.getParameter("doid");
		String filename=request.getParameter("filename");
		String parameters=request.getParameter("parameters");
		
		ParameterBean ab=new ParameterBean();
	//	System.out.println(uid);
		Connection con=DBConnection.connect();
		try {
			String	sql = "select * from parameters where doid='" + doid + "' ";
			if (com.dao.DBConnection.getData(sql) == true) {
				pw.println("<script type=\"text/javascript\">");
				pw.println("alert('Already Parameter Added');");
				pw.println("window.location='GeneratePKDC.jsp';</script>");
			}else {
			Statement st=con.createStatement();
			int i=st.executeUpdate("insert into parameters values('"+fid+"','"+doid+"','"+filename+"','"+parameters+"') ");
			
			 pw.println("<script type=\"text/javascript\">");
			 pw.println("alert('Parameter Added Successfully ...');");
			 pw.println("location='AddParameter.jsp';");
			 pw.println("</script>");
		} 
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
