<%@ page language="java" contentType="text/html; charset=UTF-8"
<<<<<<< HEAD
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
<script
src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.0/jquery.min.js"></script>
<meta charset="UTF-8">
<title>회원가입</title>
<style type="text/css">
.error {
	display: none;
}
</style>
</head>
<body>
	<h1>회원가입</h1>
	<hr>
	<form method="post" action="join_action.jsp" id="joinForm">
		<input type="hidden" id="idCheckResult" value="0">
			<div id="id-box">
				<label for="id">아이디</label>
				<input type="text" name="id" id="id">
				<span><button type="button" id="idCheckBtn">아이디 중복 검사</button></span><br>
				<p id="messageid>"></p>
			</div>	
			<div id="pw-box">
				<label for="password">비밀번호</label>
				<input type="password" name="password" id="password"><br><p id="messagepw"></p>
			</div>	
			<div id="name-box">
				<label for="name">이름</label>
			 	<input type="text" name="name" id="name"><br><p id="messagename"></p>
			</div>	
		<button type="submit" id="joinbtn">회원가입</button>
		<button type="reset">다시작성</button>
	</form>
	<div id="message"><%=message %></div>
	<script type="text/javascript">
	joinForm.id.focus();
 	document.getElementById("joinbtn").onclick= function (e) {
		console.log(joinForm.id.value);
	
		var id= document.querySelector('#id').value;
		var password= document.querySelector('#password').value;
		var name= document.querySelector('#name').value;
		
		
		if (id =="") {
			document.querySelector('#messageid').innerHTML="아이디를 입력해주세요";
			e.prevenDefault();		
		}else{
			document.querySelector('#messageid').innerHTML="";
		}
	/* 	
		var idReg = /^[a-zA-Z]\w{5,19}$/g;
		if(!idReg.test(id)){
			document.querySelector('#messageid>').innerHTML="아이디는 영문자로 시작되는 영문자,숫자,_의 6~20범위의 문자로만 작성 가능합니다.";
			e.prevenDefault();		
			
		} */
		
		if (password == "") {
			document.querySelector('#messagepw').innerHTML="비밀번호를 입력해주세요";
			e.prevenDefault();
			
		}else{
			document.querySelector('#messagepw').innerHTML="";
		}
		
/* 		var passwdReg = /^(?=.*[a-zA-Z])(?=.*[0-9])(?=.*[~!@#$%^&*_-]).{6,20}$/g;
		if (!passwdReg.test(password)) {
			document.getElementById("messagepw").innerHTML="비밀번호를 형식에 맞게 입력해주세요";
			e.prevenDefault();
			}
 */		
		if (name =="") {
			document.querySelector('#messagename').innerHTML="이름을 입력해주세요";
			e.prevenDefault();
			
		}else{
			document.querySelector('#messagename').innerHTML="";
		}
	}
 	
	

=======
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html>
<head>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.0/jquery.min.js"></script>
<meta charset="UTF-8">
<title>회원가입</title>
<style type="text/css">
.error{
	display: none;
}
</style>
</head>
<body>
	<h1>회원가입</h1>
	<hr>
	<form method="post" action="join_action.jsp" id="joinForm">
	<input type="hidden" id="idCheckResult" value="0">
		<ul>
			<li>
				<label for="id">아이디</label>
			 	<input type="text" name="id" id="id">
			 	<span><button type="button" id="idCheckBtn">아이디 중복 검사</button></span>
			 	<div id="messageid>"></div>
			 	<div id="idCheckMsg" class="error">아이디 중복검사를 반드시 해주세요.</div>
			</li>
			<li><label for="password">비밀번호</label> 
				<input type="password" name="password" id="password">
			 	<div id="messagepw"></div>
			</li>
			<li><label for="name">이름</label> <input type="text" name="name" id="name">
				<div id="messagename" class="error">이름을 입력해주세요</div>
			</li>
		</ul>
		<button type="submit" id="joinbtn">회원가입</button>
		<button type="reset">다시작성</button>
	</form>

<script type="text/javascript">
	document.getElementById("joinbtn").onclick = function(){
		alert("버튼누름");
		var idReg = /^[a-zA-Z]\w{5,19}$/g;
		var passwdReg = /^(?=.*[a-zA-Z])(?=.*[0-9])(?=.*[~!@#$%^&*_-]).{6,20}$/g;
		
		
		if (joinForm.id.value == "") {
			document.getElementById("messageid").innerHTML="이름을 입력해주세요";
			return;		
		}else if(!idReg.test(id)){
			document.getElementById("messageid").innerHTML="아이디는 영문자로 시작되는 영문자,숫자,_의 6~20범위의 문자로만 작성 가능합니다.";
			return;		
			
		}
		
		if (joinForm.password.value == "") {
			document.getElementById("messagepw").innerHTML="비밀번호를 입력해주세요";
			return;		
		}else if (!passwdReg.test(password)) {
			document.getElementById("messagepw").innerHTML="비밀번호를 형식에 맞게 입력해주세요";
			return;		
		}
		
		if (joinForm.name.value == "") {
			document.getElementById("messagename").innerHTML="이름을 입력해주세요";
			return;		
		}
		
		joinForm.submit();
		
	}
	
	document.getElementById("idCheckBtn").onclick=function() {
		window.location.href='id_check.jsp';
	}
	
	$("#id").change(function() {
		//아이디 중복 검사 결과값을 저장한 입력태그의 입력값 변경 - 아이디 중복 검사 미실행
		$("#idCheckResult").val("0");
	});
>>>>>>> refs/remotes/origin/main
</script>
</body>
</html>