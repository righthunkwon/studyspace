<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="com.ssafy.hw.step2.dto.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<style>
#user-info {
	text-align: right;
}
</style>
<div id="user-info">
	<%-- session에서 loginUser를 가져와서 존재 여부에 따라 로그인 폼 또는 사용자 정보를 출력한다. --%>
	<!-- 로그인 정보가 없을 때 -->
	<c:if test="${sessionScope.loginUser == null }">
	<form method="post" action="main">
		<input type="hidden" name="action" value="login"> <input
			type="text" name="userid" placeholder="아이디"> <input
			type="password" name="userpass" placeholder="비밀번호"> <input
			type="submit" value="로그인">
	</form>
	</c:if>
	
	<!--  로그인 정보가 존재할 때 -->
	<c:if test="${sessionScope.loginUser != null }">
	<div>
		${sessionScope.loginUser.name }
		님 반갑습니다. <a href="main?action=logout">로그아웃</a>
	</div>
	</c:if>
</div>
<hr>
<script>
	// request 영역에 msg라는 이름의 attribute가 있다면 화면에 alert으로 출력한다.
	let msg = "<%=request.getAttribute("msg")%>";
	if (msg != "null") {
		alert(msg);
	}
</script>