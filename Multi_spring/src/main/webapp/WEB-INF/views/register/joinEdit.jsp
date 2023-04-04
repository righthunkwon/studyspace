<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<style>
	#joinEditForm ul {
		overflow:auto;
	}
	#joinEditForm li {
		float:left;
		width:20%;
		padding:20px 0;
		border-bottom:1px solid gray;
		line-height:40px;
	}
	#joinEditForm li:nth-child(2n) {
		width:80%;
	}
	#joinEditForm li:last-child {
		width:100%;
	}
	#addr, #addrdetail {
		width:80%;
	}
</style>
<script>
	$(function() {
		// 1. 우편번호 검색
		$("#zipSearch").on('click', function() {
			window.open("zipcodeSearch","zipcode","width=500, height=600"); // 주소, 창이름, 옵션
		});
		
		// 2. 유효성 검사
		$("#joinEditForm").submit(function() {

			// (1) 비밀번호 검사
			if($("#userpwd").val()=="") {
				alert("회원정보를 수정하려면 비밀번호를 입력하세요.");
				return false;
			}
			
			// (2) 연락처 검사
			// 연락처를 하나의 변수에 담는다(010-1111-1111)
			var tel = $("#tel1").val()+"-"+$("#tel2").val()+"-"+$("#tel3").val();
			var reg = /^(010|02|031|041|051)-[0-9]{3,4}-[0-9]{4}$/
			console.log(tel);
			if(!reg.test(tel)) {
				alert("전화번호를 잘못 입력하셨습니다.");
				return false;
			}
			
			// (3) 이메일 검사
			// 아이디는 6~15글자, @ 필수
			reg = /^\w{6,15}@[a-zA-Z]{2,8}[.][a-z]{2,5}(.[a-z]{2,5})?$/
			if(!reg.test($("#email").val())){
				alert("이메일을 잘못 입력하셨습니다.");
				return false;
			}
			
			// (4) 취미 검사
			// 취미는 반드시 두 개 이상 선택
			var hobbyCount = 0;
			$("input[name=hobbyArr]").each(function() {
				if(this.checked==true) {
					hobbyCount++;
				}
			});
			if(hobbyCount<2) {
				alert("취미는 두 개 이상 선택해주세요.");
				return false;
			}
			
			// form 태그의 action 속성 설정
			$("#joinEditForm").attr("action", "joinEditOk");
		});
	});
</script>
<div class="container">
	<h1>회원정보수정 폼</h1>
	<form method="post" id="joinEditForm">
	<ul>
		<li>아이디</li>
		<li>
			<input type="text" name="userid" id="userid" minlength="8" maxlength="15" value="${dto.userid}" readonly/>
		</li>
		<li>비밀번호</li>
		<li><input type="password" name="userpwd" id="userpwd" minlength="8" maxlength="15"/></li>
		<li>이름</li>
		<li><input type="text" name="username" id="username" minlength="2" maxlength="10" value="${dto.username}" readonly/></li>
		<li>연락처</li>
		<li>
			<select name="tel1" id="tel1">
				<option value="010" <c:if test="${dto.tel1=='010' }">selected</c:if>>010</option>
				<option value="02" <c:if test="${dto.tel1=='02' }">selected</c:if>>>02</option>
				<option value="031" <c:if test="${dto.tel1=='031' }">selected</c:if>>>031</option>
				<option value="041" <c:if test="${dto.tel1=='041' }">selected</c:if>>>041</option>
				<option value="051" <c:if test="${dto.tel1=='051' }">selected</c:if>>>051</option>
			</select> -
			<input type="text" name="tel2" id="tel2" maxlength="4" value="${dto.tel2}"/> -
			<input type="text" name="tel3" id="tel3" maxlength="4" value="${dto.tel3}"/>
		</li>
		<li>이메일</li>
		<li><input type="text" name="email" id="email" value="${dto.email}"/></li>
		<li>우편번호</li>
		<li>
			<input type="text" name="zipcode" id="zipcode" value="${dto.zipcode}"/>
			<input type="button" value="우편번호찾기" id="zipSearch"/>
		</li>
		<li>주소</li>
		<li><input type="text" name="addr" id="addr" value="${dto.addr}"/></li>
		<li>상세주소</li>
		<li><input type="text" name="addrdetail" id="addrdetail" value="${dto.addrdetail}"/></li>
		<li>취미</li>
		<li>
			<input type="checkbox" name="hobbyArr" value="영화" <c:forEach var="h" items="$[dto.hobbyArr]"><c:if test="${h=='영화'}">checked</c:if></c:forEach>/>영화
			<input type="checkbox" name="hobbyArr" value="등산" <c:forEach var="h" items="$[dto.hobbyArr]"><c:if test="${h=='등산'}">checked</c:if></c:forEach>/>등산
			<input type="checkbox" name="hobbyArr" value="축구" <c:forEach var="h" items="$[dto.hobbyArr]"><c:if test="${h=='축구'}">checked</c:if></c:forEach>/>축구
			<input type="checkbox" name="hobbyArr" value="농구" <c:forEach var="h" items="$[dto.hobbyArr]"><c:if test="${h=='농구'}">checked</c:if></c:forEach>/>농구
			<input type="checkbox" name="hobbyArr" value="야구" <c:forEach var="h" items="$[dto.hobbyArr]"><c:if test="${h=='야구'}">checked</c:if></c:forEach>/>야구
			<input type="checkbox" name="hobbyArr" value="코딩" <c:forEach var="h" items="$[dto.hobbyArr]"><c:if test="${h=='코딩'}">checked</c:if></c:forEach>/>코딩
		</li>
		<li>
			<input type="submit" value="회원정보수정하기"/>
		</li>
	</ul>
	</form>
</div>