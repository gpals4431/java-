<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Formatter - 숫자 변환 태그</h1>
	<hr>
	<c:set var ="price" value="1000000000"/>
	<p>가격 = ${price }원</p>
	
	<!-- formatNumber 태그 : 숫자값을 원하는 패턴의 문자열로 변환하여 제공하는 태그 -->
	<p>가격 = <fmt:formatNumber value="${price }" type="number"/>원</p>
</body>
</html>