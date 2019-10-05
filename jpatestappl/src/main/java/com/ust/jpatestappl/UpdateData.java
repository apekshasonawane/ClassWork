package com.ust.jpatestappl;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.ust.jpatestappl.dto.Movie;

public class UpdateData {

	public static void main(String[] args) {

		EntityManagerFactory entityManagerFactory = null;
		EntityManager entityManager = null;
		EntityTransaction transaction = null;

		try {
			entityManagerFactory = Persistence.createEntityManagerFactory("TestPersistence");
			entityManager = entityManagerFactory.createEntityManager();
			transaction = entityManager.getTransaction();
			transaction.begin();
			Movie movie = entityManager.find(Movie.class, 103);
			System.out.println(movie);

			movie.setName("Airlift");
			System.out.println("Updated Data=>" + movie);
			System.out.println(entityManager.contains(movie));
			entityManager.detach(movie);		//detach() used to detach object 
			System.out.println(entityManager.contains(movie));
			movie.setRating("excellent");
			entityManager.merge(movie);
			System.out.println(entityManager.contains(movie));
		
			System.out.println("Updated Data=>" + movie);
			transaction.commit();

		} catch (Exception e) {
			transaction.rollback();
			e.printStackTrace();
		} finally {
			entityManager.close();
		}

	}

}
