package com.ssafy.prac7.movie;

public class MovieManagerImpl implements IMovieManager {
	private static final int MAX_SIZE = 100;
	Movie[] movieList = new Movie[MAX_SIZE];
	private int size = 0;

	// singleton
	private static MovieManagerImpl instance = new MovieManagerImpl();

	// 객체 생성 방지
	private MovieManagerImpl() {
	}

	// 인스턴스 반환
	public static IMovieManager getInstance() {
		return instance;
	}

	@Override
	public void add(Movie movie) {
		if (size < MAX_SIZE) {
			movieList[size] = movie;
			size++;
		} else if (size == MAX_SIZE) {
			System.out.println("영화는 100개 까지만 등록할 수 있습니다.");
		}
	}

	@Override
	public Movie[] getList() {
		Movie[] result = new Movie[size];
		for (int i = 0; i < size; i++) {
			result[i] = movieList[i];
		}
		return result;
	}

	@Override
	public Movie[] searchByTitle(String title) {
		int cnt = 0;
		for (int i = 0; i < this.size; i++) {
			if (movieList[i].getTitle().contains(title)) {
				cnt++;
			}
		}
		
		if (cnt == 0) {
			return null;
		}

		Movie[] mv = new Movie[cnt];
		
		for (int i = 0, idx = 0; i < this.size; i++) {
			if (movieList[i].getTitle().contains(title)) {
				mv[idx++] = movieList[i];
			}
		}
		return mv;
	}

	@Override
	public Movie[] getMovies() {
		int cnt = 0;
		for (int i = 0; i < this.size; i++) {
			if (!(movieList[i] instanceof SeriesMovie)) {
				cnt++;
			}
		}
		
		if (cnt == 0) {
			return null;
		}
		
		Movie[] mv = new Movie[cnt];
		
		for (int i = 0, idx = 0; i < this.size; i++) {
			if (!(movieList[i] instanceof SeriesMovie)) {
				mv[idx] = movieList[i];
				idx++;
			}
		}
		return mv;
	}

	@Override
	public SeriesMovie[] getSeriesMovies() {
		int cnt = 0;
		for (int i = 0; i < this.size; i++) {
			if(movieList[i] instanceof SeriesMovie) {
				cnt++;
			}
		}
		
		if (cnt == 0) {
			return null;
		}
		
		SeriesMovie[] smv = new SeriesMovie[cnt];
		
		for (int i = 0, idx = 0; i < this.size; i++) {
			if (movieList[i] instanceof SeriesMovie) {
				smv[idx++] = (SeriesMovie) movieList[i];
			}
		}
		return smv;
	}

	@Override
	public double getRunningTimeAvg() {
		int sum = 0;
		for (int i = 0; i < this.size; i++) {
			sum += movieList[i].getRunningTime();
		}
		return sum / (double) this.size;
	}

}
