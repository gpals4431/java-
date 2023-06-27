<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%--
템플릿 페이지를 구현한 JSP 문서
=> 클라이언트에 모든 요청에 대한 응답결과를 제공하는 JSP 문서페이지
=> 템플릿 페이지의 웹문서 몸체부에는 클라이언트 요청에의한 전달값을 이용하여 JSP문서의 실행
결과를 제공받아 포함
 --%>
<%	//1.경로가 null일 경우 내가 지정하고자하는 경로 지정
	String group = request.getParameter("group");
	if(group==null) group="main";
	
	String worker=request.getParameter("worker");
	if(worker==null) worker="main_page";
	
	//템플릿 페이지의 웹문서 몸체부에 포함된 jsp 경로
	String contentPath=group+"/"+worker+".jsp";//쇼핑몰 메인페이지로 이동
	
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.0/jquery.min.js"></script>
<link href="css/style.css" rel="stylesheet" type="text/css">
</head>
<body>
	<div id="header">
		<jsp:include page="header_main.jsp"></jsp:include>
	</div>
	<div id="content">
		<jsp:include page="<%= contentPath %>"></jsp:include>
		<!-- 템플릿 페이지의 웹문서 몸체부에 포함된 jsp 경로로 이동  -->
	</div>
	<div id="footer">
		<jsp:include page="footer.jsp"></jsp:include>
	</div>
</body>
</html>                    