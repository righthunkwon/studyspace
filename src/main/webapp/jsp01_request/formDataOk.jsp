<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.Arrays"%>
<% 
	// 한글을 post 방식으로 전송할 때 깨지지 않게 하는 방법(인코딩)	
	request.setCharacterEncoding("UTF-8");
	
	// request.getParameter : form 태그로 보낸 데이터를 서버에서 request 하기
	String username = request.getParameter("username");
	String userpwd = request.getParameter("userpwd");
	String reception = request.getParameter("reception");
	// request.getParameterValues : 여러 데이터 선택
	String interest[] = request.getParameterValues("interest"); 
	String local = request.getParameter("local");
	
	System.out.println("이름=" + username);
	System.out.println("비밀번호=" + userpwd);
	System.out.println("수신여부=" + reception);
	System.out.println("관심분야=" + interest);
	System.out.println("지역=" + local);
%> 

<div>이름 : <%=username %></div>
<div>비밀번호 : <%=userpwd %></div>
<div>수신여부 : <%=reception %></div>
<div>관심분야 : <%=Arrays.toString(interest) %></div>
<div>지역 : <%=local %></div>

<div>접속자의 컴퓨터 ip : <%=request.getRemoteAddr() %></div>
<!--  application/x-www-form-urlencoded 는 html form의 기본 content-type -->
<div>contentType : <%=request.getContentType() %></div>  
<div>전송방식(get/post) : <%=request.getMethod() %></div>
<div>프로토콜 : <%=request.getProtocol() %></div>
<div>URI : <%=request.getRequestURI() %></div> <!-- 전체 경로 -->
<div>ContextPath : <%=request.getContextPath() %></div> <!-- 일부 경로 -->
<div>URL : <%=request.getRequestURL() %></div>
<div>서버이름 : <%=request.getServerName() %></div>
<div>포트번호 : <%=request.getServerPort() %></div>
<!-- C:\workspaceWeb\.metadata\.plugins\org.eclipse.wst.server.core\tmp0\wtpwebapps\webJSP\ -->
<div>절대주소 : <%=request.getServletContext().getRealPath("/") %></div> <!-- / = webJSP -->
<div>쿼리주소 : <%=request.getQueryString() %></div>