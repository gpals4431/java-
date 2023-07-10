<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% 
	request.setCharacterEncoding("utf-8");	


	//전달값 반환받아 저장
	String id = request.getParameter("id");
	String name = request.getParameter("name");

%>    
    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	홍길동님[abc123], 안녕하세요
	<%= name%>[<%=id %>]님, 안녕하세요
</body>
</html>