<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="/inc/loginCheck.jspf" %>
	<script>
		// jquery
		$(function() {
			$("#editFrm").submit(function() {
				if($("#subject").val()=="") {
					alert("제목을 입력하세요.")
					return false;
				}
				if($("#content").val()=="") {
					alert("글 내용을 입력하세요.")
					return false;
				}
				return true;
			});
		});
	</script>
	<div class="container">
		<h1>글 수정 폼</h1>
		<form method="post" action="<%=request.getContextPath()%>/board/boardEditOk.do" id="editFrm">
			<ul>
				<li>제목</li>
				<li><input type="text" name="subject" value="${dto.subject }" style="width:90%"/></li>
				<li>글내용</li>
				<li><textarea name="content" id="content" style="width:90%; height:300px;">${dto.content }</textarea></li>
				<li>
					<input type="submit" value="글수정"/>
					<input type="reset" value="다시 수정하기"/>
				</li>
			</ul>
			<!-- 수정할 레코드 번호 -->
			<input type="hidden" name="no" value="${dto.no }"/>
		</form>
	</div>
