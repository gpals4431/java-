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

}
%>
<!DOCTYPE html>
<html>
<head>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.0/jquery.min.js"></script>
<link rel="stylesheet" type="text/css" href="../css/example_write.css">
<meta charset="UTF-8">
<title>입력창</title>
<style type="text/css">
/* Style The Dropdown Button */
.dropbtn {
  background-color: #4CAF50;
  color: white;
  padding: 16px;
  font-size: 16px;
  border: none;
  cursor: pointer;
}

/* The container <div> - needed to position the dropdown content */
.dropdown {
  position: relative;
  display: inline-block;
}

/* Dropdown Content (Hidden by Default) */
.dropdown-content {
  display: none;
  position: absolute;
  background-color: #f9f9f9;
  min-width: 160px;
  box-shadow: 0px 8px 16px 0px rgba(0,0,0,0.2);
  z-index: 1;
}

/* Links inside the dropdown */
.dropdown-content a {
  color: black;
  padding: 12px 16px;
  text-decoration: none;
  display: block;
}

/* Change color of dropdown links on hover */
.dropdown-content a:hover {background-color: #f1f1f1}

/* Show the dropdown menu on hover */
.dropdown:hover .dropdown-content {
  display: block;
}

/* Change the background color of the dropdown button when the dropdown content is shown */
.dropdown:hover .dropbtn {
  background-color: #3e8e41;
}
</style>
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
				<td><input type="number" name="amoney" id="amoney">
			</tr>
			<tr>
				<th>사용날짜</th>
				<td><input type="date" name="usedate" id="usedate">
			</tr>
		</table>
		<div class="select-box">
			<button type="button" id="inBtn" name="ain" value="ain">입금</button>
			<button type="button" id="outBtn" name="aout" value="aout">출금</button>
		</div>

		<div class="dropdown">
			<button class="dropbtn" id="aoutlistbtn">출금 카테고리</button>
			<div class="dropdown-content" id="aoutlist">
				<a href="#">식사</a>
				<a href="#">교통비</a>
			    <a href="#">생활</a>
			    <a href="#">의료/건강</a>
				<a href="#">문화/여가</a>
				<a href="#">주거/통신</a>
				<a href="#">저금/투자</a>
			</div>
		</div>
		<div class="dropdown">
			<button class="dropbtn" id="ainlistbtn">입금 카테고리</button>
			<div class="dropdown-content" id="ainlist">
				<a href="#">급여</a> 
				<a href="#">용돈</a> 
				<a href="#">생활</a> 
				<a href="#">사업수익</a> 
				<a href="#">금융수익</a>
			</div>
		</div>
		<p id="message" style="color: red"><%=message%></p>
		<br>
		<hr>
		<div class="clickbtn">
			<button type="button" id="insertBtn">&nbsp;삽&nbsp;입&nbsp;</button>
			<button type="reset">다시작성</button>
			<button type="button" id="updateBtn">&nbsp;변&nbsp;경&nbsp;</button>
		</div>
	</form>

	<script type="text/javascript">
	console.log(document.querySelectorAll("#aoutlist a"));
	
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
	</script>
	
	<script type="text/javascript">
	document.getElementById("insertBtn").onclick=function(e) {

		writeForm.aname.focus();
			var aname=document.querySelector( '#aname').value;
			var amoney=document.querySelector( '#amoney').value;
			var amoneyReg=/[0-9]{100}/g;
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

			else if	(!amoneyReg.test(amoney)) {
				document.querySelector('#message').innerHTML="금액은 양수로만 입력해주세요."
				writeForm.amoney.focus();
				e.preventDefault();
			}

			else if (usedate=="") {
				document.querySelector('#message').innerHTML="사용날짜를 입력해주세요."
				writeForm.usedate.focus();
				e.preventDefault();
			}
		}
	 */
	
	</script>
</body>
</html>