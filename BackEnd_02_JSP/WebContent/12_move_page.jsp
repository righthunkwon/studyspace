<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>페이지 이동</title>
</head>
<body>
	페이지 이동
	요청(request)을 받아 화면을 변경하는 방법은 두 가지가 있다.
	
	(1) 포워드 방식	
	
		요청이 들어오면 요청을 받은 JSP 또는 Servlet이 직접 응답을 작성하지 않고,
		요청을 서버 내부에서 전달하여 해당 요청을 처리하는 방식.
	
		request, response 객체가 전달되어 사용되기 때문에 객체가 사라지지 않는다.
		브라우저의 URL은 변경되지 않아 최초 요청한 주소가 표시된다.
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("page");
		dispatcher.forward(request, response);
	
	
	(2) 리다이렉트 방식

		요청이 들어오면 내부 로직 실행 후 브라우저의 URL을 변경하도록 하여
		새로운 요청을 생성함으로써 페이지를 이동하는 방식
	
		브라우저가 새로운 요청을 만들어 내기 때문에 최초 요청 주소와
		다른 요청 주소가 화면에 보여진다.
	
		response.sendRedirect("location");
		
</body>
</html>