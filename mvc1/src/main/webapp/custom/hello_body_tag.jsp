<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="simple" uri="http://www.itwill.xyz/mvc/custom"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>custom tag - Anyattribute and Anybody</h1>
	<hr>
	<simple:helloBody test="true">홍길동</simple:helloBody>
	<simple:helloBody test="false">전우치</simple:helloBody>
	<hr>
	<%
		String name="전우치";
		request.setAttribute("name", "일지매");
	%>
	
	<simple:helloBody test="true"><%=name %></simple:helloBody>
	<simple:helloBody test="false">${name }</simple:helloBody>
	<hr>
	<% 
		boolean result=true;
		request.setAttribute("result", false);
	%>
	<simple:helloBody test="<%=result %>" >장길산</simple:helloBody> <!-- 변수값 -->
	<simple:helloBody test="${result })">홍경래</simple:helloBody><!-- 속성값 -->
	<hr>
</body>
</html>