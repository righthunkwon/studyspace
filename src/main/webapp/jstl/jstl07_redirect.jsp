<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!-- boardListTest 파일로 자동 이동 -->
<c:redirect url="/board/boardListTest.jsp">
	<c:param name="no">10001</c:param>
	<c:param name="searchKey" value="제목"/>
	<c:param name="searchWord" value="신모델"/>
</c:redirect>