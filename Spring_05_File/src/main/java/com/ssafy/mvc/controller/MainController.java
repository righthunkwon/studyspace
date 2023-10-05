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

/**
 * Handles requests for the application home page.
 */
@Controller
public class MainController {
	
	@Autowired
	private ServletContext servletContext;
	
	@Autowired
	private ResourceLoader resLoader;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home() {
		return "home";
	}
	
	@GetMapping("regist")
	public String registForm() {
		return "regist";
	}
	
	@PostMapping("upload")
	public String upload(MultipartFile upload_file, Model model) {
		// 파일이 실제로 저장될 위치를 가져와
		String uploadPath = servletContext.getRealPath("/upload");
		
		//만약에 등록하려고 하는 upload 폴더가 없을 수도 있다. 
		File folder = new File(uploadPath);//폴더
		if(!folder.exists()) //존재하지 않는다면
			folder.mkdir(); //만들어
		
		//실제 파일이름을 가져와
		String fileName = upload_file.getOriginalFilename();
		File target = new File(uploadPath, fileName);
		//파일을 해당 폴더에 저장을 하자.
		//저장하는 방법은 크게 2가지 
		//1. FileCopyUtiles
		//2. File 인스턴스를 직접 활용
		
		try {
			FileCopyUtils.copy(upload_file.getBytes(), target);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		model.addAttribute("fileName", fileName);
		
		return "result";
	}
	
	@PostMapping("upload2")
	public String upload2(MultipartFile[] upload_files, Model model) throws IOException {
		
		//파일들의 이름을 저장할 리스트 생성 (임시)
		List<String> list = new ArrayList<>();
		
		//널이 아니면 파일들이 있다는 뜻 이므로 업로드 진행시켜~
		if(upload_files != null) {
			Resource res = resLoader.getResource("resources/upload");
			if(!res.getFile().exists())
				res.getFile().mkdir();
			
			//단순히 upload 폴더에 냅다 저장하는게 아니라 경로를 날짜별로 할건지 사람별로 할껀지에 대한 고민을 해보자.
			
			for(MultipartFile mFile :upload_files) {
				//가짜 파일들 생략(내용이 없는 것들)
				if(mFile.getSize() > 0) {
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
