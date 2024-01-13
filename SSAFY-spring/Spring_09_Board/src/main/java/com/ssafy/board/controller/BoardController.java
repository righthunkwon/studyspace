package com.ssafy.board.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.ssafy.board.model.dto.Board;
import com.ssafy.board.model.dto.SearchCondition;
import com.ssafy.board.model.service.BoardService;

@Controller
public class BoardController {

	@Autowired 
	private BoardService boardService;
	
	@GetMapping("/")
	public String index() {
		// 현재 프로젝트에는 index.jsp 가 없어서 목록으로 redirect
		return "redirect:list";
	}
	
	@GetMapping("list")
	public String list(Model model) {
		List<Board> list = boardService.getList();
		model.addAttribute("list", list);
		return "/board/list";
	}
	
	@GetMapping("detail")
	public String detail(Model model, int id) {
		Board board = boardService.getBoard(id);
		model.addAttribute("board", board);
		return "/board/detail";
	}
	
	@GetMapping("writeform")
	public String writeform() {
		return "/board/writeform";
	}
	
	@PostMapping("write")
	public String write(Board board) {
		System.out.println("DB처리 이전 board: " + board);
		boardService.writeBoard(board);
		System.out.println("DB처리 이후 board: " + board);
		return "redirect:detail?id="+board.getId();
	}
	
	@GetMapping("updateform")
	public String updateform(Model model, int id) {
		// id에 일치하는 게시글 가져와 모델을 통해 폼으로 전송
		// 현재 구현된 코드로는 게시글을 하나 얻어오면 조회수가 증가하는 문제 발생
		model.addAttribute("board", boardService.getBoard(id));
		return "/board/updateform";
	}
	
	@PostMapping("update")
	public String update(Board board) {
		System.out.println(board);
		boardService.modifyBoard(board);
		return "redirect:detail?id="+board.getId();
	}
	
	@GetMapping("delete")
	public String delete(int id) {
		boardService.removeBoard(id);
		return "redirect:list";
	}

	@GetMapping("search")
	public String search(Model model, SearchCondition condition) {
		model.addAttribute("list", boardService.search(condition));
		return "/board/list";
	}
}
