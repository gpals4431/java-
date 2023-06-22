<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!-- 로그인 상태의 사용자에게 환영메세지를 전달하여 응답하는 jsp문서 -->
<!-- 비로그인 상태의 사용자인 경우 [login_form.jsp] 문서로 이동 -->

<%
/*session.setAttribute(String attributeName:클라이언트의 정보(JSESSIONID 쿠키)로 바인딩된 세션에 
매개변수로 전달된 속성명의 속성값(객체)을 반환하는 메소드
=> Object 객체로 반환되므로 반드시 명시적 객체 형변환을 사용
=> 속성명으로 저장된 속성값이 없는 경우 null 반환 
바인딩된 세션에서 권한 관련 정보가 저장된 객체를 반환받아 저장 */
	String loginId=(String)session.getAttribute("loginId");

	if(loginId==null){//세션에 반환받은 속성값(객체)가 없는 경우 - 비로그인 상태의 사용자
		response.sendRedirect("login_form.jsp");//세션 사용 이용 - 권한에 따른 페이지의 응답을 다르게 할 수 있도록 함		
	}
	
 %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>로그인 사용자 전용 페이지</h1>
	<hr>
	<p>로그인 사용자만 확인 가능한 내용입니다.</p>
	<p>로그인 사용자만 확인 가능한 내용입니다.</p>
	<p>로그인 사용자만 확인 가능한 내용입니다.</p>
	<p>로그인 사용자만 확인 가능한 내용입니다.</p>
	<p>로그인 사용자만 확인 가능한 내용입니다.</p>
	<p>로그인 사용자만 확인 가능한 내용입니다.</p>
	<p>로그인 사용자만 확인 가능한 내용입니다.</p>
	<p>로그인 사용자만 확인 가능한 내용입니다.</p>
</body>
</html>