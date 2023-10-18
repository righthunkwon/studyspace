<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 목록</title>
<%@ include file="../common/bootstrap.jsp" %>
</head>
<body>
	<div class="container">
		<h2>게시글 목록</h2>
		<hr>
		<table class="table text-center">
			<tr>
				<th>번호</th>
				<th>제목</th>
				<th>작성자</th>
				<th>조회수</th>
				<th>등록날짜</th>
			</tr>
			<c:forEach items="${list}" var="board">
				<tr>
					<td>${board.id}</td>
					<td><a href="detail?id=${board.id}">${board.title}</a></td>
					<td>${board.writer}</td>
					<td>${board.viewCnt}</td>
					<td>${board.regDate}</td>
				</tr>
			</c:forEach>
		</table>
		
		<!-- action -->
		<!-- action의 경로를 작성할 때는 사실 경로 전체를 기술하는 것이 명확하다. -->
		<!-- 부트스트랩은 class로 CSS의 디자인을 넣는다. 해당 코드에서는 부트스트랩을 이용하였다. -->
		<form action="search" method="GET" class="row">
			<!-- 부트스트랩은 화면을 12개의 구역으로 나누어 처리한다. -->
			<!-- 해당 파일에서는  2, 4, 2, 2, 1, 1로 구역을 여섯 개로 나누었다. -->
			<!-- 구역을 그리드로 나누기 위해서는 부모에 'row' 클래스를, 자식에 'col-구역크기'의 클래스를 부여한다. -->
		 	<div class="col-2">
		 		<label>검색기준</label>
		 		<!-- name 속성은  GET 혹은 POST 요칭 시 쿼리 스트링의 키로 들어간다. -->
		 		<!-- option 태그의 value 속성은  GET 혹은 POST 요청 시 서버에 쿼리 스트링의 값으로 들어간다. -->
		 		<!-- 반면, input 태그의 value 속성은  input 요소의 초깃값을 명시하며, 사용자가 직접 입력한 값이 쿼리 스트링의 값으로 들어간다. -->
		 		<select class="form-select" name="key">
		 			<option value="none">-</option>
		 			<option value="writer">작성자</option>
		 			<option value="title">제목</option>
		 			<option value="content">내용</option>
		 		</select>
		 	</div>
		 	<div class="col-5"> 
		 		<label>검색 내용</label>
		 		<input type="text" name="word" class="form-control">
		 	</div>
		 	<div class="col-2">
		 		<label>정렬 기준</label>
		 		<select class="form-select" name="orderBy">
		 			<option value="none">-</option>
		 			<option value="writer">작성자</option>
		 			<option value="title">제목</option>
		 			<option value="view_cnt">조회수</option>
		 		</select>
		 	</div>
		 	<div class="col-2">
		 	<label>정렬 방향</label>
		 		<select class="form-select" name="orderByDir">
		 			<option value="asc">오름차순</option>
		 			<option value="desc">내림차순</option>
		 		</select>
		 	</div>
		 	<div class="col-1">
		 		<input type="submit" value="검색" class="btn btn-primary mt-4">
		 	</div>
		</form>
		<div class="d-flex justify-content-end mt-2">
			<a href="writeform"class="btn btn-warning">새 글 등록</a>
		</div>
	</div>
</body>
</html>