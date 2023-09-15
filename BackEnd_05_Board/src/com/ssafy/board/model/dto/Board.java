package com.ssafy.board.model.dto;

import java.util.Date;

// CRUD
// 게시글 등록 C, 회원가입
// 게시글 조회 R, 정보조회/로그인
// 게시글 수정 U, 수정
// 게시글 삭제 D, 탈퇴

public class Board {
	// 클래스 변수
	private static int no = 1;
	
	private int id; // 고유번호
	private String title; // 제목
	private String writer; // 작성자
	private String content; // 내용
	private String regDate; // 등록일
	private int viewCnt; // 조회수
	
	// 기본 생성자
	public Board() {
	}

	// 생성자
	// id, regDate, viewCnt는 자동으로 등록되므로 생성자의 인자에 포함하지 않는다.
	// 하지만 이러한 값들이 0 혹은 null일 경우 문제가 발생할 수 있기 때문에 이들을 별도로 처리해주어야 한다.
	public Board(String title, String writer, String content) {
		this.title = title;
		this.writer = writer;
		this.content = content;
		
		this.id = no++; // 클래스 변수 no를 활용하여 고유번호 등록
		this.regDate = new Date().toString(); // 현재 날짜 둥록
	}
	
	// Getter, Setter, toString
	public static int getNo() {
		return no;
	}

	public static void setNo(int no) {
		Board.no = no;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getRegDate() {
		return regDate;
	}

	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}

	public int getViewCnt() {
		return viewCnt;
	}

	public void setViewCnt(int viewCnt) {
		this.viewCnt = viewCnt;
	}

	@Override
	public String toString() {
		return "Board [id=" + id + ", title=" + title + ", writer=" + writer + ", content=" + content + ", regDate="
				+ regDate + ", viewCnt=" + viewCnt + "]";
	}
	
}
