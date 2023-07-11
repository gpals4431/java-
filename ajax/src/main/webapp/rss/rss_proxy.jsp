<%@page import="org.apache.commons.httpclient.methods.GetMethod"%>
<%@page import="org.apache.commons.httpclient.HttpClient"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- 가상의 클라이언트(브라우저)를 이용하여 다른 서버의 웹프로그램을 요청하고 실행결과를 
응답받아 전달하는 jsp 문서 --%>
<%--
=> HttpClient 객체를 사용하여 프록시(Proxy)기능을 제공하는 웹프로그램 작성 
=> https://apache.org 사이트에서 필요한 라이브러리 파일을 다운로드받아 프로젝트에 빌드처리
=> commons-httpclient, codec, loggin.jar 빌드 처리
프록시 : 대신 요청받아서 조작없이 그대로 응답
--%>
<%
	//요청 웹프로그램의 url 주소 저장
	String url ="https://www.khan.co.kr/rss/rssdata/kh_sports.xml";
	
	//HttpClient객체 생성 - 가상의 브라우저 기능을 제공하기 위한 객체
	HttpClient client = new HttpClient();
	
	//GetMethod 객체 생성 - 가상의 브라우저를 사용하여 GET 방식으로 웹프로그램 요청하기 위한 객체
	//=>POSTMethod 객체 생성 - 가상의 브라우저를 사용하여 POST 방식으로 웹프로그램 요청하기 위한 객체
	GetMethod method = new GetMethod(url);
	
	try{
		//HttpClient.executeMethod(Method method): 가상의 브라우저를 사용하여 웹프로그램을 요청하는 메소드
		//=> 가상의 브라우저로 요청한 웹프로그램 실행에 대한 상태코드(SC - int)를 반환 
		int statusCode=client.executeMethod(method);
		
		//클라이언트에게 응답처리하기 위한 프록시 프로그램의 response 객체 초기화 - 자신이 가진 정보 없애기
		response.reset();
		
		//프록시 프로그램의 출력스트림(out 객체) 초기화
		out.clearBuffer();
		
		//프록시 프로그램을 요청한 클라이언트에게 상태코드 전달 - 프록시 중재자역할 전달만 하면됨 중간에 조작X
		response.setStatus(statusCode);//자신 코드 말고 다른서버의 상태코드로 응답
		
		if(statusCode==HttpServletResponse.SC_OK){//정상적인 실행결과를 응답받은 경우 - 상태코드:200
			//Method.getResponseBodyAsString():요청에대한 실행결과가 저장된 리스폰즈 메세지 몸체부의
			//결과값을 문자열로 반환하는 메소드
			//=> 결과값을 반환받아 원하는 문자형태(charset)으로 변경하여 저장
			String result = new String(method.getResponseBodyAsString().getBytes("8859_1"),"utf-8");
			
			//프록시 프로그램을 요청한 클라이언트에게 실행결과에 대한 문서형태(MimeType)를 전달
			response.setContentType("text/xml;charset=utf-8");
			
			//프록시 프로그램을 요청한 클라이언트에게 실행결과를 전달
			out.println(result);
		}
		
	}finally{
		//가상의 브라우저를 사용하여 접속된 웹서버의 연결 해제 
		//method.releaseConnection() : 웹 서버 접속을 해제하는 메소드
		if(method!=null)method.releaseConnection();
	}
	
%>