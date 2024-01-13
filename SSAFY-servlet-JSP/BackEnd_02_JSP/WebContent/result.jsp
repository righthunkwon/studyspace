<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.ssafy.dto.Person" %>   
<%@ page import="java.util.Arrays" %>   
 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Result</title>
</head>
<body>
	<% Person p = (Person)request.getAttribute("person"); %>
	<table>
		<tr>
			<td>이름</td>
			<td><%=p.getName() %></td>
		</tr>
		<tr>
			<td>나이</td>
			<td><%=p.getAge() %></td>
		</tr>
		<tr>
			<td>성별</td>
			<td><%=p.getGender() %></td>
		</tr>
		<tr>
			<td>취미</td>
			<td><%=Arrays.toString(p.getHobbies()) %></td>
		</tr>
	</table>
	<!-- /BackEnd_02_JSP는 디렉터리 명으로 Context root -->
	<a href="/BackEnd_02_JSP">홈으로</a>
</body>
</html>