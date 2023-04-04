<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>board view</title>
<link rel="stylesheet" href="/webJSP/inc/style.css" type="text/css"/>
<script>
	function delQna() {
		if(confirm("해당 글을 삭제하시겠습니까?")) {
			location.href="<%=request.getContextPath()%>/board/boardDelOk.do?no=${boardDTO.no}";
		}		
	}
</script>
</head>
<body>
	<div class="container">
		<h1>글 내용 보기</h1>
		<c:if test="${boardDTO.no == 0 }">
			<p>해당 글은 존재하지 않습니다.</p>
		</c:if>
		
		<c:if test="${boardDTO.no > 0 }">
			<ul>
				<li>번호</li>
				<li>${boardDTO.no }</li>
				<li>작성자</li>
				<li>${boardDTO.userid }</li>
				<li>조회수</li>
				<li>${boardDTO.hit }</li>
				<li>등록일</li>
				<li>${boardDTO.writedate }</li>
				<li>제목</li>
				<li>${boardDTO.subject }</li>
				<li>글내용</li>
				<li>${boardDTO.content }</li>
			</ul>
			<p>
				<c:if test="${logId==boardDTO.userid }">
					<a href="<%=request.getContextPath() %>/board/boardEdit.do?no=${boardDTO.no }">수정</a>
					<a href="javascript:delQna()">삭제</a>
				</c:if>
			</p>
		</c:if>
	</div>
</body>
</html>