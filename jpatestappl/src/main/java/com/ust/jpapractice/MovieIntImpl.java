package com.ust.jpapractice;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.ust.jpatestappl.dto.Movie;

public class MovieIntImpl implements MovieInt {

	EntityManagerFactory emf = null;
	EntityManager em = null;
	EntityTransaction et = null;

	public boolean insertMovie(Movie m) {
		int id;
		String name;
		String rating;
		Scanner sc=new Scanner(System.in);
		
		emf = Persistence.createEntityManagerFactory("TestPersistence");
		em = emf.createEntityManager();
		et = em.getTransaction();
		et.begin();
		System.out.println("Enter id=>");
		id=sc.nextInt();
		sc.nextLine();
		System.out.println("Enter name=>");
		name=sc.nextLine();
		System.out.println("Enter rating=>");
		rating=sc.nextLine();
		m.setId(id);
		m.setName(name);
		m.setRating(rating);
		em.persist(m);
		System.out.println("Added....");
		et.commit();
		return true;
	}

	public void getAllMovies() {
		emf = Persistence.createEntityManagerFactory("TestPersistence");
		em = emf.createEntityManager();

		String query = "from Movie";
		Query query1 = em.createQuery(query);
		List<Movie> result = query1.getResultList();
		System.out.println(result);

	}

	public boolean updateMovie(Movie m) {
		emf = Persistence.createEntityManagerFactory("TestPersistence");
		em = emf.createEntityManager();
		et = em.getTransaction();
		et.begin();
		String query = "update Movie set name=:nm where id=:id";
		Query query1 = em.createQuery(query);
		query1.setParameter("nm", "avenger");
		query1.setParameter("id", 1);
		int m2 = query1.executeUpdate();

		System.out.println("Updated....");
		et.commit();
		return true;
	}

	
	  public boolean deleteMovie(Movie m) { // TODO Auto-generated method stub
			emf = Persistence.createEntityManagerFactory("TestPersistence");
			em = emf.createEntityManager();
			et = em.getTransaction();
			et.begin();
			String query = "delete from Movie  where id=:id";
			Query query1 = em.createQuery(query);
			query1.setParameter("id", 3);
			int m2 = query1.executeUpdate();

			System.out.println("deleted....");
			et.commit();
			return true;
	  }

	public boolean getOneRecord(Movie m) {
		int id;
	emf=Persistence.createEntityManagerFactory("TestPersistence");
	em=emf.createEntityManager();
	String q="select * from Movie where id=:id";
	System.out.println("Enter id to display info=>");
	Scanner sc=new Scanner(System.in);
	id=sc.nextInt();
	Movie m2=em.find(Movie.class, id);
	System.out.println(m2.getId());
	System.out.println(m2.getName());
	System.out.println(m2.getRating());
		return true;
	}
	 
}
