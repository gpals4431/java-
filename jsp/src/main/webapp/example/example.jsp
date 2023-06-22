<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<% Date now = new Date();
	String printDate="< "+(now.getMonth()+1)+"월 >";%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
h2{
	width: 100%;
	text-align: center;
	padding: 20px;
	margin: 0 auto;
	font-weight: bold;
	font-size: 1.5em;
}

</style>
</head>
<body>
	<h2><%= printDate %></h2>
	<hr>
	
</body>
</html>