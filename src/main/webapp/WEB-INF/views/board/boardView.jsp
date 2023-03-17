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
		// 댓글 목록 : ajax로 해당 게시물에 대한 모든 댓글을 선택하여 뷰에 표시
		function commentList() {
			$.ajax({
				url : "/campus/commentList",
				data : {
					no : ${dto.no}
				},
				type : "GET",
				dataType:"json",
				success : function(comment) {
					var tag = "";
					$(comment).each(function(i, cDTO) {
						tag += "<li><div><b>"+cDTO.userid+" ("+cDTO.writedate+")</b>";
						// 본인이 쓴 댓글일 때 수정과 삭제 버튼 표시
						// 클라이언트 단(javaScript, cDTO.userid)과 서버 단의 데이터(jstl, logId)를 일치시키기 위해 '' 표시
						if(cDTO.userid == '${logId}') { 
							tag += "<input type='button' value='수정'/>";
							tag += "<input type='button' value='삭제' title='"+cDTO.c_no+"'/>";
							tag += "<p>"+cDTO.c_comment+"</p></div>";
							// 댓글 수정폼 만들기 : 기존댓글, 댓글번호(c_no) 필요
							tag += "<div style='display:none'>";
							tag += "<form method='post'>";
							tag += "<input type='hidden' name='c_no' value='"+cDTO.c_no+"'/>"; // 댓글 일련번호
							tag += "<textarea name='c_comment' style='width:400px; height:80px;'>"+cDTO.c_comment+"</textarea>"; // 댓글 내용
							tag += "<input type='submit' value='댓글수정하기'>";
							tag += "</form>";
							tag += "</div>";
						} else { // 본인이 작성한 댓글이 아닐 때는 댓글 내용만 출력
							tag += "<p>"+cDTO.c_comment+"</p></div>";	
						}
						tag += "<li>";
					});
					$("#commentList").html(tag);
				},
				error : function(e) {
					console.log(e.responseText)
				}
			});
		}
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
					
					// 댓글 목록을 다시 불러오기(새 댓글 반영)
					commentList();
				}, 
				error : function(e) {
					console.log(e.responseText);
				}
			});
			return false
		});
		// 댓글 수정 폼 보여주기 : 본인이 쓴 글일때 edit 버튼을 클릭하면 글 내용은 숨기고 폼을 보여준다.
		$(document).on('click', '#commentList input[value=수정]', function() {
			// 기존 폼과 숨겨놓은 댓글 내용을 처리한다
			/* $("#commentList>li>div:nth-first").css('display', 'block');
			$("#commentList>li>div:nth-last").css('display', 'none'); */
			$(this).parent().css("display","none"); // 댓글을 숨기고
			$(this).parent().next().css("display", "block"); // 폼을 보여준다
		});
		// 댓글 수정 DB작업
		$(document).on('click', '#commentList input[value=댓글수정하기]', function() {
			// 데이터 준비
			var params = $(this).parent().serialize();
			var url = "/campus/commentEdit";
			
			$.ajax({
				url : url,
				data : params,
				type : "POST",
				success : function(result) {
					console.log(result);
					// 댓글 목록 다시 불러오기
					commentList();
				},
				error : function(e) {
					console.log(e.responseText);
				}
			});
			return false;
		});
		
		// 댓글 삭제
		$(document).on('click', '#commentList input[value=삭제]', function() {
			if(confirm('댓글을 삭제하시겠습니까?')) {
				var params = "c_no=" + $(this).attr("title");
				console.log(params);
				var url = "/campus/commentDelete";
				$.ajax({
					url : url,
					data : params,
					success : function(result) {
						console.log(result);
						commentList();
					}, 
					error : function(e) {
						console.log(e.responseText);
					}
				});
			}
		});

		// 댓글 목록 불러오기(처음 게시글에 들어올 때 실행)
		commentList();
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

		</ul>
	</div>
</div>