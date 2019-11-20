package com.ustglobal.webapp.servlets.database;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;




public class DisplayEmployeeServelet extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String empId = req.getParameter("empid");

		int id1 = 0;
		String name;
		int sal;
		String gender;

		String url = "jdbc:mysql://localhost:3306/ust_ty_db?user=root&password=1234";
		String sql = "select * from employee_info where id=?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try{
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(url);

			pstmt = conn.prepareStatement(sql);
			int eid = Integer.parseInt(empId);
			pstmt.setInt(1, eid);
			rs = pstmt.executeQuery();
			PrintWriter out = resp.getWriter();
			if(rs.next()) {	 
				id1 = rs.getInt("id");
				name = rs.getString("name");
				sal = rs.getInt("sal");
				gender = rs.getString("gender");

				out.println("<html>");
				out.println("<body>");

				out.println("<table align='center' border='1' > ");
				out.println("<tr><th colspan='4'>EMPLOYEE DETAILS</th></tr>");
				out.println("<tr><th>ID</th><th> Name</th><th>EMP Sal </th><th> Gender</th></tr>");

				out.println("<tr>");
				out.println("<td>"+id1+"</td>");
				out.println("<td>"+name+" </td>");
				out.println("<td>"+sal+" </td>");
				out.println("<td>"+gender+" </td>");
				out.println("</tr>");

				out.println("</table>");
				out.println("</body>");
				out.println("</html>");
			}
			else {
				out.println("<h1>Sorry no data found</h1>");
			}

		}catch(Exception e){
			e.printStackTrace();

		}finally {
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


	}
}
