package xyz.itwill10.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import xyz.itwill10.dto.Member;

@Controller
public class JoinController {
	@RequestMapping(value = "/join", method = RequestMethod.GET)
	public String join() {
		return "join_form";
	}

	/*
	 * @RequestMapping(value="/join", method = RequestMethod.POST) public String
	 * join(@RequestParam String id, @RequestParam String passwd ,@RequestParam
	 * String name, @RequestParam String email, Model model) {
	 * model.addAttribute("id", id); model.addAttribute("passwd", passwd);
	 * model.addAttribute("name", name); model.addAttribute("email", email); return
	 * "join_display"; }
	 * 
	 * 
	 * @RequestMapping(value="/join", method = RequestMethod.POST) public String
	 * join(@ModelAttribute("id") String id, @ModelAttribute("passwd") String passwd
	 * ,@ModelAttribute("name") String name, @ModelAttribute("email") String email)
	 * {
	 * 
	 * return "join_display"; }
	 */
	/*
	 * @RequestMapping(value="/join", method = RequestMethod.POST) public String
	 * join(@RequestParam String id, @RequestParam String passwd ,@RequestParam
	 * String name, @RequestParam String email, Model model) {
	 * 
	 * Member member= new Member(); member.setId(id); member.setName(name);
	 * member.setEmail(email); member.setPasswd(passwd);
	 * 
	 * //model.addAttribute("member", member); model.addAttribute(member); return
	 * "join_display"; }
	 */
	/*
	 * @RequestMapping(value="/join", method = RequestMethod.POST) public String
	 * join(@ModelAttribute("mem") Member member, Model model ) {
	 * if(member.getId().equals("abc123")) {
	 * model.addAttribute("message","이미 사용중인 아이디"); return "join_form"; } return
	 * "join_display";
	 * 
	 * }
	@RequestMapping(value = "/join", method = RequestMethod.POST)
	public String join(@RequestParam Map<String, String> map, Model model) {
		model.addAttribute("mem", map);
		return "join_display";

	}
	 */
	
	@RequestMapping(value="/same_param", method = RequestMethod.GET)
	public String input() {
		return "same_form";
		
	}
	@RequestMapping(value="/same_param", method = RequestMethod.POST)
	public String input(@RequestParam String[] food, Model model) {
		model.addAttribute("food", food);
		return "same_display";
		
	}

}
