<%@page import="emp.dto.EmpDTO"%>
<%@page import="emp.service.EmpServiceImpl"%>
<%@page import="emp.service.EmpService"%>
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
		request.setCharacterEncoding("euc-kr");
		response.setContentType("text/html;charset=euc-kr");
		
		String deptno = request.getParameter("deptno");
		String name = request.getParameter("name"); 
		String id = request.getParameter("id");
		String pass = request.getParameter("pass"); 
		String addr = request.getParameter("addr");
		int point = Integer.parseInt(request.getParameter("point")); 
		String grade = request.getParameter("grade"); 
		
		EmpService service = new EmpServiceImpl();
		EmpDTO user = new EmpDTO(id, pass, name, addr, grade, point, deptno);
		int result = service.insert(user);
		
		String msg = "";
		if(result>=1){
			msg = result+"개 행 삽입 성공";
		}else{
			msg = "삽입실패";
		}
	%>	
	<h1><%= msg %></h1>
	
</body>
</html>