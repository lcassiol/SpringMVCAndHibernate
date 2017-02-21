package com.springmvc.dao;

import java.util.List;

import com.springmvc.model.Movie;


public interface MovieDAO {
	
	public void addMovie(Movie mv);
	public void updateMovie(Movie mv);
	public List<Movie> listMovie();
	public Movie getMovieById(Long id);
	public void removeMovie(Long id);

}
