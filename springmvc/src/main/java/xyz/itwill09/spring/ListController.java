package xyz.itwill09.spring;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

//모델 기능?�� ?��공하�? ?��?�� ?��?��?�� - ?���? 처리 ?��?��?�� : Controller ?��?��?��
// => Spring ?��?��?��?��?�� ?��?��브러리의 Controller ?��?��?��?��?���? ?��?��받아 ?��?��
// => ?��?��?��?��?���? [/list.do]?�� URL 주소�? ?���??�� 경우 컨트롤러?�� ?��?�� ?��?��?�� ?���? 처리 ?��?��?��
public class ListController implements Controller {
	//?��?��?��?��?�� ?���??�� ?��?�� ?��?�� ?��출되?�� ?���? 처리 메소?��
	// => ModelAndView 객체?�� ?��?�� �??�� ?��보�?? ???��?��?�� 반환
	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		//ModelAndView 객체 : 처리결과 �? 뷰이�?(ViewName)�? ???��?���? ?��?�� 객체
		ModelAndView modelAndView=new ModelAndView();
		
		//?��?��?? 처리 - Service ?��?��?��?�� 메소?�� ?���?
		List<Product> productList=new ArrayList<Product>();
		productList.add(new Product(1000, "컴퓨?��"));
		productList.add(new Product(2000, "?��?���?"));
		productList.add(new Product(3000, "?��블릿"));
		
		//ModelAndView.addObject(String attributeName, Object attributeValue)
		// => ModelAndView 객체?�� 처리결과�? ?��?��값으�? ???��?��?�� 메소?�� - Request Scope
		// => request.setAttribute() 메소?��?? ?��?��?�� 기능?�� ?��공하?�� 메소?��
		modelAndView.addObject("productList", productList);
		
		//ModelAndView.setViewName(String viewName) : ModelAndView 객체?�� 뷰이�?(ViewName)?�� ???��?��?�� 메소?��
		// => 컨트롤러?�� ?��?�� 뷰이름을 JSP 문서�? �?경하?�� ?��?��?�� ?��?�� - ?��?�� 처리
		modelAndView.setViewName("product_list");
		
		return modelAndView;
	}

}
