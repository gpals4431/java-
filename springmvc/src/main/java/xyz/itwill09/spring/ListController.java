package xyz.itwill09.spring;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

//λͺ¨λΈ κΈ°λ₯? ? κ³΅νκΈ? ?? ?΄??€ - ?μ²? μ²λ¦¬ ?΄??€ : Controller ?΄??€
// => Spring ?? ???¬ ?Ό?΄λΈλ¬λ¦¬μ Controller ?Έ?°??΄?€λ₯? ??λ°μ ??±
// => ?΄?Ό?΄?Έ?Έκ°? [/list.do]? URL μ£Όμλ‘? ?μ²?? κ²½μ° μ»¨νΈλ‘€λ¬? ??΄ ?€??  ?μ²? μ²λ¦¬ ?΄??€
public class ListController implements Controller {
	//?΄?Ό?΄?Έ?Έ ?μ²?? ??΄ ?? ?ΈμΆλ? ?μ²? μ²λ¦¬ λ©μ?
	// => ModelAndView κ°μ²΄? ??΅ κ΄?? ¨ ? λ³΄λ?? ???₯??¬ λ°ν
	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		//ModelAndView κ°μ²΄ : μ²λ¦¬κ²°κ³Ό λ°? λ·°μ΄λ¦?(ViewName)λ₯? ???₯?κΈ? ?? κ°μ²΄
		ModelAndView modelAndView=new ModelAndView();
		
		//?°?΄?? μ²λ¦¬ - Service ?΄??€? λ©μ? ?ΈμΆ?
		List<Product> productList=new ArrayList<Product>();
		productList.add(new Product(1000, "μ»΄ν¨?°"));
		productList.add(new Product(2000, "?Έ?ΈλΆ?"));
		productList.add(new Product(3000, "?λΈλ¦Ώ"));
		
		//ModelAndView.addObject(String attributeName, Object attributeValue)
		// => ModelAndView κ°μ²΄? μ²λ¦¬κ²°κ³Όλ₯? ??±κ°μΌλ‘? ???₯?? λ©μ? - Request Scope
		// => request.setAttribute() λ©μ??? ? ?¬? κΈ°λ₯? ? κ³΅ν? λ©μ?
		modelAndView.addObject("productList", productList);
		
		//ModelAndView.setViewName(String viewName) : ModelAndView κ°μ²΄? λ·°μ΄λ¦?(ViewName)? ???₯?? λ©μ?
		// => μ»¨νΈλ‘€λ¬? ??΄ λ·°μ΄λ¦μ JSP λ¬Έμλ‘? λ³?κ²½ν?¬ ?¬?? ?΄? - ??΅ μ²λ¦¬
		modelAndView.setViewName("product_list");
		
		return modelAndView;
	}

}
