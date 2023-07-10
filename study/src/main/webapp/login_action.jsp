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
	
	if(loginMember.getPassword().equals(password)){
		response.sendRedirect("main.jsp");
		session.setAttribute("loginMember", loginMember);
	}else{
		response.sendRedirect("login.jsp");
		session.setAttribute("message", "아이디와 비번 불일치");
	}
	

%>