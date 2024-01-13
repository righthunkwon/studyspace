<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>목록</title>
</head>
<body>
	<h2>게시글 목록</h2>
	<hr>
	<table>
		<tr>
			<th>번호</th>
			<th>제목</th>
			<th>글쓴이</th>
			<th>조회수</th>
			<th>등록일</th>
		</tr>
		<c:forEach items="${list}" var="board">
			<tr>
				<td>${board.id }</td>
				<td>
					<a href="board?act=detail&id=${board.id }">${board.title }</a>
				</td>
				<td>${board.writer }</td>
				<td>${board.viewCnt }</td>
				<td>${board.regDate }</td>
			</tr>
		</c:forEach>
	</table>
	<a href="board?act=writeform">글 등록</a>
</body>
</html>