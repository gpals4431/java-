<%@page import="study.dao.joinDAO"%>
<%@page import="study.dto.joinDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% 
	request.setCharacterEncoding("utf-8");

	if(request.getMethod().equals("GET")){
		response.sendError(HttpServletResponse.SC_BAD_REQUEST);
		response.sendRedirect("login.jsp");
		return;
	}
	
	String id=request.getParameter("id");
	String password=request.getParameter("password");
	
	joinDTO join=new joinDTO();
	join.setId(id);
	join.setPassword(password);
	
	joinDAO.getDAO().selectJoin(id);
	
	response.sendRedirect("main.jsp");

%>