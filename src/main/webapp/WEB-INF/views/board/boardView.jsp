<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<style>
	.boardSubMenu {
		background:gray;
		padding:50px 0;
	}
	.boardSubMenu a:link, .boardSubMenu a:hover, .boardSubMenu a:visited{
		color:#FFF1DB;
	}
	#c_comment {
		width:50%;
		height:80px;
	}
	#commentList>li{
		padding:10px 0;
		border-bottom:2px solid #ddd;
	}
</style>
<script>
	function boardDel() {
		if(confirm("정말 삭제하시겠습니까?")) {
			location.href = "boardDel?no=${dto.no}&nowPage=${vo.nowPage}<c:if test="${vo.searchWord!=null}">&searchKey=${vo.searchKey}&searchWord=${vo.searchWord}</c:if>";
		}		
	}
	
	$(function() {
		// 댓글 등록
		$("#commentForm").submit(function() {
			// id가 commentForm인 곳에서 submit 이벤트가 발생했을 경우, 즉 댓글이 있을 경우 ajax가 실행되도록 한다.
			if($("#c_comment").val()=="") { // 댓글이 없을 경우
				alert("내용을 입력하세요.");
				return false;
			}
			// 댓글이 있을 경우
			// 폼의 컴퍼넌트의 데이터를 name 속성의 값과 value 속성의 값을 이용하여 쿼리문을 만들어준다.
			var query = $(this).serialize(); // no=123&c_comment=댓글내용
			$.ajax({
				url : "/campus/commentSend",
				data : query,
				type : "POST",
				success : function(result) {
					console.log(result);
					// 기존에 입력한 댓글 지우기
					$("#c_comment").val("");
					
					// 댓글 목록을 다시 불러오기
					
				}, 
				error : function(e) {
					console.log(e.responseText);
				}
			});
			return false; // form
		});
	});
</script>
<div class="container">
	<h1>글 내용 보기</h1>
	<ul id="view">
		<li>번호</li>
		<li>${dto.no }</li>
		<li>작성자</li>
		<li>${dto.username }</li>
		<li>조회수</li>
		<li>${dto.hit }</li>
		<li>등록일</li>
		<li>${dto.writedate }</li>
		<li>제목</li>
		<li>${dto.subject}</li>
		<li>글내용</li>
		<li>${dto.content}</li>
	</ul>
	
	<div class="boardSubMenu">
		<a href="boardList?nowPage=${vo.nowPage }<c:if test="${vo.searchWord!=null }">&searchKey=${vo.searchKey }&searchWord=${vo.searchWord }</c:if>">글목록</a>
		<c:if test="${logId==dto.userid}">
			<a href="boardEdit?no=${dto.no }&nowPage=${vo.nowPage }<c:if test="${vo.searchWord!=null}">&searchKey=${vo.searchKey}&searchWord=${vo.searchWord}</c:if>">수정</a>
			<a href="javascript:boardDel()">삭제</a>
		</c:if>
	</div>
	
	<!-- 댓글 -->
	<hr/>
	<div>
		<c:if test="${logStatus=='Y' }"> <!-- 로그인한 경우 -->
			<form method="post" id="commentForm">
				<input type="hidden" name="no" value="${dto.no }"/> <!-- 원글 글번호 -->
				<textarea name="c_comment" id="c_comment"></textarea>
				<button>댓글 등록</button>
			</form>
		</c:if>
		<ul id="commentList">
			<li>
				<b>kwon (2023-03-01 12:12:12)</b> 수정, 삭제
				<p> 코멘트<br/>
					여러줄
				</p>
			</li>
			<li>
				<b>kwon (2023-03-01 12:12:12)</b> 수정, 삭제			
				<p> 코멘트<br/>
					여러줄
				</p>
			</li>
		</ul>
	</div>
</div>