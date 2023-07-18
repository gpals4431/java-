<%@page import="xyz.example.dao.ExampleDAO"%>
<%@page import="xyz.example.dto.ExampleDTO"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
	//[검색]태그를 클릭하면 [example_main.jsp]문서 요청 = 검색대상 검색단어를 전달

	request.setCharacterEncoding("utf-8");	

	//전달값 저장 
	//검색대상 - 입/출금
	String search=request.getParameter("search");
	if(search==null){
		search="";
	}
	//검색단어 - 검색창에 입력된 값 
	String keyword=request.getParameter("keyword");
	if(keyword==null){
		keyword="";
	}
	
	//검색단어와 대상을 입력받아 검색행의 갯수를 반환하는 DAO 메소드 호출
	int totalCount=ExampleDAO.getDao().searchAccountCount(search, keyword);
			
	//검색단어와 대상을 입력받아 검색하여 검색된 정보를 List 객체로 반환하는 dao 클래스 호출
	List<ExampleDTO> accountList=ExampleDAO.getDao().searchAccountList(search, keyword);
	
	
	 
%>
<!DOCTYPE html>
<html>
<head>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.0/jquery.min.js"></script>
<meta charset="UTF-8">
<title>가계부 프로그램</title>
<link rel="stylesheet" type="text/css" href="../css/example_main.css">
</head>
<body>
<div id="header">
	<%-- <h2><%=date.substring(5,7) %></h2> --%>
</div>

<form method="post" action="example_main.jsp">
<div id="content">
	<select name="search">
		<option value="ain">입금</option>
		<option value="aout">출금</option>
	</select>
	<input type="text" name="keyword" placeholder="내역을 입력해주세요." autofocus size="20" style="color:gray" >
	<button type="submit" id="searchBtn">&nbsp;&nbsp;검색&nbsp;&nbsp;</button>
</div>
	<hr>
		<div style="width:100%; height:600px; overflow:auto">
			<table border="1" >
				<tr>
					<th width="150">사용처</th>
					<th width="150">&nbsp;금&nbsp;액&nbsp;</th>
					<th width="90">입/출금</th>
					<th width="150">사용날짜</th>
					<th>출금내역</th>
					<th>입금내역</th>
					<th width="60">&nbsp;변&nbsp;경&nbsp;</th>
					<th width="60">&nbsp;삭&nbsp;제&nbsp;</th>
					<%
					if (totalCount == 0) {
					%>
				
				<tr>
					<td colspan="7" style="text-align: center">검색된 게시글이 없습니다.</td>
				</tr>
				<%
				} else {
				%>
				<%
				for (ExampleDTO account : accountList) {
				%>
				<tr>
					<td><%=account.getAname()%></td>
					<td><%=account.getAmoney()%></td>
					<td><%=account.getAinout()%></td>
					<td><%=account.getUsedate().substring(0, 10)%></td>
					<td><%=account.getAout()%></td>
					<td><%=account.getAin()%></td>
					<td><input type="button" value="변경" onclick="updateAccount()"></td>
					<td><input type="button" value="삭제" onclick="removeAccount(<%=account.getNo()%>"></td>
				</tr>
				<%} %>
				<%} %>
			</table>
		</div>
		<hr>
<div id="footer">
	<button type="button" id="submitBtn" onclick="location.href='example_write.jsp'">&nbsp;&nbsp;&nbsp;추&nbsp;가&nbsp;&nbsp;&nbsp;</button>
	<button type="reset">다시작성</button>
</div>
</form>
<script type="text/javascript">
function removeAccount(no) {//deletestudent의 request 매개변수값으로 전달 -> deletestudent.jsp에서 삭제처리
	if(confirm("계좌정보를 정말로 삭제 하시겠습니까?")) {
		location.href="example_delete.jsp?no="+no;
	}
}
</script>s
</body>
</html>