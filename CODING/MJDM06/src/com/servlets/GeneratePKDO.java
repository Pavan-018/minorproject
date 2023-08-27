package com.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.DBConnection;


/**
 * Servlet implementation class GeneratePKDO
 */
@WebServlet("/GeneratePKDO")
public class GeneratePKDO extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GeneratePKDO() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter pw=response.getWriter();
		HttpSession session=request.getSession();
		String uid=request.getParameter("email");
		String sk = com.dao.PortNumber.getSk();
		System.out.println("kkkkkkkkk"+uid);
		Connection con=DBConnection.connect();
	try {
		String	sql = "select * from keygen where doid='" + uid + "' ";
			if (DBConnection.getData(sql) == true) {
				pw.println("<script type=\"text/javascript\">");
				pw.println("alert('Already IDs Generated');");
				pw.println("window.location='GeneratePKDO.jsp';</script>");
			}else {
			Statement st=con.createStatement();
			int i=st.executeUpdate("insert into keygen values('"+sk+"','"+uid+"') ");
			 pw.println("<script type=\"text/javascript\">");
			 pw.println("alert('IDs For DO("+uid+") are Generated Successfully');");
			 pw.println("location='GeneratePKDO.jsp';");
			 pw.println("</script>");
			} }catch (SQLException e) {
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
