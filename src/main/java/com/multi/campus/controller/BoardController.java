package com.multi.campus.controller;

import java.nio.charset.Charset;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.multi.campus.dto.BoardDTO;
import com.multi.campus.dto.PagingVO;
import com.multi.campus.service.BoardService;

// Controller : ��� ��� ��� �Ұ�, ��ũ��Ʈ �ʿ� �� jsp ������ ���� �� ����
// RestController : ����Ʈ�� �鿣�忡�� ����� �� �ִ� ��� ����, ��ȯ���� String���� �ϸ� �������� ���ϸ��� �ƴ϶� ������ �������� ó���Ѵ�
@RestController
@RequestMapping("/board") // ���� �� ��� �ּҿ� /board�� ���δ�.
public class BoardController {
	@Inject
	BoardService service;
	
	// �Խ��� ���
	@GetMapping("/boardList")
	public ModelAndView boardList(PagingVO vo) {
		ModelAndView mav = new ModelAndView();
		
		// �� ���ڵ� ��
		vo.setTotalRecord(service.totalRecord(vo));
		System.out.println(vo.toString());
		// DB ��ȸ
		// �ش� ������ ���ڵ� ����
		mav.addObject("list", service.pageSelect(vo));
		
		mav.addObject("vo", vo);
		mav.setViewName("board/boardList");
		return mav;
	}
	
	// �۾�����
	@GetMapping("/boardWrite")
	public ModelAndView boardWrite() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("board/boardWrite");
		return mav;
	}
	
	// �۾���(DB���)
	@PostMapping("/boardWriteOk")
	public ResponseEntity<String> boardWriteOk(BoardDTO dto, HttpServletRequest request) {
		dto.setIp(request.getRemoteAddr()); // ip
		dto.setUserid((String)request.getSession().getAttribute("logId")); // �α����� ���̵� ���ϱ�
		
		// �� ��� �� �����ϸ� ���� �߻�
		// �۵�� ����: location.href="boardList";
		// �۵�� ����: alert("�۵�Ͻ���"), history.back();
		String htmlTag = "<script>";
		try {
			int result = service.boardInsert(dto);
			htmlTag += "location.href='boardList'";
		} catch(Exception e) {
			htmlTag += "alert('�� ��Ͽ� �����߽��ϴ�');";
			htmlTag += "history.back();";
		}
		htmlTag += "</script>";
		
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(new MediaType("text", "html", Charset.forName("UTF-8")));
		headers.add("Content-Type", "text/html; charset=UTF-8");
		
		return new ResponseEntity<String>(htmlTag, headers, HttpStatus.OK);
	}
	// �۳��뺸��
	@GetMapping("/boardView")
	public ModelAndView boardView(int no, PagingVO vo) {
		
		// ��ȸ�� ����
		service.boardHitCount(no);
		
		
		BoardDTO dto = service.boardSelect(no);
		ModelAndView mav = new ModelAndView();
		mav.addObject("dto", dto); // ������ ���ڵ�
		mav.addObject("vo", vo); // ��������ȣ, �˻���, �˻�Ű
		mav.setViewName("board/boardView");
		return mav;
	}
	// ������
	@GetMapping("/boardEdit")
	public ModelAndView boardEdit(int no, PagingVO vo) {
		BoardDTO dto = service.boardEditSelect(no);
		
		String subject = dto.getSubject().replaceAll("\"","&quot;");
		subject.replaceAll("'","&#39;");
		dto.setSubject(subject);
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("dto", dto);
		mav.addObject("vo", vo);
		mav.setViewName("board/boardEdit");
		return mav;
	}
	// ����(DB update)
	@PostMapping("/boardEditOk")
	public ResponseEntity<String> boardEditOk(BoardDTO dto, PagingVO vo, HttpSession session) { 
		// �����ϱ� ���ؼ��� ���ڵ� ��ȣ�� �α��� ���̵� ��� ���ƾ� �Ѵ�
		dto.setUserid((String)session.getAttribute("logId"));
		String bodyTag = "<script>";
		try {
			service.boardUpdate(dto);
			bodyTag += "location.href='boardView?no="+dto.getNo()+"&nowPage="+vo.getNowPage();
			if(vo.getSearchWord()!=null) { // �˻�� ���� ��
				bodyTag += "&searchKey="+vo.getSearchKey()+"&searchWord="+vo.getSearchWord();
			}
			bodyTag += "';";
		} catch (Exception e) {
			e.printStackTrace();
			bodyTag += "alert('�� ������ �����Ͽ����ϴ�.')";
			bodyTag += "history.back()";
		}
		bodyTag += "</script>";
		
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(new MediaType("text", "html", Charset.forName("UTF-8")));
		headers.add("Content-Type", "text/html; charset=UTF-8");
		
		ResponseEntity<String> entity = new ResponseEntity<String>(bodyTag, headers, HttpStatus.OK);
		return entity;
	}
	
	
	// ����
	@GetMapping("/boardDel")
	public ModelAndView boardDel(BoardDTO dto, PagingVO vo, HttpSession session) {
		dto.setUserid((String)session.getAttribute("logId"));
		int result = service.boardDelete(dto);
		ModelAndView mav = new ModelAndView();
		mav.addObject("nowPage", vo.getNowPage());
		if(vo.getSearchWord()!=null) {
			mav.addObject("searchKey", vo.getSearchKey());
			mav.addObject("searchWord", vo.getSearchWord());
		}
		if(result > 0) { // ���� ���� : ����Ʈ�� �̵�
			mav.setViewName("redirect:boardList");
		} else { // ���� ���� : �� ���뺸��� �̵�
			mav.addObject("no", dto.getNo());
			mav.setViewName("redirect:boardView");
		}
		return mav;
	}
	
	// ���� �� �� ���� ����
	@PostMapping("/boardMultiDel")
	public ModelAndView boardMultiDel(BoardDTO dto, PagingVO vo) {
		int result = service.boardMultiLineDelete(dto.getNoList()); // ����
		ModelAndView mav = new ModelAndView();
		mav.addObject("nowPage", vo.getNowPage());
		if(vo.getSearchWord()!=null && !vo.getSearchWord().equals("")) {
			mav.addObject("searchKey", vo.getSearchKey());
			mav.addObject("searchWord", vo.getSearchWord());
		}
		mav.setViewName("redirect:boardList");
		return mav;
	}
}
