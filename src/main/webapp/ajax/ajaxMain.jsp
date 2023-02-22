<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ajax main</title>
<link rel="stylesheet" href="/webJSP/inc/style.css" type="text/css"/>
<style>
	#view {
		border: 2px solid gray;
		height: 300px;
	}
</style>
<script>

	// (1) loadDocument
	function loadDocument() {
		// 비동기식으로 서버에 접속하여 ajaxTextData.txt의 파일 내용을 가져오기
		// 1. 웹서버에 데이터를 요청하는 객체
		var xHttp = new XMLHttpRequest();
		
		// 2. ready 이벤트가 발생하면 자동으로 호출되는 메소드 - 서버에 접속하여 정보를 가져오기
		/*
		   	this.readyState : XMLHttpRequest의 처리 상태
		 					 0:초기화 실패, 1:서버연결, 2:요청접수, 3:처리요청, 4:요청완료
							 
			this.status : 요청 상태번호 변환
						  200:정상처리, 402:금지, 404:찾을 수 없음
						  
			this.statusText : 정상처리(OK), 데이터 받기 실패(NOT Found)
		
			this.responseText : 전송받은 정보
						  		
		*/
		xHttp.onreadystatechange = function() {
			console.log('readyState ->', this.readyState);
			console.log('status', this.status);
						
			if(this.readyState == 4 && this.status == 200) {
				document.getElementById("view").innerHTML = this.responseText;	
			} else {
				document.getElementById("view").innerHTML = "요청한 자료가 없습니다.";
			}
		}
		
		// 3. 서버에 데이터 요청
		// xHttp.open("전송방식", "가져올 파일명", 논리값);
		// 		전송방식 : get, post
		// 		논리값 : true(동기식), false(비동기식)
		xHttp.open("GET", "ajaxTextData.txt", true);
		
		// 4. 서버에 요청서 제출 (ready 이벤트 발생)
		xHttp.send();
	}
	
	// (2) loadDocument2
	function loadDocument2() {
		var xHttp2 = new XMLHttpRequest();
		
		xHttp2.onreadystatechange = function() {
			if(this.readyState == 4 && this.status == 200) { // 정상적으로 전송이 된 경우
				document.getElementById("view").innerHTML = this.responseText;
			}
		}
		
		xHttp2.open("GET", "ajaxJSP.jsp?firstname=정훈&lastname=권", true);
		xHttp2.send();
	}
</script>
</head>
<body>
	<div class="container">
		<h1>자바스크립트를 이용한 ajax 구현하기</h1>
			<input type="button" value="ajax(javascript/text)" onclick="loadDocument()"/>
			<input type="button" value="ajax(javascript/JSP)" onclick="loadDocument2()"/>
			<div id="view">
				
			</div>	
	</div>
</body>
</html>