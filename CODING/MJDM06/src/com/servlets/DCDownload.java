package com.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.DBConnection;


/**
 * Servlet implementation class DCDownload
 */
@WebServlet("/DCDownload")
public class DCDownload extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DCDownload() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	
		PrintWriter o = response.getWriter();
		HttpSession session = request.getSession(false);
		String dcid = (String) session.getAttribute("email");
		String doid = request.getParameter("doid");
		String fid = request.getParameter("fid");
	//	String mkkeys = request.getParameter("mkkeys");
	//	String pkkeys = request.getParameter("pkkeys");
		String pkkeys1 = DBConnection.getkey(dcid);
		String mkkeys1 = DBConnection.getkey1(dcid);
		
		System.out.println("dcid"+dcid);
		System.out.println("sk"+pkkeys1);
		String sql1="select * from dcpks where dcid='"+dcid+"' and sk='"+pkkeys1+"'";
		if (DBConnection.getData(sql1) == true) {
			System.out.println("Outer If :");
			System.out.println("Outer  :"+dcid);
		String sql = "select * from store where fid='" + fid + "' and sessionkey='"
				+ mkkeys1 + "' ";
		if (DBConnection.getData(sql) == true) {
			System.out.println("Inner If :");
			System.out.println("mkkeys1:"+mkkeys1);
			response.sendRedirect("Download?fid=" + fid);
		}
		}else {
						o.println("<script type=\"text/javascript\">");
						o.println("alert('File Keys are Wrong...');");
						o.println("window.location='DCDownload.jsp';</script>");
				}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
			}
}
