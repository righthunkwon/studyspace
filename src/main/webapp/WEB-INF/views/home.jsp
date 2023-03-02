<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div>
	<h1>
		Hello world!  
	</h1>
	<div class="desc">
		(1) javaScript 외부파일 (script.js)<br/>
		(2) CSS 외부파일 (style.css)<br/>
		(3) 이미지파일<br/><br/>
		
		해당 파일들은 webapp 하위의 resources에 넣어야 한다.<br/><br/>
		
		만약 원하는 경로가 있다면, 먼저 webapp 하위폴더를 만든 뒤, <br/> 
		webapp/WEB-INF/spring/appServlet/servlet-context.xml 에<br/>
		해당 폴더명의 resources 경로를 추가해주어야 한다.
	</div>
	<div>
		번호 : ${num }<br/>
		이름 : ${name }<br/>
	</div>
	<img src="img/shiba_dog.jpg" onclick="test()"/>
</div>