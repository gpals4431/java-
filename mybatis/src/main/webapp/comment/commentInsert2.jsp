<%@page import="xyz.itwill.dao.MyCommentDAO"%>
<%@page import="xyz.itwill.dto.MyComment1"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	MyComment1 comment3 = new MyComment1();
	comment3.setCommentId("qwe");/* myuser테이블에 삽입된 아이디를 써야함 */
	comment3.setCommentContent("세번쨰 게시글");
	MyCommentDAO.getDAO().insertComment2(comment3);
	
	MyComment1 comment4 = new MyComment1();
	comment4.setCommentId("abc");/* myuser테이블에 삽입된 아이디를 써야함 */
	comment4.setCommentContent("네번쨰 게시글");
	MyCommentDAO.getDAO().insertComment2(comment4);
	
	
%><!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>게시글 등록</h1>
	<hr>
	<h3>게시글을 성공적으로 삽입</h3>
</body>
</html>