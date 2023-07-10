package xyz.itwill.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.regex.Pattern;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.tools.DocumentationTool.Location;

//입력페이지(form.html)로 부터 전달받은 입력값(회원정보)을 반환받아 클라이언트에게 전달하여 응답하는 서블릿
//=> 입력페이지의 form태그를 이용하여 POST 방식으로 요청해야만 실행되는 서블릿
@WebServlet("/join.itwill")
public class JoinServlet_05 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();

		//서블릿을 GET방식으로 요청한 경우 비정상적인 요청으로 클라이언트에게 에러코드를
		//전달하거나 에러페이지로 이동되도록 처리
		//HttpServletRequest.getMethod() : 서블릿을 요청한 요청방식(GET / POST)을 반환하는 메소드
		if(request.getMethod().equals("GET")) {//서블릿을 비정상적(=GET 방식)으로 요청한 경우 - 정상적인 경우 : form 태그로 요청
			/*
			//HttpServletResponse.sendError(int sc) :클라이언트에게 에러코드(4xx 또는 5xx)를 전달하여 응답하는 메소드
			//=> 상태코드(Status Code)는 HttpServletResponse 인터페이스의 정의된 상수 사용이 권장됨
			//response.sendError(405);
			//response.sendError(HttpServletResponse.SC_BAD_REQUEST);//400
			response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED);//405
			return;
			*/
			
			//HttpServletResponse.sendRedirect(String url) : 클라이언트에게 301(=재요청) 상태코드와 url 주소를 전달하여 응답
			//=> 클라이언트는 전달받은 URL 주소로 브라우저의 요청 URL을 변경하여 재요청하여 실행결과를 응답받아 출력 - (중요!)페이지 이동(redirect 이동)
			//response.sendRedirect("error.html");//에러페이지로 이동
			//response.sendRedirect("form.html");//입력페이지로 이동
		
			//클라이언트에게 자바스크립트 전달하여 응답
			/* => 경고창을 이용하여 메세지 출력 후 입력페이지로 이동 처리 */
			out.println("<script type='text/javascript'>");
			out.println("alert('비정상적으로 페이지를 요청하였습니다");
			out.println("Location.href='form.html';");
			out.println("</script>");
		
			return;
		}
		
		// 서블릿을 요청할 때 전달된 값을 반환받아 저장
		// HttpServletRequest.getParameter(String name) : 매개변수로 전달된 이름의 전달값을 문자열로 반환하는 메소드
		//= 요청할때 전달된값을 주세요
		//=> 매개변수의 이름으로 전달값이 없는 경우 [null] 반환 
		
		//서블릿을 POST 방식으로 요청한 경우 사용자 입력값을 리퀘스트 메세지 몸체부에 저장하여 전달
		//=> 리퀘스트 메세지 몸체부에 저장되어 전달되는 값의 기본 문자형태가 서유럽어 ISO-8859-1문자형태로 반환받아 사용
		//=> 리퀘스트 메세지 몸체부에 저장되어 전달되는 값에 대한 캐릭터셋 변경
		//HttpServletRequest.setCharacterEncoding(String encoding):리퀘스트 몸체부에대한 문자형태를 변경하는 메소드
		//GET방식으로 요청한 경우 리퀘스트 몸체부를 사용하지 않으므로 메소드 사용할 필요없음
		request.setCharacterEncoding("utf-8");
		
		
		//서블릿을 요청할 때 전달된 값을 반환받아 저장
		//HttpServletRequest.getParameter(String name) : 매개변수로 전달받은 이름의 전달값을 
		//문자열(String 객체)로 반환하는 메소드
		// => 매개변수의 이름으로 전달된 값이 없는 경우 [null] 반환
		String id=request.getParameter("id");
		String passwd=request.getParameter("passwd");
		String name=request.getParameter("name");
		String email=request.getParameter("email");
		String gender=request.getParameter("gender");
		
		//동일한 이름으로 전달되는 다수의 값이 여러개 있는 경우 getParameterValues() 메소드 호출
		//String hobby=request.getParameter("hobby");//첫번째 전달값만 반환받아 저장
		//HttpServletRequest.getParameter("String name"): 매개변수로 전달받은 이름의 모든 전달값을
		//문자열 배열(String[])로 반환하는 메소드
		String[] hobby=request.getParameterValues("hobby");
		String job=request.getParameter("job");
		String profile=request.getParameter("profile");
		
		/*
		if(id==null||id.equals("")) {//전달값이 없는 경우
			return;
		}
		
		if(!Pattern.matches("^[a-zA-Z]\\w{5,19}$", id)) {
		//입력값 검증 중요!, 전달값이 정규표현식 패턴과 맞지 않은 경우 -> fomr.html에서도 했는데 또하는 이유는 보안때문에
			return;
		}
		*/
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<meta charset='UTF-8'>");
		out.println("<title>Servlet</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h1>회원가입 확인</h1>");
		out.println("<hr>");
		out.println("<p>아이디="+id+"</p>");
		out.println("<p>비밀번호="+passwd+"</p>");
		out.println("<p>이름="+name+"</p>");
		out.println("<p>이메일="+email+"</p>");
		out.println("<p>성별="+gender+"</p>");
		
		out.println("<p>취미=");
		for(int i=0;i<hobby.length;i++) {
			out.println(hobby[i]);//배열이라 일괄처리 필요, 배열의 요소값을 HTML 문서에 포함하여 응답
			if(i < hobby.length-1) {
				out.println(",");
			}
		}
		out.println("</p>");
		out.println("<p>직업="+job+"</p>");
		//엔터는 브라우저에 실행되지 않는 문자이므로 <br>태그로 변환
		out.println("<p>자기소개=<br>"+profile.replace("\n","<br>")+"</p>");
		out.println("</body>");
		out.println("</html>");
	}

}
