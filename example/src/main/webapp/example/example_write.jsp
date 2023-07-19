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


<%@page import="xyz.example.dao.ExampleDAO"%>
<%@page import="xyz.example.dto.ExampleDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
String message = (String) session.getAttribute("message");
if (message == null) {//정상적인 요청
	message = "";
} else {
	session.removeAttribute("message");
}

ExampleDTO account = (ExampleDTO) session.getAttribute("account");
if (account != null) {
	session.removeAttribute("account");

	String aout = "";
	String ain = "";
	
	String search=request.getParameter("search");
	if(search==null){
		search="";
	}
	
	//입/출금 버튼의 값과 DTO를 가져와 삽입행의 갯수를 반환하는 DAO 메소드 호출
	int insertaccount=ExampleDAO.getDao().insertAccount(account, search);
			

}
%>
<!DOCTYPE html>
<html>
<head>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.0/jquery.min.js"></script>
<link rel="stylesheet" type="text/css" href="../css/example_write.css">
<meta charset="UTF-8">
<title>입력창</title>
<script type="text/javascript">
function submit(e) {
	writeForm.aname.focus();
		var aname=document.querySelector( '#aname').value;
		var amoney=document.querySelector( '#amoney').value;
		var usedate=document.querySelector('#usedate').value;
		
		if (aname=="") {
			document.querySelector('#message').innerHTML="사용처를 입력해주세요."
			writeForm.aname.focus();
			e.preventDefault();
		}
		
		else if (amoney=="") {
			document.querySelector('#message').innerHTML="금액을 입력해주세요."
			writeForm.amoney.focus();
			e.preventDefault();
		}


		else if (usedate=="") {
			document.querySelector('#message').innerHTML="사용날짜를 입력해주세요."
			writeForm.usedate.focus();
			e.preventDefault();
		}
		
		location.href="example_main.jsp";
	}
</script>
</head>
<body>
	<form name="writeForm" action="example_write_action.jsp" method="post">
		<h1>사용내역</h1>
		<hr>
		<table border="1" class="insertinfo">
			<tr>
				<th>사용처</th>
				<td><input type="text" name="aname" id="aname">
			</tr>
			<tr>
				<!--0이하면 0원으로 초기화  -->
				<th>금액</th>
				<td><input type="number" name="amoney" id="amoney" min="0">
			</tr>
			<tr>
				<th>사용날짜</th>
				<td><input type="date" name="usedate" id="usedate">
			</tr>
		</table>
	
	<!-- 	<div class="select-box">
			<input type="checkbox" id="inBtn" name="search" value="ain">입금
			<input type="checkbox" id="outBtn" name="search" value="aout">출금
		</div> 
 -->

		<!-- 버튼을 선택하면 search에 값이 저장 -->
		<div class="dropdown">
			<button type="button" class="dropbtn" id="aoutlistbtn" name ="search" value="출금">출금</button>
			<div class="dropdown-content" id="aoutlist">출금
				<select id="aoutList" name="aout">
					<option value="식사">식사</option>
					<option value="교통비">교통비</option>
					<option value="생활">생활</option>
					<option value="의료/건강">의료/건강</option>
					<option value="문화/여가">문화/여가</option>
					<option value="주거/통신">주거/통신</option>
					<option value="저금/투자">저금/투자</option>
				</select>
			</div>
		</div>
		<div class="dropdown">
			<button type="button" class="dropbtn" id="ainlistbtn" name="search" value="입금">입금</button>
			<div class="dropdown-content" id="ainlist">입금
				<select id="ainList" name="ain">
					<option value="급여">급여</option>
					<option value="용돈">용돈</option>
					<option value="사업수익">사업수익</option>
					<option value="금융수익">금융수익</option>
				</select>
			</div>
		</div>
		<p id="message" style="color: red"><%=message%></p>
		<br>
		<hr>
		<div class="clickbtn">
			<button type="button" id="insertBtn" onclick="submit()">&nbsp;삽&nbsp;입&nbsp;</button>
			<button type="reset">다시작성</button>
			<button type="button" id="updateBtn">&nbsp;변&nbsp;경&nbsp;</button>
		</div>
	</form>

	<script type="text/javascript">

	/* console.log(document.querySelectorAll("#aoutlist a"));
	
	let outlist = '식사';
	let inlist = '급여';
	
	document.querySelectorAll("#aoutlist a")
	.forEach((menu) => menu.addEventListener("click",function(){
		//1.버튼을 가져온다
		//2. 버튼에 값을 바꾼다
		document.getElementById("aoutlistbtn").textContext=this.textContent;
		//3. 선택된 값을 변수에 저장한다
		outlist=this.textContent;
		console.log("outlist 는 ",outlist);
		
	}));
	
	document.querySelectorAll("#ainlist a")
	.forEach((menu) => menu.addEventListener("click",function(){
		//1.버튼을 가져온다
		//2. 버튼에 값을 바꾼다
		document.getElementById("ainlistbtn").textContext=this.textContent;
		//3. 선택된 값을 변수에 저장한다
		inlist=this.textContent;
		console.log("inlist 는 ",inlist);
		
	}));
	
	 */
	 
	 
	
	
	</script>
</body>
</html>