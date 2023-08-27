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

import com.dao.DBConnection;


/**
 * Servlet implementation class SendPKToDC
 */
@WebServlet("/SendPKToDC")
public class SendPKToDC extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SendPKToDC() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter pw=response.getWriter();
		String sk=request.getParameter("sk");
		String dcid=request.getParameter("dcid");
		Connection con=DBConnection.connect();
		try {
			String	sql = "select * from DCpks where dcid='" + dcid + "' ";
			if (com.dao.DBConnection.getData(sql) == true) {
				pw.println("<script type=\"text/javascript\">");
				pw.println("alert('Already SK Keys Sent');");
				pw.println("window.location='ViewAllDCPK.jsp';</script>");
			}else {
			Statement st=con.createStatement();
			int i=st.executeUpdate("insert into DCpks values(0,'"+sk+"','"+dcid+"','Sent')");
			 pw.println("<script type=\"text/javascript\">");
			 pw.println("alert('SK Sent Successfully...');");
			// pw.println("location='Request.jsp';");
			 pw.println("location='ViewAllDCPK.jsp';");
			 pw.println("</script>");
		} 
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			 pw.println("<script type=\"text/javascript\">");
			 pw.println("alert('SK Already Sent ...');");
			 pw.println("location='ViewAllDCPK.jsp';");
			 pw.println("</script>");
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
