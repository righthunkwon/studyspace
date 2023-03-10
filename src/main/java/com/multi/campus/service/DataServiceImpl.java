package com.multi.campus.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.multi.campus.dao.DataDAO;
import com.multi.campus.dto.DataDTO;

@Service
public class DataServiceImpl implements DataService {
	@Autowired
	DataDAO dao;

	@Override
	public List<DataDTO> dataAllSelect() {
		return dao.dataAllSelect();
	}
}
