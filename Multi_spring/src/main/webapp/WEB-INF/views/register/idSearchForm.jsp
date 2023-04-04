<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<style>
	.container > div {
		width:50%;
		margin:100px auto;
	}
	.container li {
		padding:5px;	
	}
	.container input {
		width:100%;
	}
</style>
<script>
	// id찾기 기능 : ajax로 구현
	$(function() {
		$("#idSearch").submit(function(){
			event.preventDefault();
			
			if($("#username").val()=="") {
				alert("이름을 입력하세요.");
				return false;
			}
			if($("#email").val()==""){
				alert("이메일을 입력하세요.");
				return false;
			} 
			var url = 'idSearchEmailSend';
			var params = $("#idSearch").serialize();
			
			$.ajax({
				url : url,
				data : params,
				type : 'POST',
				success : function(result) {
					if(result=="Y") {
						alert("이메일로 아이디를 전송하였습니다.");
						location.href ="/campus/loginForm";
					} else {
						alert("사용자가 존재하지 않습니다.");
					}
				},
				error : function(e) {
					console.log(e.responseText);
				}
			});
		});
	});
</script>
<div class="container">
	<h1>아이디 찾기</h1>
	<form method="post" id="idSearch">
	<ul>
		<li>이름</li>
		<li><input type="text" name="username" id="username"/></li>
		<li>이메일</li>
		<li><input type="text" name="email" id="email"/></li>
		<li><input type="submit" value="아이디 찾기"/></li>
	</ul>
	</form>
</div>