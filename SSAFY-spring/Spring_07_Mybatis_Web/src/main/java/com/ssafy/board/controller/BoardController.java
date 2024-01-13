package com.ssafy.board.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.ssafy.board.model.dto.Board;
import com.ssafy.board.model.service.BoardService;

@Controller
public class BoardController {
	
	// DI (Dependency Injection, 의존성 주입)
	// 객체를 직접 생성(new)하는 게 아니라 외부에서 생성한 후 주입(setter)하는 방식
	// 의존성 주입을 통해 모듈 간의 결합도를 낮추고 유연성을 높일 수 있음(느슨한 결합 가능)
	
	// IoC (Inversion of Control, 제어의 역전)
	// 메소드나 객체의 호출작업을 개발자가 결정하는 것이 아니라 스프링에게 제어권을 넘겨 제어의 흐름을 처리
	
	// 기존의 객체 생성 및 실행 과정
	// (1) 객체 생성
	// (2) 의존성 객체 생성(new)
	// (3) 의존성 객체 메소드 호출
	
	// 스프링의 객체 생성 및 실행 과정
	// (1) 객체 생성
	// (2) 의존성 객체 주입(Bean Injection by Spring, IoC)
	// (3) 의존성 객체 메소드 호출
	
	// Java Bean
	// DTO, VO에 해당하는 클래스
	// 필드는 private으로 구성, getter & setter를 통해 필드에 접근
	
	// Spring Bean
	// 스프링 IoC 컨테이너가 관리하는 Java 객체
	// 컨테이너(ApplicationContext)에 의해 생명주기가 관리
	
	// Bean 등록 방법
	// 1. resources/application.xml에 직접 <bean id="" class="" />으로 각 빈을 등록
	// 2. resources/application.xml에 직접 <context:component-scan base-package="" />로 
	//    패키지를 등록 후, 패키지의 각 클래스에 어노테이션을 붙여서 빈을 등록
	// 	  (최상위 어노테이션:                  	  @Component), 
	//	  (Component의 하위 어노테이션: @Controller, @Service, @Repository) 
	// 3. Java Config (ApplicationConfig.java)
	// 4. Java Config & Component-scan
	// 5. Springboot
	
	// 요청과 응답의 흐름
	// 호출 : Web Browser → Controller → Service → Dao → DB 
	// 반환 : DB → Dao → Service → Controller → Web Browser
	
	// Service와 Dao의 차이
	// Service는 사용자 친화적으로 구현한다면(remove, write 등을 메소드명에 사용 - 사용자의 행위),
	// Dao는 데이터베이스 친화적으로 구현(메소드명에 select, update 등을 사용 - SQL 구문)
	// Dao는 단일 데이터의 접근 및 갱신을 처리
	// Service는 Dao를 호출하여 여러 번의 데이터 접근 및 갱신을 처리(Dao의 여러 메소드를 트랜잭션으로 묶어 처리)
	
	// @Autowired
	// 필요한 의존 객체의 타입에 해당하는 빈을 찾아 주입하는 어노테이션
	// 스프링 IoC 컨테이너에 등록한 빈에 의존 관계 주입이 필요할 때 의존성 주입을 도와주는 어노테이션

	// 스프링 컨테이너에 빈들을 모두 등록한 뒤 의존성 주입 단계가 이루어지는데 
	// 이때 @Autowiered 어노테이션이 부여된 메서드가 실행되며 필요한 인스턴스를 주입함
	// @Autowired는 생성자, 필드, 설정자(setter)라는 총 세 가지 방법으로 실현 가능
	
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
		boardService.writeBoard(board);
		return "redirect:list";
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
}
