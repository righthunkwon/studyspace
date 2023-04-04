package com.multi.campus.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.multi.campus.dao.TransactionDAO;
import com.multi.campus.dto.BoardDTO;

@Service
public class TransactionServiceImpl implements TransactionService {
	@Autowired
	TransactionDAO dao;

	@Override
	public int transBoardInsert(BoardDTO dto) {
		return dao.transBoardInsert(dto);
	}
}
