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

/**
 * Servlet implementation class GeneratePKDC
 */
@WebServlet("/GeneratePKDC")
public class GeneratePKDC extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GeneratePKDC() {
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
		Connection con=com.dao.DBConnection.connect();
	try {
		String	sql = "select * from keygen1 where dcid='" + uid + "' ";
			if (com.dao.DBConnection.getData(sql) == true) {
				pw.println("<script type=\"text/javascript\">");
				pw.println("alert('Already IDs Generated');");
				pw.println("window.location='GeneratePKDC.jsp';</script>");
			}else {
			Statement st=con.createStatement();
			int i=st.executeUpdate("insert into keygen1 values('"+sk+"','"+uid+"') ");
			 pw.println("<script type=\"text/javascript\">");
			 pw.println("alert('IDs Keys For DC("+uid+") are Generated Successfully');");
			 pw.println("location='GeneratePKDC.jsp';");
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
