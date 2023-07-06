<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- [books.jsp] 문서를 ajax 기능으로 요청하여 xml 데이터로 응답받아 태그로 변경하여
클라이언트에게 전달하여 응답하는 jsp 문서
=> xsl 문서를 사용하여 xml 데이터를 html 태그로 변환하여 응답 처리
=> [books.xsl]문서를 ajax 기능으로 요청하여 xslt를 응답받아 사용 --%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>교재목록</h1>
	<hr>
	<div id="books"></div>
	
	<script type="text/javascript">
	var xmlDoc=null;//XML 데이터를 저장하기위한 전역변수
	var xslDoc=null;//XSL 데이터를 저장하기위한 전역변수
	
	$.ajax({
		tyep:"get",
		url:"books.jsp",
		dataType: "xml",
		success: function (result) {
			xmlDoc=result;
			doXSLT();//XSL을 XML로 변환
		},
		error : function (xhr) {
			alert("에러코드 ="+xhr.status);
		}
	});
	
	$.ajax({
		tyep:"get",
		url:"books.xsl",
		dataType: "xml",
		success: function (result) {
			xslDoc=result;
			doXSLT();//XSL을 XML로 변환
		},
		error : function (xhr) {
			alert("에러코드 ="+xhr.status);
		}
	});
	
	//XSLT 데이터를 XML 데이터를 사용하여 HTML 태그로 변환하는 함수
	function doXSLT() {
		if(xmlDoc==null || xslDoc==null) return;//뭐가 뭔지 실행될지 모르지만 둘다 null이 아닐떄만 실행
		
		//xslProcessor 객체 생성 - XSLT 데이터를 사용하여 XML 데이터를 변환하기 위한 객체 
		var xslProcessor=new XSLTProcessor();
		
		//xslProcessor.importStylesheet(xslt) : xslProcessor 객체에 XSLT 데이터를 전달받아 저장하기 위한 메소드
		xslProcessor.importStylesheet(xslDoc);
		
		//xslProcessor.transformToFragment(xml, document) : XML 데이터를 전달받아 xslProcessor객체를
		//사용하여 document 객체의 자식 Element 객체로 변환하여 반환하는 메소드
		var fragment = xslProcessor.transformToFragment(xmlDoc, document);
		
		$("#books").append(fragment);
		
	}
	</script>
</body>
</html>