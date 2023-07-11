<%@page import="xyz.example.dao.ExampleDAO"%>
<%@page import="xyz.example.dto.ExampleDTO"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    

	
<%
	Date date = new Date();
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

	int totalAccount=ExampleDAO.getDao().searchCount(search, keyword);
			
	
	
	List<ExampleDTO> searchAccountList = ExampleDAO.getDao().searchAcoountList(search, keyword);
		

	
	
	String aout=(String)session.getAttribute("aout");
	String ain=(String)session.getAttribute("ain");
	
	if(aout==null||ain==null){
		aout="";
		ain="";
	}else{
		session.removeAttribute("aout");
		session.removeAttribute("ain");
	}
	 

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>가계부 프로그램</title>
<style type="text/css">
h2{
	text-align: center;
	padding: 20px;
	margin: 0 auto;
	font-weight: bold;
	font-size: 1.5em;
	background: black;
	color: white;
}
#content{
	text-align: center;
	padding: 10px;
	margin: 0 auto;
	font-size: 1em;
	border-radius: 30px;
	font-weight: bold;
	

}
#footer{
	text-align: center;
	padding: 10px;
	margin: 0 auto;
	
}
button{
	background: black;
	color: white;
	border-radius: 30px;
	font-weight: bold;
	font-size: 1.1em;

}

table{
	border: 1px solid black;
	width: 900px;
	margin: 0 auto;
}
tr th{
	background: black;
	color: white;
}
select{
	width: 60px;
	height: 30px;
}
</style>
</head>
<body>
<div id="header">
	<button></button>
	<h2><%=date.getMonth()+1%>월</h2>
</div>

<form method="post">
<div id="content">
	<select name="search">
		<option value="ain">입금</option>
		<option value="aout">출금</option>
	</select>
	<input type="text" name="keyword"  size="20" >
	<button type="submit" id="searchBtn">&nbsp;&nbsp;검색&nbsp;&nbsp;</button>
</div>
	<hr>
</form>
<form action="example_write.jsp" method="post">
<table border="1">
	<tr>
		<th width="150">사용처</th>
		<th  width="150">&nbsp;금&nbsp;액&nbsp;</th>
		<th  width="90">입/출금</th>
		<th  width="150">사용날짜</th>
		<th>출금내역</th>
		<th>입금내역</th>
		<th  width="60">&nbsp;삭&nbsp;제&nbsp;</th>
	</tr>
	
	<%if(totalAccount==0){ %>
	<tr>
		<td colspan="7" align="center">검색된 정보가 없습니다.</td>	
	</tr>
	
	<% }else{ %>
		<% for(ExampleDTO account :searchAccountList) { %>
		<tr>
		<td><%= account.getAname() %></td>
		<td><%= account.getAmoney() %></td>
		<td><%= account.getAinout() %></td>
		<td><%= account.getUsedate().substring(0,10) %></td>
		<td><%= account.getAout() %></td>
		<td><%= account.getAin()%></td>
		<td><input type="button" value="삭제" onclick="removeAccount(<%=account.getNum()%>)"></td>
		</tr>
		<%} %>
	<%} %>
</table>
	<hr>
<div id="footer">
	<button type="submit" id="submitBtn">&nbsp;&nbsp;&nbsp;입&nbsp;력&nbsp;&nbsp;&nbsp;</button>
	<button type="reset">다시작성</button>
</div>
</form>
<script type="text/javascript">
function removeAccount(no) {//deletestudent의 request 매개변수값으로 전달 -> deletestudent.jsp에서 삭제처리
	if(confirm("계좌정보를 정말로 삭제 하시겠습니까?")) {
		location.href="deleteAccount.jsp?no="+no;
	}
}


</script>
</body>
</html>