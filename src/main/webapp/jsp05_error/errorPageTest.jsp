<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!-- 
	errorPage는 현재 JSP 페이지에서 예외가 발생했을 때 
	사용자에게 보여줄 예외 화면을 처리할 JSP 페이지의 경로를 지정한다.
-->
<%@ page errorPage="errorPage.jsp" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>에러 페이지</title>
</head>
<body>
	<form>
		첫번째 수 : <input type="text" name="num1"/><br/>
		두번째 수 : <input type="text" name="num2"/><br/>
		<input type="submit" value="결과 확인"/>
	</form>
	<hr/>
	<h1>계산 결과</h1>
	<ul>
	<%
		String num1Str = request.getParameter("num1");
		String num2Str = request.getParameter("num2");
		
		if(num1Str != null && num2Str != null && !num1Str.equals("") && !num2Str.equals("")) {
			int a = Integer.parseInt(num1Str);
			int b = Integer.parseInt(num2Str);
			%>
				<li><%=a %> + <%=b %> = <%=a+b %></li>
				<li><%=a %> - <%=b %> = <%=a-b %></li>
				<li><%=a %> * <%=b %> = <%=a*b %></li>
				<li><%=a %> / <%=b %> = <%=a/b %></li>
			<%
		} else {
			out.println("계산이 불가능한 값입니다.");
		}
	 %>
	 </ul>
</body>
</html>
