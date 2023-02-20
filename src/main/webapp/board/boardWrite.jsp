<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	// 로그인이 안 된 경우 로그인 폼으로 이동
	String logStatus = (String) session.getAttribute("logStatus");
	if(logStatus == null || !logStatus.equals("Y")) {
		response.sendRedirect(request.getContextPath()+"/jsp02_response/login.html");
	}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>board write</title>
<!-- 초기화와 같이 전체 파일에 공통으로 적용될 스타일은 템플릿 처리하는 게 편리하다. -->
<link rel="stylesheet" href="<%=request.getContextPath() %>/inc/style.css" type="text/css"/>
<style>
	input[name=subject], textarea{width:100%;}
	textarea[name=content] {height:300px;}
</style>
<script>
	// 제목 글 내용이 있는지 확인
	function frmCheck() {
		if(document.getElementById("subject").value=="") {
			alert("제목을 입력하세요.");
			return false;
		}
		if(document.getElementById("content").value=="") {
			alert("내용을 입력하세요.")
			return false;
		}
		return true;
	}
	
</script>
</head>
<body>
	<div class="container">
		<h1>글쓰기 폼</h1>
		<!-- 서버로 보내기 위해 폼 태그 내부에 작성 -->
		<form method="post" action="<%=request.getContextPath() %>/board/boardWriteOk.jsp" onsubmit="return frmCheck()">
			<ul>
				<li>제목</li>
				<li><input type="text" name="subject" id="subject"/></li>
				<li>글 내용</li>
				<li><textarea name="content" id="content"></textarea></li>
				<li>
					<input type="submit" value="글 등록"/>
					<input type="reset" value="다시 쓰기"/>
				</li>
			</ul>
		</form>
	</div>
</body>
</html>