<%@page import="xyz.itwill.dto.MyHewon"%>
<%@page import="xyz.itwill.dao.MyHewonDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% 

	MyHewonDAO.getDAO().insertHewon(new MyHewon("aaa", "홍길동","010-1111-1111","aaa@itwill.com", 1));
	MyHewonDAO.getDAO().insertHewon(new MyHewon("bbb", "임꺽정","010-2222-2222","bbb@itwill.com", 2));
	MyHewonDAO.getDAO().insertHewon(new MyHewon("ccc", "전우치","010-3333-3333","ccc@itwill.com", 3));
	MyHewonDAO.getDAO().insertHewon(new MyHewon("ddd", "일지매","010-4444-4444","ddd@itwill.com", 4));
	MyHewonDAO.getDAO().insertHewon(new MyHewon("fff", "장길산","010-5555-5555","fff@itwill.com", 3));

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