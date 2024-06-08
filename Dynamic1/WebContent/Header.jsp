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
	<%
		UserBean user = (UserBean) session.getAttribute("user");
		String msg = "hii, ";
		if (user != null) {

			msg += user.getFirstName() + " " + user.getLastName();

		} else {

			msg += "guest";

		}
	%>
	<br>
	<a href="UserRegistration.jsp">signUp</a> |
	<%
		if (user != null) {
	%>
	<a href="UserListCtl">UserList</a> |
	<a href="LoginCtl?operation=logout">logout</a>
	<%
		} else {
	%>
	<a href="LoginCtl">login</a>
	<%
		}
	%>

	<h4><%=msg%></h4>
	<br>
	<br>
	<hr>
</body>
</html>