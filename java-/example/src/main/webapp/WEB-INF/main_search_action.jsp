<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!-- 입금.출금에 따른 검색행 반환 -->

<%
//전달값 저장 
//검색대상 - 입/출금
	String search=request.getParameter("search");
	if(search==null){
		search="";
	}
//검색단어 - 검색창에 입력된 값 
	String keyword=request.getParameter("keyword");
	if(keyword==null){
		keyword="";
	}

%>
    
    