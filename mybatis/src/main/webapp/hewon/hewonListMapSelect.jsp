<%@page import="xyz.itwill.dao.MyHewonDAO"%>
<%@page import="xyz.itwill.dto.MyHewon"%>
<%@page import="xyz.itwill.dao.MyCommentDAO"%>
<%@page import="xyz.itwill.dto.MyComment1"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	List<Map<String, Object>> hewonList=MyHewonDAO.getDAO().selectMapHewonList();
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>MYBATIS</title>
<style type="text/css">
table {
	border: 1px solid black;
	border-collapse: collapse;
}

td {
	border: 1px solid black;
	text-align: center;
	padding: 3px;
}

.no { width: 100px; }
.name { width: 150px; }
.content { width: 250px; }
.date { width: 200px; }
</style>
</head>
<body>
	<h1>게시글 목록</h1>
	<hr>
	<table>
		<tr>
			<td class="no">아이디</td>
			<td class="name">이름</td>
			<td class="content">전화번호</td>
			<td class="date">이메일</td>
			<td class="date">공개범위</td>
		</tr>
		<% for(Map<String, object> hewon : hewonList) { %>
		<tr>
			<td><%=hewon.get("HEWON_ID") %></td>
			<td><%=hewon.getName() %></td>
			<td><%=hewon.getPhone() %></td>
			<td><%=hewon.getEmail() %></td>
			<td><%=hewon.getStatus() %></td>
		</tr>
		<% } %>
	</table>
</body>
</html>




