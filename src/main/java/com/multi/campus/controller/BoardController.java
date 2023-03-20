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

// Controller : 뷰단 언어 사용 불가, 스크립트 필요 시 jsp 파일을 생성 후 구현
// RestController : 프론트언어를 백엔드에서 기술할 수 있는 기능 제공, 반환형을 String으로 하면 뷰페이지 파일명이 아니라 컨텐츠 내용으로 처리한다
@RestController
@RequestMapping("/board") // 파일 내 모든 주소에 /board를 붙인다.
public class BoardController {
	@Inject
	BoardService service;
	
	// 게시판 목록
	@GetMapping("/boardList")
	public ModelAndView boardList(PagingVO vo) {
		ModelAndView mav = new ModelAndView();
		
		// 총 레코드 수
		vo.setTotalRecord(service.totalRecord(vo));
		System.out.println(vo.toString());
		// DB 조회
		// 해당 페이지 레코드 선택
		mav.addObject("list", service.pageSelect(vo));
		
		mav.addObject("vo", vo);
		mav.setViewName("board/boardList");
		return mav;
	}
	
	// 글쓰기폼
	@GetMapping("/boardWrite")
	public ModelAndView boardWrite() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("board/boardWrite");
		return mav;
	}
	
	// 글쓰기(DB등록)
	@PostMapping("/boardWriteOk")
	public ResponseEntity<String> boardWriteOk(BoardDTO dto, HttpServletRequest request) {
		dto.setIp(request.getRemoteAddr()); // ip
		dto.setUserid((String)request.getSession().getAttribute("logId")); // 로그인한 아이디 구하기
		
		// 글 등록 시 실패하면 예외 발생
		// 글등록 성공: location.href="boardList";
		// 글등록 실패: alert("글등록실패"), history.back();
		String htmlTag = "<script>";
		try {
			int result = service.boardInsert(dto);
			htmlTag += "location.href='boardList'";
		} catch(Exception e) {
			htmlTag += "alert('글 등록에 실패했습니다');";
			htmlTag += "history.back();";
		}
		htmlTag += "</script>";
		
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(new MediaType("text", "html", Charset.forName("UTF-8")));
		headers.add("Content-Type", "text/html; charset=UTF-8");
		
		return new ResponseEntity<String>(htmlTag, headers, HttpStatus.OK);
	}
	// 글내용보기
	@GetMapping("/boardView")
	public ModelAndView boardView(int no, PagingVO vo) {
		
		// 조회수 증가
		service.boardHitCount(no);
		
		
		BoardDTO dto = service.boardSelect(no);
		ModelAndView mav = new ModelAndView();
		mav.addObject("dto", dto); // 선택한 레코드
		mav.addObject("vo", vo); // 페이지번호, 검색어, 검색키
		mav.setViewName("board/boardView");
		return mav;
	}
	// 수정폼
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
	// 수정(DB update)
	@PostMapping("/boardEditOk")
	public ResponseEntity<String> boardEditOk(BoardDTO dto, PagingVO vo, HttpSession session) { 
		// 수정하기 위해서는 레코드 번호와 로그인 아이디 모두 같아야 한다
		dto.setUserid((String)session.getAttribute("logId"));
		String bodyTag = "<script>";
		try {
			service.boardUpdate(dto);
			bodyTag += "location.href='boardView?no="+dto.getNo()+"&nowPage="+vo.getNowPage();
			if(vo.getSearchWord()!=null) { // 검색어가 있을 때
				bodyTag += "&searchKey="+vo.getSearchKey()+"&searchWord="+vo.getSearchWord();
			}
			bodyTag += "';";
		} catch (Exception e) {
			e.printStackTrace();
			bodyTag += "alert('글 수정에 실패하였습니다.')";
			bodyTag += "history.back()";
		}
		bodyTag += "</script>";
		
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(new MediaType("text", "html", Charset.forName("UTF-8")));
		headers.add("Content-Type", "text/html; charset=UTF-8");
		
		ResponseEntity<String> entity = new ResponseEntity<String>(bodyTag, headers, HttpStatus.OK);
		return entity;
	}
	
	
	// 삭제
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
		if(result > 0) { // 삭제 성공 : 리스트로 이동
			mav.setViewName("redirect:boardList");
		} else { // 삭제 실패 : 글 내용보기로 이동
			mav.addObject("no", dto.getNo());
			mav.setViewName("redirect:boardView");
		}
		return mav;
	}
	
	// 여러 글 한 번에 삭제
	@PostMapping("/boardMultiDel")
	public ModelAndView boardMultiDel(BoardDTO dto, PagingVO vo) {
		int result = service.boardMultiLineDelete(dto.getNoList()); // 삭제
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
