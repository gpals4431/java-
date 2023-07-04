<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>AJAX</title>
<style type="text/css">
#display {
	margin: 10px;
	font-size: 20px;
}
</style>
</head>
<body>

	<h1>브라우저 캐싱</h1>
	<hr>
	<div>
		클라이언트 플랫폼의 현재 날짜와 시간은 <span id="clientTime">2023년 7월 4일 12시 22분
			30 초</span>입니다.
	</div>
	<div>
		서버 플랫폼의 현재 날짜와 시간은 <span id="serverTime">2023년 7월 4일 12시 22분 30
			초</span>입니다.
	</div>

	<script type="text/javascript">
	//브라우저가 실행된 클라이언트 플랫폼의 현재 날짜와 시간을 제공받아 태그를 변경하는 함수
	// => 브라우저가 실행된 클라이언트에 따라 다른 결과 제공 가능
	function displayClientTime() {
		var now = new Date();
		var displayTime = now.getFullYear()+"년"+(now.getMonth()+1)+"월"+now.getDate()+"일"
			+now.getHours()+"시"+now.getMinutes()+"분"+now.getSeconds()+"초";
		
		document.getElementById("clientTime").innerHTML=displayTime;
	}
	
	displayClientTime();
	setInterval(displayClientTime, 1000);
	
	//웹프로그램을 실행하는 서버 플랫폼의 현재 날짜와 시간을 제공받아 태그를 변경하는 함수
	// => 서버 플랫폼의 날짜와 시간을 제공받아 사용하므로 모든 클라이언트에게 동일한 결과 제공
	// 문제점) 동일한 웹프로그램을 지속적으로 요청한 경우 브라우저 캐싱 기능에 의해 서버에서 
	//제공된 응답 결과가 아닌 기존 응답 결과를 재사용 - 최초 응답결과를 사용하여 응답 처리
	//예) img 파일을 불러들여서 출력 -> 임시저장소에 저장 후 필요할때 가져와서 사용 - 가독성 증가 , 좀 더 빠른 응답결과 제공
	//해결법-1) 요청 웹프로그램의 url 주소를 계속 바꿔줘야함 
	//해결법-1) 요청 웹프로그램에서 응답결과가 브라우징 캐싱 기능으로 사용되지 않도록 무효화 처리
function displayServerTime() {
		var xhr=new XMLHttpRequest();
		xhr.onreadystatechange=function() {
			if(xhr.readyState==4) {
				if(xhr.status==200) {
					document.getElementById("serverTime").innerHTML=xhr.responseText;
				} else {
					alert("에러코드 = "+xhr.status);
				}
			}
		}
		xhr.open("get", "clock_two.jsp");
		//xhr.open("get", "clock_two.jsp?dummy="+new Date().getTime());
		xhr.send(null);
	}
	
	displayServerTime();
	setInterval(displayServerTime, 1000);
	
</script>
</body>
</html>