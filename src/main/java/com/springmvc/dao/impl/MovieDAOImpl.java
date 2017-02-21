package com.springmvc.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.springmvc.dao.MovieDAO;
import com.springmvc.model.Movie;

@Repository
public class MovieDAOImpl implements MovieDAO{

	private static final Logger logger = LoggerFactory.getLogger(MovieDAOImpl.class);
	
	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sf){
		this.sessionFactory = sf;
	}
	
	public void addMovie(Movie mv) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(mv);
		logger.info("Movie saved successfully, Person Details=" + mv);
		
	}

	public void updateMovie(Movie mv) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(mv);
		logger.info("Movie updated successfully, Movie Details=" + mv);
		
	}

	public List<Movie> listMovie() {
		Session session = this.sessionFactory.getCurrentSession();
		List<Movie> movieList = session.createQuery("from Movie").list();
		for(Movie mv : movieList){
			logger.info("Movie List::" + mv);
		}
		
		return movieList;
	}

	public Movie getMovieById(Long id) {
		Session session = this.sessionFactory.getCurrentSession();		
		Movie mv = (Movie) session.load(Movie.class, new Long(id));
		logger.info("Movie loaded successfully, Movie details=" + mv);
		
		return mv;
	}

	public void removeMovie(Long id) {
		Session session = this.sessionFactory.getCurrentSession();
		Movie mv = (Movie) session.load(Movie.class, new Long(id));
		if(null != mv){
			session.delete(mv);
		}
		
		logger.info("Movie deleted successfully, person details=" + mv);
	}

}
