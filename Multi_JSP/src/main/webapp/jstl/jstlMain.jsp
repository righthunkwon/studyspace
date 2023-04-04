<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<!-- 5초 후 자동으로 네이버 홈페지이로 이동 -->
<!-- <meta http-equiv="Refresh" content="5; https://www.naver.com"/> -->
<title>jstl main</title>
<link rel="stylesheet" href="/webJSP/inc/style.css" type="text/css"/>
</head>
<body>
	<div class="container">
		<h1>JSTL : JSP Tag Library</h1>
		<pre>
			[JSTL 환경설정]
			
			1. https://tomcat.apache.org/taglibs/standard/에서 라이브러리 
			   jakarta-taglibs-standard-1.1.2.zip 파일 다운로드
			   
			2. 압축을 푼 후 lib 파일에 있는
			   jstl.jar, standard.jar을 webapp 내 /WEB-INF/lib에 복사
			   
			3. 태그 라이브러리를 사용하는 페이지에서 지시부를 표시
			   < %@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" % >
		</pre>
		
		<ol>
			<li><a href="jstl01_setTag.jsp">set tag : 변수선언 및 변수삭제</a></li>
			<li><a href="jstl02_ifTag.jsp?name=권정훈&age=28&firstname=정훈">if tag : 조건문</a></li>
			<li><a href="jstl03_forEachTag.jsp">forEach tag : 반복문</a></li>
			<li><a href="jstl04_forTokensTag.jsp">forTokens tag</a></li>
			<li><a href="jstl05_urlTag.jsp">url Tag</a></li>
			<li><a href="jstl06_choose.jsp?name=kwon&age=19">choose Tag : 다중if문 혹은 switch문과 유사한 태그</a></li>
			<li>
				<pre>
					[리다이렉트 하는 방법]
					
					1. html의 meta 태그를 활용하여 페이지를 자동으로 이동시키기(상단에 기술)
					   -> < meta http-equiv="Refresh" content="5; https://www.naver.com"/ >			
					
					2. JavaScript를 이용하여 페이지를 자동으로 이동시키기
					   -> location.href="url"
					
					3. jsp의 response 객체를 이용하여 자동 페이지 이동시키기
					   -> response.sendRedirect("url");
					   
					4. jstl에서 페이지 자동으로 이동시키기
				</pre>
					<a href="jstl07_redirect.jsp">redirect Tag</a>
			</li>
		</ol>
	</div>
</body>
</html>