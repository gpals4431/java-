<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
	/* 내장 객체를 이용하여 객체를 속성값으로 저장
	=> 속성명을 이용하여 속성값을 구분 - 내장객체가 다른 경우 같은 이름의 속서명 사용 가능
	=> 내장객체에 동일한 속성명이 있는 경우 기존 속성값 대신 새로운 속성값으로 변경*/
	pageContext.setAttribute("pagename", "홍길동");// page scope : 내장객체 소멸 => 속성값도 소멸, 자기자신만 사용 가능
	request.setAttribute("requestName","임꺽정");//request scope : 자기자신, 스레드가 이동된 jsp만.. 스레드가 이동될때 request,response 제공받을 수 있어서 스레드가 이동된 jsp에서 사용가능
	session.setAttribute("sessionName", "전우치");//session(클라이언트마다 다름) scope :  모든 jsp문서에서 사용 가능 - 클라이언트가 같은 경우
	application.setAttribute("applicationName", "일지매");//application Scope : 클라이언트 상관없이 모든 jsp에서 사용 가능

%>
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
		String pageName=(String)pageContext.getAttribute("pageName");
		String requestName=(String)request.getAttribute("requestName");
		String sessionName=(String)session.getAttribute("sessionName");
		String applicationName=(String)application.getAttribute("applicationName");
	%>
	<p>pageName=<%= pageName %></p>
	<p>requestName=<%= requestName %></p>
	<p>sessionName=<%= sessionName %></p>
	<p>applicationName=<%= applicationName %></p>
</body>
</html>