<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- user 객체 사용을 위해 import --%>
<%@ page import="com.ssafy.hw.step2.dto.*"%>
<html>
<head>
<meta charset="UTF-8">
<title>사용자정보사이트</title>
<style>
	label {
		display: inline-block;
		width: 80px;
	}
	#user-info {
		text-align: right;
	}
</style>
<script>
	// request 영역에 msg라는 이름의 attribute가 있다면 화면에 alert으로 출력한다.
	let msg = "<%=request.getAttribute("msg")==null?"":request.getAttribute("msg")%>";
	if (msg) {
		alert(msg)
	}
</script>
</head>
<body>
	<div id="user-info">
		<%-- session에서 loginUser를 가져와서 존재 여부에 따라 로그인 폼 또는 사용자 정보를 출력한다. --%>
		<%
		// session에서 user 객체 가져오기
		Object userObj = session.getAttribute("loginUser");
		// null 인지 검사후 User 로 타입 변환
		User user = userObj == null ? null : (User) userObj;
		// 로그인 정보가 없을 경우는 로그인을 위한 폼을 제공한다.
		if (userObj == null) {
		%>
		<%--로그인 폼 --%>
		<form method="post" action="main">
			<input type="hidden" name="action" value="login">
			<input type="text" name="userid" placeholder="아이디">
			<input type="password" name="userpassword" placeholder="비밀번호">
			<input type="submit" value="로그인">
		</form>
		<%
		    } 
		// 로그인 정보가 있는 경우는 사용자 이름과 로그아웃을 위한 링크를 생성한다.
		else {
		%>
		<div>
			<%--user에 설정한 이름 사용 --%>
			<%=user.getName()%>
			님 반갑습니다.
			<a href="main?action=logout">로그아웃</a>
		</div>
		<%
		    }
		%>
	</div>
	<hr>
	<h1>SSAFY 사용자 관리</h1>
	<form method="post" action="main">
		<fieldset>
		<legend>사용자 정보 입력</legend>
		<!-- front-controller pattern에서 요청을 구분하기 위한 parameter -->
		<input type="hidden" name="action" value="regist">
		<label for="id">아이디</label>
		<input type="text" id="id" name="id"><br>
		<label for="password">비밀번호</label>
		<input type="password" id="password" name="password"><br>
		<label for="name">이름</label>
		<input type="text" id="name" name="name"><br>
		<label for="email">이메일</label>
		<input type="email" id="email" name="email"><br>
		<label for="age">나이</label>
		<input type="number" id="age" name="age"><br>
		<input type="submit" value="등록">
		<input type="reset" value="초기화">
		</fieldset>
	</form>
</body>
</html>
