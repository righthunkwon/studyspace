<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP 내장객체</title>
</head>
<body>
	JSP 기본 객체
	request			: 요청 정보를 저장하는 객체
	response		: 응답 정보를 저장하는 객체
	pageContext		: JSP 페이지 정보를 저장하는 객체
	session			: HTTP 세션 정보를 저장하는 객체
	application		: 웹 어플리케이션 context 정보를 저장하는 객체
	out				: 결과를 출력하기 위해 사용하는 스트림
	page			: JSP 페이지를 구현한 자바 클래스 인스턴스
	exception		: 에러페이지에서 사용, 오류 정보를 담는다.
	
	JSP의 기본 객체 영역(scope)
	Page - Request - Session - application 순으로 포함관계를 이루며 범위가 넓다.
	
	JSP의 기본 객체 영역의 메소드
	setAttribute		 
	getAttribute		 
	getAttributeNames	
	removeAttribute		
</body>
</html>