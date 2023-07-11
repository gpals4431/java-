<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- RSS 서비스를 제공하는 웹프로그램을 AJAX 기능으로 요청하여 실행결과를 응답받아
클라이언트에게 전달하여 응답하는 JSP 문서
RSS(Really Simple Syndication 또는 Rich Site Summary) : 블로그, 뉴스, 기업정보 등과 같이
자주 업데이트되는 사이트의 컨텐츠를 보다 쉽게 사용자에게 제공하기 위해 만들어진 서비스 -->
<!DOCTYPE html>
<html>
<head>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.0/jquery.min.js"></script>

<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>RSS Reader</h1>
	<hr>
	<div id="display"></div>

	<script type="text/javascript">
	$.ajax({
		tyep:"get",
		/*
		문제점: 현재 실행중인 웹프로그램과 동일한 서버의 웹프로그램은 AJAX 기능으로 요청하여
		실행결과를 응답받아 처리 가능하지만 다른 서버의 웹프로그램은 요청할 경우 에러(에러코드:0 - 요청자제가 안됨) 발생
		//url:"https://www.khan.co.kr/rss/rssdata/kh_sports.xml",
		
		해결법: 다른 서버의 웹프로그램을 프록시 기능으로 요청하여 응답하는 프로그램을 작성하여
		AJAX 기능으로 프록시 프로그램을 요청하여 실행결과를 응답받아 처리 가능 
		*/
		url: "rss_proxy.jsp",//proxy: 우회하다		
		
		dataType: "xml",//json은 대용량 데이터 안됨, 뉴스처럼 많은 것들은 xml로 전달
		success: function(xmlDoc) {
			var channelTitle=$(xmlDoc).find("channel").children("title").text();
			
			var html="<h2>"+channelTitle+"</h2>";
			html+="<ul>";
			$(xmlDoc).find("item").each(function() {
				var title=$(this).find("title").text();
				var link=$(this).find("link").text();
				var date;
				if($(this).find("pubDate").length!=0){/*다른 기사에서 date를 pubDate 이거를 쓴대여 그래서 저렇게 두개를 적어놓으면 다른 기사 받아서 사용가능*/
					var link=$(this).find("pubDate").text();
				}else{
					var link=$(this).find("dc\\:date").text();//:구분자 앞에 역슬래쉬(\) 반드시 2번 써야 제대로 읽어드림 -> 안쓰면 : 문자값으로 읽어드림
				}
				html+="<li><a href='"+link+"'>"+title+"["+date+"]</a></li>";
			});
			html+="</ul>";
			
			$("#display").html(html);

		}, 
		error: function(xhr) {
			alert("에러코드 = "+xhr.status);
		}
	});
	
	</script>
</body>
</html>