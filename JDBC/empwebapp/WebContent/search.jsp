<%@page import="com.ustglobal.empwebapp.dto.EmployeeInfo"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   
<%
EmployeeInfo info = (EmployeeInfo)request.getAttribute("info");

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

			<center>
			<fieldset style='width:50%;height:200px'>
			<h1 style='text-align: center'>Employee details</h1>
			<a href = './home' style='float:left'>Home</a>
			<a href = './logout' style='float:right'>Logout</a>
			
			<table align='center' cellspacing='2' border='1'>
			<% if(info!=null) { %>
			<tr>
			<th> ID </th>
			<th>Name</th>
			<th>Email</th>
		
			</tr>
			
			<tr>
			<td> <%= info.getId() %></td>
			<th><%= info.getName()  %> </td>
			<td> <%=info.getEmail()  %> </td>
			</tr>
			
			</table>
			<% }
			else
			{%>
			<h2>Sorry :( No data found</h2>
			<%} %>
			</fieldset>
			</center>
</body>
</html>