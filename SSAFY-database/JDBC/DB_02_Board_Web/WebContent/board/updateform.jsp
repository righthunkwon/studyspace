<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 수정</title>
</head>
<body>
	<h2>게시글 수정</h2>
	<form action="board" method="POST">
		<input type="hidden" name="act" value="update"> 
		<input type="hidden" name="id" value="${board.id}"> 
		제목 : <input type="text" name="title" value="${board.title }"> <br>
		쓰니 : <input type="text" name="writer" readonly value="${board.writer }"> <br>
		내용 : <textarea rows="10" cols="10" name="content">${board.content}</textarea><br>
		
		<button>수정</button>
	</form>
	
	
</body>
</html>