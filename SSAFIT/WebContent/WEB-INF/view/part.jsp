<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>Part</title>
<style>
.homeimages {
	text-align: center; /* 가운데 정렬 */
}

.homeimages img {
	width: 500px;
	margin: 0 auto; /* 가로 가운데 정렬 */
	display: block;
	margin: 0 auto; /* 블록 요소로 설정하여 가운데 정렬을 적용합니다. */
}

.empty {
	height: 500px;
}

.small-empty {
	height: 60px;
}
</style>
</head>
<body>
	<%@ include file="../include/header.jsp"%>
	<div class="homeimages">
		<div class="small-empty"></div>
		<h2>부위별 운동</h2>

		<table>
			<tr></tr>
			<c:forEach items="${list }" var="video">
				<tr>
					<div>
						<a href="main?action=detail&id=${video.id }"><img
							src="${video.imgSrc }" /></a>
					</div>
					<div>${video.title }</div>
					<c:if test="${video.fitPartName eq 'body'}">
				전신
				</c:if>
					<c:if test="${video.fitPartName eq 'topbody'}">
				상체
				</c:if>
					<c:if test="${video.fitPartName eq 'bottombody'}">
				하체
				</c:if>
					<c:if test="${video.fitPartName eq 'belly'}">
				복부
				</c:if>
					<div>${video.channelName }</div>
				</tr>
			</c:forEach>
		</table>
		<div class="empty"></div>
		<%@ include file="../include/footer.jsp"%>
	</div>
</body>
</html>