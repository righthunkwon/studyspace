package com.multi.campus.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.multi.campus.dao.CommentDAO;
import com.multi.campus.dto.CommentDTO;

@Service
public class CommentServiceImpl implements CommentService {
	@Autowired
	CommentDAO dao;

	@Override
	public int commentInsert(CommentDTO dto) {
		return dao.commentInsert(dto);
	}
}
