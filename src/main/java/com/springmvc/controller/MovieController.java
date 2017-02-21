package com.springmvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.springmvc.model.Movie;
import com.springmvc.service.MovieService;

@Controller
public class MovieController {

	private MovieService movieService;
	
	@Autowired
	@Qualifier(value="movieService")
	public void setMovieService(MovieService ms)
	{
		this.movieService = ms;
	}
	
	@RequestMapping(value = "/movies", method = RequestMethod.GET)
	public String listMovies(Model model) {
		model.addAttribute("movie", new Movie());
		model.addAttribute("listMovies", this.movieService.listMovies());
		return "movie";
	}
	
	//For add and update movie both
	@RequestMapping(value= "/movie/add", method = RequestMethod.POST)
	public String addMovie(@ModelAttribute("movie") Movie mv){
		
		System.out.println(mv.getName());
		if(mv.getId() == null){
			//new person, add it
			this.movieService.addMovie(mv);
		}else{
			//existing person, call update
			this.movieService.updateMovie(mv);
		}
		
		return "redirect:/movies";
		
	}
	
	@RequestMapping("/remove/{id}")
    public String removeMovie(@PathVariable("id") Long id){
		
        this.movieService.removeMovie(id);
        return "redirect:/movies";
    }
 
    @RequestMapping("/edit/{id}")
    public String editPerson(@PathVariable("id") Long id, Model model){
        model.addAttribute("movie", this.movieService.getMovieById(id));
        model.addAttribute("listMovies", this.movieService.listMovies());
        return "movie";
    }
	
}
