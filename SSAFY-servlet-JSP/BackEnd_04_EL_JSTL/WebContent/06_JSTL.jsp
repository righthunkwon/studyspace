<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!-- JSTL 등록 -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSTL</title>
</head>
<body>
	<!-- JSTL core -->
	<!-- 간단하게 사용하기 위해 prefix 속성값을 부여하고 '속성값:기능'의 형태로 사용한다.-->
	
	<!-- (1) c:out -->
	<c:out value="Hello SSAFY!"></c:out> <br/>
	
	<!-- <f:out value="SSAFY Hello!"></f:out> <br/> -->
	<!-- 상단에 core를 등록하는 코드에서 prefix를 f로 수정한다면 위의 코드도 작동한다. -->
	<!-- 하지만 의미를 잘 전달하기 위해 core는 굳이 다른 걸로 쓰기보다는 당연히 c로 쓰는 게 좋다. -->
	
	
	<!-- (2) c:set -->
	<!-- c:set var="변수명" value="변수값" scope="page/request/session/application -->
	<c:set var="msg" value="Hello!"></c:set>
	${msg} <br/>
	
	<c:set var="username">Kwon</c:set> <!-- c:set은 이렇게도 사용 가능 -->
	${username} <br/>
	
	<!-- 객체 가져오기 -->
	<!-- 객체를 가져오기 위해서는 객체생성연산자 new를 활용하여 패키지명을 포함한 클래스명 전체를 가져와야 한다.  -->
	<c:set var="person" value="<%= new com.ssafy.dto.Person() %>"></c:set>
	
	<!-- 객체 값 집어넣기 -->
	<!-- set의 property는 Person의 변수에 직접 접근하는 게 아니라 setter에 접근한다. -->
	<c:set target="${person}" property="name" value="Kwon" ></c:set>
	${person}
</body>
</html>