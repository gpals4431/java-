package xyz.itwill10.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ModelController {
	@RequestMapping("/display1")
	public String display1(Model model){
		model.addAttribute("name","홍길동");
		//model.addAttribute("now",new SimpleDateFormat("yyyy년 MM월 dd일 HH시 mm분 ss초").format(new Date()));
		return "model_display";
	}
	@RequestMapping("/display2")
	public String display2(Model model){
		model.addAttribute("name","임꺽정");
		//model.addAttribute("now",new SimpleDateFormat("yyyy년 MM월 dd일 HH시 mm분 ss초").format(new Date()));
		return "model_display";
	}
	@RequestMapping("/display3")
	public String display3(Model model){
		model.addAttribute("name","전우치");
		//model.addAttribute("now",new SimpleDateFormat("yyyy년 MM월 dd일 HH시 mm분 ss초").format(new Date()));
		return "model_display";
	}
	
	@ModelAttribute(value = "now") 
	public String getNow(){
		return new SimpleDateFormat("yyyy년 MM월 dd일 HH시 mm분 ss초").format(new Date()); 
	}
}
