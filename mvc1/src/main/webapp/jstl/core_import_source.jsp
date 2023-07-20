<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
   <!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Core - URL 관리 태그</h1>
	<hr>
	<p>core_import_source.jsp 문서의 응답 결과입니다.</p>
	
	<!-- import 태그 : 다른 웹프로그램을 요청하여 실행결과를 응답받아 포함하는 태그
	=> JSP의 include 액션 태그와 유사한 기능 제공
	url 속성: import 태그로 요청할 웹프로그램의 URL 주소를 속성값으로 설정
	var 속성: 웹프로그램의 응답결과를 저장하기 위한 스코프 객체의 속성명을 속성값으로 설정  -->
	<%-- <c:import url="http://www.khan.co.kr/rss/rssdata/kh_sports.xml"/> --%>
	
	<!-- import 태그에 하위태그로 param 태그외에 다른 코드가 존재할 경우 에러 발생 - JSP 주석 예외 -->
	<c:import url="core_import_target.jsp">
		<c:param name="name" value="홍길동"/>
	</c:import>
</body>
</html>