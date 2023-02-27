<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:choose>
	<c:when test="${result>0 }">
		<c:redirect url="/board/boardList.do"></c:redirect>
	</c:when>
	
	<c:when test="${result<=0 }">
		<script>
			alert("글이 등록되지 않았습니다.")
			history.back();
		</script>
	</c:when>
</c:choose>