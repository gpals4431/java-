<%@page import="xyz.itwill.dao.MyHewonDAO"%>
<%@page import="xyz.itwill.dto.MyHewon"%>
<%@page import="xyz.itwill.dao.MyCommentDAO"%>
<%@page import="xyz.itwill.dto.MyComment1"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%

	int status=0;
	if(request.getParameter("status")!=null){
		status=Integer.parseInt(request.getParameter("status"));
	}
	List<MyHewon> hewonList=null;
	if(status==0){
		hewonList = MyHewonDAO.getDAO().selectHewonList();//전체검색
	}else{
		hewonList = MyHewonDAO.getDAO().selectStatusHewonList();//조건 검색
		
	}
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
		<% for(MyHewon hewon : hewonList) { %>
		<tr>
			<td><%=hewon.getId() %></td>
			<td><%=hewon.getName() %></td>
			<td><%=hewon.getPhone() %></td>
			<td><%=hewon.getEmail() %></td>
			<td><%=hewon.getStatus() %></td>
		</tr>
		<% } %>
	</table>
	
	<br>
	<form method="post">
		회원검색(공개범위) :
		<select name="status">
			<option value="0" selected="selected">전체</option>
			<option value="1" >&nbsp;&nbsp;1&nbsp;&nbsp;</option>
			<option value="2" >&nbsp;&nbsp;2&nbsp;&nbsp;</option>
			<option value="3" >&nbsp;&nbsp;3&nbsp;&nbsp;</option>
			<option value="4" >&nbsp;&nbsp;4&nbsp;&nbsp;</option>
		</select>
		<button type="submit">검색</button>
	</form>

</body>
</html>




