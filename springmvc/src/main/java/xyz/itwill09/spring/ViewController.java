package xyz.itwill09.spring;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

//ëª¨ë¸ ê¸°ëŠ¥?„ ? œê³µí•˜ê¸? ?œ„?•œ ?´?˜?Š¤ - ?š”ì²? ì²˜ë¦¬ ?´?˜?Š¤(Controller ?´?˜?Š¤)
// => ?´?¼?´?–¸?Š¸ê°? [/view.do]?˜ URL ì£¼ì†Œë¡? ?š”ì²??•œ ê²½ìš° ì»¨íŠ¸ë¡¤ëŸ¬?— ?˜?•´ ?‹¤?–‰?  ?š”ì²? ì²˜ë¦¬ ?´?˜?Š¤
public class ViewController implements Controller {
	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView modelAndView=new ModelAndView();
		modelAndView.addObject("product", new Product(4000,"?”„ë¦°í„°"));
		modelAndView.setViewName("product_view");
		return modelAndView;
	}
}
