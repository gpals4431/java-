package xyz.itwill10.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class RedirectController {
	@RequestMapping("/forward_move")
	public String forward(Model model) {
		// Model ��ü�� ����Ͽ� ��(View)���� ������ ��ü�� �Ӽ������� ���� - Request Scope
		model.addAttribute("name", "ȫ�浿");

		// �並 �����ϱ� ���� ���̸�(ViewName) ��ȯ
		// => Front Controller(DispatchServlet Ŭ����)�� �������� ���̸���
		// InternalResourceViewResolver
		// ��ü�� ����Ͽ� JSP ������ ��ȯ�ϰ� JSP ������ ������ �̵��Ͽ� ���� ó��
		// ������ �̵� : ���� ���ο��� ���� �����α׷��� �����带 �ٸ� �����α׷����� �̵��Ͽ� ���� ó��
		// => Ŭ���̾�Ʈ�� ��û URL �ּҴ� ������� ������ Request Scope �Ӽ����� ��ü�� �����޾� ��� ����
		return "display_forward";
	}

	@RequestMapping("/redirect_move")
	public String redirect() {
		return "display_redirect";
	}

	/*
	 * @RequestMapping("/redirect") public String redirect() { return
	 * "redirect:/redirect_move"; }
	 */
	/*
	 * @RequestMapping("/redirect") public String redirect(Model model){ //model ��ü��
	 * ����� �Ӽ����� �����̷�Ʈ �̵��� �������� ��û ó�� �޼ҵ�� �信�� ��� �Ұ��� //���ڿ��� ���� ��ü�� �����Ҷ��� �ȵ�
	 * model.addAttribute("name", "�Ӳ���"); return "redirect:/redirect_move"; }
	 */
	
	//��ûó�� �޼ҵ��� �Ű������� RedirectAttributes �������̽��� �Ű������� �����Ͽ� ��ü�� FrontController���� ����
	@RequestMapping("/redirect")
	public String redirect(RedirectAttributes attributes){
		attributes.addFlashAttribute("name", "�Ӳ���");
		return "redirect:/redirect_move";
	}
}
