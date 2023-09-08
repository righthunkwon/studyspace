package com.ssafy.ws.step1.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.ssafy.ws.step1.dto.Car;

// 이 서블릿이 호출되기 위해서는 url 상에 http://server_ip:port/context_name/main 이 필요하다.
@WebServlet("/main")
public class MainServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	// 등록한 자동차 저장
	private static List<Car> carList = new ArrayList<>();

	/**
	 * get 방식의 요청에 대해 응답하는 메서드이다. front controller pattern을 적용하기 위해 내부적으로 process를
	 * 호출한다.
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		process(request, response);
	}

	/**
	 * post 방식의 요청에 대해 응답하는 메서드이다. front controller pattern을 적용하기 위해 내부적으로 process를
	 * 호출한다.
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// post 요청 시 한글 파라미터의 처리를 위해 encoding을 처리한다.
		request.setCharacterEncoding("utf-8");
		process(request, response);
	}

	/**
	 * request 객체에서 action 파라미터를 추출해서 실제 비지니스 로직 메서드(ex: doRegist) 호출해준다.
	 */
	private void process(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getParameter("action");
		switch (action) {
		case "regist":
			doRegist(request, response);
			break;
		case "list":
			doList(request, response);
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
		String VIN = request.getParameter("VIN");
		String modelName = request.getParameter("modelName");
		String color = request.getParameter("color");
		// 문자열로 전달된 mileage는 숫자로 변환
		int mileage = Integer.parseInt(request.getParameter("mileage"));
		// 전달받은 파라미터로 Car 객체를 생성하고, attribute에 등록한다.
		Car car = new Car(VIN, modelName, color, mileage);
		request.setAttribute("car", car);
		// carList에 자동차 추가
		carList.add(car);
		// 세션에 지금까지 등록한 자동차 수를 저장한다.
		HttpSession session = request.getSession();
		session.setAttribute("carCount", carList.size());
		// JSP 화면 호출을 위해 RequestDispatcher의 forward를 사용한다.
		// 이때 연결할 jsp의 이름을 넘겨준다. forward에서 /는 context root를 나타낸다.
		RequestDispatcher disp = request.getRequestDispatcher("/regist_result.jsp");
		disp.forward(request, response);
	}

	/**
	 * 현재까지 등록한 자동차 정보를 list.jsp로 forward를 통해 전달
	 * 
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	private void doList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// attribute에 지금까지 등록한 자동차 리스트 등록
		request._________("cars", carList);
		// forward를 통해 list.jsp 호출
		_________ disp = request._________("/list.jsp");
		disp._________(request, response);
	}
}