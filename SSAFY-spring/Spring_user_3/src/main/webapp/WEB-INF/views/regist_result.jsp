<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>사용자 등록 결과</title>
</head>
<body>
	<h1>사용자 등록 결과</h1>
	<h2>등록 사용자 정보</h2>
	<table>
		<thead>
			<tr>
				<th>항목</th>
				<th>내용</th>
			</tr>
		</thead>
		<tbody>
			<tr>
				<td>아이디</td>
				<td>${user.id }</td>
			</tr>
			<tr>
				<td>비밀번호</td>
				<td>${user.password }</td>
			</tr>
			<tr>
				<td>이름</td>
				<td>${user.name }</td>
			</tr>
			<tr>
				<td>이메일</td>
				<td>${user.email }</td>
			</tr>
			<tr>
				<td>나이</td>
				<td>${user.age }</td>
			</tr>
		</tbody>
	</table>
	<a href="./regist">추가등록</a>
	<a href="./list">사용자 목록</a>
</body>
</html>