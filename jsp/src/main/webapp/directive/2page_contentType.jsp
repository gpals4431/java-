<%-- <%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%> --%>
<%@ page language="java" contentType="application/msword; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<style type="text/css">
table{
	border: 1px solid black;
	border-collapse: collapse;
}
th, td{
	border: 1px solid black;
	text-align: center;
	width: 200px;
	padding: 2px;
}


</style>
<meta charset="UTF-8">
<title>JSP</title>
</head>
<body>
	<h1>page Directive - contentType 속성</h1>
	<hr>
	<p>page Directive의 ContentType 속성에는 JSP 문서를 요청하여 응답 받을 수 있는 파일형태(Mime type)와 
	파일의 문자형태(CharSet - Encoding)를 속성값으로 설정</p>
	<hr>
	<table>
		<tr>
			<th>학번</th><th>이름</th><th>주소</th>
		</tr>
		<tr>
			<td>1000</td><td>홍길동</td><td>서울시 강남구 역삼동</td>
		</tr>
		<tr>
			<td>2000</td><td>임꺽정</td><td>서울시 서초구 방배동</td>
		</tr>
		<tr>
			<td>3000</td><td>전우치</td><td>서울시 관악구 봉천동</td>
		</tr>
	</table>
	
	
</body>
</html>