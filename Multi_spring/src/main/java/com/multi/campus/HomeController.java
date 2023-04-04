package com.multi.campus;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller // annotation : Controller, RestController
public class HomeController {
	
	// Controller�� ������ �޾� �̸� View�� �Ѱ��ش�.
	
	// (1) localhost:9090/campus/
	@RequestMapping(value = "/", method = RequestMethod.GET) // get ��� ����(�����ּ�: /)
	public String home(Model model) { // Model �� Ȱ���Ͽ� ����
		model.addAttribute("num", 123);
		model.addAttribute("name", "�𵨵�����");
		return "home";
	}
	
	// (2) localhost:9090/campus/test?name=��
	// : request ��ü�� Ȱ���� ���
	@RequestMapping("/test") // get ��� ������ �ٸ� ����(�����ּ�: /test)
	public ModelAndView test(HttpServletRequest request) {
		String name = request.getParameter("name");
		System.out.println("test(�̸�):"+name);
		
		// ModelAndView : �����Ϳ� �� ������ ������ �Բ� ������ Ŭ����
		ModelAndView mav = new ModelAndView();
		
		// ������ ����
		mav.addObject("num", 456);
		mav.addObject("name", name);
		
		// �� ������ ����
		mav.setViewName("home");
		
		return mav;
	}
	
	// (3) localhost:9090/campus/test2?addr=�����
	// : �Ű������� �־��ִ� ���
	@RequestMapping("/test2") // get ��� ������ �� �ٸ� ����(�����ּ�: /test2)
	public ModelAndView test2(String addr) {
		System.out.println("test2(�ּ�):"+addr);
		
		// ���ο��� �ٸ� �������� �̵��ϴ� ���
		// (/test2 �� ó���� �� /test3 ���� �ּҷ� �̵��ϵ��� ����)
		ModelAndView mav = new ModelAndView();
		mav.addObject("num", 789);
		mav.addObject("name", "test2");
		// ������ �ٸ� ��Ʈ�ѷ��� �����ּ� �Է�(redirect:�ּ�)
		mav.setViewName("redirect:test3");
		return mav;
	}
	
	// (4) localhost:9090/campus/test3?num=100&name=������
	// : DTO�� Ȱ���ϴ� ���
	@RequestMapping("/test3") // get ��� ������ �� �ٸ� ����(�����ּ�: /test3)
	public String test3(TestDTO dto, Model model) { // DTO�� ����� ���� �޼ҵ� �̸��� �ٲ㵵 ���� ����(RequestMapping�� /test3�̾�� �Ѵ�).
		System.out.println("test3(����):"+(dto.getNum()+456000));
		System.out.println("test3(�̸�):"+(dto.getName()));
		System.out.println(dto.toString());
		model.addAttribute("num", 123456789);
		model.addAttribute("name", "test3");
		return "home";
	}
	
	// (5) localhost:9090/campus/test4?tel=010-1234-5678
	@GetMapping("/test4") // get ��� ������ �� �ٸ� ����(�����ּ�: /test4)
	// (����) @PostMapping("/test4") // post ��� ����
	public String test4(String tel) {
		System.out.println("test4(����ó):"+tel);
		return "home";
	}
	
}
