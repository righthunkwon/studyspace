package com.multi.campus.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.multi.campus.dao.DataDAO;
import com.multi.campus.dto.DataDTO;
import com.multi.campus.dto.DataFileDTO;

@Service
public class DataServiceImpl implements DataService {
	@Autowired
	DataDAO dao;

	@Override
	public List<DataDTO> dataAllSelect() {
		return dao.dataAllSelect();
	}

	@Override
	public int dataInsert(DataDTO dto) {
		return dao.dataInsert(dto);
	}

	@Override
	public int dataFileInsert(List<DataFileDTO> fileList) {
		return dao.dataFileInsert(fileList);
	}

	@Override
	public int dataDelete(int no) {
		return dao.dataDelete(no);
	}

	@Override
	public int dataFileDelete(int no) {
		return dao.dataFileDelete(no);
	}

	@Override
	public DataDTO dataSelect(int no) {
		return dao.dataSelect(no);
	}

	@Override
	public List<DataFileDTO> dataFileSelect(int no) {
		return dao.dataFileSelect(no);
	}
}
