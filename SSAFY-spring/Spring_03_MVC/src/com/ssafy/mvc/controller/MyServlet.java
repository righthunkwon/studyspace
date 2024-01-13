package com.ssafy.mvc.controller;

import javax.servlet.http.HttpServlet;


// 서블릿(컨트롤러)
// 서블릿은 우리가 직접 만들었기 때문에 어노테이션을 활용하여 등록할 수 있다.
// 물론, web.xml에서도 서블릿을 등록할 수 있다.

// 디스패쳐서블릿(스프링의 컨트롤러)
// 하지만, 디스패쳐서블릿은 스프링에 이미 만들어진 클래스이므로 어노테이션을 활용하여 등록할 수 없다.
// 스프링의 디스패쳐서블릿은 web.xml에서만 등록할 수 있다.
// @WebServlet("/MyServlet") // MyController와 겹칠 수 있기에 컨트롤러로 인식하지 않게 주석처리
public class MyServlet extends HttpServlet {
}
