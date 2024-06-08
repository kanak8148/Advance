<html>
<body>
	<h2>Hello World!</h2>
	<%
		String str = "Hello JSP";
	%>
	<%=str%>
	<%
		for (int i = 0; i <= 10; i++) {
	%>

	<h1><%=i%>Hello World
	</h1>
	<%
		}
	%>
</body>
</html>
