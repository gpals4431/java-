package xyz.itwill.mvc;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

//클라이언트가 [/logout.do]로 요청한 경우 객체로 생성될 모델 역활의 클래스
// => 로그아웃 처리 후 [/loginform.do] 페이지로 리다이렉트 이동하기 위한 정보가 저장된 ActionForward 객체 반환
public class LogoutModel implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session=request.getSession();
		//session.removeAttribute("loginUserinfo");//세션에 저장된 특정 값을 삭제
		session.invalidate();//세션을 삭제 세션에 속해있는 값도 삭제
		
		ActionForward actionForward=new ActionForward();
		actionForward.setForward(false);//리다이렉트 이동
		actionForward.setPath(request.getContextPath()+"/loginform.do");
		return actionForward;
	}

}
