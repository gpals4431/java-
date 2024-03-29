<%@page import="xyz.itwill.dto.AjaxCommentDTO"%>
<%@page import="xyz.itwill.util.Utility"%>
<%@page import="xyz.itwill.dao.AjaxCommentDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- 댓글정보를 전달받아 AJAX_COMMENT 테이블에 저장된 댓글정보로 삭제하고 실행결과를 JSON 데이타로 응답하는 JSP 문서 --%>
<%
	if(request.getMethod().equals("PUT")){
		response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED);
		return;
	}
	request.setCharacterEncoding("utf-8");
	
	int num=Integer.parseInt(request.getParameter("num"));
	
	int rows=AjaxCommentDAO.getDAO().deleteAjaxComment(num);

%>
<% if(rows>0){//삭제행이 있는 경우 %>
{"code":"success"}
<%}else{//삭제행이 없는 경우 %>
{"code":"error"}
<%} %>