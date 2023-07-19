<%@page import="java.io.Console"%>
<%@page import="study.dao.joinDAO"%>
<%@page import="study.dto.joinDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%

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
	
	
	if(rows>0){//회원가입 성공시 메인페이지로 이동
		System.out.print("회원가입 성공");
		response.sendRedirect("main.jsp");
		
	}else{//아이디 중복체크가 안됨........
		System.out.print(rows);
	 	response.sendRedirect("join.jsp");
		session.setAttribute("message", "아이디 중복, 다른아이디 사용해주세요.");	
	}
		
%>