package com.ustglobal.phonesimulator.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.ustglobal.phonesimulator.dto.PhoneBean;

public class PhoneDaoImplementation implements PhoneDao{

	private static final  String URL = "jdbc:mysql://localhost:3306/contactfile?user=root&password=1234";
	private static final String Driver_NAME = "com.mysql.jdbc.Driver";
	private static final String SELECT_SQL = "select * from contact";
	private static final String SELECT_NAME_SQL = "select * from contact where name =?";
	private static final String ADD_SQL = "insert into contact values (?,?,?)";
	private static final String EDIT_SQL = "update contact  set number =?,group_name=? where name=?";
	private static final String DELETE_SQL = "delete from contact where name=?";

	/****************** Show all contact *******************/
	@Override
	public List<PhoneBean> showAllContacts() {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			Class.forName(Driver_NAME);
			conn = DriverManager.getConnection(URL);
			stmt = conn.createStatement();
			rs = stmt.executeQuery(SELECT_SQL);
			List<PhoneBean> contacts = new ArrayList<PhoneBean>();
			while(rs.next()) {
				PhoneBean bean =  new PhoneBean();
				bean.setName(rs.getString("name"));
				bean.setNumber(rs.getLong("number"));
				bean.setGroup(rs.getString("group_name"));
				contacts.add(bean);

			}
			return contacts;

		}catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
				if(conn!=null) {
					conn.close();
				}
				if(stmt!=null) {
					stmt.close();
				}
				if(rs!=null) {
					rs.close();
				}
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
		return null;
	}
	/********************* Search Contact ***************/
	@Override
	public PhoneBean searchContact(String name) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			Class.forName(Driver_NAME);
			conn = DriverManager.getConnection(URL);
			pstmt = conn.prepareStatement(SELECT_NAME_SQL);
			pstmt.setString(1, name);
			rs = pstmt.executeQuery();
			PhoneBean bean1 =  new PhoneBean();
			if(rs.next()) {

				bean1.setName(rs.getString("name"));
				bean1.setNumber(rs.getLong("number"));
				bean1.setGroup(rs.getString("group_name"));


			}
			return bean1;

		}catch (Exception e) {
			e.printStackTrace();
		}	finally {
			try {
				if(conn!=null) {
					conn.close();
				}
				if(pstmt!=null) {
					pstmt.close();
				}
				if(rs!=null) {
					rs.close();
				}
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
		return null;
	}

	@Override
	public int addContact(PhoneBean bean) {
		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			Class.forName(Driver_NAME);
			conn = DriverManager.getConnection(URL);
			pstmt = conn.prepareStatement(ADD_SQL);

			pstmt.setString(1, bean.getName());
			pstmt.setLong(2, bean.getNumber());
			pstmt.setString(3, bean.getGroup());

			int result = pstmt.executeUpdate();

			return result;

		}catch (Exception e) {
			e.printStackTrace();
		}	finally {
			try {
				if(conn!=null) {
					conn.close();
				}
				if(pstmt!=null) {
					pstmt.close();
				}
				
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
		return 0;
	}

	@Override
	public int deleteContact(PhoneBean bean) {
		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			Class.forName(Driver_NAME);
			conn = DriverManager.getConnection(URL);
			pstmt = conn.prepareStatement(DELETE_SQL);
			pstmt.setString(1, bean.getName());

			int result = pstmt.executeUpdate();

			return result;

		}catch (Exception e) {
			e.printStackTrace();
		}	finally {
			try {
				if(conn!=null) {
					conn.close();
				}
				if(pstmt!=null) {
					pstmt.close();
				}
				
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
		return 0;
	}
	/**************EDIT*************/
	@Override
	public int editContact(PhoneBean bean) {
		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			Class.forName(Driver_NAME);
			conn = DriverManager.getConnection(URL);
			pstmt = conn.prepareStatement(EDIT_SQL);
			pstmt.setString(3, bean.getName());
			pstmt.setLong(1, bean.getNumber());
			pstmt.setString(2, bean.getGroup());
			int result = pstmt.executeUpdate();

			return result;

		}catch (Exception e) {
			e.printStackTrace();
		}	finally {
			try {
				if(conn!=null) {
					conn.close();
				}
				if(pstmt!=null) {
					pstmt.close();
				}
				
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
		return 0;
	}

}
