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
	
	//@GetMapping("/method")//getmapping ������̼��� rest ��Ʈ�ѷ����� ���� ��� 
	@RequestMapping(value="/method", method = RequestMethod.GET)
	public String inputTwo() {
		return "method_input2";
	}
	
	//value ���� �����ϰ� �����ϴ� ���� ������ - ��û����� �ٸ����\/
	//post�� ���±׸� �̿��Ͽ� ��û, ����Ʈ�� �ּҸ� ���� �ٲٸ� get���
	@RequestMapping(value="/method", method = RequestMethod.POST)
	public String outputTwo(HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException {
		request.setCharacterEncoding("utf-8");
		String name= request.getParameter("name");
		request.setAttribute("name", name);
		return "method_output"; 
	}
}
