package com.dao;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.beans.DCBean;
import com.beans.DOBean;
import com.beans.StoreBean;
import com.beans.UserKeyBean;
import com.dao.DBConnection;
public class DBConnection {

	public static Connection connect() {
		Connection con = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/MJDM06", "root", "root");
			return con;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			return con;
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
			return con;
		}

	}
	// Method for user Registration
	public static boolean getData(String sql) {
		// TODO Auto-generated method stub
		boolean b = false;
		Connection con = connect();
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			b = rs.next();
			rs.close();
			ps.close();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return b;
	}
	public static ResultSet getData1(String sql) {
		// TODO Auto-generated method stub
			Connection con = connect();
			ResultSet rs = null;
			try{
				PreparedStatement ps = con.prepareStatement(sql);
				rs = ps.executeQuery();
			}catch(SQLException e){
				e.printStackTrace();
			}
			return rs;
		}
	 public static ResultSet getServer() throws SQLException
		{
			Connection con =DBConnection.connect();
			String sql="select * from server ";
			Statement s=con.createStatement();
			ResultSet r=s.executeQuery(sql);
			return r;
		}
	 public static String getName(String sql) {
			// TODO Auto-generated method stub
			String name ="";
			Connection con = connect();
			try {
				PreparedStatement ps = con.prepareStatement(sql);
				ResultSet rs = ps.executeQuery();
				if(rs.next()){
					name = rs.getString(1);
				}
				rs.close();
				ps.close();
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return name;

		}
	public static int setDO(String sql, DOBean ub) {
		// TODO Auto-generated method stub
		int i = 0;
		Connection con = connect();
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, ub.getName());
			ps.setString(2, ub.getEmail());
			ps.setString(3, ub.getGender());
			ps.setString(4, ub.getMobile());
			ps.setString(5, ub.getPassword());
			ps.setString(6, "pending");
			i = ps.executeUpdate();
			ps.close();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return i;
	}
	public static int setDC(String sql, DCBean dc) {
		// TODO Auto-generated method stub
		int i = 0;
		Connection con = connect();
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, dc.getName());
			ps.setString(2, dc.getEmail());
			ps.setString(3, dc.getGender());
			ps.setString(4, dc.getMobile());
			ps.setString(5, dc.getPassword());
			ps.setString(6, "pending");
			i = ps.executeUpdate();
			ps.close();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return i;
	}
	public static List<String> getCSName(String sql) {
		// TODO Auto-generated method stub
		List<String> lt = new ArrayList<String>();
		Connection con = connect();
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				lt.add(rs.getString(1));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return lt;
	}
	public static List<String> getUserRequest(String sql) {
		// TODO Auto-generated method stub
		List<String> lt = new ArrayList<String>();
		Connection con = connect();
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				lt.add(rs.getString(1));
				lt.add(rs.getString(2));
				lt.add(rs.getString(3));
				lt.add(rs.getString(4));
				lt.add(rs.getString(7));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return lt;
	}
	public static int update(String sql) {
		// TODO Auto-generated method stub
		int i = 0;
		Connection con = connect();
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			i = ps.executeUpdate();
			ps.close();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return i;
	}
	 public static ResultSet getUserDetails(String sid) throws SQLException
		{
			Connection con =DBConnection.connect();
			String sql="select * from user where cserver='CloudServer1' and status1='Approved'";
			Statement s=con.createStatement();
			ResultSet r=s.executeQuery(sql);
			return r;
		}
	 public static ResultSet getUserDetails2(String sid) throws SQLException
		{
			Connection con =DBConnection.connect();
			String sql="select * from user where cserver='CloudServer2' and status1='Approved'";
			Statement s=con.createStatement();
			ResultSet r=s.executeQuery(sql);
			return r;
		}
	/* public static int store(String sql, StoreBean sb) {
			// TODO Auto-generated method stub
			int i = 0;
			Connection con = connect();
			try {
				PreparedStatement ps = con.prepareStatement(sql);
				ps.setString(1, sb.getId());
				ps.setString(2, sb.getUid());
				ps.setString(3, sb.getName());
				InputStream photo = sb.getPhoto();
				if(photo != null){
					ps.setBinaryStream(4, photo);
				}
				ps.setString(5, sb.getCserver());
				ps.setString(6, sb.getDa());
				ps.setString(7, sb.getContent());
				ps.setDouble(8, sb.getSize());
				i = ps.executeUpdate();
			}catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return i;
		}*/
	 public static ResultSet getUserDataDetails(String sid) throws SQLException
		{
			Connection con =DBConnection.connect();
			String sql="select * from store where cserver='CloudServer1'";
			Statement s=con.createStatement();
			ResultSet r=s.executeQuery(sql);
			return r;
		}
	 public static ResultSet getSetup1(String uid) throws SQLException
	 {
	 	Connection con =DBConnection.connect();
	 	String sql="select * from user where email='"+uid+"' and cserver='CloudServer1'";
	 	Statement s=con.createStatement();
	 	ResultSet r=s.executeQuery(sql);
	 	return r;
	 }
	 public static ResultSet getSendPK(String uid) throws SQLException
	 {
	 	Connection con =DBConnection.connect();
	 	String sql="select * from privatekeys where email='"+uid+"' and cserver='CloudServer1'";
	 	Statement s=con.createStatement();
	 	ResultSet r=s.executeQuery(sql);
	 	return r;
	 }
	 public static List<String> getCServer(String sql) {
			// TODO Auto-generated method stub
			List<String> lt = new ArrayList<String>();
			Connection con = connect();
			try {
				PreparedStatement ps = con.prepareStatement(sql);
				ResultSet rs = ps.executeQuery();
				while(rs.next()){
					lt.add(rs.getString(1));
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return lt;
		}
	 public static String getkey(String uid)
	 {
	 String key="";
	 	Connection con =DBConnection.connect();
	 	String sql="select sk from dcpks where dcid='"+uid+"' ";
	 	Statement s;
	 try {
	 	s = con.createStatement();
	 	ResultSet r=s.executeQuery(sql);
	 	r.next();
	 	key=r.getString(1);
	 	r.close();
	 } catch (SQLException e) {
	 	// TODO Auto-generated catch block
	 	e.printStackTrace();
	 }finally{
	 	try {
	 		con.close();
	 	} catch (SQLException e) {
	 		// TODO Auto-generated catch block
	 		e.printStackTrace();
	 	}
	 }
	 	return key;
	 }
	 public static String getkey1(String uid)
	 {
	 String key="";
	 	Connection con =DBConnection.connect();
	 	String sql="select keys1 from ukeys where uid='"+uid+"' ";
	 	Statement s;
	 try {
	 	s = con.createStatement();
	 	ResultSet r=s.executeQuery(sql);
	 	r.next();
	 	key=r.getString(1);
	 	r.close();
	 } catch (SQLException e) {
	 	// TODO Auto-generated catch block
	 	e.printStackTrace();
	 }finally{
	 	try {
	 		con.close();
	 	} catch (SQLException e) {
	 		// TODO Auto-generated catch block
	 		e.printStackTrace();
	 	}
	 }
	 	return key;
	 }
	 public static List<String> getFile(String sql) {
			// TODO Auto-generated method stub
			List<String> lt = new ArrayList<String>();
			Connection con = connect();
			try {
				PreparedStatement ps = con.prepareStatement(sql);
				ResultSet rs = ps.executeQuery();
				while(rs.next()){
					lt.add(rs.getString(2));
					lt.add(rs.getString(3));
					lt.add(rs.getString(5));
					lt.add(rs.getString(6));
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return lt;
		}
	 public static ResultSet getUserPKDetails( ) throws SQLException
		{
			Connection con =DBConnection.connect();
			String sql="select * from sharepk ";
			Statement s=con.createStatement();
			ResultSet r=s.executeQuery(sql);
			return r;
		}
	 public static ResultSet getUserDataDetails2(String sid) throws SQLException
		{
			Connection con =DBConnection.connect();
			String sql="select * from recovery where cserver='CloudServer2'";
			Statement s=con.createStatement();
			ResultSet r=s.executeQuery(sql);
			return r;
		}
	 public static ResultSet getAuthenticationRequest(String uid) throws SQLException
		{
			Connection con =DBConnection.connect();
			String sql="select * from sharepk where email='"+uid+"'";
			Statement s=con.createStatement();
			ResultSet r=s.executeQuery(sql);
			return r;
		}
	 public static String getRID1(String sid)
	 {
	 String key="";
	 	Connection con =DBConnection.connect();
	 	String sql="select rid from sharepk where tocserver2='"+sid+"'";
	 	Statement s;
	 try {
	 	s = con.createStatement();
	 	ResultSet r=s.executeQuery(sql);
	 	r.next();
	 	key=r.getString(1);
	 	r.close();
	 } catch (SQLException e) {
	 	// TODO Auto-generated catch block
	 	e.printStackTrace();
	 }finally{
	 	try {
	 		con.close();
	 	} catch (SQLException e) {
	 		// TODO Auto-generated catch block
	 		e.printStackTrace();
	 	}
	 }
	 	return key;
	 }
	 public static List<String> getRID(String sql) {
			// TODO Auto-generated method stub
			List<String> lt = new ArrayList<String>();
			Connection con = connect();
			try {
				PreparedStatement ps = con.prepareStatement(sql);
				ResultSet rs = ps.executeQuery();
				while(rs.next()){
					lt.add(rs.getString(1));
				//	lt.add(rs.getString(2));
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return lt;
		}
	 public static List<String> getOName(String sql) {
			// TODO Auto-generated method stub
			List<String> lt = new ArrayList<String>();
			Connection con = connect();
			try {
				PreparedStatement ps = con.prepareStatement(sql);
				ResultSet rs = ps.executeQuery();
				while(rs.next()){
					lt.add(rs.getString(1));
					//lt.add(rs.getString(2));
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return lt;
		}
	 public static String getOName1(String uid)
	 {
	 String key="";
	 	Connection con =DBConnection.connect();
	 	String sql="select name from user where email='"+uid+"'";
	 	Statement s;
	 try {
	 	s = con.createStatement();
	 	ResultSet r=s.executeQuery(sql);
	 	r.next();
	 	key=r.getString(1);
	 	r.close();
	 } catch (SQLException e) {
	 	// TODO Auto-generated catch block
	 	e.printStackTrace();
	 }finally{
	 	try {
	 		con.close();
	 	} catch (SQLException e) {
	 		// TODO Auto-generated catch block
	 		e.printStackTrace();
	 	}
	 }
	 	return key;
	 }
	 public static ResultSet getVerifyRequest(String sid) throws SQLException
		{
			Connection con =DBConnection.connect();
			String sql="select * from verify where tocserver1='CloudServer1' and status1='Pending'";
			Statement s=con.createStatement();
			ResultSet r=s.executeQuery(sql);
			return r;
		}
	 public static List<String> getRecoverFile(String sql) {
			// TODO Auto-generated method stub
			List<String> lt = new ArrayList<String>();
			Connection con = connect();
			try {
				PreparedStatement ps = con.prepareStatement(sql);
				ResultSet rs = ps.executeQuery();
				while(rs.next()){
					lt.add(rs.getString(1));
					lt.add(rs.getString(2));
					lt.add(rs.getString(3));
				//	lt.add(rs.getString(4));
					lt.add(rs.getString(5));
					lt.add(rs.getString(6));
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return lt;
		}
	
	 public static ResultSet getUsersPK() throws SQLException
		{
			Connection con =DBConnection.connect();
			String sql="select * from privatekeys ";
			Statement s=con.createStatement();
			ResultSet r=s.executeQuery(sql);
			return r;
		}
	 public static List<String> getViewFile(String sql) {
			// TODO Auto-generated method stub
			List<String> lt = new ArrayList<String>();
			Connection con = connect();
			try {
				PreparedStatement ps = con.prepareStatement(sql);
				ResultSet rs = ps.executeQuery();
				while(rs.next()){
					lt.add(rs.getString(2));
					lt.add(rs.getString(3));
					lt.add(rs.getString(5));
					lt.add(rs.getString(6));
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return lt;
		}
	 public static ResultSet getUserD( String uid) throws SQLException
		{
			Connection con =DBConnection.connect();
			String sql="select * from user where email='"+uid+"' and cserver='CloudServer2' and status1='Approved' ";
			Statement s=con.createStatement();
			ResultSet r=s.executeQuery(sql);
			return r;
		}
	 public static ResultSet getUserRecoveryReq( ) throws SQLException
		{
			Connection con =DBConnection.connect();
			String sql="select * from recoveryrequest";
			Statement s=con.createStatement();
			ResultSet r=s.executeQuery(sql);
			return r;
		}
	public static int DCRequest(String sql1, DCBean ub) {
		// TODO Auto-generated method stub
			int i = 0;
			Connection con = connect();
			try{
				PreparedStatement ps = con.prepareStatement(sql1);
				ps.setString(1, ub.getName());
				ps.setString(2, ub.getEmail());
				ps.setString(3, ub.getGender());
				ps.setString(4, ub.getMobile());
				ps.setString(5, ub.getPassword());
				ps.setString(6, "Approved");
				
				i = ps.executeUpdate();
			}catch(Exception e){
				e.printStackTrace();
			}
			return i;
		}
	public static int DORequest(String sql1, DOBean ub) {
		// TODO Auto-generated method stub
			int i = 0;
			Connection con = connect();
			try{
				PreparedStatement ps = con.prepareStatement(sql1);
				ps.setString(1, ub.getName());
				ps.setString(2, ub.getEmail());
				ps.setString(3, ub.getGender());
				ps.setString(4, ub.getMobile());
				ps.setString(5, ub.getPassword());
				ps.setString(6, "Approved");
				
				i = ps.executeUpdate();
			}catch(Exception e){
				e.printStackTrace();
			}
			return i;
		}
	public static int Store(String sql, StoreBean u) {
		// TODO Auto-generated method stub
		int i = 0;
		Connection con = connect();
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, u.getUid());
			ps.setString(2, u.getFilename());
			ps.setString(3, u.getKeywords());
			InputStream photo = u.getPhoto();
			if (photo != null) {
				ps.setBinaryStream(4, photo);
			}
			ps.setString(5, u.getEnc());
			ps.setString(6, u.getContent());
			ps.setString(7, u.getSessionkey());
			i = ps.executeUpdate();
			ps.close();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return i;
	}
	public static ResultSet getSetup1() throws SQLException
	{
		Connection con =DBConnection.connect();
		String sql="select * from doregister ";
		Statement s=con.createStatement();
		ResultSet r=s.executeQuery(sql);
		return r;
	}
	public static ResultSet getSetup2() throws SQLException
	{
		Connection con =DBConnection.connect();
		String sql="select * from dcregister ";
		Statement s=con.createStatement();
		ResultSet r=s.executeQuery(sql);
		return r;
	}
	public static ResultSet getAllDCPK() throws SQLException
	{
		Connection con =DBConnection.connect();
		String sql="select * from keygen1 ";
		Statement s=con.createStatement();
		ResultSet r=s.executeQuery(sql);
		return r;
	}
	public static ResultSet getAllDOPK() throws SQLException
	{
		Connection con =DBConnection.connect();
		String sql="select * from keygen ";
		Statement s=con.createStatement();
		ResultSet r=s.executeQuery(sql);
		return r;
	}
	public static List<String> getDOFile(String sql) {
		// TODO Auto-generated method stub
		List<String> lt = new ArrayList<String>();
		Connection con = connect();
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				lt.add(rs.getString(1));
				lt.add(rs.getString(2));
				lt.add(rs.getString(3));
			}
			rs.close();
			ps.close();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return lt;
	}
	public static int sendRKeys(String sql, com.beans.KeyReqBean kb) {
		// TODO Auto-generated method stub
		int i = 0;
		Connection con = connect();
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, kb.getFid());
			ps.setString(2, kb.getOwn());
			ps.setString(3, kb.getEmail());
			ps.setString(4, "pending");
			ps.setString(5, kb.getDa());
			i = ps.executeUpdate();
			ps.close();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return i;
}
	public static List<String> getDOKeys(String sql) {
		// TODO Auto-generated method stub
		List<String> lt = new ArrayList<String>();
		Connection con = connect();
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				lt.add(rs.getString(8));
				
			}
			rs.close();
			ps.close();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return lt;
	}
	public static int sendKeys(String sql,UserKeyBean kb) {
		// TODO Auto-generated method stub
		int i = 0;
		Connection con = connect();
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, kb.getFid());
			ps.setString(3, kb.getUid());
			ps.setString(4, kb.getKey1());
			ps.setString(2, kb.getDoid());
			i = ps.executeUpdate();
			ps.close();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return i;
	}
	public static ResultSet getMyKeys(String uid) throws SQLException
	{
		Connection con =DBConnection.connect();
		String sql="select * from ukeys where uid='"+uid+"'";
		Statement s=con.createStatement();
		ResultSet r=s.executeQuery(sql);
		return r;
	}
	public static ResultSet getMyDecryptFilesKeys(String uid) throws SQLException
	{
		Connection con =DBConnection.connect();
		String sql="select * from store where doid='"+uid+"'";
		Statement s=con.createStatement();
		ResultSet r=s.executeQuery(sql);
		return r;
	}
	public static ResultSet getMyKeys1(String uid) throws SQLException
	{
		Connection con =DBConnection.connect();
		String sql="select * from ukeys where uid='"+uid+"'";
		Statement s=con.createStatement();
		ResultSet r=s.executeQuery(sql);
		return r;
	}
	public static List<String> getKey(String sql) {
		// TODO Auto-generated method stub
		List<String> lt = new ArrayList<String>();
		Connection con = connect();
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				lt.add(rs.getString(1));
			}
			rs.close();
			ps.close();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return lt;
	}
	public static ResultSet getDOFiles(String uid) throws SQLException
	{
		Connection con =DBConnection.connect();
		String sql="select * from store where doid='"+uid+"'";
		Statement s=con.createStatement();
		ResultSet r=s.executeQuery(sql);
		return r;
	}
	 }
