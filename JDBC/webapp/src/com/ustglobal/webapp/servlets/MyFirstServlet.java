package com.ustglobal.webapp.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MyFirstServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		ServletContext context= getServletContext();
		String companyName = context.getInitParameter("company-name");
		
		ServletConfig config = getServletConfig();
		String batchName  = config.getInitParameter("batch-name");
		
		PrintWriter out = resp.getWriter();
		resp.setContentType("text/html");


		
		out.println("<html>");
		out.println("<body>");

		Date date = new Date();
		out.println("<h1 style='color:red'> Date and time is:");
		out.println(date.toString());
        

		String url = req.getRequestURI();
		String method = req.getMethod();
		System.out.println("<br>");

		out.println(url);
         
		System.out.println("<br>");
		out.println(method);
		out.println("</h1>");
		out.println("<h1>");
		out.println(companyName);
		out.println("</h1>");
		out.println("<h1>");
		out.println(batchName);
		out.println("</h1>");
		Object obj =req.getAttribute("obj");
		
		out.println(obj);
		out.println("</body>");
		out.println("</html>");




	}
}
