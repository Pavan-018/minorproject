package com.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.beans.DCBean;
import com.dao.DBConnection;

/**
 * Servlet implementation class DCRequest
 */
@WebServlet("/DCRequest")
public class DCRequest extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DCRequest() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		/*PrintWriter o=response.getWriter();
		String name = request.getParameter("name");
		String sql = "select * from dcregister where email='" + name + "'";
		ResultSet rs = DBConnection.getData1(sql);
		String sql1 = "insert into dcregister values(?,?,?,?,?,?) ";
		DCBean ub = new DCBean();
		try {
			while (rs.next()) {
				ub.setName(rs.getString(1));
				ub.setEmail(rs.getString(2));
				ub.setGender(rs.getString(3));
				ub.setMobile(rs.getString(4));
				ub.setPassword(rs.getString(5));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		int i = DBConnection.DCRequest(sql1, ub);
		if (i == 1) {
			
			o.println("Cloud Controller Authenticate the DC Request");
			sql = "update dcregister set status1='Approved' where email='" + name + "'";
			int k = DBConnection.update(sql);
			if (k == 1)
				response.sendRedirect("DCRequest.jsp?name=Member");
		} else {
			response.sendRedirect("RegisterError.jsp");
		}*/
		
		
		PrintWriter o = response.getWriter();
		String email=request.getParameter("email");
		Connection con=DBConnection.connect();
		try {
			Statement st=con.createStatement();
			int i=st.executeUpdate("update dcregister set status1='Approved' where email='"+email+"'");
			response.sendRedirect("DCRequest.jsp");
		} catch (SQLException e) {
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
