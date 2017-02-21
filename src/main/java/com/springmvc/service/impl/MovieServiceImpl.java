package com.springmvc.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import com.springmvc.dao.MovieDAO;
import com.springmvc.model.Movie;
import com.springmvc.service.MovieService;

public class MovieServiceImpl implements MovieService{

	private MovieDAO movieDAO;
	
	public void setMovieDAO(MovieDAO movieDAO) {
		this.movieDAO = movieDAO;
	}
	
	@Transactional
	public void addMovie(Movie mv) {
		this.movieDAO.addMovie(mv);
		
	}
	
	@Transactional
	public void updateMovie(Movie mv) {
		this.movieDAO.updateMovie(mv);
		
	}

	@Transactional
	public List<Movie> listMovies() {

		return this.movieDAO.listMovie();
	}

	@Transactional
	public Movie getMovieById(Long id) {
		return this.movieDAO.getMovieById(id);
	}

	@Transactional
	public void removeMovie(Long id) {
		this.movieDAO.removeMovie(id);
	}
	
	

}
