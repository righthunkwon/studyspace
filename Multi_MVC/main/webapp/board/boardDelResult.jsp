<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:if test="${cnt>0 }">
	<script>
		location.href = "<%=request.getContextPath() %>/board/boardList.do";
	</script>
</c:if>

<c:if test="${cnt<=0 }">
	alert("글 삭제에 실패했습니다.");
	location.href ="<%=request.getContextPath() %>/board/boardView.do?no=${no }";
</c:if>