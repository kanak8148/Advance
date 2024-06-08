<%@page import="com.rays.bean.UserBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%@ include file="Header.jsp"%>
	<%
		String fname = (String) request.getAttribute("fname");
		String succ = (String) request.getAttribute("succ");
		String error = (String) request.getAttribute("error");
		UserBean bean = (UserBean) request.getAttribute("bean");
	%>
	<br>
	<br>
	<center>
		<%
			if (succ != null) {
		%>
		<%=succ%>
		<%
			}
		%>
		<%
			if (error != null) {
		%>
		<%=error%>
		<%
			}
		%>

		<form action="UserRegistrationCtl" method="post">
			<tr>
				<td><input type="hidden" name="id"
					value="<%=(bean != null) ? bean.getId() : ""%>"></td>
			</tr>
			<table>
				<tr>
					<th>First Name:</th>
					<td><input type="text" name="firstName"
						value="<%=(bean != null) ? bean.getFirstName() : ""%>"></td>
					<td>
						<%
							if (fname != null) {
						%> <font color="red"><%=fname%></font> <%
 	}
 %>
					</td>
				</tr>
				<tr>
					<th>last Name:</th>
					<td><input type="text" name="lastName"
						value="<%=(bean != null) ? bean.getLastName() : ""%>"></td>
				</tr>
				<tr>
					<th>Email:</th>
					<td><input type="email" name="loginId"
						value="<%=(bean != null) ? bean.getLoginId() : ""%>"></td>
				</tr>
				<tr>
					<th>Password:</th>
					<td><input type="password" name="password"
						value="<%=(bean != null) ? bean.getPassword() : ""%>"></td>
				</tr>
				<tr>
					<th>PhoneNo:</th>
					<td><input type="text" name="phoneNo"
						value="<%=(bean != null) ? bean.getPhoneNo() : ""%>"></td>
				</tr>
				<tr>
					<th>dob:</th>
					<td><input type="date" name="dob"
						value="<%=(bean != null) ? bean.getDob() : ""%>"></td>
				</tr>
				<tr>
					<th>Gender:</th>
					<td><input type="text" name="gender"
						value="<%=(bean != null) ? bean.getGender() : ""%>"></td>
				</tr>
				<tr>
					<th></th>
					<td><input type="submit" name="operation"
						value="<%=(bean != null) ? "update" : "save"%>"></td>
				</tr>
			</table>
		</form>
	</center>
	<%@ include file="Footer.jsp"%>
</body>
</html>