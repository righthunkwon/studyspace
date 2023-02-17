<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.sql.ResultSet"%>
<%@ page import="java.sql.Connection"%>
<%@ page import="java.sql.DriverManager"%>
<%@ page import="java.sql.PreparedStatement"%>

<%!
	// jdbc 드라이브 로딩 후 DB 연결 객체를 반환하는 메소드 (1번과 2번 과정)
	public Connection getConn() {
		Connection con = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
			String username = "scott";
			String password = "tiger";
			con = DriverManager.getConnection(url, username, password);
		} catch(Exception e) {
			e.printStackTrace();
		}
		return con;
	}
%>

<%
	// 로그인 폼의 아이디와 비밀번호를 request
	// 등록한 계정 : hippoDev/1234 
	String userid = request.getParameter("userid");
	String userpwd = request.getParameter("userpwd");
	
	// DB 조회
	// 1. 드라이브 로딩
	// 2. DB 연결
	Connection conn = getConn();
	
	// 3. sql -> statement 생성
	String sql = "select count(userid) from register where userid=? and userpwd=?";
	PreparedStatement pstmt = conn.prepareStatement(sql);
	pstmt.setString(1, userid);
	pstmt.setString(2, userpwd);
	
	// 4. 실행
	ResultSet rs = pstmt.executeQuery();

	// 5. 조회결과에 따른 처리
	rs.next();
	int result = rs.getInt(1);
	
	// 6. 종료
	rs.close();
	pstmt.close();
	conn.close();
	
	/*
	// JSP로 구현
	
	if(result > 0) { // 로그인 성공 -> 홈페이지로 이동
		response.sendRedirect(request.getContextPath()+"/index.jsp");
	} else { // 로그인 실패 -> 로그인 페이지로 이동
		response.sendRedirect(request.getContextPath()+"/jsp02_response/login.html");
	}
	*/
	
	// javascript 로 구현
	if(result>0) {
		// 로그인 성공
		%>
		<script>
			alert("로그인에 성공하셨습니다. 홈페이지로 이동합니다.");
			location.href = "<%=request.getContextPath()%>/index.jsp";
		</script>
		<%
	} else {
		// 로그인 실패
		%>
		<script>
		alert("로그인에 실패하였습니다.");
		history.back(); // 이전 페이지로 이동, history.go(-1)와 동일한 기능 
		</script>
		<%
	}
%>	
