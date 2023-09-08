<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!-- 로그아웃 -->
<!-- 방법1: 로그인 유저 지우기 -->
<%
	session.removeAttribute("loginuser");
%>
<script type="text/javascript">
	alert("로그아웃 되었습니다.");
	location.href = "loginForm.jsp";
</script>

<!-- 방법2: 세션 지우기 -->
<%
	session.invalidate();
%>
<script type="text/javascript">
	alert("로그아웃 되었습니다.");
	location.href = "loginForm.jsp";
</script>
