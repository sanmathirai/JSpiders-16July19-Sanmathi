package com.ustglobal.jdbcapp;

import java.sql.*;

import com.mysql.jdbc.Driver;

public class MyFirstJDBC {
	public static void main(String[] args) {

		Connection conn = null;
		Statement stmt = null;
		ResultSet rs  = null;
		try {
			
			//Step 1 :load the driver
			Driver driver = new Driver();
			DriverManager.registerDriver(driver);
			
			//Step 2 get connection
			String url = "jdbc:mysql://localhost:3306/ust_ty_db";
			conn = DriverManager.getConnection(url,"root","1234");
			
			
			stmt = conn.createStatement();
			String sql = "select * from employee_info";
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				int sal = rs.getInt("sal");
				String gender = rs.getString("gender");
				
				System.out.println("Id is :"+id);
				System.out.println("Name is :"+name);
				System.out.println("Salary  is :"+sal);
				System.out.println("gender is :"+gender);
				System.out.println("********************");


			}
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		finally {
			try {
				if(conn!=null)
				{
					conn.close();
				}
				if(stmt!=null)
				{
					stmt.close();
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
}//end of MyFirstJdbc
