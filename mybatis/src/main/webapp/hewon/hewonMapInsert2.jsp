<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page import="xyz.itwill.dto.MyHewon"%>
<%@page import="xyz.itwill.dao.MyHewonDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% 

	Map<String , Object> map =new HashMap<>();
	map.put("id","xxx");
	map.put("name","홍경래");
	map.put("phone","010-5555-5555");
	map.put("email","xxx@itwill.com");
	map.put("status",4);

	MyHewonDAO.getDAO().insertMapHewon(map);
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>회원등록</h1>
	<hr>
	<h3>회원정보 삽입 완료</h3>
</body>
</html>