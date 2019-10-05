package com.ust.jpatestappl;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.ust.jpatestappl.dto.Movie;

public class App {
	public static void main(String[] args) {
		EntityTransaction transaction = null;
		EntityManager entityManager = null;
		Movie movie = new Movie();
		movie.setId(101);
		movie.setName("URI");
		movie.setRating("Good");
		try {
			EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("TestPersistence"); // object
			entityManager = entityManagerFactory.createEntityManager(); // object of EM can be created multiple times
			transaction = entityManager.getTransaction();
			transaction.begin();
			entityManager.persist(movie); // persist method is used to add object into table
			System.out.println("Saved");
			transaction.commit(); // without commit data will not be get inserted
		} catch (Exception e) {
			transaction.rollback();
			e.printStackTrace();
		} finally {
			entityManager.close();
		}
	}
}
