package xyz.itwill09.mvc;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//λͺ¨λΈ κΈ°λ₯? ? κ³΅νκΈ? ?? ?΄??€ - ?μ²? μ²λ¦¬ λ©μ?κ°? μΆμλ©μ?λ‘? ? ?Έ? ?Έ?°??΄?€λ₯? ??λ°μ ??±
// => ?΄?Ό?΄?Έ?Έκ°? [/view.itwill]? URL μ£Όμλ‘? ?μ²?? κ²½μ° μ»¨νΈλ‘€λ¬? ??΄ ?€??  ?μ²? μ²λ¦¬ ?΄??€
public class ViewController implements Controller {
	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Member member=new Member("test", "?Όμ§?λ§?", "??Έ? μ’λ‘κ΅?");
		request.setAttribute("member", member);
		return "member_view";
	}

}
