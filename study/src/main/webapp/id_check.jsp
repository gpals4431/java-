<%@page import="study.dao.joinDAO"%>
<%@page import="study.dto.joinDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	if(request.getParameter("id")==null){
		response.sendError(HttpServletResponse.SC_BAD_REQUEST);
		return;
	}
	
	String id= request.getParameter("id");
	
	joinDTO join=joinDAO.getDAO().selectJoin(id);

%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%if(join==null){ %>
	<div id="id">입력한 [<%=id %>] 는 사용가능합니다.</div>
	<br>
	<div>
		<button type="button" onclick="select();">아이디 사용</button>
	</div>
	<script type="text/javascript">
	function select() {
		idchekForm.id.value="<%=id%>";
		idcheckForm.idCheckResult.value="1";
	}
	
	</script>
	<%}else{ %>
<form action="#" id="idchekForm">
	<div id="id">입력한 [<%=id %>]는 이미 사용중입니다.
	<br>새로운 아이디를 입력해주세요.</div>
	<label>새로운 아이디</label>
	<input type="text" name="id"><span id="message" style="color:red;"></span>
	<button type="button" onclick="submit();">확인</button>
	<script type="text/javascript">
	function submit() {
		if(document.id.val()=""){
			document.getElementById("message").innerHTML="아이디를 입력해주세요."
			return;
		}
		var idReg=/^[a-zA-Z]\w{5,19}$/g;
		if(!idReg.test(id)){
			document.getElementById("message").innerHTML="아이디를 형식에 맞게 입력해주세요."
			return;
		}
	}
	
	</script>
	<%} %>
	</form>
</body>
</html>