package com.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.DBConnection;


/**
 * Servlet implementation class KeyReq
 */
@WebServlet("/KeyReq")
public class KeyReq extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public KeyReq() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter o = response.getWriter();
		String fid = request.getParameter("fid");
		HttpSession session = request.getSession(false);
		String email = (String) session.getAttribute("email");
		String sql = "select doid from store where fid='" + fid + "'";
		String own = DBConnection.getName(sql);
		Date d = new Date();
		String da = "" + d;
		sql = "select * from keyreq where fid='" + fid + "' and uid='"
				+ email + "'";
		if (DBConnection.getData(sql) == true) {
			o.println("<script type=\"text/javascript\">");
			o.println("alert('Already Made Request For MK Keys');");
			o.println("window.location='SearchQuery.jsp';</script>");
		} else {
			com.beans.KeyReqBean kb = new com.beans.KeyReqBean();
			kb.setFid(fid);
			kb.setOwn(own);
			kb.setEmail(email);
			kb.setDa(da);
			sql = "insert into keyreq values(?,?,?,?,?)";
			int i = DBConnection.sendRKeys(sql, kb);
			if(i > 0){
				o.println("<script type=\"text/javascript\">");
				o.println("alert('MK Key Request Sent Successfully');");
				o.println("window.location='SearchQuery.jsp';</script>");
			}else{
				o.println("<script type=\"text/javascript\">");
				o.println("alert('MK Keys request not sent');");
				o.println("window.location='SearchQuery.jsp';</script>");
			}
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
