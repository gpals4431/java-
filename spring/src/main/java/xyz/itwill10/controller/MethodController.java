package xyz.itwill10.controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MethodController {
	@RequestMapping("/method_input")
	public String inputOne() {
		return "method_input1";
	}
	
	@RequestMapping("/method_output")
	public String outputOne(HttpServletRequest request, HttpServletResponse response)
			throws IOException {
		if(request.getMethod().equals("GET")) {
			//response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED);
			response.sendRedirect("method_input");
			return null;
		}
		request.setCharacterEncoding("utf-8");
		String name= request.getParameter("name");
		request.setAttribute("name", name);
		return "method_output";
	}
	
	//@GetMapping("/method")//getmapping 어노테이션은 rest 컨트롤러에서 많이 사용 
	@RequestMapping(value="/method", method = RequestMethod.GET)
	public String inputTwo() {
		return "method_input2";
	}
	
	//value 값을 동일하게 설정하는 것을 권장함 - 요청방식이 다를경우\/
	//post는 폼태그를 이용하여 요청, 사이트의 주소를 직접 바꾸면 get방식
	@RequestMapping(value="/method", method = RequestMethod.POST)
	public String outputTwo(HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException {
		request.setCharacterEncoding("utf-8");
		String name= request.getParameter("name");
		request.setAttribute("name", name);
		return "method_output"; 
	}
}
