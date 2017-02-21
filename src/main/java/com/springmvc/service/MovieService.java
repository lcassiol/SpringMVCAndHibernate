package com.springmvc.service;

import java.util.List;

import com.springmvc.model.Movie;

public interface MovieService {

	public void addMovie(Movie mv);
	public void updateMovie(Movie mv);
	public List<Movie> listMovies();
	public Movie getMovieById(Long id);
	public void removeMovie(Long id);
	
}
