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
	
	joinDTO member =joinDAO.getDAO().selectJoin(id);
	
	if(member==null||!member.getPassword().equals(password)){
		session.setAttribute("message", "아이디와 비밀번호가 일치하지않습니다.");
		session.setAttribute("id", id);
		response.sendRedirect("login.jsp");
		return;
	}
	
	session.setAttribute("loginMember", joinDAO.getDAO().selectJoin(id));
	
	
%>