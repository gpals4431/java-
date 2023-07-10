<%-- 
1. input 태그 입력값 받아 삽입 처리
1-1. 입력값 검증 처리 //ok
2. 입/출금 버튼 태그로 입력값 받으면 해당 카테고리만 보여지게 처리
3. 삽입버튼 눌렀을 때 sql에 삽입처리

1. input 태그 입력값 받아 변경 처리
2. 입/출금 버튼 태그로 입력값 받아 변경 처리
3. 드롭다운 박스를 이용하여 입력값 받아 변경 처리 
4. 삽입버튼 눌렀을 때 sql에 변경처리

1. reset 버튼으로 입력값 초기화 처리 //ok
 --%>


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
		
	String aout = "";
	String ain = "";
		
		
	}%>
<!DOCTYPE html>
<html>
<head>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.0/jquery.min.js"></script>
<link rel="stylesheet" type="text/css" href="../css/example_write.css">
<meta charset="UTF-8">
<title>입력창</title>
</head>
<body>
<form name="writeForm" action="example_write_action.jsp">
<h1>사용내역</h1>
<hr>
	<table border="1" class="clickinout">
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
			<td colspan="2">
			<button type="button" id="inBtn" name="ig">입금</button>
			<button type="button" id="outBtn" name="cg">출금</button></td>
		</tr>
		<tr>
			<td colspan="2" id="inout"><!-- 선택에 따라 뜰 수 잇도록 -->
			<label id="aout">출금 카테고리</label>
			<select name="aout" >
				<option value=""></option>
				<option value="eat">식사</option>
				<option value="traffic">교통비</option>
				<option value="life">생활</option>
				<option value="healthy">의료/건강</option>
				<option value="culture">문화/여가</option>
				<option value="home">주거/통신</option>
				<option value="invest">저금/투자</option>
			</select>
			<hr>
			<label id="ain">입금 카테고리</label>
			<select name="ain" >
				<option value=""></option>
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
	<div class="clickbtn">
	<button type="button" id="insertBtn" onclick="submitCheck();">&nbsp;삽&nbsp;입&nbsp;</button><!-- 검증 필요 -->
	<button type="reset">다시작성</button>
	<button type="button" id="updateBtn">&nbsp;변&nbsp;경&nbsp;</button><!-- 검증 필요 -->
	</div>
	</form>
	
	<script type="text/javascript">
writeForm.name.focus();
	/* function submitCheck() {
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
	 */
$("#inBtn").click(function() {
	if($("#aout").css("display")="none"){
	$("#ain").show();
	$("#aout").hide();
		
	}
});
$("#outBtn").click(function() {
	$("#aout").show();
	$("#ain").hide();
});
}
		
	
	
	</script>
</body>
</html>