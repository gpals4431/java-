<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<c:set var="phone" value="010-1234-5678"/>
	<p>전화번호 - ${phone }</p>
	<hr>
	
	<c:set var="num" value="${fn:split(phone, '-' }"/>
</body>
</html>