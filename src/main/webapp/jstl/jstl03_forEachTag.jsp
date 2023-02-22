<%@page import="java.util.HashMap"%>
<%@page import="com.multicampus.home.board.BoardDAO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>for each</title>
<link rel="stylesheet" href="/webJSP/inc/style.css" type="text/css"/>
</head>
<body>
	<div class="container">
		<h1>반복문 사용하기</h1>
		<h2>숫자를 이용하여 반복문 처리하기</h2>
			<c:set var="dan" value="${9 }"/>
			<!-- var(변수) begin(시작값) end(종료값) step(증감값, 생략시 1씩 증가) -->
			<c:forEach var="i" begin="1" end="9" step="1">
				${dan } * ${i } = ${dan*i }<br/>
			</c:forEach>
		
		<h2>배열을 이용하여 반복문 처리하기</h2>
		<!-- 배열이나 컬렉션일 경우 items를 활용한다! -->
			<%
				int arr[] = {90, 80, 70, 50, 62, 42, 61, 38};			
			%>
			<c:forEach var="n" items="<%=arr %>">
				[${n }],
			</c:forEach>
			
		<h2>List를 이용하여 반복문 처리하기</h2>
			<%
				List<String> nameList = new ArrayList<String>();
			
				nameList.add("권정훈");
				nameList.add("머스크");
				nameList.add("잡스");
			%>
			<c:forEach var="name" items="<%=nameList %>">
				[${name }],
			</c:forEach>
		<h2>게시판 목록을 가져오기</h2>
			<%
				BoardDAO dao = new BoardDAO();
			%>
			<ul>
			<c:forEach var="dto" items="<%=dao.boardAllRecord() %>">
				<li>${dto.no }, ${dto.subject }, ${dto.userid }, ${dto.writedate }, ${dto.hit }</li>
			</c:forEach>
			</ul>
		<h2>Map을 이용하여 반복문 처리하기</h2>
			<!-- key와 value -->
			<%
				HashMap<String, String> hm = new HashMap<String, String>();
				hm.put("name","권정훈");
				hm.put("tel","010-1111-1111");
				hm.put("addr","서울시 강남구");
			%>
			<!-- key와 value가 하나의 객체로 mapData 변수에 대입된다. -->
			<c:forEach var="mapData" items="<%=hm %>">
				<div>key : ${mapData.key }, value : %{mapData.value }</div>
			</c:forEach>
		<h2>(참고) DTO 클래스 이용하기 : BoardDTO boardSelect</h2>
			<c:set var="board" value="<%=dao.boardSelect(1) %>"/>
			<div>
				번호 : ${board.no }<br/>
				제목 : ${board.subject }<br/>
				날짜 : ${board.writedate }<br/>
			</div>
		<h2>자바스크립트에서 콘솔로 출력</h2>
			<script>
				console.log("<%=hm%>");
				console.log("<%=nameList%>");
				console.log("${board}");
			</script>
	</div>
</body>
</html>