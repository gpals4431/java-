<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%-- errorPage="4-1page_error.jsp" --%>
<%
	String text="ABCDEFG";
	//String text=null;
	
	//int su=10/0;
	
	if(request.getMethod().equals("GET")){
		//클라이언트에게 400에러코드 전달하여 응답
		response.sendError(HttpServletResponse.SC_BAD_REQUEST);
		return;
	}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>page Directive- errorPage 속성</h1>
	<hr>
	<p>문자열의 문자 갯수 = <%=text.length() %></p>
</body>
</html>