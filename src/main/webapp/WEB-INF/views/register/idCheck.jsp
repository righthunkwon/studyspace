<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<style>
	header, footer {
		display:none;
	}
</style>
<script>
	function setUserid(id) {
		// 회원가입 폼에 체크한 아이디를 표기
		opener.document.getElementById("userid").value=id;
		opener.document.getElementById("idStatus").value="Y";
		// 아이디중복검사 팝업 창 닫기
		window.close(); // self.close
	}
</script>
<div class="container">
	<div>
		<!-- 사용이 가능한 경우 -->
		<c:if test="${result==0}">
			<b>${userid}</b>는 사용 가능한 아이디입니다.
			<input type="button" value="사용하기" onclick="setUserid('${userid}')"/>
		</c:if>				
		
		<!-- 사용이 불가능한 경우 -->
		<c:if test="${result>0}">
			<b>${userid}</b>는 사용 불가능한 아이디입니다.
		</c:if>
	</div>
	<hr/>
	<div>
		<form>
			아이디 입력 : <input type="text" name="userid" id="userid"/>
			<input type="submit" value="아이디중복검사"/>
		</form>
	</div>
</div>