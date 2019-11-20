package com.ustglobal.jdbcapp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/*import com.mysql.jdbc.Driver;*/

public class DynamicDeleteQuery {
	public static void main(String[] args) {
		String url = "jdbc:mysql://localhost:3306/ust_ty_db?user=root&password=1234";
		//dynamic query

		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			Class.forName("com.mysql.jdbc.Driver");
			/*
			 * Driver driver = new Driver(); DriverManager.deregisterDriver(driver);
			 */

			
			conn = DriverManager.getConnection(url);

			String sql = "delete from employee_info where id=?";
			pstmt = conn.prepareStatement(sql);

			
			
			pstmt.setInt(1, Integer.parseInt(args[0]));

			int count = pstmt.executeUpdate();
			System.out.println(count);

		}	catch(Exception e)
		{
			e.printStackTrace();
		}
		finally {
			try {
				if(conn!=null)
				{
					conn.close();
				}
				if(pstmt!=null)
				{
					pstmt.close();
				}

			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
