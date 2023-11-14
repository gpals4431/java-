package xyz.itwill09.mvc;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//컨트롤러(Controller) : ?��?��?��?��?��?�� 모든 ?���??�� 받아 URL 주소�? 분석?��?�� ?��?��?�� ?���? 처리 
//?��?��?��(Model)?�� 메소?���? ?��출하?�� ?��?��?��?��?��?�� ?���??�� 처리?���? JSP 문서(View)�? ?��?��?���? 
//?��?��?��?�� ?��?��처리 ?��?���? ?��로그?��?�� ?��름을 ?��?��?��?�� 기능 ?���? - ?��블릿(Servlet)?���? 구현

//컨트롤러 기능?�� ?��공하�? ?��?�� ?��블릿 ?��?��?��
// => ?��?��?��?��?��?�� 모든 ?���??�� 받아 처리?��?�� ?��?�� 진입?��?�� ?��?��?�� ?��?�� - Front Controller Pattern
// => [web.xml] ?��?��?��?�� ?��?��?���? ?��블릿(?��?��로그?��)?���? ?��록하�? ?��?��?��?��?��?�� 모든 ?���??�� 
//받아 처리?�� ?�� ?��?���? URL ?��?�� ?��?��
public class DispatcherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	//?��?��?��?��?��?�� ?���??�� 처리?���? ?��?�� ?��?�� ?��출되?�� 메소?���? ?��버라?��?�� ?��?��
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1.?��?��?��?��?��?�� ?���? URL 주소�? 분석?��?�� ?���??��보�?? 반환받아 ???��
		String requestURI=request.getRequestURI();
		String contextPath=request.getContextPath();
		String command=requestURI.substring(contextPath.length());
		
		//2.?��?��?��?��?��?�� ?���??��보�?? ?��?��?��?�� ?���? 처리 ?��?��?��(Model)?�� 객체�? ?��공받?�� 객체?��
		//메소?�� ?��출하?�� ?��?��?��?��?��?�� ?���??�� 처리?���? ?��?�� �??�� ?���?(View)�? 반환받아 ???��
		//?��?��?��?��?���? 참조�??���? ?��?��?���? ?��?��?��?��?���? ?��?��받�? 모든 ?��?��?��?��?��?�� 객체 ???�� �??��
		/*
		Controller controller=null;
		//?��?��?��?��?��?�� ?���??��보�?? 비교?��?�� ?���? 처리 ?��?��?��(Model)�? 객체�? ?��?��?��?�� ???��
		if(command.equals("/list.itwill")) {
			controller=new ListController();
		} else if(command.equals("/view.itwill")) {
			controller=new ViewController();
		}
		*/
		
		//HandlerMapping ?��?��?���? 객체 ?��?��
		// => HandlerMapping ?��?��?�� :?��?��?��?��?��?�� ?���??��보�? ?���? 처리 ?��?��?��?�� 객체�? ?��?��리로
		//???��?�� Map 객체�? ?��공하�? ?��?�� ?��?��?��
		HandlerMapping handlerMapping=new HandlerMapping();
		//HandlerMapping 객체?�� 메소?���? ?��출하?�� 매개�??��?�� ?��?��?�� ?���??��보에 ???�� ?���? 처리
		//?��?��?��?�� 객체�? 반환받아 ???��
		Controller controller=handlerMapping.getController(command);
		
		//?���? 처리 ?��?��?��?�� 메소?���? ?��출하?�� ?��?��?��?��?��?�� ?���??�� 처리?���? ?��?�� 처리?�� JSP
		//문서?�� ?���?(ViewName)?�� 반환받아 ???��
		String viewName=controller.handleRequest(request, response);
		
		//3.JSP 문서�? ?��?��?�� ?��?��?��?�� ?��?��?��?��?��?���? 처리결과�? ?��?��?��?���? 처리
		// => ?���? 처리 메소?��?�� 반환�?(ViewName)?�� ?��?��?��?�� JSP 문서?�� 경로�? ?��?��?��?�� ?��?��?�� ?��?��
		//ViewResolver ?��?��?���? 객체 ?��?��
		// => ViewResolver ?��?��?�� : ?���? 처리 메소?��?�� 반환�?(ViewName)?�� ?��?��?��?�� ?��?�� 처리?��
		//JSP 문서?�� 경로�? ?��?��?��?�� 반환?��?�� 메소?��
		ViewResolver viewResolver=new ViewResolver();
		String view=viewResolver.getView(viewName);//?��?��?�� JSP 문서?�� 경로�? 반환받아 ???��
		request.getRequestDispatcher(view).forward(request, response);//JSP 문서�? ?��?��?�� ?��?��
	}
}