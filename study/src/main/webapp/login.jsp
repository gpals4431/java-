<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String message=(String)session.getAttribute("message");
	if(message==null){
		message="";
	}else{
		session.removeAttribute("message");
	}
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>로그인 페이지</title>
</head>
<body>
	<h1>로그인</h1>
	<hr>
	<form action="login_action.jsp" method="post" name="loginForm">
	<ul>
		<li>
			<label>아이디</label>
			<input type="text" id="id">
		</li>
		<li>
			<label>비밀번호</label>
			<input type="password" id="password">
		</li>
	</ul>
	<button type="submit" id="loginbtn">로그인</button>
	<button type="reset">다시작성</button>
	<div id="message"></div>
	</form>
	
	<script type="text/javascript">
	document.getElementById("loginForm").onclick= function () {
	
	var id=document.querySelector('#id').value;
	var password=document.querySelector('#password').value;
	
	if(id==""){
		document.getElementById("message").innerHTML="아이디를 입력해주세요.";
		e.preventDefault();
	}
	if(password==""){
		document.getElementById("message").innerHTML="비밀번호를 입력해주세요.";
		e.preventDefault();
	}
	</script>
</body>
</html>