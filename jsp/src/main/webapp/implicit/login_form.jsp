<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- 사용자로부터 로그인 처리에 필요한 인증정보(id, pw)를 입력받기 위한 JSP 문서 
=> 로그인 태그를 클릭한 경우 로그인 처리페이지(login_action.jsp) 문서 요청 - 입력값(인증정보) 전달 -->
<%
/*
	//전달된 에러메세지를 반환받아 저장
	String message=request.getParameter("message");
	if(message==null){//전달값이 없는 경우
		message="";//null 문자 출력 방지
	}
*/

	//바인딩된 세션에 저장된 에러메세지를 반환받아 저장 
	String message=(String)session.getAttribute("message");
	if(message==null){
		message="";
	}else{
		//session.removeAttribute(String attributeName) : 클라이언트 정보로 바인딩된 세션에 속성값을 삭제하는 메소드
		//해주는 이유? 바인딩된 세션에 저장된 객체는 소멸전까지는 유지, 하지만 message는 다른곳에 쓸 필요없음
		// => 다른 jsp문서에서 세션에 저장된 에러메세지를 사용할 수 없도록 삭제	처리 필요
		session.removeAttribute("message");
	}
	
	String id=(String)session.getAttribute("id");
	if(id==null){
		id="";
	}else{
		//session.removeAttribute(String attributeName) : 클라이언트 정보로 바인딩된 세션에 속성값을 삭제하는 메소드
		//해주는 이유? 바인딩된 세션에 저장된 객체는 소멸전까지는 유지, 하지만 message는 다른곳에 쓸 필요없음
		// => 다른 jsp문서에서 세션에 저장된 에러메세지를 사용할 수 없도록 삭제	처리 필요
		session.removeAttribute("id");
	}

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP</title>
</head>
<body>
	<h1>로그인</h1>
	<hr>
	<form action="login_action.jsp" method="post" name="loginForm">
	<table>
		<tr>
			<td>아이디</td>
			<td><input type="text" name="id" value=<%=id %>></td>
		</tr>
		<tr>
			<td>비밀번호</td>
			<td><input type="password" name="passwd"></td>
		</tr>
		<tr>
			<td colspan="2"><button type="button" id="loginBtn">로그인</button></td>
		</tr>
	</table>
	</form>
	<p id="message" style="color:red;"><%= message%><!-- null도 하나의 문자열로 취급함 --></p>
	
	<script type="text/javascript">
	loginForm.id.focus();
	
	document.getElementById("loginBtn").onclick=function() {
		if(loginForm.id.value=="") {
			document.getElementById("message").innerHTML="아이디를 입력해 주세요";
			loginForm.id.focus();
			return;
			
		}
		if(loginForm.passwd.value=="") {
			document.getElementById("message").innerHTML="비밀번호를 입력해 주세요";
			loginForm.passwd.focus();
			return;
			
		}
		  loginForm.submit();
	   
	}
	
	</script>
	
		
</body>
</html>