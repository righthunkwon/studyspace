package com.multi.campus.controller;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import com.multi.campus.dto.DataDTO;
import com.multi.campus.dto.DataFileDTO;
import com.multi.campus.service.DataService;

@Controller
public class DataController {
	@Inject
	DataService service;
	
	// 자료실 리스트
	@RequestMapping("/data/dataList")
	public ModelAndView dataList() {
		ModelAndView mav = new ModelAndView();
		List<DataDTO> list = service.dataAllSelect();
		
		mav.addObject("list", list);
		mav.setViewName("data/dataList");
		
		return mav;
	}
	
	// 자료실 글 등록 폼
	@RequestMapping("/data/dataWrite")
	public String dataWrite() {
		return "data/dataWrite";
	}
	
	// 자료실 글등록(DB)
	@PostMapping("/data/dataWriteOk")
	public ModelAndView dataWriteOk(HttpServletRequest request, DataDTO dto) {
		// request에는 폼의 제목, 글내용, 첨부파일이 들어있다.
		// session에는 글쓴이(logId)가 들어있다.
		dto.setUserid((String)request.getSession().getAttribute("logId"));
		
		// 접속자 ip
		dto.setIp(request.getRemoteAddr());
		
		// MultipartHttpServletRequest는 request를 이용하여 구한다.
		// (1) 파일 업로드
		MultipartHttpServletRequest mr = (MultipartHttpServletRequest)request;
		
		// (2) mr에서 MultipartFile 객체를 얻어오기 (업로드한 파일의 수만큼 존재)
		List<MultipartFile> files = mr.getFiles("filename");
		System.out.println(files.size());
		// (3) 파일을 서버에 업로드할 위치의 절대주소가 필요
		String path = request.getSession().getServletContext().getRealPath("/uploadfile");
		System.out.println("path-->" + path);
		
		// 업로드 시작 (단, 동일한 파일명의 파일이 존재할 때는 새로 파일명을 만들어줘야 한다)
		List<DataFileDTO> fileList = new ArrayList<DataFileDTO>();// 업로드한 파일명들을 담을 컬렉션 
		if(files!=null) { // 업로드한 파일이 있을 때
			for(int i=0; i<files.size(); i++) {// 업로드한 파일의 수만큼 반복수행
				MultipartFile mf = files.get(i);
				String orgFilename = mf.getOriginalFilename(); // 클라이언트가 업로드한 원래 파일명을 구한다.
				if(orgFilename != null && !orgFilename.equals("")) { // 원래 파일명이 존재하면 rename을 수행한다.
					// 파일객체가 있는지 확인 후 같은 파일이 있으면 파일명을 변경한다.
					File f = new File(path, orgFilename);
					
					if(f.exists()) { // file이 있으면 true, 없으면 false
						// abc.gif -> abc (1).gif -> abc (2).gif -> ...
						for(int renameNum=1; ; renameNum++ ) { // 1, 2, 3, 4, ...
							// 마지막 .의 위치를 구함으로써 파일명과 확장자를 나눈다.
							int point = orgFilename.lastIndexOf(".");
							String orgFile = orgFilename.substring(0, point); // 확장자를 뺀 파일명
							String orgExt = orgFilename.substring(point+1); // 확장자
							
							String newFilename = orgFile+ " (" + renameNum + ")." + orgExt; // 새로 만든 파일명
							f = new File(path, newFilename);
							if(!f.exists()) { // 새로 만들 파일이 존재하지 않을 경우 반복문을 중단한다.
								orgFilename = newFilename;
								break;
							}
						}
					}
					// 새로운 파일명을 찾았을 때 업로드를 수행, 파일명 보관
					try {
						mf.transferTo(new File(path, orgFilename));
					} catch(Exception e) {
						
					}
					System.out.println(orgFilename);
					DataFileDTO dfDTO = new DataFileDTO();
					dfDTO.setFilename(orgFilename);
					fileList.add(dfDTO);
				}
			}
		}
		ModelAndView mav = new ModelAndView();
		try {
			// (4) 메인 글 insert 구현하기 (생성된 시퀀스를 함께 구하는 방식)
			int result = service.dataInsert(dto);
			// 원글의 시퀀스를 파일명이 있는 dto에 세팅
			for(DataFileDTO fDTO : fileList) {
				fDTO.setNo(dto.getNo());
			}
			
			// (5) 원글 시퀀스와 파일명을 DB에 추가
			int fileResult = service.dataFileInsert(fileList);
			mav.setViewName("redirect:dataList");
		} catch(Exception e) {
			// 파일삭제
			for(DataFileDTO fDTO : fileList) {
				fileDelete(path, fDTO.getFilename());
			}
			// (6) 레코드 추가할 때 에러가 발생할 경우 : 파일 및 레코드를 삭제하고 글쓰기로 이동(history)
			service.dataDelete(dto.getNo());
			service.dataFileDelete(dto.getNo());
			
			mav.addObject("msg", "자료실 글 등록에 실패하였습니다.");
			mav.setViewName("data/dataResult");
		}
		return mav;
	}
	// 업로드 파일 삭제
	public void fileDelete(String path, String filename) {
		File f = new File(path, filename);
		f.delete();
	}
	
	// 자료실 글내용보기
	@GetMapping("/data/dataView/{no}")
	public ModelAndView dataView(@PathVariable("no") int no) {
		// no와 같은 레코드 선택
		DataDTO dto = service.dataSelect(no);
		
		// no에 해당하는 첨부파일 선택(파일은 여러개이므로 컬렉션 사용)
		List<DataFileDTO> fileList = service.dataFileSelect(no);
		ModelAndView mav = new ModelAndView();
		mav.addObject("dto", dto);
		mav.addObject("fileList", fileList);
		mav.setViewName("data/dataView");
		
		return mav;
	}
}
