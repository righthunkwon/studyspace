<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="com.ssafy.dto.Person"%>
<%@ page import="java.util.ArrayList"%>
<!-- WebContent 내부에 있는 jsp 파일은 주소를 적을 경우 외부애서도 접근 가능하지만,  -->
<!-- WebContent의 WEB-INF 내부에 있는 jsp 파일에는 외부에서는 접근할 수 없다.  -->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>List</title>
</head>
<body>
	<%
		ArrayList<Person> list = (ArrayList<Person>) request.getAttribute("list");
		for (int i = 0; i < list.size(); i++) {
			out.print(list.get(i).getName());
	%>
	<br> <!-- JSP에서 줄바꿈을 하는 방법 -->
	<%
		}// for
	%>
</body>
</html>