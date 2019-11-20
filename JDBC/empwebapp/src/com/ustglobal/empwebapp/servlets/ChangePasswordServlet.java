package com.ustglobal.empwebapp.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ustglobal.empwebapp.dao.EmployeeDAO;
import com.ustglobal.empwebapp.dto.EmployeeInfo;
import com.ustglobal.empwebapp.util.EmployeeDAOManger;

@WebServlet("/changepassword")
public class ChangePasswordServlet extends HttpServlet{
@Override
protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	HttpSession session  = req.getSession(false);
	if(session!=null) {
		String pass = req.getParameter("npassword");
		String confirmPass = req.getParameter("cpassword");
		
		
		if(pass.equals(confirmPass)) {
			EmployeeInfo info = (EmployeeInfo)session.getAttribute("info");
			EmployeeDAO dao = EmployeeDAOManger.getEmployeeDAO();
			dao.changePassword(info.getId(), pass);
			
			RequestDispatcher dispatcher = req.getRequestDispatcher("/home");
			dispatcher.forward(req, resp);
		}else {
			String msg = "password not matching";
			req.setAttribute("msg",msg);
		
			RequestDispatcher dispatcher = req.getRequestDispatcher("/changepassword.jsp");
			dispatcher.include(req, resp);
		}
		
	}
	else {
		RequestDispatcher dispatcher = req.getRequestDispatcher("/login.jsp");
		dispatcher.forward(req, resp);
	}
}
}
