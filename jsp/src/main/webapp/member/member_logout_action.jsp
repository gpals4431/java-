<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	//바인딩된 세션에서 권한 관련 정보의 속성값을 삭제처리 - 로그아웃 처리
	//session.removeAttribute("loginMember");
	session.invalidate();//장바구니까지 사라짐...
	
	response.sendRedirect(request.getContextPath() + "/index.jsp?group=member&worker=member_login");
%>