<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<style>
	#view li {
		border-bottom:1px solid gray;
		padding:5px 0;
	}
</style>
<script>
	const answerDelCheck = () =>{
		if(confirm('정말 삭제하시겠습니까?')) {
			location.href="/campus/answer/answerDelete?no=${dto.no}";
		}	
	}
</script>
<div class="container">
	<h1>답변 보기</h1>
	<ul id="view">
		<li>번호 : ${dto.no }</li>
		<li>작성자 : ${dto.userid }</li>
		<li>등록일 : ${dto.writedate }</li>
		<li>조회수 : ${dto.hit }</li>
		<li>제목</li>
		<li><b>${dto.title }</b></li>
		<li>글내용</li>
		<li>${dto.content }</li>
	</ul>
	<p>
		<!-- 로그인이 된 경우에 답변 작성 가능 -->
		<c:if test="${logStatus=='Y' }">
			<a href="answerReplyWrite/${dto.no }">답글쓰기</a>
		</c:if>
		<!-- 본인이 작성할 글일 때만 수정과 삭제 가능 -->
		<c:if test="${dto.userid==logId }">
			<a href="answerEdit/${dto.no}">수정</a>
			<a href="javascript:answerDelCheck()">삭제</a>
		</c:if>
	</p>
</div>