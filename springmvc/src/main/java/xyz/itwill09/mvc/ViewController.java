package xyz.itwill09.mvc;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//모델 기능?�� ?��공하�? ?��?�� ?��?��?�� - ?���? 처리 메소?���? 추상메소?���? ?��?��?�� ?��?��?��?��?���? ?��?��받아 ?��?��
// => ?��?��?��?��?���? [/view.itwill]?�� URL 주소�? ?���??�� 경우 컨트롤러?�� ?��?�� ?��?��?�� ?���? 처리 ?��?��?��
public class ViewController implements Controller {
	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Member member=new Member("test", "?���?�?", "?��?��?�� 종로�?");
		request.setAttribute("member", member);
		return "member_view";
	}

}
