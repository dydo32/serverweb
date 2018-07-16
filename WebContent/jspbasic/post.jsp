<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="EUC-KR">
	<title>Insert title here</title>
</head>
<body>
	<% 
		request.setCharacterEncoding("EUC-KR");
		String userId = request.getParameter("userId");
		String userName = request.getParameter("userName");
		String passwd = request.getParameter("passwd");
		String gender = request.getParameter("gender");
		String job = request.getParameter("job");
		String[] item = request.getParameterValues("item");
	%>
	<h1>customer</h1>
	<hr/>
	<h3>아이디: <%=userId %></h3>
	<h3>성명: <%=userName %></h3>
	<h3>패스워드: <%=passwd %></h3>
	<h3>성별: <%=gender %></h3>
	<h3>job: <%=job %></h3>
	<h3>Favorites: 
	<% for(int i=0; i<item.length; i++){ %>
		<%=item[i]%>
	<% }%>
	</h3>
</body>
</html>