<%@page import="xyz.example.dao.ExampleDAO"%>
<%@page import="xyz.example.dto.ExampleDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%//삽입을 눌렀을 때 실행하는 action 처리 jsp문서

	//jsp 문서 get방식으로 요청시 - 비정상적 요청
	if(request.getMethod().equals("GET")){
		session.setAttribute("message","비정상적인 요청입니다.");
		response.sendRedirect("example_write");
		return;
	}

	//post방식으로 요청시
	request.setCharacterEncoding("utf-8");
	
	//전달값을 반환받아 변수에 저장
	String aname = request.getParameter("aname");
	int amoney=Integer.parseInt(request.getParameter("amoney"));
	String ainout = request.getParameter("ainout");
	String usedate = request.getParameter("usedate");
	String aout = request.getParameter("aout");
	String ain = request.getParameter("ain");
	int num=Integer.parseInt(request.getParameter("num"));
	
	ExampleDTO account = new ExampleDTO();
	account.setAname(aname);
	account.setAmoney(amoney);
	account.setAinout(ainout);
	account.setUsedate(usedate);
	account.setAout(aout);
	account.setAin(ain);
	account.setNum(num);
	
			
	ExampleDAO.getDao().insertAccount(account);
	
	response.sendRedirect("example_write.jsp");
%>