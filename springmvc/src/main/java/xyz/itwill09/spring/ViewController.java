package xyz.itwill09.spring;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

//모델 기능?�� ?��공하�? ?��?�� ?��?��?�� - ?���? 처리 ?��?��?��(Controller ?��?��?��)
// => ?��?��?��?��?���? [/view.do]?�� URL 주소�? ?���??�� 경우 컨트롤러?�� ?��?�� ?��?��?�� ?���? 처리 ?��?��?��
public class ViewController implements Controller {
	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView modelAndView=new ModelAndView();
		modelAndView.addObject("product", new Product(4000,"?��린터"));
		modelAndView.setViewName("product_view");
		return modelAndView;
	}
}
