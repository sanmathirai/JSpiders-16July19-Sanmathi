<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<jsp:useBean id="msg" class="java.lang.String" scope="request"></jsp:useBean>
<body>

	<center>
		<fieldset style="width: 50%;">
			<a href="./home" style="float: left">HOME</a> 
			<a href="./logout" style="float: right">LOGOUT</a>
			<form action="./changepassword" method="post">
				<center>
					<h1>Change password</h1>
				</center>
				<h4 style="color:red"><%=msg %></h4>
				<table align="center" cellspacing="15">


					<tr>
						<td>New password</td>
						<td><input name="npassword" type="password"></td>
					</tr>
					<tr>
						<td>Confirm password</td>
						<td><input name="cpassword" type="password"></td>
					</tr>

					<tr>
						<td align="right"><input type="submit" value="Change"
							style="background-color: green; color: white; width: 90px; height: 30px;"></td>
						<td align="right"><input type="reset" value="Reset"
							style="background-color: green; color: white; width: 90px; height: 30px;"></td>
					</tr>
					

				</table>


			</form>
		</fieldset>
</body>
</html>