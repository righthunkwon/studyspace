 package com.ssafy.hw.step2.servlet;
 import java.io.IOException;
 import javax.servlet.RequestDispatcher;
 import javax.servlet.ServletException;
 import javax.servlet.annotation.WebServlet;
 import javax.servlet.http.Cookie;
 import javax.servlet.http.HttpServlet;
 import javax.servlet.http.HttpServletRequest;
 import javax.servlet.http.HttpServletResponse;
 import javax.servlet.http.HttpSession;
 import com.ssafy.hw.step2.dto.User;
 //이 서블릿이 호출되기 위해서는 url 상에 http://server_ip:port/context_name/main 이 필요하다.
 @WebServlet("/main")
 public class MainServlet extends HttpServlet {
 	private static final long serialVersionUID = 1L;	
     /**
      * get 방식의 요청에 대해 응답하는 메서드이다.
      * front controller pattern을 적용하기 위해 내부적으로 process를 호출한다.
      */
 	protected void doGet(HttpServletRequest request, HttpServletResponse response)
 			throws ServletException, IOException {
 		process(request, response);
 	}		
     /** 
      * post 방식의 요청에 대해 응답하는 메서드이다.
      * front controller pattern을 적용하기 위해 내부적으로 process를 호출한다.
      */
     protected void doPost(HttpServletRequest request, HttpServletResponse response)
             throws ServletException, IOException {
         // post 요청 시 한글 파라미터의 처리를 위해 encoding을 처리한다.
         request.setCharacterEncoding("utf-8");
         process(request, response);
     }	
     /**
      * request 객체에서 action 파라미터를 추출해서 실제 비지니스 로직 메서드(ex: doRegist) 
      * 호출해준다.
      */
 	private void process(HttpServletRequest request, HttpServletResponse response)
 			throws ServletException, IOException {
 		String action = request.getParameter("action");
 		switch (action) {
 		case "regist":
 			doRegist(request, response);
 			break;
 		case "login":
 			doLogIn(request,response);
 			break;
 		case "logout":
 			doLogOut(request,response);
 			break;
 		}
 	}
     /**
      * 클라이언트에서 전달된 request를 분석한 결과를 regist_result.jsp에서 볼 수 있도록 한다.
      * RequestDispatcher를 사용해서 regist_result.jsp로 forward한다.
      * 
      * @param request
      * @param response
      * @throws ServletException
      * @throws IOException
      */
 	private void doRegist(HttpServletRequest request, HttpServletResponse response)
 			throws ServletException, IOException {
 		// request 객체에서 전달된 parameter를 추출한다.
 		String id = request.getParameter("id");
 		String password = request.getParameter("password");
 		String name = request.getParameter("name");
 		String email = request.getParameter("email");
 		// 문자열로 전달된 age는 숫자로 변환
 		int age = Integer.parseInt(request.getParameter("age"));		
 		// 전달받은 파라미터를 request에 담는다.
 		request.setAttribute("id", id);
 		request.setAttribute("password", password);
 		request.setAttribute("name", name);
 		request.setAttribute("email", email);
 		request.setAttribute("age", age);
		// JSP 화면 호출을 위해 RequestDispatcher의 forward를 사용한다.
 		// 이때 연결할 jsp의 이름을 넘겨준다. forward에서 /는 context root를 나타낸다.
 		RequestDispatcher disp = request.getRequestDispatcher("/regist_result.jsp");
 		disp.forward(request, response);	
 	}
 	/**
 	 * 클라이언트를 통해 전달된 id와 password를 이용해 user객체생성, 반환
 	 * @param request
 	 * @param response
 	 * @throws ServletException
 	 * @throws IOException
 	 */
 	private void doLogIn(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
 		// form 의 input과 비교하여 작성
 		String id = request.getParameter("userid");
 		String password = request.getParameter("userpassword");
 		String name = "김싸피";
 		User user = new User();
 		user.setId(id);
 		user.setPassword(password);
 		user.setName(name);
 		// 응답헤더에 쿠키 객체를 추가한다. 개발자 도구를 통해 쿠키가 존재하는지 확인해본다.
 		Cookie userId = new Cookie ("userId", id);
 		// 쿠키 소멸 시간 설정 ( 1일 )
 		userId.setMaxAge(60*60*24);
 		// 응답 헤더에 쿠키 추가
 		response.addCookie(userId);	
 		String msg = "로그인 성공!";
 		// session 가져오기
 		HttpSession session = request.getSession();	
 		// id, password 비교하여 동작 구분
 		if(id.equals("ssafy") && password.equals("1234")) {
 			// id, password가 일치하면 session에 사용자 정보 저장
 			session.setAttribute("loginUser", user);
 		} else {
 			// 일치하지 않으면 로그인 실패 메시지 변경
 			msg = "로그인 실패!";
 		}
 		// 로그인 결과 request 에 전달
 		request.setAttribute("msg", msg);
 		RequestDispatcher disp = request.getRequestDispatcher("/regist.jsp");
 		disp.forward(request, response);
 	}
 	/**
 	 * 로그아웃 동작 정의
 	 * @param request
 	 * @param response
 	 * @throws IOException
 	 */
 	private void doLogOut(HttpServletRequest request, HttpServletResponse response) throws IOException {
 		// session 가져오기
 		HttpSession  session = request.getSession();	
 		// session 만료시키기
 		session.invalidate();	
 		// 리다이렉트 시키기
 		response.sendRedirect("./regist.jsp");
 	}
 }