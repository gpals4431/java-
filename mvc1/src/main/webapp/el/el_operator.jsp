<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>EL Operator</h1>
	<hr>
	<%-- EL 연산자 : EL 표현식에서 사용하는 연산자 - 산술, 비교, 논리 연산자 등 --%>
	<%=request.setAttribute("num1", 20)%>
	<%=request.setAttribute("num2", 10)%>
	<div>num1=${num1 }</div>
	<div>num2=${num2 }</div>
	<hr>
	<div>num1 * num2 = ${num1 * num2}</div>
	<div>num1 / num2 = ${num1 / num2}</div>
	<div>num1 % num2 = ${num1 % num2}</div>
	<div>num1 + num2 = ${num1 + num2}</div>
	<div>num1 - num2 = ${num1 - num2}</div>
</body>
</html>