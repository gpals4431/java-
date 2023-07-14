<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
String message = (String) session.getAttribute("message");
if (message == null) {
	message = "";
} else {
	session.removeAttribute("message");
}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인 페이지</title>
<style type="text/css">
.message{
	color: red;
}
</style>
</head>
<body>
	<h1>로그인</h1>
	<hr>
	<form action="login_action.jsp" method="post" name="loginForm" >
		<ul>
			<li><label>아이디</label> <input type="text" id="id" name="id"><br>
			<!-- name : 서버 전달값! !! !  !데이터 연결 , id는 그냥 식별자! -->
			<p id="messageid" class="message"></p></li>
			<li><label>비밀번호</label> <input type="password" id="password" name="password"><br>
			<p id="messagepw"  class="message"></p></li>
		</ul>
		<button type="submit" id="loginbtn">로그인</button>
		<button type="reset">다시작성</button>
		<div id="message" style="color: red"><%=message%></div>
	</form>

	<script type="text/javascript">
		document.getElementById("loginbtn").onclick = function(e) {

			/*  var id=document.querySelector('#id').value;
			 var password=document.querySelector('#password').value;
			 */
			if (document.querySelector('#id').value == "") {
				document.querySelector('#messageid').innerHTML = "아이디를 입력해주세요.";
				e.preventDefault();
			}
			if (document.querySelector('#password').value == "") {
				document.querySelector('#messagepw').innerHTML = "비밀번호를 입력해주세요.";
				e.preventDefault();
			}
		}
	</script>
</body>
</html>