package com.ust.jpatestappl.jpql;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.ust.jpatestappl.dto.Movie;

public class ReadDataInList {

	public static void main(String[] args) {

		EntityManagerFactory entityManagerFactory = null;
		EntityManager entityManager = null;

		try {

			entityManagerFactory = Persistence.createEntityManagerFactory("TestPersistence");
			entityManager = entityManagerFactory.createEntityManager();
			EntityTransaction transaction = entityManager.getTransaction();

			String jpql = "from Movie";
			Query query = entityManager.createQuery(jpql);
			List<Movie> resultList = query.getResultList();

			for (Movie movie : resultList) {
				System.out.println(movie.getId());
				System.out.println(movie.getName());
				System.out.println(movie.getRating());
				System.out.println("************************************");

				String jpql2 = "select name from Movie";
				Query query2 = entityManager.createQuery(jpql2);

				/*
				 * List<Movie> resultNameList=query.getResultList();
				 * System.out.println("All movie names are here=>"); for(Movie
				 * movie1:resultNameList) { System.out.println(movie1.getId());
				 * System.out.println("****************************"); }
				 */

				List<String> resultNameList = query2.getResultList();
				System.out.println("All movie names are here=>");
				for (String string : resultNameList) {
					System.out.println(string);
					System.out.println("****************************");
				}

			}
 
			// Movie movie= entityManager.find(Movie.class, 101); //find() used to find
			// particular record by passing primary key
			/*
			 * Movie movie = entityManager.getReference(Movie.class, 103);
			 * System.out.println(movie.getId()); System.out.println(movie.getName());
			 * System.out.println(movie.getRating());
			 */

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
