package com.ssafy.prac7.movie;

public interface IMovieManager {
	void add (Movie movie);
	
	Movie[] getList();
	
	Movie[] searchByTitle(String title);
	
	Movie[] getMovies();
	
	SeriesMovie[] getSeriesMovies();
	
	double getRunningTimeAvg();
}
