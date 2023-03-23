package com.multi.campus.controller;

import java.util.List;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.multi.campus.dto.RegisterDTO;
import com.multi.campus.dto.ZipcodeDTO;
import com.multi.campus.service.RegisterService;

@Controller
public class RegisterController {
	
	@Autowired
	RegisterService service;
	@Autowired
	JavaMailSenderImpl mailSender;
	
	// �α�����
	@GetMapping("/loginForm")
	public String login() {
		return "register/loginForm"; // WEB-INF/views/register/loginForm.jsp
	}
	
	// �α���(DB)
	@PostMapping("/loginOk")
	public ModelAndView loginOk(String userid, String userpwd, HttpServletRequest request, HttpSession session) {
		System.out.println("userid->"+userid);
		RegisterDTO dto = service.loginOk(userid, userpwd);
		// ���÷��ڵ尡 ���� ��� dto�� null�� �Ǿ� �α��ο� �����Ѵ�.
		// ���÷��ڵ尡 ���� ��쿡�� �α����� �����Ѵ�.
		ModelAndView mav = new ModelAndView();
		if(dto!=null) { // �α��� ����
			session.setAttribute("logId", dto.getUserid());
			session.setAttribute("logName", dto.getUsername());
			session.setAttribute("logStatus", "Y");
			mav.setViewName("redirect:/");
		} else { // �α��� ����
			mav.setViewName("redirect:loginForm");
		}
		return mav;
	}
	
	// �α׾ƿ�(���� ����)
	@RequestMapping("/logout")
	public ModelAndView logout(HttpSession session) {
		session.invalidate();
		ModelAndView mav = new ModelAndView();
		mav.setViewName("redirect:/");
		return mav;
	}
	
	// ȸ������ ��
	@GetMapping("/join")
	public String join() {
		return "register/join";
	}
	
	// ���̵� �ߺ��˻� ��
	@GetMapping("/idCheck")
	public String idCheck(String userid, Model model) {
		// DB ��ȸ -> ���̵��� ���� Ȯ��(0 �Ǵ� 1)
		int result = service.idCheckCount(userid);
		
		// �信�� ����ϱ� ���� �𵨿� ����
		model.addAttribute("userid", userid);
		model.addAttribute("result", result);
		
		return "register/idCheck";
	}
	
	// �����ȣ �˻�
	@RequestMapping(value="/zipcodeSearch", method=RequestMethod.GET)
	public ModelAndView zipcodeSearch(String doroname) {
		ModelAndView mav = new ModelAndView();
		// ������ �ּҰ� ������ return�� null
		List<ZipcodeDTO> zipList = null;
		if(doroname!=null) { 
			zipList = service.zipSearch(doroname);
		}
		mav.addObject("zipList", zipList);
		mav.setViewName("register/zipcodeSearch");
		return mav;
	}

	@RequestMapping(value="/joinOk", method=RequestMethod.POST)
	public ModelAndView joinOk(RegisterDTO dto) {
		System.out.println(dto.toString());
		ModelAndView mav = new ModelAndView();
		// ȸ������
		int result = service.registerInsert(dto);
		
		if(result>0) { // ȸ������ ���� �� : �α��� ������
			mav.setViewName("redirect:loginForm");
		} else { // ȸ������ ���� �� : history.back()(������ ���� ����), ȸ������ ������(���� �ʱ�ȭ)
			mav.addObject("msg", "ȸ�� ���Կ� �����Ͽ����ϴ�.");
			mav.setViewName("register/joinOkResult");
		}
		return mav;
	}
	
	// ȸ���������� �� - session �α��� ���̵� �ش��ϴ� ȸ�������� select�Ͽ� ���������� �̵�
	@GetMapping("/joinEdit")
	public ModelAndView joinEdit(HttpSession session) {
		RegisterDTO dto = service.registerEdit((String)session.getAttribute("logId"));
		ModelAndView mav = new ModelAndView();
		mav.addObject("dto", dto);
		mav.setViewName("register/joinEdit");
		return mav;
	}
	
	// ȸ����������(DB�۾�) - form�� ����� session�� �α��� ���̵� ���� ȸ�������� ����
	@PostMapping("/joinEditOk")
	public ModelAndView joinEditOk(RegisterDTO dto, HttpSession session) {
		dto.setUserid((String)session.getAttribute("logId"));
		int cnt = service.registerEditOk(dto);
		ModelAndView mav = new ModelAndView();
		if(cnt>0) { // ���������� : DB���� ������ ���� �����ֱ�
			mav.setViewName("redirect:joinEdit");
		} else { // �������н� : ���� ������ ���
			mav.addObject("msg", "ȸ�� ���� ������ �����Ͽ����ϴ�.");
			mav.setViewName("register/joinOkResult");
		}
		return mav;
	}
	
	// ���̵� ã��
	@GetMapping("/idSearchForm")
	public String idSearchForm() {
		return "register/idSearchForm";
	}
	
	@PostMapping("idSearchEmailSend")
	@ResponseBody
	public String idSearchEmailSend(RegisterDTO dto) {
		// �̸��� �̸����� ��ġ�ϴ� ȸ���� ���̵�
		String userid = service.idSearch(dto.getUsername(), dto.getEmail());
		
		// ���̵� ������ �̸� ajax�� �����ϰ�,	���̵� ������ DB�� ��ȸ�� ���̵� �̸��Ϸ� ������ �ȳ�
		if(userid==null || userid.equals("")) { // ���̵� ������
			return "N";
		} else { // ���̵� ������
			String emailSubject = "���̵� ã�� ���";
			String emailContent = "<div style='background:beige; margin:50px; padding:50px; ";
			emailContent += "border:2px solid beige; font-size:2em; text-align:center'>";
			emailContent += "�˻��� ���̵��Դϴ�.";
			emailContent += "���̵�: "+userid;
			emailContent += "</div>";
			

			try {
				// mimeMessage -> mimeMessageHelper
				MimeMessage message = mailSender.createMimeMessage();
				MimeMessageHelper messageHelper = new MimeMessageHelper(message, true, "UTF-8");
				
				// ������ �����ּ�
				messageHelper.setFrom("dhtmxk8134@naver.com");
				messageHelper.setTo("dhtmxk8135@gmail.com");
				messageHelper.setSubject(emailSubject);
				messageHelper.setText("text/html; charset=UTF-8", emailContent);
				
				mailSender.send(message);
				return "Y";
				
			} catch (MessagingException e) {
				e.printStackTrace();
				return "N";
			}
			

		}
	}
}
