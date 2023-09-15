<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>SSAFIT</title>
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

h2 {
	margin-top: 30px;
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
		<h2>운동 부위 선택</h2>
		<button class="body-button"
			onclick="location.href='main?action=part&fitpart=body'">전신</button>
		<button class="topbody-button"
			onclick="location.href='main?action=part&fitpart=topbody'">상체</button>
		<button class="bottombody-button"
			onclick="location.href='main?action=part&fitpart=bottombody'">하체</button>
		<button class="belly-button"
			onclick="location.href='main?action=part&fitpart=belly'">복부</button>
		<div class="small-empty"></div>
		<hr />
		<div class="small-empty"></div>


		<h2>최근 가장 많이 본 영상</h2>

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