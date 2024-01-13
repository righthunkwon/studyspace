<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Regist</title>
</head>
<body>
	<form action="main" method="POST">
		<input type="hidden" name="action" value="regist">
		<label>이름 : </label>
		<input type="text" placeholder="이름을 입력하세요" name="name"><br>
		<label>나이 : </label>
		<input type="number" min="0" placeholder="나이를 입력하세요" name="age"><br>
		<input type="radio" id="man" name="gender" value="man">
		<label for="man">남자</label>
		<input type="radio" id="woman" name="gender" value="woman">
		<label for="woman">여자</label>
		
		<fieldset>
			<legend>취미</legend>
			<input type="checkbox" id="sleep" name="hobby" value="sleep">
			<label for="sleep">수면</label>
			<input type="checkbox" id="eat" name="hobby" value="eat">
			<label for="eat">먹기</label>
			<input type="checkbox" id="study" name="hobby" value="study">
			<label for="study">공부</label>
			<input type="checkbox" id="jump" name="hobby" value="jump">
			<label for="jump">점프</label>
		</fieldset>
		<input type="submit">
	</form>
</body>
</html>