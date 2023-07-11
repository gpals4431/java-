<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String message=(String)session.getAttribute("message");
	if(message==null){
		message="";
	}else{
		session.removeAttribute("message");
	}

	String id=(String)session.getAttribute("id");
	if(id==null) {
		id="";
	} else {
		session.removeAttribute("id");
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
			<input type="text" id="id" value=<%=id %>><br><p id="messageid"></p>
		</li>
		<li>
			<label>비밀번호</label>
			<input type="password" id="password"><br><p id="messagepw"></p>
		</li>
	</ul>
	<button type="submit" id="loginbtn">로그인</button>
	<button type="reset">다시작성</button>
	<div id="message"><%=message %></div>
	</form>
	
	<script type="text/javascript">
	document.getElementById("loginbtn").onclick= function (e) {
	
	var id=document.querySelector('#id').value;
	var password=document.querySelector('#password').value;
	
	if(id==""){
		document.querySelector('messageid').innerHTML="아이디를 입력해주세요.";
		e.preventDefault();
	}
	if(password==""){
		document.querySelector('messagepw').innerHTML="비밀번호를 입력해주세요.";
		e.preventDefault();
	}
	</script>
    

</body>
</html>