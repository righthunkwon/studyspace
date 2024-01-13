package com.ssafy.mvc.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class MainController {

	@Autowired // 의존성 주입
	private ServletContext servletContext;

	@Autowired // 의존성 주입
	private ResourceLoader resLoader;

	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home() {
		return "home";
	}

	
	@GetMapping("regist")
	public String registForm() {
		return "regist";
	}

	
	@PostMapping("upload") // 하나의 파일 업로드를 처리하는 메소드
	public String upload(MultipartFile upload_file, Model model) {
		// 파일 하나는 MultipartFile로 받는다.

		// 참고) regist 뷰페이지
//		<form action="upload" method="post" enctype="multipart/form-data">
//			<input type="file" name="upload_file"> 
//		</form>

		// 파일이 실제로 저장될 위치
		String uploadPath = servletContext.getRealPath("/upload"); // 파일 저장 경로 설정

		// 만약 등록하려고 하는 upload 폴더가 없을 경우에는 폴더를 만든다.
		File folder = new File(uploadPath); // 폴더를 만들기 위한 객체 생성
		if (!folder.exists()) { // 폴더가 존재하지 않는다면
			folder.mkdir(); // 폴더 디렉토리를 만든다.
		}

		// 실제 파일이름을 가져오기
		String fileName = upload_file.getOriginalFilename();

		// 파일을 폴더에 저장하는 방법
		// 1) FileCopyUtiles
		// 2) File 인스턴스를 직접 활용

		File target = new File(uploadPath, fileName);
		try {
			FileCopyUtils.copy(upload_file.getBytes(), target);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		model.addAttribute("fileName", fileName);
		return "result";
	}

	
	@PostMapping("upload2") // 여러 개의 파일 업로드를 처리하는 메소드
	public String upload2(MultipartFile[] upload_files, Model model) throws IOException {
		// 파일 여러 개는 MultipartFile[](배열)로 받는다.
		
		// 파일들의 이름을 저장할 리스트 생성
		List<String> list = new ArrayList<>();

		// 업로드 파일들이 널이 아니면 파일들이 있다는 뜻 이므로 업로드를 진행
		if (upload_files != null) {
			Resource res = resLoader.getResource("resources/upload"); // 파일 저장 경로 설정
			
			// 만약 파일이 존재하지 않는다면 디렉토리 생성
			if (!res.getFile().exists()) {
				res.getFile().mkdir();
			}
				
			// 단순히 upload 폴더에 냅다 저장하는게 아니라 경로를 날짜별로 할건지 사람별로 할껀지에 대한 고민을 해보자.
			for (MultipartFile mFile : upload_files) {
				// 잘못된 파일들을 생략(0byte짜리들은 업로드하지 않는다)
				if (mFile.getSize() > 0) {
					mFile.transferTo(new File(res.getFile(), mFile.getOriginalFilename()));
					list.add(mFile.getOriginalFilename());
				}
			}
		}
		model.addAttribute("list", list);
		return "result";
	}

	
	@GetMapping("download")
	public String download(Model model, String fileName) {
		Map<String, Object> fileInfo = new HashMap<>();
		fileInfo.put("fileName", fileName);
		
		model.addAttribute("downloadFile", fileInfo);
		
		return "fileDownLoadView";
	}
}
