package com.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.DBConnection;

/**
 * Servlet implementation class DOLogin
 */
@WebServlet("/DOLogin")
public class DOLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DOLogin() {
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
		PrintWriter pw = response.getWriter();
		String uid = request.getParameter("email");
		String pwd = request.getParameter("password");
		String sql = "select * from doregister where email='"+uid+"' and password='"+pwd+"'and status1='Approved'";
		boolean b = DBConnection.getData(sql);
		HttpSession session = request.getSession();
		if(b == true){
			session.setAttribute("email", uid);
			sql = "select name from doregister where email='"+uid+"'";
			String name = DBConnection.getName(sql);
			session.setAttribute("name", name);
			response.sendRedirect("DOHome.jsp");
		}else{
			pw.println("<script type=\"text/javascript\">");
			pw.println("alert('Please enter valid Details');");
			pw.println("window.location='DOLogin.jsp';</script>");
		}
	}

}
