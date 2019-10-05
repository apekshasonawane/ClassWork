package com.ust.jpatestappl.jpql;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.ust.jpatestappl.dto.Movie;

public class DeleteData {

	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory = null;
		EntityManager entityManager = null;

		try {

			entityManagerFactory = Persistence.createEntityManagerFactory("TestPersistence");
			entityManager = entityManagerFactory.createEntityManager();
			EntityTransaction transaction = entityManager.getTransaction();

			transaction.begin();
			//String jpql4 = "delete from Movie where id=103";
			String jpql4 = "delete from Movie where id=:id";		//for dynamic input
			Query query4 = entityManager.createQuery(jpql4);
			query4.setParameter("id", 103);
			int res = query4.executeUpdate();
			System.out.println(res);
			transaction.commit();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
