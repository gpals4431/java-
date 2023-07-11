<%@page import="xyz.example.dto.ExampleDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String message=(String)session.getAttribute("message");
	if(message==null){//정상적인 요청
		message="";
	}else{
		session.removeAttribute("message");
	}
	
	ExampleDTO account = (ExampleDTO)session.getAttribute("account");
	if(account!=null){
		session.removeAttribute("account");
	}%>
<!DOCTYPE html>
<html>
<head>
<style type="text/css">
body{
	width:70%;
	margin: 0 auto;
	padding: 10px;
	border: 3px solid black;
	text-align: center;
	font-size: 1em;
		border-radius: 30px;
	
}
table{
	margin: 0 auto;
	border: 3px solid black;
	width: 700px
	table-layout: fixed;;
	border-collapse: collapse;
}
tr, th{
	border: 1px solid black;
	height: 30px;
	text-align: center;
	width:100px;
		border-radius: 30px;
	
}
tr, td{
	border: 1px solid black;
	height: 30px;
	text-align: center;
	width:100px;
	
	
}
#inout{
	text-align: center;
	margin: 0 auto;
	width:50px;
	padding: 30px;
	
}
table button{
	text-align: center;
	margin: 0 auto;
	width: 50px;
	height: 40px;
	background: black;
	color: white;
	background: black;
	color: white;
	font-weight: bold;
		border-radius: 30px;
	
}
button{
	text-align: center;
	margin: 3px;
	width: 70px;
	height: 30px;
	background: black;
	color: white;
	font-weight: bold;
	border-radius: 30px;
	
}

</style>
<meta charset="UTF-8">
<title>입력창</title>
</head>
<body>
<form name="writeForm">
<h1>사용내역</h1>
<hr>
	<table border="1">
		<tr>
			<th id="class">사용처</th>
			<td><input type="text" name="name" <% if(account!=null){ %> value="<%=account.getAname() %>"<%} %>>
			</td>
		</tr>
		<tr> <!--0이하면 0원으로 초기화  -->
			<th id="class">금액</th>
			<td><input type="number" name="money"></td>
		</tr>
		<tr>
			<th id="class">사용날짜</th>
			<td><input type="date" name="usedate"></td>
		</tr>
		<tr>
			<td colspan="2" id="inoutBtn" onclick="inoutCheck()">
			<button type="button" id="inBtn">입금</button>
			<button type="button" id="outBtn">출금</button></td>
		</tr>
		<tr>
			<td colspan="2" id="inout"><!-- 선택에 따라 뜰 수 잇도록 -->
			<select id="out" >
				<option value="eat">식사</option>
				<option value="traffic">교통비</option>
				<option value="life">생활</option>
				<option value="healthy">의료/건강</option>
				<option value="culture">문화/여가</option>
				<option value="home">주거/통신</option>
				<option value="invest">저금/투자</option>
			</select>
		
			<select id="in" >
				<option value="salary">급여</option>
				<option value="cash">용돈</option>
				<option value="bussiness">사업수익</option>
				<option value="plus">금융수익</option>
			</select>
			</td>
		</tr>
		</table>
	<br>
	<hr>
	<button type="button" id="insertBtn" onclick="submitCheck();">&nbsp;삽&nbsp;입&nbsp;</button><!-- 검증 필요 -->
	<button type="reset">다시작성</button>
	<button type="button" id="updateBtn">&nbsp;변&nbsp;경&nbsp;</button><!-- 검증 필요 -->
	</form>
	
	<script type="text/javascript">
	writeForm.name.focus();
	function submitCheck() {
		if(writeForm.name.value==""){
			alert("사용처를 입력해주세요.")
			writeForm.name.focus();
			return;
		}
		
			
		if(writeForm.money.value==""){
			alert("금액을 입력해주세요.")
			writeForm.money.focus();
			return;
		}
		
		var moneyReg=/[0-9]{100}/g;
		if(!moneyReg.test(writeForm.money.value)){
			alert("금액은 양수의 숫자로만 입력해주세요.");
			writeForm.money.focus();
			return;
		}
		
		
		if(writeForm.date.value==""){
			alert("사용날짜 입력해주세요.")
			writeForm.date.focus();
			return;
		}
		if(writeForm.name.value==""){
			alert("사용처를 입력해주세요.")
			writeForm.name.focus();
			return;
		}
		
		
		writeForm.method="post";
		writeForm.action="insertaccount.jsp";
		writeForm.submit();
		
	}
		
	
	
	</script>
</body>
</html>