package com.servlets;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import com.beans.StoreBean;
import com.dao.DBConnection;
import com.dao.PortNumber;
import com.dao.Test;

/**
 * Servlet implementation class Store
 */
@MultipartConfig(maxFileSize = 16177215)
@WebServlet("/Store")
public class Store extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Store() {
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
		PrintWriter pw=response.getWriter();
		HttpSession session=request.getSession();
		String uid=(String)session.getAttribute("email");
		String filename=request.getParameter("filename");
		String keywords=request.getParameter("keywords");
		Part img = request.getPart("message");
		InputStream photo = null, photo1 = null;
		if(img != null){
			photo = img.getInputStream();
			photo1 = img.getInputStream();
		}
		String content = img.getContentType();
		String key = PortNumber.getKeys();
		String text = "";
		int j = 0;
		while((j=photo.read())!=-1) {
			text = text + (char) j;
		}
		String enc = Test.encryption(text, key);
		System.out.println(enc);
		
		StoreBean u = new StoreBean();
		u.setUid(uid);
		u.setFilename(filename);
		u.setKeywords(keywords);
		u.setPhoto1(photo1);
		u.setEnc(enc);
		u.setContent(content);
		u.setSessionkey(key);
		String sql = "insert into store values(0,?,?,?,?,?,?,?)";
		int i = DBConnection.Store(sql, u);
		if(i > 0){
			pw.println("<script type=\"text/javascript\">");
			pw.println("alert('Message Encrypted & Stored Sucessfully...');");
			pw.println("window.location='Store.jsp';</script>");
		}else{
			pw.println("<script type=\"text/javascript\">");
			pw.println("alert('Message not Encrypted & Stored');");
			pw.println("window.location='Store.jsp';</script>");
		}
	}
	}
