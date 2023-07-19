<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>EL 내장객체 - Context Init Parameter</h1>
	<hr>
	<h2>EL 미사용</h2>
	<p>[web.xml] 파일에서 context-param 엘리먼트로 제공되는
	
	<!-- EL 표현식에서 initparam 내장객체를 사용하여 쿠키값을 제공받아 출력 처리 가능
	=> initparam 내장객체는 Map 객체로 맵키 대신 param-name 엘리먼트의 이름을 사용하여 
	param-value 표현식으로 쿠키값을 출력-->
	<p>이름 - ${initparam.name }</p>
	
</body>
</html>