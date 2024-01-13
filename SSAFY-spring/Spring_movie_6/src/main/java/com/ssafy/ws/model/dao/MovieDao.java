package com.ssafy.ws.model.dao;

import java.util.List;

import com.ssafy.ws.model.dto.Movie;

public interface MovieDao {

	int insert(Movie movie);

	Movie searchById(int id);

	List<Movie> selectAll();

	List<Movie> searchByTitle(String title);

}
