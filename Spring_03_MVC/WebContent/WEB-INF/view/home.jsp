<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>반갑습니다.</title>
</head>
<body>
	<h2>웰컴 홈</h2>
	${msg }
	
	<form action="test4" method="POST">
		id : <input type="text" name="id">
		pw : <input type="password" name="pw">
		age : <input type="number" name="age">
		<button>등록</button>
	</form>
</body>
</html>