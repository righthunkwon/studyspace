<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<style>
	#joinForm ul {
		overflow:auto;
	}
	#joinForm li {
		float:left;
		width:20%;
		padding:20px 0;
		border-bottom:1px solid gray;
		line-height:40px;
	}
	#joinForm li:nth-child(2n) {
		width:80%;
	}
	#joinForm li:last-child {
		width:100%;
	}
	#addr, #addrdetail {
		width:80%;
	}
</style>
<script>
	$(function() {
		// 1. 아이디 중복검사
		$("input[value=아이디중복검사]").click(function() {
			if($("#userid").val()!="") {
				window.open("idCheck?userid="+$("#userid").val(),"chk","width=400, height=300"); // 주소, 창이름, 옵션	
			} else {
				alert("아이디를 입력하세요.");
			}
		});
		
		// 2. 아이디 입력란에 키보드를 입력하면 아이디중복검사를 초기화(Y->N)
		$("#userid").keyup(function() {
			$("#idStatus").val("N");
		});
		
		// 3. 우편번호 검색
		$("#zipSearch").on('click', function() {
			window.open("zipcodeSearch","zipcode","width=500, height=600"); // 주소, 창이름, 옵션
		});
		
		// 4. 유효성 검사
		$("#joinForm").submit(function() {
			
			if($("#userid").val()=="") {
				alert("아이디를 입력하세요.");
				return false;
			}
			// (1) 아이디 검사
			// 규칙 : 첫번째문자는 영대소문자로, 영어대소문자/숫자/_ 가능, 글자길이는 8~15글자
			var reg = /^[A-Za-z]{1}[A-Za-z_0-9]{7,14}$/
			
			if(!reg.test($("#userid").val())){ // 유효한 값이면 true, 잘못된 값이면 false
				alert("아이디 길이는 8~15자이고, 아이디의 첫번째 문자는 영어대소문자로 시작하여야 하며,\n영어대소문자, 숫자, _만 입력할 수 있습니다.");
				return false;
			}
			
			if($("#idStatus").val()=="N") {
				alert("아이디 중복검사를 눌러주세요.");
				return false;
			}
			
			// (2) 비밀번호 검사
			if($("#userpwd").val()=="") {
				alert("비밀번호를 입력하세요.");
				return false;
			}
			if($("#userpwd").val() != $("#userpwd2").val()){
				alert("비밀번호가 일치하지 않습니다.")
				return false;
			}
			
			// (3) 이름 검사
			reg = /^[가-힣]{2,10}$/
			if(!reg.test($("#username").val())) {
				alert("이름의 길이는 2~10글자까지 한글만 가능합니다.");
				return false;
			}
			
			// (4) 연락처 검사
			// 연락처를 하나의 변수에 담는다(010-1111-1111)
			var tel = $("#tel1").val()+"-"+$("#tel2").val()+"-"+$("#tel3").val();
			reg = /^(010|02|031|041|051)-[0-9]{3,4}-[0-9]{4}$/
			console.log(tel);
			if(!reg.test(tel)) {
				alert("전화번호를 잘못 입력하셨습니다.");
				return false;
			}
			
			// (5) 이메일 검사
			// 아이디는 6~15글자, @ 필수
			reg = /^\w{6,15}@[a-zA-Z]{2,8}[.][a-z]{2,5}(.[a-z]{2,5})?$/
			if(!reg.test($("#email").val())){
				alert("이메일을 잘못 입력하셨습니다.");
				return false;
			}
			
			// (6) 취미 검사
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
			$("#joinForm").attr("action", "joinOk");
			return true;
		});
	});
</script>
<div class="container">
	<h1>회원가입 폼</h1>
	<form method="post" id="joinForm">
	<ul>
		<li>아이디</li>
		<li>
			<input type="text" name="userid" id="userid" minlength="8" maxlength="15"/>
			<input type="button" value="아이디중복검사"/>
			<input type="hidden" id="idStatus" value="N"/>
		</li>
		<li>비밀번호</li>
		<li><input type="password" name="userpwd" id="userpwd" minlength="8" maxlength="15" value="12345678"/></li>
		<li>비밀번호확인</li>
		<li><input type="password" name="userpwd2" id="userpwd2" value="12345678"/></li>
		<li>이름</li>
		<li><input type="text" name="username" id="username" minlength="2" maxlength="10" value="권정훈"/></li>
		<li>연락처</li>
		<li>
			<select name="tel1" id="tel1">
				<option value="010">010</option>
				<option value="02">02</option>
				<option value="031">031</option>
				<option value="041">041</option>
				<option value="051">051</option>
			</select> -
			<input type="text" name="tel2" id="tel2" maxlength="4" value="1234"/> -
			<input type="text" name="tel3" id="tel3" maxlength="4" value="5678"/>
		</li>
		<li>이메일</li>
		<li><input type="text" name="email" id="email" value="abcdef@naver.com"/></li>
		<li>우편번호</li>
		<li>
			<input type="text" name="zipcode" id="zipcode"/>
			<input type="button" value="우편번호찾기" id="zipSearch"/>
		</li>
		<li>주소</li>
		<li><input type="text" name="addr" id="addr"/></li>
		<li>상세주소</li>
		<li><input type="text" name="addrdetail" id="addrdetail"/></li>
		<li>취미</li>
		<li>
			<input type="checkbox" name="hobbyArr" value="영화"/>영화
			<input type="checkbox" name="hobbyArr" value="등산"/>등산
			<input type="checkbox" name="hobbyArr" value="축구"/>축구
			<input type="checkbox" name="hobbyArr" value="농구"/>농구
			<input type="checkbox" name="hobbyArr" value="야구"/>야구
			<input type="checkbox" name="hobbyArr" value="코딩"/>코딩
		</li>
		<li>
			<input type="submit" value="회원가입"/>
		</li>
	</ul>
	</form>
</div>