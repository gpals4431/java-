package xyz.itwill.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//서블릿은 클라이언트 요청에 의해 WAS 프로그램에 등록된 서블릿 클래스를 읽어 메모리에 저장하고
//서블릿 클래스로 객체를 생성하여 요청 처리 메소드를 호출
//=> 클라이언트 요청에 의한 서블릿 객체가 이미 생성되어 있는 경우 새로운 서블릿 객체를 생성하지 않고
//기존 서블릿 객체를 사용하여 요청 처리 메소드 호출 - 최초 요청한 사용자가 있다면 그 서블릿 클래스를 객체로 만듬 이후는 요청에대한처리만 발생 - 메모리 낭비x
//=> WAS 프로그램이 종료되면 WAS 프로그램에 의해 생성되어 관리된 모든 서블릿 객체 소멸
//=> WAS 프로그램은 서블릿 객체를 관리하는 웹컨테이너 기능을 제공
//컨테이너 : 프로그램 실행에 필요한 객체의 생명주기(lifecycle : 객체 생성,사용,소멸 관리)를 관리하는 프로그램
//=> 서블릿=컴포넌트 : 컨테이너에 의해 관리되는 웹컴퍼넌트 
@WebServlet("/Life.itwill")
public class LifeCycleServlet_04 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private String name;//필드를 사용하는 이유 ? 모든 메소드가 사용하기 위해서->필드 초기화는 init()에서 처리를 권장
	
	//서블릿 클래스로 객체를 생성하기 위한 생성자 - 객체 생성시 실행된 명령 작성 - 초기화 처리
	public LifeCycleServlet_04() {
		//name="홍길동";
		System.out.println("### LifeCycleServlet 클래스의 객체 생성자 호출 ###");
	}
	
	//서블릿 객체가 생성된 후 WAS 프로그램에 의해 자동으로 한번만 호출되는 메소드
	//- 객체 생성후 실행된 명령 작성 - 초기화 처리
	//생성자 대신 init 메소드를 이용하여 초기화 처리 명령을 작성하는 이유??
	//=> init() 메소드는 매개변수로 ServletConfig 객체를 매개변수로 제공받아 사용 가능
	//ServletConfig 객체 : 웹자원을 생성하기 위한 환경설정 관련 정보를 저장한 객체 => xml에서 param등을 이용하여 작성할 수 잇음
	//=> [web.xml] 파일에서 제공되는 값을 얻어와 서블릿 클래스에서 사용 가능 - 유지보수의 효율성 증가
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		System.out.println("### LifeCycleServlet 클래스의 init() 메소드 호출 ###");
		//name="홍길동";
		
		//[web.xml] 파일의 context-param 엘리먼트로 제공되는 값 반환 
		//ServletConfig.getServletContext() : ServletContext 객체를 반환하는 메소드
		//ServletContext.getInitParameter(String name): [web.xml]파일에서 제공되는 값을 얻어와 반환하는 메소드
		name=config.getServletContext().getInitParameter("name");

 		
 		//[web.xml] 파일의 init-param 엘리먼트로 제공되는 값을 ServletConfig 객체의
 		//getInitParameter 메소드를 얻어와 반환 
 		
	}
	
	//서블릿 객체가 소멸되기 전에 WAS 프로극램에 의해 자동으로 1번만 호출되는 메소드
	//=> 객체 소멸 전 실행될 마무리 명령 작성 - 마무리 처리(별로 중요하지 않음)
	@Override
	public void destroy() {
		System.out.println("### LifeCycleSessrvlet 클래스의 destroy()메소드 호출 ###");
	}

		
	//클라이언트가 요청할때마다 WAS 프로그램에 의해 서블릿 객체로 반복 호출되는 메소드
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("### LifeCycleServlet 클래스의 service()메소드 호출 ###");
		
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out=response.getWriter();
		
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<meta charset='UTF-8'>");
		out.println("<title>Servlet</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h1>서블릿의 생명주기</h1>");
		out.println("<hr>");
		out.println("<p>"+name+"님, 안녕하세요.</p>");
		out.println("</body>");
		out.println("</html>");
	}
	
	


}
