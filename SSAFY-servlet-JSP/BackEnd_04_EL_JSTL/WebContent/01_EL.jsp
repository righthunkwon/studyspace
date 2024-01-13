<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>EL</title>
</head>
<body>
	<!-- Scriptlet: Hello! -->
	<% out.print("Hello!"); %>
	
	<!-- Expression -->
	<%= "Hello!" %>
	
	<!-- EL: Hello! -->
	${"Hello!" }
</body>
</html>