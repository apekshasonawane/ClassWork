package com.ust.jpatestappl;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.ust.jpatestappl.dto.Movie;

public class ReadData {

	public static void main(String[] args) {

		EntityManagerFactory entityManagerFactory = null;
		EntityManager entityManager = null;

		try {

			entityManagerFactory = Persistence.createEntityManagerFactory("TestPersistence");
			entityManager = entityManagerFactory.createEntityManager();

			// Movie movie= entityManager.find(Movie.class, 101); //find() used to find
			// particular record by passing primary key
			Movie movie = entityManager.getReference(Movie.class, 103);
			System.out.println(movie.getId());
			System.out.println(movie.getName());
			System.out.println(movie.getRating());

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
