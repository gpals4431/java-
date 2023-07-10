<%@page import="study.dto.joinDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
	joinDTO loginMember=(joinDTO)session.getAttribute("loginMember");

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTP-8">
<title>메인페이지</title>
</head>
<body>
<h1>홈</h1>
<hr>
<div id="header"></div>
<% if(loginMember==null) {//비로그인 상태의 사용자인 경우 %>
	<button type="button" id="login_btn" onclick="location.href='login.jsp'">로그인</button>
	<button type="button" id="join_btn" onclick="location.href='join.jsp'">회원가입</button>
	<% } else {//로그인 상태의 사용자인 경우 %>
		<%=loginMember.getName() %>님, 환영합니다.&nbsp;&nbsp;
		<button type="button" id="login_btn" onclick="location.href='logout.jsp'">로그아웃</button>
		<% } %>
<div id="content"></div>
	<div>메인페이지</div>
</body>
</html>