<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>리뷰 목록</title>
<style>
h2, h4 {
	text-align: center;
}

h2 {
	margin-top: 30px;
}

.homeimages img {
	width: 500px;
	margin: 0 auto; /* 가로 가운데 정렬 */
	display: block;
	margin: 0 auto; /* 블록 요소로 설정하여 가운데 정렬을 적용합니다. */
}

table {
	width: 1000px;
	margin: 0 auto; /* 가로 가운데 정렬 */
}

/* 두 번째 열의 너비를 100px로 설정 */
table tr td:nth-child(1), table tr th:nth-child(1) {
	width: 100px;
}

table tr td:nth-child(2), table tr th:nth-child(2) {
	width: 100px;
}

table tr td:nth-child(5), table tr th:nth-child(5) {
	width: 100px;
}

table tr td:nth-child(6), table tr th:nth-child(6) {
	width: 100px;
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
		<h2>리뷰 목록</h2>
		<img src="${video.imgSrc }" />
		<c:if test="${empty rlist  }">
			<div class="small-empty"></div>
			<h4>후기가 존재하지 않습니다.</h4>
		</c:if>
		<c:if test="${not empty rlist  }">
			<div>
				<table>
					<tr>
						<th>제목</th>
						<th>작성자</th>
						<th>내용</th>
						<th>등록일</th>
						<th>수정</th>
						<th>삭제</th>
					</tr>
					<c:forEach items="${rlist }" var="review">
						<tr>
							<td>${review.title }</td>
							<td>${review.writer }</td>
							<td>${review.content }</td>
							<td>${review.regDate }</td>
							<td><a
								href="main?action=updateform&rid=${review.id }&vid=${video.id }">수정</a></td>
							<td><a
								href="main?action=remove&rid=${review.id }&vid=${video.id }">삭제</a></td>
						</tr>
					</c:forEach>
				</table>
			</div>
		</c:if>
		<div class="empty"></div>
		<%@ include file="../include/footer.jsp"%>
	</div>
</body>
</html>