<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<style>
	.board_header {
		padding:30px;
		background-color:gray;
	}
	.board_header a:link, .board_header a:hover, .board_header a:visited{
		color:#FFF1DB;
	}
	.pHeader div {
		width:50%;
		float:left;
		padding:10px 0;
		background:#888;
		color:white;
	}
	.pHeader div:last-child {
		text-align:right;
	}
	.board_list li{
		float:left;
		width:10%;
		height:40px;
		line-height:40px;
		border-bottom:1px solid gray;
	}
	.board_list li:nth-child(5n+2) { /* 제목 */
		width:60%;
		white-space:nowrap; /* 줄바꿈 방지 */
		overflow:hidden; /* 넘친 문자 숨기기 */
		text-overflow:ellipsis; /* 넘친 문자가 나올 경우 말줄임표시 표기 */
	}
	.pagingDiv li{
		float:left;
		padding:10px 20px;
	}
	.pagingDiv a:link, .pagingDiv a:hover, .pagingDiv a:visited, 
	.board_list a:link, .board_list a:hover, .board_list a:visited{
		color:#000;
	}
	.searchDiv {
		clear:left;
		padding:10px;
		text-align:center;
	}
</style>
<script>
	$(function() {
		$("#searchForm").submit(function() {
			if($("#searchWord").val()=="") {
				alert("검색어를 입력하세요.");
				return false;
			}
			return true;
		});
	});
</script>
<div class="container">
	<h1>게시판 목록</h1>
	
	<div class="board_header"><a href="boardWrite">글쓰기</a></div>
	<div class="pHeader">
		<div>총레코드 수 : ${vo.totalRecord}</div>
		<div>${vo.nowPage}/${vo.totalPage}</div>
	</div>
	<ul class="board_list">
		<li>번호</li>
		<li>제목</li>
		<li>작성자</li>
		<li>조회수</li>
		<li>등록일</li>
		
		<c:forEach var="bDTO" items="${list }">
			<li>${bDTO.no }</li>
				<!-- 글내용보기 레코드번호, 현재페이지, 검색어가 있으면 검색키, 검색어를 가지고 뷰페이지로 이동하여야 다시 목록으로 해당 검색과 페이지로 이동할 수 있다. -->
			<li><a href="boardView?no=${bDTO.no}&nowPage=${vo.nowPage}<c:if test="${vo.searchWord!=null}">&searchKey=${vo.searchKey}&searchWord=${vo.searchWord}</c:if>">${bDTO.subject }</a></li>
			<li>${bDTO.username }</li>
			<li>${bDTO.hit }</li>
			<li>${bDTO.writedate }</li>
		</c:forEach>
	</ul>
	<!-- 페이징 -->
	<div class="pagingDiv">
		<ul>
			<!-- nowPage -->
			<c:if test="${vo.nowPage==1 }"> <!-- 현재페이지가 첫번째 페이지일 때 -->
				<li>prev</li>
			</c:if>
			<c:if test="${vo.nowPage>1 }"> <!-- 현재페이지가 첫번째 페이지가 아닐 때 -->
				<li><a href="boardList?nowPage=${vo.nowPage-1}<c:if test='${vo.searchWord!=null}'>&searchKey=${vo.searchKey}&searchWord=${vo.searchWord}</c:if>">prev</a></li>
			</c:if>
			<!-- 페이지 번호 -->
			<c:forEach var="p" begin="${vo.startPageNum }" end="${vo.startPageNum+vo.onePageNumCount-1 }">
				<c:if test="${p <= vo.totalPage }"> <!-- 표시할 페이지 번호가 총 페이지수보다 작거나 같을 때는 페이지번호를 출력한다 -->
					<!-- 현재 페이지 표시하기 -->
					<c:if test="${p==vo.nowPage }">
						<li style="background:gray">
					</c:if>
					<c:if test="${p!=vo.nowPage }">
						<li>
					</c:if>
					<a href="boardList?nowPage=${p}<c:if test='${vo.searchWord!=null}'>&searchKey=${vo.searchKey}&searchWord=${vo.searchWord}</c:if>">${p}</a></li>
				</c:if>
			</c:forEach>
			<!-- 다음페이지 -->
			<c:if test="${vo.nowPage < vo.totalPage }"> <!-- 다음페이지가 있을 때 -->	
				<li><a href="boardList?nowPage=${vo.nowPage+1}<c:if test='${vo.searchWord!=null}'>&searchKey=${vo.searchKey}&searchWord=${vo.searchWord}</c:if>">next</a></li>
			</c:if>
			
			<c:if test="${vo.nowPage == vo.totalPage }"> <!-- 다음페이지가 없을 때(현재페이지가 마지막 페이지일 때) -->	
				<li>next</li>
			</c:if>
		</ul>
	</div>
	
	<!-- 검색 -->
	<div class="searchDiv">
		<form method="get" id="searchForm" action="boardList">
			<select name="searchKey">
				<option value="subject">제목</option>
				<option value="username">작성자</option>
				<option value="content">글내용</option>
			</select>
			<input type="text" name="searchWord" id="searchWord"/>
			<input type="submit" value="Search"/>
		</form>
	</div>
</div>



















