package com.ssafy.mvc.view;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.util.FileCopyUtils;
import org.springframework.web.servlet.view.AbstractView;

public class FileDownLoadView extends AbstractView {

	public FileDownLoadView() {
		setContentType("application/download; charset=UTF-8");
	}

	// 암기할 필요 없는 코드
	@Override
	protected void renderMergedOutputModel(Map<String, Object> model, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		// 다운로드 받을 파일의 경로
		ServletContext ctx = getServletContext();
		String realPath = ctx.getRealPath("/upload");

		// 전송받은 모델(파일 정보)
		Map<String, Object> fileInfo = (Map<String, Object>) model.get("downloadFile");
		String fileName = (String) fileInfo.get("fileName"); // 파일 경로

		// 파일 객체 생성
		File file = new File(realPath, fileName);

		//////////////////////////////////////////////////////////////////////////////////////
		response.setContentType(getContentType());
		response.setContentLength((int) file.length());

		String header = request.getHeader("User-Agent");
		boolean isIE = header.indexOf("MSIE") > -1 || header.indexOf("Trident") > -1;
		String filename = null;
		// IE는 다르게 처리
		if (isIE) {
			filename = URLEncoder.encode(fileName, "UTF-8").replaceAll("\\+", "%20");
		} else {
			filename = new String(fileName.getBytes("UTF-8"), "ISO-8859-1");
		}
		response.setHeader("Content-Disposition", "attachment; filename=\"" + filename + "\";");
		response.setHeader("Content-Transfer-Encoding", "binary");
		//////////////////////////////////////////////////////////////////////////////////////
		
		// 파일 FileInputStream, OutputStream
		// 잘 안 떠오르면 파일 객체 다시 공부해보기
		OutputStream out = response.getOutputStream();
		FileInputStream fis = null;
		try {
			fis = new FileInputStream(file);
			FileCopyUtils.copy(fis, out);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (fis != null) {
				try {
					fis.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		out.flush();
	}
}
