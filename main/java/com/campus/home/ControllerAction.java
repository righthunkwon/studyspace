package com.campus.home;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ControllerAction")
public class ControllerAction extends HttpServlet {
	// mapping 주소와 실행할 객체를 보관할 컬렉션
	Map<String, CommandService> map = new HashMap<String, CommandService>();
	
	public ControllerAction() {
        super();
    }

	public void init(ServletConfig config) throws ServletException {
		// urlMapping.properties 파일의 내용을 가져와서 HashMap에 key와 value로 세팅
		// urlMapping.properties에서 key는 /index.do이고, value는 com.campus.home.IndexCommand이다.
		
		// (1) web.xml에 init-param으로 프로퍼티 파일 등록
		String propertiesFileName = config.getInitParameter("proConfig");
		
		// (2) propertiesFileName의 내용을 properties 객체에 담는다.
		Properties propObject = new Properties();
		
		try {
			FileInputStream fis = new FileInputStream(propertiesFileName);
			propObject.load(fis);
		} catch (Exception e){
			System.out.println("프로퍼티 생성 예외 발생...-->"+e.getMessage());
		}
		
		// (3) propObejct의 key의 목록을 구하여 value 객체로 만든 후 Map에 저장한다.
		Enumeration keyList = propObject.propertyNames();
		try {
			while(keyList.hasMoreElements()) {
				// key & valuse 값 얻어오기(문자열)
				String key = (String)keyList.nextElement(); // key (/index.do) 얻어오기
				String className = propObject.getProperty(key); // key를 이용하여 value 얻어오기(com.campus.home.IndexCommand)
				System.out.println(key+"="+className);
				
				// 문자열을 Class로 만들기 : Class.forName("문자열")
				Class commandClass = Class.forName(className);
				
				// Class에서 객체를 가져와 인터페이스로 형변환
				CommandService service = (CommandService)commandClass.getDeclaredConstructors()[0].newInstance();
				
				// Map에 추가
				map.put(key, service);
			}
		} catch (Exception e) {
			System.out.println("Map에 객체를 추가할 때 에러 발생...-->"+e.getMessage());
		}
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// uri 구하기 
		String uri = request.getRequestURI(); // /webMVC/index.do   ,   /webMVC/board/boardList.do
		String ctx = request.getContextPath(); // /weMVC            ,   /board/boardList.do
		
		// 접속한 주소 알아보기
		String commandKey = uri.substring(ctx.length()); // /index.do
		
		// key를 이용하여 CommandService를 Map에서 가져오기
		CommandService service = map.get(commandKey);
		String viewname = service.processStart(request, response); // /index.jsp
		
		// 뷰 페이지로 이동하기
		RequestDispatcher dispatcher = request.getRequestDispatcher(viewname);
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
