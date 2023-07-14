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
   
   joinDTO join =joinDAO.getDAO().selectJoin(id);
   
   if(join==null||!join.getPassword().equals(password)){
      System.out.print(join);
      session.setAttribute("message", "아이디와 비밀번호가 일치하지않습니다.");
      response.sendRedirect("login.jsp");
      return;
 
   }else{
 	  session.setAttribute("loginMember", joinDAO.getDAO().selectJoin(id));
 	  response.sendRedirect("main.jsp");
   }
   
%>