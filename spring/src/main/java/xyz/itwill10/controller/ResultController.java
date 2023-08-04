package xyz.itwill10.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ResultController {
/*	@RequestMapping("/resultMav")
	public ModelAndView modelAndViewResult() {
		ModelAndView modelAndView =new ModelAndView("result_display");
		modelAndView.addObject("mavName","ȫ�浿");

		return modelAndView;*/
	
	@RequestMapping("/resultMav")
	public ModelAndView modelAndViewResult(ModelAndView modelAndView) {
		modelAndView.setViewName("result_display");
		modelAndView.addObject("mavName","ȫ�浿");
		return modelAndView;
		
	}
	
	@RequestMapping("/resultRequest")
	public String requestResult(HttpServletRequest request) {
		request.setAttribute("requestName", "�Ӳ���");
		return "result_display";
		
	}
	
	//���� �Ϲ����� ���
	@RequestMapping("/resultModel")
	public String modelResult(Model model) {
		model.addAttribute("modelName", "����ġ");
		return "result_display";
	}
}
