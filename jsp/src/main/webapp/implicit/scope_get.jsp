<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP</title>
</head>
<body>
	<h1>객체의 사용범위(scope)</h1>
	<hr>
	<%
		//내장객체에 저장된 속성값을 속성명으로 구분하여 반환받아 저장
		// => 속서명의 속성값이 없는 경우 null 반환
		// => Object 객체로 반환하므로 명시적 형 객체 형변환 이용
		String pageName=(String)pageContext.getAttribute("pageName");//출력x
		String requestName=(String)request.getAttribute("requestName");//출력x
		String sessionName=(String)session.getAttribute("sessionName");//브라우저가 닫히면 세션 언바인딩 새로운 세션으로 바인딩 => 속성값도 소멸
		String applicationName=(String)application.getAttribute("applicationName");//was 닫히면 소멸
	%>
	<p>pageName=<%= pageName %></p>
	<p>requestName=<%= requestName %></p>
	<p>sessionName=<%= sessionName %></p>
	<p>applicationName=<%= applicationName %></p>
</body>
</html>