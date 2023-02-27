<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:if test="${result>0 }">
	<script>
		location.href="<%=request.getContextPath()%>/board/boardView.do?no=${no}";
	</script>
</c:if>

<c:if test="${result<=0 }">
	<script>
		alert("게시글을 수정하지 못했습니다.")
		history.back();
	</script>
</c:if>