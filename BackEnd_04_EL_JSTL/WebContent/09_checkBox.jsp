<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>반찬 고르기</title>
</head>
<body>
	<h2>반찬 고르기</h2>
	<form action="10_checkBoxResult.jsp">
		<!-- label로 구현하는 걸 권장(input의 id를 label의 for에 연결하여 사용 -->
		<input type="checkBox" name="dish" value="계란말이">계란말이 
		<input type="checkBox" name="dish" value="돈까스">돈까스 
		<input type="checkBox" name="dish" value="무말랭이">무말랭이 <br/>
		<input type="checkBox" name="dish" value="오징어젓갈">오징어젓갈 
		<input type="checkBox" name="dish" value="명란젓">명란젓 
		<input type="checkBox" name="dish" value="코다리조림">코다리조림 <br/><br/>
		<button>이거 먹을래!</button>
	</form>
	
</body>
</html>