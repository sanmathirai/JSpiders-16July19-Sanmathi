package com.ustglobal.jdbcapp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Driver;

public class DynamicSelectQuery {
	public static void main(String[] args) {
		
		String url = "jdbc:mysql://localhost:3306/ust_ty_db?user=root&password=1234";
		//dynamic query
		String sql = "select * from employee_info where id=?";
		
		Connection conn = null;
		PreparedStatement pstmp = null;
		ResultSet rs = null;
		
		
		try {
			Driver driver = new Driver();
			DriverManager.deregisterDriver(driver);
			
			conn = DriverManager.getConnection(url);
			
			pstmp = conn.prepareStatement(sql);
			String empid = args[0];
			int id = Integer.parseInt(empid);
			
			pstmp.setInt(1, id);
			
			rs = pstmp.executeQuery();
			
				if(rs.next()) {
					int id1 = rs.getInt("id");
					String name = rs.getString("name");
					int sal = rs.getInt("sal");
					String gender = rs.getString("gender");
					
					System.out.println("<h1>"+id1+"<h1>");
					
			}
			
		}	catch(SQLException e)
		{
			e.printStackTrace();
		}
		finally {
			try {
				if(conn!=null)
				{
					conn.close();
				}
				if(pstmp!=null)
				{
					pstmp.close();
				}
				if(rs!=null)
				{
					rs.close();
				}
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
	}//end of main
}//end of DynamicSelectQuery
