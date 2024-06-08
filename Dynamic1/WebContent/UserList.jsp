<%@page import="com.rays.bean.UserBean"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
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
		int pageNo = (int) request.getAttribute("pageNo");
		String dmsg = (String) request.getAttribute("delete");
		List list = (List) request.getAttribute("userList");
		List nextList = (List) request.getAttribute("nextUser");
	%>
	<h1 align="center">UserList</h1>
	<%
		if (dmsg != null) {
	%>
	<font color="red"><%=dmsg%></font>
	<%
		}
	%>
	<form action="UserListCtl" method="post">
		<table style="width: 30%">
			<tr>
				<td><input type="text" name="firstName"
					placeholder="Enter First Name"></td>
				<td></td>
				<td><input type="submit" name="operation" value="search">
				</td>
			</tr>
			<tr></tr>
			<tr></tr>
			<tr></tr>
		</table>
		<table border="2" width="100%" align="center">
			<tr>
				<th>Select</th>
				<th>Id</th>
				<th>FirstName</th>
				<th>LastName</th>
				<th>Email</th>
				<th>PhoneNo</th>
				<th>dob</th>
				<th>Gender</th>
				<th>Edit</th>
			</tr>
			<%
				Iterator<UserBean> it = list.iterator();
				while (it.hasNext()) {

					UserBean bean = it.next();
			%>
			<tr align="center">
				<td><input type="checkbox" name="ids" value="<%=bean.getId()%>"></td>
				<td><%=bean.getId()%></td>
				<td><%=bean.getFirstName()%></td>
				<td><%=bean.getLastName()%></td>
				<td><%=bean.getLoginId()%></td>
				<td><%=bean.getPhoneNo()%></td>
				<td><%=bean.getDob()%></td>
				<td><%=bean.getGender()%></td>
				<td><a href="UserRegistrationCtl?id=<%=bean.getId()%>">edit</a></td>
			</tr>
			<%
				}
			%>
		</table>
		<table style="width: 100%">
			<tr>
				<td><input type="submit" name="operation" value="previous"
					<%=(pageNo != 1) ? "" : "disabled"%>></td>


				<td align="center"><input type="submit" name="operation"
					value="delete"></td>


				<td align="right"><input type="submit" name="operation"
					value="next" <%=(nextList.size() != 0) ? "" : "disabled"%>></td>
			</tr>
		</table>
		<input type="hidden" name="pageNo" value="<%=pageNo%>">
	</form>
	<%@ include file="Footer.jsp"%>
</body>
</html>