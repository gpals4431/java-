<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- 사용자로부터 회원정보를 입력받기 위한 jsp 문서
=> [회원등록]태그를 클릭한 경우 [non_useBean_action.jsp]문서를 요청하여 이동 - 입력값 전달(회원정보) -->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>회원 정보 등록</h1>
	<form action="useBean_action.jsp" method="post">
	<table>
		<tr>
			<td>이름</td>
			<td><input type="text" name="name"></td>
		</tr>
		<tr>
			<td>전화번호</td>
			<td><input type="text" name="phone"></td>
		</tr>
		<tr>
			<td>주소</td>
			<td><input type="text" name="address"></td>
		</tr>
		<tr>
			<td colspan="2"><button type="submit">회원등록</button>
		</tr>
	</table>
	
	
	</form>
</body>
</html>