<%@page import="study.dao.joinDAO"%>
<%@page import="study.dto.joinDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% 
	request.setCharacterEncoding("utf-8");

	if(request.getMethod().equals("GET")){
		response.sendError(HttpServletResponse.SC_BAD_REQUEST);
		return;
	}
	
	String id=request.getParameter("id");
	String password=request.getParameter("password");
	
	joinDTO loginMember=joinDAO.getDAO().selectJoin(id, password);
	
	if(loginMember==null||!loginMember.getPassword().equals(password)){//로그인 실패
		session.setAttribute("message", "아이디 또는 비밀번호가 잘못입력되었습니다.");
		session.setAttribute("id", id);
		response.sendRedirect("login.jsp");
		return;
	}
	
	session.setAttribute("loginMember", joinDAO.getDAO().selectJoin(id, password));
	
	
%>