<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Core- URL 관리 태그</h1>
	<form action="core_redirect_action.jsp" method="post">
		이름 : <input type="text" name="name">
		<button type="submit">제출</button>
	</form>
</body>
</html>