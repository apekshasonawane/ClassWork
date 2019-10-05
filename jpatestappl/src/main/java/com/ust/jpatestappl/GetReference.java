package com.ust.jpatestappl;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.ust.jpatestappl.dto.Movie;

public class GetReference {

	public static void main(String[] args) {

		EntityManagerFactory entityManagerFactory = null;
		EntityManager entityManager = null;

		try {

			entityManagerFactory = Persistence.createEntityManagerFactory("TestPersistence");
			entityManager = entityManagerFactory.createEntityManager();

			Movie movie = entityManager.getReference(Movie.class, 109);// entityNotFoundException for unavailable primary key
			System.out.println(movie.getId());
			System.out.println(movie.getName());
			System.out.println(movie.getRating());
			System.out.println(movie.getClass());

			/*
			 * Movie movie1=entityManager.find(Movie.class, 103);//NullPointerException for
			 * unavailable primary key System.out.println(movie1.getId());
			 * System.out.println(movie1.getName()); System.out.println(movie1.getRating());
			 * System.out.println(movie1.getClass());
			 */

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
