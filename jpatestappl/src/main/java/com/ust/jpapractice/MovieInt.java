package com.ust.jpapractice;

import com.ust.jpatestappl.dto.Movie;

public interface MovieInt {
	public boolean insertMovie(Movie m);
	public void getAllMovies();
	public boolean updateMovie(Movie m);
	public boolean deleteMovie(Movie m);
	public boolean getOneRecord(Movie m);

}
