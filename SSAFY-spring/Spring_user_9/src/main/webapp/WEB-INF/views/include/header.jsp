<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="com.ssafy.hw.model.dto.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<style>
#nav-header {
	display: flex;
	justify-content: space-between;
}
.nav-search{
	width:50%;	
}

.nav-search span {
	margin-left: 10px;
	border: solid black 1px;
	padding: 5px;
}

.nav-login
</style>
<div id="nav-header">
	<%-- session에서 loginUser를 가져와서 존재 여부에 따라 로그인 폼 또는 사용자 정보를 출력한다. --%>
	<div class="nav-search">
		<form action="search" method="get">
			<span>
				<label>검색 조건</label>
				<select name="key">
					<option value="none" selected>없음</option>
					<option value="id">아이디</option>
					<option value="name">이름</option>
					<option value="email">이메일</option>
				</select>
			</span>
			
			<span>
				<label>정렬 기준</label>
				<select name="orderBy">
					<option value="none" selected>없음</option>
					<option value="id">아이디</option>
					<option value="name">이름</option>
					<option value="email">이메일</option>
				</select>
			</span>
			
			<span>
				<label>정렬 방향</label>
				<select name="orderByDir">
					<option value="asc" selected>오름차순</option>
					<option value="desc">내림차순</option>
				</select>
			</span>
			
			<span>
				<input type="text" name="word" placeholder="검색어를 입력해주세요.">
				<input type="submit" value="검색">
			</span>
		</form>
	</div>
	<div class="nav-login">
		<c:if test="${empty loginUser }">
		<form method="post" action="login">
		<input type="text" name="id" placeholder="아이디"> 
		<input type="password" name="password" placeholder="비밀번호"> 
		<input type="submit" value="로그인">
		</form>
		</c:if>
		<c:if test="${!empty loginUser }">
		<div>
			${loginUser.name }
			님 반갑습니다. <a href="./logout">로그아웃</a>
		</div>
		</c:if>
	</div>
</div>
<hr>
<script>
	// request 영역에 msg라는 이름의 attribute가 있다면 화면에 alert으로 출력한다.
	let msg = "${msg}";
	if (msg) {
		alert(msg)
	}
</script>