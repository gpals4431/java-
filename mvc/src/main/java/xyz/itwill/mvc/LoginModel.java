package xyz.itwill.mvc;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginModel implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ActionForward actionForward=new ActionForward();
		
		//클라이언트의 요청에 대한 명령을 실행하면서 발생되는 모든 예외를 처리하기 위한 기능 구현
		try {//예외 인위적으로 발생시킴
			//[login.do] GET 방식으로 요청 -> 폼태그로 post요청함 - 비정상적인 요청
			if(request.getMethod().equals("GET")) {
				throw new Exception();
			}
			
			//서블릿(컨트롤러) 요청시 전달값 받아서 저장 
			//=>서블릿(컨트롤러)의 request 객체를 요청 처리 메소드의 매개변수로 전달받아 사용
			String userid=request.getParameter("userid");
			String password=request.getParameter("password");
			
			//모델 클래스의 요청 처리 메소드에서는 Service 클래스의 객체로 메소드를 호출하여 
			//데이터 처리 관련 기능이 실행되도록 작성
			
			
		}catch(Exception e) {
			e.printStackTrace();//서버 콘솔에 예외가 발생한 예외정보 출력
			//[error.do]페이지로 리다이렉트 이동하기 위한 정보를 ActionForward 객체에 저장
			actionForward.setForward(false);
			actionForward.setPath(request.getContextPath()+"/error.do");
		}
		
		return actionForward;
	}

}
