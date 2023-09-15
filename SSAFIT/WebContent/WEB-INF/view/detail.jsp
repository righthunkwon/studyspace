<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>Detail</title>
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
		<h2 id="title">영상 상세보기</h2>

		<table>
			<tr></tr>
			<tr>
				<div>
					<img src="${video.imgSrc }" />

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
		</table>
		<div class=small-empty></div>
		<button class="body-button"
			onclick="location.href='main?action=writeform&id=${video.id}'">리뷰작성</button>
		<button class="body-button"
			onclick="location.href='main?action=list&id=${video.id}'">리뷰목록</button>
	</div>
	<div class="empty"></div>
	<%@ include file="../include/footer.jsp"%>
</body>
</html>