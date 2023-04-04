<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>스프링에서 ajax 구현하기</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.3/jquery.min.js"></script>
<script>
	$(function() {
		// (1) 비동기식으로 서버에서 문자열 받아오기
		$("#ajaxString").click(function() {
			var address = "ajaxString";
			var params = "num=1234&name=권정훈";
			$.ajax({
				url : address,
				data : params,
				type : "GET",
				success : function(result) {
					$("#resultData").append("<div>"+result+"</div>")
				}, error : function(e) {
					console.log(e.responseText)
				}
			});
		});
		
		// (2) 비동기식으로 서버에서 객체(DTO, VO)를 받아오기
		$("#ajaxObject").on('click', function() {
			var url = "ajaxObject";
			var params = {
					no:123456,
					subject:'ajaxTest',
					content:'ajaxTest'
			};
			$.ajax({
				url : url,
				data : params,
				dataType : 'json',
				type : 'GET',
				success : function(result) {
					// 백엔드에서 리턴한 DTO는 자바스크립트에서는 json 형식으로 처리된다.
					console.log(result);
					
					var tag ="<ul>";
					tag += "<li>번호 : " + result.no + "</li>";
					tag += "<li>제목 : " + result.subject + "</li>";
					tag += "<li>내용 : " + result.content + "</li>";
					tag += "<li>이름 : " + result.username + "</li>";
					tag += "</ul>";
					
					$("#resultData").append(tag);
				}, error : function(e) {
					console.log(e.responseText);
				}
			});
		});
		
		// (3) 비동기식으로 컬렉션(List) 받아오기
		$("#ajaxList").on('click', function() {
			$.ajax({
				url : 'ajaxList',
				data : {
					no : 1234,
					name : "권정훈"
				},
				type : 'POST',
				success : function(result) {
					console.log(result);
					var tag = "<ol>";
					$.each(result, function(i, data) {
						tag += "<li>("+i+") 번호:"+data.no+", 제목:"+data.subject+", 글내용:"+data.content+", 글쓴이:"+data.username+"</li>";
					});
					tag += "</ol>";
					
					$("#resultData").append(tag);
				}, error : function(e) {
					console.log(e.responseText());
				}
			});			
		});
		
		// (4) 비동기식으로 서버에서 컬렉션(Map) 정보 가져오기
		$("#ajaxMap").click(function() {
			$.ajax({
				url : "ajaxMap",
				data : "num=77777&name=갤럭시&tel=010-1234-5678",
				// 전송방식을 생략하면 get 방식
				// type : 'GET',
				success : function(result) {
					console.log(result);
					
					// 프론트단 출력(뷰페이지)
					var tag = "<ol>";
					
					// 주소
					tag += "<li>addr : " + result.addr + "</li>";
					tag += "<li>totalRecord : " + result.totalRecord + "</li>";
					
					// DTO
					tag += "<li>" + result.board.no + ", " + result.board.subject + ", " + result.board.content + ", " + result.board.username + "</li>";
					
					// List
					$(result.boardList).each(function(idx, data) {
						tag += "<li>"+data.no+", "+data.subject+", "+data.content+", "+data.username+"</li>";					
					});
					tag += "</ol>"
					
					$("#resultData").append(tag);
				}, error : function(e) {
					console.log(e.responseText);
				}
			});
		});
		
		// (5) 비동기식으로 JSON 데이터 얻어오기
		$("#ajaxJson").click(function() {
			$.ajax({
				url : "ajaxJson",
				success : function(result) {
					console.log(result);
					
					// 프론트단 출력(뷰페이지)
					// 자바에서 문자열로 만들어 놓은 값을 json형식의 데이터로 사용하기 위해서는 json을 파싱하여야 한다.
					var jsonData = JSON.parse(result);
					console.log(jsonData);
					
					var tag = "<ul>";
					tag += "<li>번호: " + jsonData.no + "</li>";
					tag += "<li>이름: " + jsonData.username + "</li>";
					tag += "<li>연락처: " + jsonData.tel + "</li>";
					tag += "<li>주소: " + jsonData.addr + "</li>";
					tag += "</ul>";
					
					$("#resultData").append(tag);
				}, error : function(e) {
					console.log(e.responseText);
				}
			});		
		});
	});
</script>
</head>
<body>
	<h1>ajax : 비동기식 접속</h1>
	비동기식으로 controller에 접속하여 정보를 return 받는다.
	<button id="ajaxString">ajax 문자열</button>
	<button id="ajaxObject">ajax 객체(DTO, VO)</button>
	<button id="ajaxList">ajax List</button>
	<button id="ajaxMap">ajax Map</button>
	<button id="ajaxJson">ajax Json</button>
	<div id="resultData" style="border:2px solid gray;"></div>
</body>
</html>