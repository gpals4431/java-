<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- [songs_two.jsp]문서를 AJAX기능으로 요청하여 실행결과를 json데이터로 응답받아 태그를 변경하여 
클라이언트에게 전달하는 JSP문서 - jQuery 라이브러리의 AJAX 관련 메소드 사용 --%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.0/jquery.min.js"></script>
</head>
<body>
	<h1>jQuery AJAX</h1>
	<hr>
	<h2>(음원차트&nbsp;<span id="now"></span>&nbsp;현재기준)</h2>
	<div id="songList"></div>
	
	<script type="text/javascript">
	$.ajax({
		type: "get",
		url: "songs_two.jsp",
		dataType: "json",
		success: function(obj) {
			$("#now").html(obj.now);
			
			var html="<ol>";
			$(obj.songs).each(function () {
				html+="<li><b>"+this.title+"</b>["+this.singer+"]</li>";
			});
			
			html+="</ol>";
			$("#songList").html(html);
			
		},
		error: function (xhr) {
			alert("에러코드="+xhr.status);
		}

});
	
	</script>
</body>
</html>