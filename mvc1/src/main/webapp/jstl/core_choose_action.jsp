<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>MVC</title>
</head>
<body>
	<h1>Core - 흐름 제어 태그</h1>
	<hr>
	<%--EL 표현식에서 param 내장객체 또는 paramValues 내장객체를 사용하여 전달값을 
		제공받아 출력 처리 가능 = request.getParameter랑 동일
	=> param 내장객체 또는 paramValues 내장객체는 Map 객체로 맵키 대신 전달값의 
		이름을 사용하여 전달값 구분--%>
	<c:choose>
		<c:when test="${!empty(param.score) }">
			<p>입력점수 = ${param.score }점</p>
			<c:choose>
				<c:when test="${param.score <= 100 && param.score >= 90 }">
					<c:set var="grade" value="A"/>
				</c:when>
				<c:when test="${param.score <= 89 && param.score >= 80 }">
					<c:set var="grade" value="B"/>
				</c:when>
				<c:when test="${param.score <= 79 && param.score >= 70 }">
					<c:set var="grade" value="C"/>
				</c:when>
				<c:when test="${param.score <= 69 && param.score >= 60 }">
					<c:set var="grade" value="D"/>
				</c:when>
				<c:otherwise>
					<c:set var="grade" value="F"/>
				</c:otherwise>
			</c:choose>
			<p>${param.score }점은 ${grade } 학점입니다.</p>			
		</c:when>
		<c:otherwise>
			<p style="color: red;">입력페이지에서 점수를 반드시 입력해 주세요.</p>
			<a href="core_choose_form.jsp">입력페이지 이동</a>
		</c:otherwise>
	</c:choose>
</body>
</html>