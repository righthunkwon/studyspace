package com.ssafy.fit.model.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ssafy.fit.model.dao.MainDao;
import com.ssafy.fit.model.dao.MainDaoImpl;
import com.ssafy.fit.model.dto.Review;
import com.ssafy.fit.model.dto.Video;

@WebServlet("/main")
public class SsafitController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private MainDao mainDao = MainDaoImpl.getInstance();

	public SsafitController() {
	}

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// post 방식일 때는 인코딩 설정
		// get 방식은 jsp에 다시 보내지므로 그때 인코딩이 되어 별도 설정 불필요
		if (request.getMethod().equals("POST")) {
			request.setCharacterEncoding("UTF-8");
		}

		String action = request.getParameter("action");

		switch (action) {
		case "ssafit":
			doSsafit(request, response);
			break;
		case "list":
			doList(request, response);
			break;
		case "write":
			doWrite(request, response);
			break;
		case "writeform":
			doWriteform(request, response);
			break;
		case "part":
			doPart(request, response);
			break;
		case "detail":
			doDetail(request, response);
			break;
		case "updateform":
			doUpdateform(request, response);
			break;
		case "update":
			doUpdate(request, response);
			break;
		case "remove":
			doRemove(request, response);
			break;
		default:
			break;
		}
	}

	private void doRemove(HttpServletRequest request, HttpServletResponse response) throws IOException {
		int rid = Integer.parseInt(request.getParameter("rid"));
		int vid = Integer.parseInt(request.getParameter("vid"));
		mainDao.removeReview(vid, rid);
		response.sendRedirect("main?action=list&id=" + vid);
	}

	private void doUpdate(HttpServletRequest request, HttpServletResponse response) throws IOException {
		int rid = Integer.parseInt(request.getParameter("rid"));
		int vid = Integer.parseInt(request.getParameter("vid"));
		String title = request.getParameter("title");
		String writer = request.getParameter("writer");
		String content = request.getParameter("content");
		
		Video video = mainDao.selectOne(vid);
		Review review = mainDao.selectOneReview(vid, rid);
		review.setTitle(title);
		review.setContent(content);
		mainDao.updateReview(review, vid, rid);
		response.sendRedirect("main?action=list&id=" + vid);
	}

	private void doUpdateform(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int rid = Integer.parseInt(request.getParameter("rid"));
		int vid = Integer.parseInt(request.getParameter("vid"));
		Video video = mainDao.selectOne(vid);
		Review review = mainDao.selectOneReview(vid, rid);
		request.setAttribute("video", video);
		request.setAttribute("review", review);
		request.getRequestDispatcher("/WEB-INF/view/updateform.jsp").forward(request, response);
	}

	private void doWrite(HttpServletRequest request, HttpServletResponse response) throws IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		String title = request.getParameter("title");
		String writer = request.getParameter("writer");
		String content = request.getParameter("content");

		Video video = mainDao.selectOne(id);
		List<Review> rlist = video.getReviewList();
		Review review = new Review(title, writer, content);
		rlist.add(review);
		video.setReviewList(rlist);
		response.sendRedirect("main?action=list&id=" + id);
	}

	private void doWriteform(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		request.setAttribute("video", mainDao.selectOne(id));
		request.getRequestDispatcher("/WEB-INF/view/writeform.jsp").forward(request, response);
	}

	private void doDetail(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		request.setAttribute("video", mainDao.selectOne(id));
		request.getRequestDispatcher("/WEB-INF/view/detail.jsp").forward(request, response);
	}

	private void doPart(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String fitpart = (String) request.getParameter("fitpart");
		request.setAttribute("list", mainDao.selectAllVideosByPart(fitpart));
		request.getRequestDispatcher("/WEB-INF/view/part.jsp").forward(request, response);
	}

	private void doSsafit(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setAttribute("list", mainDao.selectAllVideos());
		request.getRequestDispatcher("/WEB-INF/view/home.jsp").forward(request, response);
	}

	private void doList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		Video video = mainDao.selectOne(id);
		List<Review> rlist = video.getReviewList();
		request.setAttribute("video", video);
		request.setAttribute("rlist", rlist);
		request.getRequestDispatcher("/WEB-INF/view/list.jsp").forward(request, response);
	}
}
