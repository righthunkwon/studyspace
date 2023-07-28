package com.ssafy.prac10.movie;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class MovieManagerImpl implements IMovieManager {
	private static final int MAX_SIZE = 100;
	List<Movie> movieList = new ArrayList<Movie>();

	// singleton
	private static MovieManagerImpl instance = new MovieManagerImpl();

	// 객체 생성
	private MovieManagerImpl() {
		loadData();
	}

	// 인스턴스 반환
	public static IMovieManager getInstance() {
		return instance;
	}

	@Override
	public void add(Movie movie) {
		if (movieList.size() < MAX_SIZE) {
			movieList.add(movie);
		} else if (movieList.size() == MAX_SIZE) {
			System.out.println("영화는 100개 까지만 등록할 수 있습니다.");
		}
	}

	@Override
	public List<Movie> getList() {
		return movieList;
	}

	@Override
	public List<Movie> searchByTitle(String title) throws TitleNotFoundException {
		List<Movie> result = new ArrayList<Movie>();
		int cnt = 0;
		for (int i = 0; i < movieList.size(); i++) {
			if ((movieList.get(i)).getTitle().contains(title)) {
				result.add(movieList.get(i));
				cnt++;
			}
		}
		if (cnt == 0) {
			throw new TitleNotFoundException(title);
		}
		return result;
	}

	@Override
	public List<Movie> getMovies() {
		List<Movie> result = new ArrayList<Movie>();
		for (int i = 0; i < movieList.size(); i++) {
			if (!(movieList.get(i) instanceof SeriesMovie)) {
				result.add(movieList.get(i));
			}
		}
		return result;
	}

	@Override
	public List<Movie> getSeriesMovies() {
		List<Movie> result = new ArrayList<Movie>();
		for (int i = 0; i < movieList.size(); i++) {
			if (movieList.get(i) instanceof SeriesMovie) {
				result.add(movieList.get(i));
			}
		}
		return result;
	}

	@Override
	public double getRunningTimeAvg() {
		int sum = 0;
		for (int i = 0; i < movieList.size(); i++) {
			sum += movieList.get(i).getRunningTime();
		}
		return sum / (double) movieList.size();
	}

	@Override
	public void saveData() {
		try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("movie.dat"))) {
			oos.writeObject(movieList);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void loadData() {
		File file = new File("movie.dat");
		if (file.exists()) {
			try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("movie.dat"))) {
				Object obj = ois.readObject();
				System.out.println(obj);
				movieList = (List<Movie>) obj;
			} catch (IOException | ClassNotFoundException e) {
				e.printStackTrace();
			}
		}
	}

}
