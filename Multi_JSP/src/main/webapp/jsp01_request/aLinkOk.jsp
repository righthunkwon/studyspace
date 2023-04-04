<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.Arrays"%>
<%@ page import="java.util.Enumeration"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		// request 내장객체는 클라이언트 측의 정보를 서버에 가져온다.
		// request.getParameter : Query 읽어오기
		String name = request.getParameter("name");
		int age = Integer.parseInt(request.getParameter("age"));
		String tel = request.getParameter("tel");
		
		// request.getParameterValues : 값이 여러개인 Query 읽어오기(배열로 정의 필요!!!)
		String hobby[] = request.getParameterValues("hobby");
		
		// 서버에 넘어가는 데이터
		System.out.println("이름=" + name);
		System.out.println("나이=" + age);
		System.out.println("연락처=" + tel);
		System.out.println("취미=" + Arrays.toString(hobby));
		
		// request.getParameterNames : 주소표시줄의 쿼리에 있는 속성(변수)명 얻어오기
		Enumeration names = request.getParameterNames();
		while(names.hasMoreElements()) {
			%>
				<div><%= names.nextElement() %></div>
			<% 
		}
		%>
	
	<!-- 클라이언트에게 보이는 부분 --> 
	이름 : <%=name %><br/>
	나이 : <%=age %><br/>
	연락처 : <%=tel %><br/>
	취미 : <%=Arrays.toString(hobby) %><br/>
</body>
</html>