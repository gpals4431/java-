<%@page import="study.dao.joinDAO"%>
<%@page import="study.dto.joinDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
<<<<<<< HEAD

	//get방식으로 요청시 에러코드 전송
	if(request.getMethod().equals("GET")){
		response.sendRedirect("error_404.jsp");
		return;
	}
 	request.setCharacterEncoding("utf-8");

	String id=request.getParameter("id");
	String name=request.getParameter("name");
	String password=request.getParameter("password");
	
	joinDTO join=new joinDTO();
	join.setId(id);
	join.setName(name);
	join.setPassword(password);
	
	int rows =joinDAO.getDAO().insertJoin(join);
	
	if(rows>0){
	response.sendRedirect("main_join.jsp");
		
	}else{
	 	response.sendRedirect("join.jsp");
		session.setAttribute("message", "아이디 중복, 다른아이디 사용해주세요.");	
	}
		
	
=======
 	request.setCharacterEncoding("utf-8");

	//get방식으로 요청시 에러코드 전송
	if(request.getMethod().equals("GET")){
		response.sendError(HttpServletResponse.SC_BAD_REQUEST);
		response.sendRedirect("join.jsp");
		return;
	}

	String id=request.getParameter("id");
	String name=request.getParameter("name");
	String password=request.getParameter("password");
	
	joinDTO join=new joinDTO();
	join.setId(id);
	join.setName(name);
	join.setPassword(password);
	
	joinDAO.getDAO().insertJoin(join);
	
	response.sendRedirect("main.jsp");
>>>>>>> refs/remotes/origin/main
	
%>