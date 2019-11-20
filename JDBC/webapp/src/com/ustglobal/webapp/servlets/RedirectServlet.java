package com.ustglobal.webapp.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RedirectServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String search = req.getParameter("search");
		String browser = req.getParameter("s");
		if(browser.equals("google"))
		{

			resp.sendRedirect("https://www.google.com/search?q="+search);
		}
		else if(browser.equals("yahoo"))
		{

			resp.sendRedirect("https://in.search.yahoo.com/?p="+search);
		}
		else
		{

			resp.sendRedirect("https://www.bing.com/search?q="+search);
		}


	}
}
