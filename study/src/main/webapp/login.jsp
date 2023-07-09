<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>로그인 페이지</title>
</head>
<body>
	<h1>로그인</h1>
	<hr>
	<form action="login_action.jsp" method="post">
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
	</form>
</body>
</html>