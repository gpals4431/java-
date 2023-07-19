<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- 클라이언트가 보내온 쿠키의 쿠키값을 반환받아 클라이언트에게 전달하여
응답하는 jSP문서 -->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>EL 내장객체 - Cookie</h1>
	<hr>
	<h2>EL 미사용</h2>
	<%
		Cookie[] cookies =request.getCookies();
	String userName ="";
	for(Cookie cookie : cookies){
		//Cookie 객체에 저장된 쿠키명을 반환받아 문자열과 비교하여 같은 경우
		if(cookie.getName().equals("userName")){
			userName=cookie.getValue();//쿠키객체에 저장된 쿠키값을 반환받아 변수에 저장
		}
	}
	%>
	<p>쿠키명 = <%=userName %></p>
	
	<h2>EL 사용</h2>
	<!-- EL 표현식에서 cookie 내장객체를 사용하여 쿠키값을 제공받아 출력 처리 가능
	=> cookie 내장객체는 Map 객체로 맵키 대신 쿠키명을 사용하여 쿠키값을 제공받아
	value 표현식으로 쿠키값을 출력-->
	<%-- //<p>쿠키명 = ${cookie.userName }</p> // 쿠키객체--%>
	<p>쿠키명 = ${cookie.userName.value }</p>
</body>
</html>