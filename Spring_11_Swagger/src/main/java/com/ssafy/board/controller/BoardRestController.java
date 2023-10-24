package com.ssafy.board.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.board.model.dto.Board;
import com.ssafy.board.model.dto.SearchCondition;
import com.ssafy.board.model.service.BoardService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import springfox.documentation.annotations.ApiIgnore;

@RestController
@RequestMapping("/api") // 반복되는 경로 적용
@Api(tags="게시판 컨트롤러") // 
@CrossOrigin("*")
public class BoardRestController {

	@Autowired 
	private BoardService boardService;
	
	// REST API
	// REST란 HTTP URI를 통해 자원(Resource)을 명시하고,
	// HTTP Method(POST,GET,PUT/PATCH,DELETE)를 통해
	// 해당 자원에 대한 CRUD Operation을 적용하는 것을 의미한다.

	// REST API는 기존과 달리 페이지가 아니라 데이터를 보낸다.
	// URI + HttpMethod(GET/POST/PUT/DELETE)
	
	
	// CRUD
	// 1.목록		: GET + localhost:8080/ContextRoot/api/board
	// 2.상세보기	: GET + localhost:8080/ContextRoot/api/board/{id}
	// 3.등록		: POST + localhost:8080/ContextRoot/api/board
	// 4.삭제		: DELETE + localhost:8080/ContextRoot/api/board/{id}
	// 5.수정		: PUT + localhost:8080/ContextRoot/api/board, /board/{id} (둘 다 가능)
	
	// 1.목록
	// http://localhost:8080/ssafy/api/board
	// servlet-context.xml에서 db 경로 바꾸고 db 내 테이블 생성하기
	@GetMapping("/board")
	@ApiOperation(value="게시글 조회", notes="검색조건도 넣으면 같이 가져온다.")
	public ResponseEntity<?> list(){
		List<Board> list = boardService.getList(); // (1) 전체 조회
//		List<Board> list = boardService.search(condition); // (2) 검색 조건 반영한 조회
		
		// 검색 결과가 존재하지 않을 경우의 반환
		if(list == null || list.size() == 0) { // 단축평가
			return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
		}
		// 검색 결과가 존재할 경우의 반환
		return new ResponseEntity<List<Board>>(list, HttpStatus.OK);
	}
	
	// 2.상세보기
	// http://localhost:8080/ssafy/api/board/{id}
	@GetMapping("/board/{id}")
	public ResponseEntity<Board> detail(@PathVariable int id){
		// 현재 코드는 게시글 제목을 클릭해서 상세보기로 들어가면 문제가 없지만,
		// 주소창을 통해 접근하려고 하는 클라이언트가 있을 수도 있기 때문에 값을 보내지 않았을 때 별도로 처리를 해줘야 한다.
		Board board = boardService.getBoard(id);
		return new ResponseEntity<Board>(board, HttpStatus.OK);
	}
	
	// 3.등록
	// http://localhost:8080/ssafy/api/board
	// INSERT, UPDATE, DELETE는 행의 변환 개수를 반환하므로 이를 이용해서 오류 발생 시의 처리를 할 수 있다. 
	@PostMapping("/board")
	public ResponseEntity<Board> write(Board board){
		boardService.writeBoard(board);
		return new ResponseEntity<Board>(board, HttpStatus.CREATED);
	}
	
	// 4.삭제
	// http://localhost:8080/ssafy/api/board/{id}
	// INSERT, UPDATE, DELETE는 행의 변환 개수를 반환하므로 이를 이용해서 오류 발생 시의 처리를 할 수 있다. 
	// 현재 코드에서는 다른 사람도 요청 주소를 통해 내 글을 지워버릴수 있으므로 인터셉터를 활용하여 권한을 체크해야 한다.
	@DeleteMapping("/board/{id}")
	public ResponseEntity<Void> delete(@PathVariable int id){
		boardService.removeBoard(id);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
	// 5.수정
	// JSON 형태의 데이터 처리(@RequestBody)
	// http://localhost:8080/ssafy/api/board/{id}
	@ApiIgnore
	@PutMapping("/board")
	public ResponseEntity<Void> update(@RequestBody Board board){
		boardService.modifyBoard(board);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
	// 5. 수정
	// {id}를 추가한 수정
//	@PutMapping("/board/{id}")
//	public ResponseEntity<Void> update(@RequestBody Board board, @PathVariable int id){
//		board.setId(id);
//		boardService.modifyBoard(board);
//		return new ResponseEntity<Void>(HttpStatus.OK);
//	}
	
}
