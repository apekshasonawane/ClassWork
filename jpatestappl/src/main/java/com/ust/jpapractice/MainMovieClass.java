package com.ust.jpapractice;

import com.ust.jpatestappl.dto.Movie;

public class MainMovieClass {

	public static void main(String[] args) {
		MovieIntImpl mi=new MovieIntImpl();
		
		Movie m1=new Movie();
		//mi.insertMovie(m1);
		
		  mi.getAllMovies(); mi.updateMovie(m1);
		//  mi.deleteMovie(m1);
		  mi.getOneRecord(m1);
		 
	}

}
