package xyz.itwill09.spring;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

//ëª¨ë¸ ê¸°ëŠ¥?„ ? œê³µí•˜ê¸? ?œ„?•œ ?´?˜?Š¤ - ?š”ì²? ì²˜ë¦¬ ?´?˜?Š¤ : Controller ?´?˜?Š¤
// => Spring ?”„? ˆ?„?›Œ?¬ ?¼?´ë¸ŒëŸ¬ë¦¬ì˜ Controller ?¸?„°?˜?´?Š¤ë¥? ?ƒ?†ë°›ì•„ ?‘?„±
// => ?´?¼?´?–¸?Š¸ê°? [/list.do]?˜ URL ì£¼ì†Œë¡? ?š”ì²??•œ ê²½ìš° ì»¨íŠ¸ë¡¤ëŸ¬?— ?˜?•´ ?‹¤?–‰?  ?š”ì²? ì²˜ë¦¬ ?´?˜?Š¤
public class ListController implements Controller {
	//?´?¼?´?–¸?Š¸ ?š”ì²??— ?˜?•´ ??™ ?˜¸ì¶œë˜?Š” ?š”ì²? ì²˜ë¦¬ ë©”ì†Œ?“œ
	// => ModelAndView ê°ì²´?— ?‘?‹µ ê´?? ¨ ? •ë³´ë?? ???¥?•˜?—¬ ë°˜í™˜
	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		//ModelAndView ê°ì²´ : ì²˜ë¦¬ê²°ê³¼ ë°? ë·°ì´ë¦?(ViewName)ë¥? ???¥?•˜ê¸? ?œ„?•œ ê°ì²´
		ModelAndView modelAndView=new ModelAndView();
		
		//?°?´?? ì²˜ë¦¬ - Service ?´?˜?Š¤?˜ ë©”ì†Œ?“œ ?˜¸ì¶?
		List<Product> productList=new ArrayList<Product>();
		productList.add(new Product(1000, "ì»´í“¨?„°"));
		productList.add(new Product(2000, "?…¸?Š¸ë¶?"));
		productList.add(new Product(3000, "?…Œë¸”ë¦¿"));
		
		//ModelAndView.addObject(String attributeName, Object attributeValue)
		// => ModelAndView ê°ì²´?— ì²˜ë¦¬ê²°ê³¼ë¥? ?†?„±ê°’ìœ¼ë¡? ???¥?•˜?Š” ë©”ì†Œ?“œ - Request Scope
		// => request.setAttribute() ë©”ì†Œ?“œ?? ?œ ?‚¬?•œ ê¸°ëŠ¥?„ ? œê³µí•˜?Š” ë©”ì†Œ?“œ
		modelAndView.addObject("productList", productList);
		
		//ModelAndView.setViewName(String viewName) : ModelAndView ê°ì²´?— ë·°ì´ë¦?(ViewName)?„ ???¥?•˜?Š” ë©”ì†Œ?“œ
		// => ì»¨íŠ¸ë¡¤ëŸ¬?— ?˜?•´ ë·°ì´ë¦„ì„ JSP ë¬¸ì„œë¡? ë³?ê²½í•˜?—¬ ?¬?›Œ?“œ ?´?™ - ?‘?‹µ ì²˜ë¦¬
		modelAndView.setViewName("product_list");
		
		return modelAndView;
	}

}
