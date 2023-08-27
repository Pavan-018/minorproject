package com.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.beans.DOBean;
import com.dao.DBConnection;

/**
 * Servlet implementation class DORegister
 */
@WebServlet("/DORegister")
public class DORegister extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DORegister() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter pw= response.getWriter();
		String Name = request.getParameter("name");
		String Email = request.getParameter("email");
		String Gender = request.getParameter("gender");
		String Mobile = request.getParameter("mobile");
		String Password = request.getParameter("password");
		
		DOBean d = new DOBean();
		d.setEmail(Email);
		d.setName(Name);
		d.setGender(Gender);
		d.setMobile(Mobile);
		d.setPassword(Password);
		
		String sql = "insert into doregister values(?,?,?,?,?,?)";
		
		int i = DBConnection.setDO(sql, d);
		if(i>0)
		{
			pw.println("<script type=\"text/javascript\">");
			pw.println("alert('DO Register Details Sent for Authentication');");
			pw.println("window.location='DORegister.jsp';</script>");
				}
		else
		{
			pw.println("<script type=\"text/javascript\">");
			pw.println("alert('Please enter valid Details');");
			pw.println("window.location='DORegister.jsp';</script>");
		}
	}

}
