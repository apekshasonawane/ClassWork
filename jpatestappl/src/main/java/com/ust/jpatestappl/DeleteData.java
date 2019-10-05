package com.ust.jpatestappl;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.ust.jpatestappl.dto.Movie;

public class DeleteData {

	public static void main(String[] args) {
		
		  Movie movie = new Movie(); 
		  EntityManagerFactory entityManagerFactory = null;
		 
		EntityManager entityManager = null;
		EntityTransaction transaction = null;

		entityManagerFactory = Persistence.createEntityManagerFactory("TestPersistence");
		entityManager = entityManagerFactory.createEntityManager();
		transaction = entityManager.getTransaction();

		movie = entityManager.find(Movie.class, 104);
		transaction.begin();
		entityManager.remove(movie);
		// entityManager.getTransaction().commit();
		transaction.commit();
		System.out.println(movie + "Deleted");

	}// end of main

}// end of class
