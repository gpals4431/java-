<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
#display {
	width: 50%;
	padding: 5px;
	margin: 10px;
	font-size: 30px;
	border: 1px solid red;
}
</style>
</head>
<body>
	<h1>AJAX - 값 전달</h1>
	<hr>
	<div id="display">요청 웹프로그램에 대한 응답 결과</div>
	<div>
		이름: <input type="text" id="name">
		<button type="button" id="getBtn">GET 방식의 요청</button>
		<button type="button" id="postBtn">POST 방식의 요청</button>
	</div>
	
	<script type="text/javascript">
	//[get 방식의 요청] 태그를 클릭한 경우 호출되는 이벤트 처리 함수
	document.getElementById("getBtn").onclick= function() {
		//입력태그의 입력값을 반환받아 저장
		var name=document.getElementById("name").value;
		
		//입력값 검증
		if(name==""){
			document.getElementById("display").innerHTML="이름을 입력해주세요.";
			return;
		}
		
		//입력태그 초기화
		document.getElementById("name").value="";
		
		var xhr = new XMLHttpRequest();
		
		//XMLHttpRequest 객체의 준비상태가 변경될때마다 호출될 이벤트 처리함수 등록
		xhr.onreadystatechange=function() {
			if(xhr.readyState==4){//XMLHttpRequest 객체에 응답결과가 전달된 경우
				if(xhr.status==200){//XMLHttpRequest 응답결과에 대한 상태코드가[200]인 경우
					//XMLHttpRequest 응답결과(HTML)를 이용하여 페이지의 태그 변경
					document.getElementById("display").innerHTML=xhr.responseText
				}else{
					alert("에러코드 ="+xhr.status);
				}
			}
		}

		//XMLHttpRequest 객체를 이용하여 웹프로그램을 GET 방식으로 요청
		// => GET 방식으로 웹프로그램을 요청할 경우 질의문자열(QUERYSTRING)를 사용하여 값 전달
		//문제점)질의 문자열로 전달값에 url 주소로 표현 불가능한 문자가 존재할 경우 400 에러코드 발생 가능 
		/*쿼리스트링할 때 url 주소로 값을 전달하는 거잖아 
		url 주소는 영문자 숫자 특수문자를 이용하는데 한글 적음 (크롬은 상관없는데 다른 웹브로우저에서는 404에러 발생 가능)*/
		//해결법)전달값을 부호화처리하여 질의문자열로 전달
		name=encodeURIComponent(name);
		xhr.open("get","data_two.jsp?name="+name, true);
		//GET방식 요청시 아직 만들지않아서 -404에러 -> 반드시 data_two.jsp를 만들어줘야함
		xhr.send(null);
		
	}
	
	//[post 방식의 요청]태그를 클릭한 경우 호출되는 이벤트 처리 함수
	document.getElementById("postBtn").onclick= function() {
		//입력태그의 입력값을 반환받아 저장
		var name=document.getElementById("name").value;
		
		//입력값 검증
		if(name==""){
			document.getElementById("display").innerHTML="이름을 입력해주세요.";
			return;
		}
		
		//입력태그 초기화
		document.getElementById("name").value="";
		
		var xhr = new XMLHttpRequest();
		
		//XMLHttpRequest 객체의 준비상태가 변경될때마다 호출될 이벤트 처리함수 등록
		xhr.onreadystatechange=function() {
			if(xhr.readyState==4){//XMLHttpRequest 객체에 응답결과가 전달된 경우
				if(xhr.status==200){//XMLHttpRequest 응답결과에 대한 상태코드가[200]인 경우
					//XMLHttpRequest 응답결과(HTML)를 이용하여 페이지의 태그 변경
					document.getElementById("display").innerHTML=xhr.responseText
				}else{
					alert("에러코드 ="+xhr.status);
				}
			}
		}
		//XMLHttpRequest 객체를 이용하여 웹프로그램을 post 방식으로 요청
		//=> send()메소드의 매개변수를 이용하여 요청 웹프로그램에 값 전달
		//문제점) send() 메소드를 이용하여 값을 전달할 경우 [mulitipart/form-data]형식으로 값 전달
		//=> 요청 웹 프로그램에서 request.getParameter() 메소드로 전달값 반환 불가능
		//해결법) [application/x-www-form-urlencoded] 형식으로 값이 전달되도록 리퀘스트메세지의 헤더 정보 변경
		xhr.open("post","data_two.jsp");//매개변수에 전달값이 생략된 경우 자동으로 [true]로 처리
		
		//XMLHttpRequest.setRequestHeader(header, value) :XMLHttpRequest 객체를 이용하여 웹프로그램 요청시 리퀘스트
		//메세지의 헤어 정보를 변경하는 메소드
		//=> 리퀘스트 메세지 몸체부에 저장된 값이 문자데이터로 표현되도록 변경 설정
		//=> 반드시 open()메소드 호출 후 사용 가능
		xhr.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
		
		xhr.send("name="+name);//리퀘스트 메세지 몸체부에 값을 저장하여 전달
	}
	</script>
</body>
</html>