<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
	//java.util.List<String> nameList= new ArrayList<>();
	List<String> nameList= new ArrayList<>();
	nameList.add("홍길동");
	nameList.add("임꺽정");
	nameList.add("전우치");
	nameList.add("일지매");
	nameList.add("장길산");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<hr>
	<ul>
	<% for(String name:nameList){%>
		<li><%= name%></li>		
	<% } %>
	</ul>
</body>
</html>