package xyz.itwill09.spring;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

//λͺ¨λΈ κΈ°λ₯? ? κ³΅νκΈ? ?? ?΄??€ - ?μ²? μ²λ¦¬ ?΄??€(Controller ?΄??€)
// => ?΄?Ό?΄?Έ?Έκ°? [/view.do]? URL μ£Όμλ‘? ?μ²?? κ²½μ° μ»¨νΈλ‘€λ¬? ??΄ ?€??  ?μ²? μ²λ¦¬ ?΄??€
public class ViewController implements Controller {
	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView modelAndView=new ModelAndView();
		modelAndView.addObject("product", new Product(4000,"?λ¦°ν°"));
		modelAndView.setViewName("product_view");
		return modelAndView;
	}
}
