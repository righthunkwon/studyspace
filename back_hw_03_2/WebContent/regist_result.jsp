<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%-- user 객체 사용을 위해 import --%>
<%@ page import="com.ssafy.hw.step2.dto.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>사용자 등록 결과</title>
<style>
table {
	border-collapse: collapse;
	width: 100%;
}

th, td {
	border: 1px solid black;
}

th:nth-child(1) {
	width: 120px;
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
			<input type="password" name="userpass" placeholder="비밀번호">
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
	</hr>
	<h1>사용자 등록 결과</h1>
	<h2>등록된 사용자 정보</h2>
	<%-- 테이블 내에서 User의 내용을 출력하기 위해 expression tag를 사용한다. --%>
	<table>
		<thead>
			<tr>
				<th>항목</th>
				<th>내용</th>
			</tr>
		</thead>
		<tbody>
			<tr>
				<td>아이디</td>
				<td><%=request.getAttribute("id")%></td>
			</tr>
			<tr>
				<td>비밀번호</td>
				<td><%=request.getAttribute("password")%></td>
			</tr>
			<tr>
				<td>이름</td>
				<td><%=request.getAttribute("name")%></td>
			</tr>
			<tr>
				<td>이메일</td>
				<td><%=request.getAttribute("email")%></td>
			</tr>
			<tr>
				<td>나이</td>
				<td><%=request.getAttribute("age")%></td>
			</tr>
		</tbody>
	</table>
	<!-- 다시 사용자를 등록할 수 있는 링크를 제공한다. -->
	<a href="regist.jsp">추가등록</a>
</body>
</html>
