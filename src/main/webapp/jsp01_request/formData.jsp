<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>폼을 이용하여 서버로 정보 보내기</h1>
	<form method="post" action="formDataOk.jsp">
		이름 : <input type="text" name="username"/><br/>
		비밀번호 : <input type="password" name="userpwd"/><br/>
		수신여부 : 
		<input type="radio" name="reception" value="yes"/>수신함
		<input type="radio" name="reception" value="no"/>수신안함<br/>
		관심분야 : 
		<input type="checkbox" name="interest" value="자바"/>Java
		<input type="checkbox" name="interest" value="자바스크립트"/>JavaScript
		<input type="checkbox" name="interest" value="부트스트랩"/>BootStrap
		<input type="checkbox" name="interest" value="JSP"/>JSP<br/>
		지역 :
		<select name="local">
			<script>
				var localName = ['서울', '경기', '인천', '강원', '충북', '충남', '대전', '전남', '전북', '경남', '경북', '제주', '기타' ];
				for(var i=0; i<localName.length; i++) {
					document.write("<option value='" + localName[i] + "'>"+localName[i]+"</option>")
				}
			</script>
		</select><br/>
		<hr/>
		<button type="image" src="../img/submit.jpg" style="width:60px; height:60px"></button>
	</form>
</body>
</html>