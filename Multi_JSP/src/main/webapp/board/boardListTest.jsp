<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>jstl test</title>
<link rel="stylesheet" href="/webJSP/inc/style.css" type="text/css"/>
</head>
<body>
	<div class="container">
		<!-- jsp : request -->
		번호 : <%=request.getParameter("no") %><br/>
		검색키 : <%=request.getParameter("searchKey") %><br/>
		검색어 : <%=request.getParameter("searchWord") %><br/>
		
		<!-- jstl : param -->
		번호 : ${param.no }<br/>
		검색키 : ${param.searchKey }<br/>
		검색어 : ${param.searchWord }<br/>
		
		<!-- jsp에서의 request는 jstl에서의 ${param.}과 같다. -->
		<!-- jstl은 jsp 스탠다드 태그 라이브러리이다. -->
	</div>
</body>
</html>