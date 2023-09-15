<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>Write form</title>
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

#formdiv {
	width: 1000px;
	margin: 0 auto;
}
</style>
</head>
<body>
	<%@ include file="../include/header.jsp"%>
	<div class="homeimages">
		<div class="small-empty"></div>
		<h2>리뷰 등록</h2>
		<div class="review-container">
			<div>
				<img src="${video.imgSrc }" />
			</div>
			<div class="small-empty"></div>
			<div id="formdiv">
				<form action="main?action=write" method="POST" class="review-form">
					<input type="hidden" name="id" value="${video.id }">
					<div class="form-group">
						<label for="title">제목:</label> <input type="text" name="title"
							id="title" class="form-control">
					</div>
					<div class="form-group">
						<label for="writer">작성자:</label> <input type="text" name="writer"
							id="writer" class="form-control">
					</div>
					<div class="form-group">
						<label for="content">내용:</label>
						<textarea rows="5" cols="100" name="content" id="content"
							class="form-control"></textarea>
					</div>
					<div class="small-empty"></div>
					<button class="btn btn-primary">등록</button>
				</form>
			</div>
			<div></div>
		</div>
		<div class="empty"></div>
		<%@ include file="../include/footer.jsp"%>
	</div>
</body>
</html>