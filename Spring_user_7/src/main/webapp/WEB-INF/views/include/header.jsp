<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="com.ssafy.hw.model.dto.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="../common/bootstrap.jsp" %>

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


</style>
<div id="nav-header">
	<%-- session에서 loginUser를 가져와서 존재 여부에 따라 로그인 폼 또는 사용자 정보를 출력한다. --%>
	<div class="nav-search">
			
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
<div id="nav-search" class="mt-4">
	<!-- 검색 기능 목록 작성 -->
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
						<option value="name">이름</option>
						<option value="age">나이</option>
					</select>
				</div>
				<div class="col-5">
					<label>검색 내용</label> 
					<input type="text" name="word" class="form-control">
				</div>
				<div class="col-2">
					<label>정렬 기준</label> <select class="form-select" name="orderBy">
						<option value="none">-</option>
						<option value="name">이름</option>
						<option value="age">나이</option>
					</select>
				</div>
				<div class="col-2">
					<label>정렬 방향</label> <select class="form-select" name="orderByDir">
						<option value="asc">오름차순</option>
						<option value="desc">내림차순</option>
					</select>
				</div>
				<div class="col-1">
					<input type="submit" value="검색" class="btn btn-primary mt-4">
				</div>
			</form>
</div>
<hr>
<script>
	// request 영역에 msg라는 이름의 attribute가 있다면 화면에 alert으로 출력한다.
	let msg = "${msg}";
	if (msg) {
		alert(msg)
	}
</script>