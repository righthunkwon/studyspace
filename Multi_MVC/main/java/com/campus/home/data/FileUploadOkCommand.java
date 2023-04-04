package com.campus.home.data;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.campus.home.CommandService;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

public class FileUploadOkCommand implements CommandService {

	@Override
	public String processStart(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 파일업로드 : cos.jar의 파일 중 MultipartRequest 클래스가 처리(폼의 데이터와 파일 업로드까지 수행)
		
		// 업로드 위치
		String path = request.getServletContext().getRealPath("/upload");
		System.out.println("path-->"+path);

		// 파일 크기 설정1024:1KB, 1024*1024:1MB, 1024*1024*1024:1GB
		int maxSize = 1024*1024*1024; 
		
		// 파일 rename 처리를 하는 클래스
		DefaultFileRenamePolicy policy = new DefaultFileRenamePolicy();
		
		// 업로드 처리(MultipartRequest의 객체 생성 : (request객체, 업로드위치, 업로드파일 최대크기(byte), 인코딩, rename)
		MultipartRequest mr = new MultipartRequest(request, path, maxSize, "UTF-8", policy);
		
		// DB에 레코드 추가
		
		// 제목, 글내용, 파일명1, 파일명2
		String title = mr.getParameter("title");
		String memo = mr.getParameter("memo");
		System.out.println("제목:"+title);
		System.out.println("글내용:"+memo);
		
		// 기존파일명
		List<String> orgFilename = new ArrayList<String>();
		
		// 새로운 파일명
		List<String> newFilename = new ArrayList<String>();
		
		// 업로드된 파일명 구하기
		Enumeration fileList = mr.getFileNames();
		
		while(fileList.hasMoreElements()) {
			String nameAttr = (String)fileList.nextElement();
			String orgFile = mr.getOriginalFileName(nameAttr); // 원래 파일 명
			String newFile = mr.getFilesystemName(nameAttr); // 새로운 파일 명
			
			System.out.println(orgFile + "-->" + newFile);
			
			orgFilename.add(orgFile);
			newFilename.add(newFile);
		}
		request.setAttribute("title", title);
		request.setAttribute("memo", memo);
		request.setAttribute("orgFilename", orgFilename);
		request.setAttribute("newFilename", newFilename);
		
		return "/data/fileuploadOk.jsp";
	}

}
