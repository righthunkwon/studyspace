<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- JSTL 등록 -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Fruits Select</title>
</head>
<body>
	<form action="07_FruitsResult">
		<select name="fruit">
			<!-- value는 편의상 이렇게 사용하지만, 개발자 간 명확히 합의를 거쳐서 사용하거나 아예 의미를 잘 드러내는 값을 사용하는 게 좋다. -->
			<option value="1">파인애플</option>
			<option value="2">망고스틴</option>
			<option value="3" selected>메론</option> <!-- selected: 기본 선택 -->
			<option value="4">사과</option>
		</select>
		<button>이거 먹을래!</button>
	</form>
</body>
</html>