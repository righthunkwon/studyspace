package com.multi.campus.controller;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

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
	
	// �ڷ�� ����Ʈ
	@RequestMapping("/data/dataList")
	public ModelAndView dataList() {
		ModelAndView mav = new ModelAndView();
		List<DataDTO> list = service.dataAllSelect();
		
		mav.addObject("list", list);
		mav.setViewName("data/dataList");
		
		return mav;
	}
	
	// �ڷ�� �� ��� ��
	@RequestMapping("/data/dataWrite")
	public String dataWrite() {
		return "data/dataWrite";
	}
	
	// �ڷ�� �۵��(DB)
	@PostMapping("/data/dataWriteOk")
	public ModelAndView dataWriteOk(HttpServletRequest request, DataDTO dto) {
		// request���� ���� ����, �۳���, ÷�������� ����ִ�.
		// session���� �۾���(logId)�� ����ִ�.
		dto.setUserid((String)request.getSession().getAttribute("logId"));
		
		// ������ ip
		dto.setIp(request.getRemoteAddr());
		
		// MultipartHttpServletRequest�� request�� �̿��Ͽ� ���Ѵ�.
		// (1) ���� ���ε�
		MultipartHttpServletRequest mr = (MultipartHttpServletRequest)request;
		
		// (2) mr���� MultipartFile ��ü�� ������ (���ε��� ������ ����ŭ ����)
		List<MultipartFile> files = mr.getFiles("filename");
		System.out.println(files.size());
		// (3) ������ ������ ���ε��� ��ġ�� �����ּҰ� �ʿ�
		String path = request.getSession().getServletContext().getRealPath("/uploadfile");
		System.out.println("path-->" + path);
		
		// ���ε� ���� (��, ������ ���ϸ��� ������ ������ ���� ���� ���ϸ��� �������� �Ѵ�)
		List<DataFileDTO> fileList = new ArrayList<DataFileDTO>();// ���ε��� ���ϸ���� ���� �÷��� 
		if(files!=null) { // ���ε��� ������ ���� ��
			for(int i=0; i<files.size(); i++) {// ���ε��� ������ ����ŭ �ݺ�����
				MultipartFile mf = files.get(i);
				String orgFilename = mf.getOriginalFilename(); // Ŭ���̾�Ʈ�� ���ε��� ���� ���ϸ��� ���Ѵ�.
				if(orgFilename != null && !orgFilename.equals("")) { // ���� ���ϸ��� �����ϸ� rename�� �����Ѵ�.
					// ���ϰ�ü�� �ִ��� Ȯ�� �� ���� ������ ������ ���ϸ��� �����Ѵ�.
					File f = new File(path, orgFilename);
					
					if(f.exists()) { // file�� ������ true, ������ false
						// abc.gif -> abc (1).gif -> abc (2).gif -> ...
						for(int renameNum=1; ; renameNum++ ) { // 1, 2, 3, 4, ...
							// ������ .�� ��ġ�� �������ν� ���ϸ�� Ȯ���ڸ� ������.
							int point = orgFilename.lastIndexOf(".");
							String orgFile = orgFilename.substring(0, point); // Ȯ���ڸ� �� ���ϸ�
							String orgExt = orgFilename.substring(point+1); // Ȯ����
							
							String newFilename = orgFile+ " (" + renameNum + ")." + orgExt; // ���� ���� ���ϸ�
							f = new File(path, newFilename);
							if(!f.exists()) { // ���� ���� ������ �������� ���� ��� �ݺ����� �ߴ��Ѵ�.
								orgFilename = newFilename;
								break;
							}
						}
					}
					// ���ο� ���ϸ��� ã���� �� ���ε带 ����, ���ϸ� ����
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
			// (4) ���� �� insert �����ϱ� (������ �������� �Բ� ���ϴ� ���)
			int result = service.dataInsert(dto);
			// ������ �������� ���ϸ��� �ִ� dto�� ����
			for(DataFileDTO fDTO : fileList) {
				fDTO.setNo(dto.getNo());
			}
			
			// (5) ���� �������� ���ϸ��� DB�� �߰�
			int fileResult = service.dataFileInsert(fileList);
			mav.setViewName("redirect:dataList");
		} catch(Exception e) {
			// ���ϻ���
			for(DataFileDTO fDTO : fileList) {
				fileDelete(path, fDTO.getFilename());
			}
			// (6) ���ڵ� �߰��� �� ������ �߻��� ��� : ���� �� ���ڵ带 �����ϰ� �۾���� �̵�(history)
			service.dataDelete(dto.getNo());
			service.dataFileDelete(dto.getNo());
			
			mav.addObject("msg", "�ڷ�� �� ��Ͽ� �����Ͽ����ϴ�.");
			mav.setViewName("data/dataResult");
		}
		return mav;
	}
	// ���ε� ���� ����
	public void fileDelete(String path, String filename) {
		File f = new File(path, filename);
		f.delete();
	}
	
	// �ڷ�� �۳��뺸��
	@GetMapping("/data/dataView/{no}")
	public ModelAndView dataView(@PathVariable("no") int no) {
		// no�� ���� ���ڵ� ����
		DataDTO dto = service.dataSelect(no);
		
		// no�� �ش��ϴ� ÷������ ����(������ �������̹Ƿ� �÷��� ���)
		List<DataFileDTO> fileList = service.dataFileSelect(no);
		ModelAndView mav = new ModelAndView();
		mav.addObject("dto", dto);
		mav.addObject("fileList", fileList);
		mav.setViewName("data/dataView");
		
		return mav;
	}
	// �ڷ�� �� ���� ��
	@GetMapping("/data/dataEdit/{num}")
	public ModelAndView dataEdit(@PathVariable("num") int no, HttpSession session) {
		ModelAndView mav = new ModelAndView();
		
		// ���� �� ��������
		DataDTO dto = service.dataEditSelect(no, (String)session.getAttribute("logId"));
		if(dto==null) { // ���� ���� �������� ���ϸ� �� ���뺸��� �̵��Ѵ�(���� ����� �������� �ʴ´�).
			mav.setViewName("redirect:dataView/"+no);
		} else { // ���� ���� ������ ��� ���� ��� ���� �����Ѵ�.
			// ���� ÷������ ��������
			List<DataFileDTO> fileList = service.dataFileSelect(no);
			mav.addObject("dto", dto);
			mav.addObject("fileList", fileList);
			mav.addObject("fileCount", fileList.size());
			
			// ���������� �̵�
			mav.setViewName("data/dataEdit");
		}
		return mav;
	}
	
	// �ڷ�� �ۼ���(DB ������Ʈ, ����, ÷������)
	@PostMapping("/data/dataEditOk")
	public ModelAndView dataEditOk(DataDTO dto, HttpSession session, HttpServletRequest request) {
		// DataDTO : ������(��ȣ, ����, ����, ������ ���ϸ�, �α��ξ��̵�)
		ModelAndView mav = new ModelAndView();
		String path = session.getServletContext().getRealPath("/uploadfile");
		
		dto.setUserid((String)session.getAttribute("logId")); // �α��� ���̵�
		
		// DB���ϰ� �������� ����
		// �������� �ʰ� ���� ����
		List<String> finalFileList = service.dataFilenameList(dto.getNo()); // DB����
		
		// ���ο� ���� ���ε�
		MultipartHttpServletRequest mr = (MultipartHttpServletRequest)request;
		List<MultipartFile> mfList = mr.getFiles("filename");
		
		// ���� ���ε�� ���ϸ��� ������ �÷���
		List<String> newFileList = new ArrayList<String>();
		if(mfList!=null) { // ���ε� ������ ���� ��
			// ���� ���ε��� MultipartFile ������ŭ �ݺ�
			for(MultipartFile mf : mfList) {
				// ���ε��� ���� ���ϸ�
				String filename = mf.getOriginalFilename();
				if(filename!=null && !filename.equals("")) { // ���ϸ��� ������ ���
					File f = new File(path, filename);
					if(f.exists()) { // ������ ������ ���
						for(int filenum=1; ; filenum++) {
							int p = filename.lastIndexOf("."); // .�� ��ġ
							String filenameNoExt = filename.substring(0, p); // ���ϸ�
							String ext = filename.substring(p+1); // Ȯ���ڸ�
							
							String newFile = filenameNoExt + " (" + filenum + ")." + ext;
							f = new File(path, newFile);
							if(!f.exists()) { // ������ ���� ���
								filename = newFile;
								break;
							}
						}//for
					}//if
					try {
						mf.transferTo(new File(path, filename));
					} catch(Exception e) {
					
					}
					// ���� ���ε��� ���ϸ��� ����
					newFileList.add(filename);
				}//if
			}//for
		}//if
		// ������ ���ϸ� -> dto.getDelfile() -> List
		// DB���� ������ ���� -> finalFileList -> List
		// ���� ���ε�� ���� -> newFileList -> List
		try {
			// ������ ���� ��
			// (1) ���� ������Ʈ
			int result = service.dataEditUpdate(dto);
			// (2) DB���� - �������� + ���� ���ε��� ����
			// DB���� - ��������
			if(dto.getDelfile()!=null) { // ������ ������ ���� ���
				for(int i=0; i<dto.getDelfile().size(); i++) {
					finalFileList.remove(dto.getDelfile().get(i));			
				}
			}
			// DB���� + ���� ���ε��� ����
			finalFileList.addAll(newFileList);
			
			System.out.println("finalFileList->" + finalFileList.toString());
			service.dataFileDelete(dto.getNo());
			
			List<DataFileDTO> fileDTOList = new ArrayList<DataFileDTO>();
			for(String fname : finalFileList) {
				DataFileDTO fDTO = new DataFileDTO();
				fDTO.setNo(dto.getNo());
				fDTO.setFilename(fname);
				fileDTOList.add(fDTO);
			}
			int fResult = service.dataFileInsert(fileDTOList);
			
			// (3) uploadfile �������� ���� ����
			if(dto.getDelfile()!=null) { // ������ ������ ���� ���
				for(int i=0; i<dto.getDelfile().size(); i++) {
					fileDelete(path, dto.getDelfile().get(i));
				}
			}
			// (4) ���� �� ���뺸��� �̵�
			mav.setViewName("redirect:dataView/"+dto.getNo());
			
		} catch(Exception e) {
			// ������ ���� ��
			// (1) ���� ���ε�� ���� ����
			for(int i=0; i<newFileList.size(); i++) {
				fileDelete(path, newFileList.get(i));
			}
			// (2) ������������ �ٽ� ������
			mav.addObject("msg", "�ڷ�� �� ������ �����Ͽ����ϴ�.");
			mav.setViewName("data/dataResult");
		}
		return mav;
	}
	
	// �ڷ�� ����
	@GetMapping("/data/dataDelete")
	public ModelAndView dataDelete(int no, HttpSession session) {
		String path = session.getServletContext().getRealPath("/uploadfile");
		// (1) DB�� �ִ� ���ϸ�� ��������
		List<String> filenameList = service.dataFilenameList(no);
		ModelAndView mav = new ModelAndView();

		// (2) ���ϸ��� �ִ� ���ڵ� ����
		int fileResult = service.dataFileDelete(no);
		
		// (2) ���� ����
		int result = service.dataEditDelete(no, (String)session.getAttribute("logId"));
		
		// (3) ���ϸ�� �����
		if(result>0) {
			// ���� ����
			for(String fname : filenameList) {
				fileDelete(path, fname);
			}
			mav.setViewName("redirect:dataList");
		} else {
			mav.setViewName("redirect:dataView/"+no);
		}
		return mav;
	}
}