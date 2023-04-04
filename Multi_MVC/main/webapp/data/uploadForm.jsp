<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<style>
	#title, #memo {
		width:90%;
	}
	#memo {
		height:300px;
	}
	#fileFrm li {
		padding:5px 0;
	}
</style>
<script>
	function frmCheck() {
		if(document.getElementById("title").value=="") {
			alert("제목을 입력하세요.");
			return false;
		}
		if(document.getElementById("memo").value=="") {
			alert("글 내용을 입력하세요.");
			return false;
		}
		var cnt=0;
		if(document.getElementById("filename1").value!="") {
			cnt++;
		}
		if(document.getElementById("filename2").value!="") {
			cnt++;
		}
		if(cnt<1) {
			alert("파일을 하나 이상 첨부하세요.");
			return false;
		}
		return true;
	}
</script>
	<div class="container">
		<h1>파일 업로드</h1>
			<p>
				1. 서버에 업로드할 위치 만들기<br/>
				   뷰 영역에 폴더 upload를 생성<br/>
				   
				2. 파일 업로드를 구현하는 프레임워크 설정<br/>
				   servlets.com → COS File Upload Library 접속<br/>
				   cos로 시작하는 zip 파일 다운로드<br/>
				   
				3. WEB-INF → lib에 cos.jar 파일 추가<br/>
				
				4. 폼 태그 내부에 enctype 속성 표시<br/>
			</p>
		<h1>파일 업로드 폼</h1>
		<form method="post" action="<%=request.getContextPath() %>/data/fileuploadOk.do" enctype="multipart/form-data" id="fileFrm" onsubmit="return frmCheck()">
			<ul>
				<li>제목</li>
				<li><input type="text" name="title" id="title"/></li>
				<li>글내용</li>
				<li><textarea name="memo" id="memo"></textarea></li>
				<li>첨부파일</li>
				<li>
					<input type="file" name="filename1" id="filename1"/><br/>
					<input type="file" name="filename2" id="filename2"/><br/>				
				</li>
				<li>
					<input type="submit" value="파일올리기"/>
					<input type="reset" value="다시쓰기"/>
				</li>
			</ul>		
		</form>
	</div>
