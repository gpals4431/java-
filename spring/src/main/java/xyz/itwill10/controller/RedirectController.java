package xyz.itwill10.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class RedirectController {
	@RequestMapping("/forward_move")
	public String forward(Model model) {
		// Model 객체를 사용하여 뷰(View)에게 제공할 객체를 속성값으로 저장 - Request Scope
		model.addAttribute("name", "홍길동");

		// 뷰를 생성하기 위한 뷰이름(ViewName) 반환
		// => Front Controller(DispatchServlet 클래스)는 제공받은 뷰이름을
		// InternalResourceViewResolver
		// 객체를 사용하여 JSP 문서로 변환하고 JSP 문서로 포워드 이동하여 응답 처리
		// 포워드 이동 : 서버 내부에서 현재 웹프로그램의 스레드를 다른 웹프로그램으로 이동하여 응답 처리
		// => 클라이언트의 요청 URL 주소는 변경되지 않으며 Request Scope 속성값을 객체로 제공받아 사용 가능
		return "display_forward";
	}

	@RequestMapping("/redirect_move")
	public String redirect() {
		return "display_redirect";
	}

	/*
	 * @RequestMapping("/redirect") public String redirect() { return
	 * "redirect:/redirect_move"; }
	 */
	/*
	 * @RequestMapping("/redirect") public String redirect(Model model){ //model 객체로
	 * 저장된 속성값은 리다이렉트 이동된 페이지의 요청 처리 메소드와 뷰에서 사용 불가능 //문자열만 가능 객체로 전달할때는 안됨
	 * model.addAttribute("name", "임꺽정"); return "redirect:/redirect_move"; }
	 */
	
	//요청처리 메소드의 매개변수에 RedirectAttributes 인터페이스에 매개변수를 선언하여 객체를 FrontController에게 제공
	@RequestMapping("/redirect")
	public String redirect(RedirectAttributes attributes){
		attributes.addFlashAttribute("name", "임꺽정");
		return "redirect:/redirect_move";
	}
}
