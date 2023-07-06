<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% String loginId = (String)session.getAttribute("loginid"); %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>LOGIN</title>
<style type="text/css">
form{
	border: 4px solid black;
	margin: 0 auto;
	padding: 100px;
	width:300px;
	height:150px;
}
div:nth-child(1){
	text-align: center;
	font-weight: bold;
	font-style: italic;
	font-size: 1.5em;
}
div:nth-child(2){
	text-align: center;
}
div:nth-child(3){
	text-align: center;
	padding: 25px;
}
button {
	width: 60px;
	height: 40px;
	background: black;
	color: white;
	font-weight: bold;
	border-radius: 50px;
	font-size: 0.7em;
}

</style>

</head>
<body>
	<form action="example_main.jsp" method="post" name="loginForm">
		<div id="textDiv">PASSWORD</div>
		<div><input type="password" name="pw"></div>
		<div><button type="button" id="pwBtn">LOGIN</button></div>
	</form>
	
	<script type="text/javascript">
		document.getElementById("pwBtn").onclick = function() {
			if(loginForm.pw.value==""){
				alert("비밀번호를 반드시 입력해주세요.");
				return;
			}
			
			loginForm.submit();
		}
	</script>
</body>
</html>