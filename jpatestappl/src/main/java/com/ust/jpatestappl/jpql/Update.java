
package com.ust.jpatestappl.jpql;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.ust.jpatestappl.dto.Movie;

public class Update {

	public static void main(String[] args) {

		EntityManagerFactory entityManagerFactory = null;
		EntityManager entityManager = null;

		try {

			entityManagerFactory = Persistence.createEntityManagerFactory("TestPersistence");
			entityManager = entityManagerFactory.createEntityManager();
			EntityTransaction transaction = entityManager.getTransaction();

			transaction.begin();
			// String jpql3="update Movie set name='dgkdjgk' where id=101";
			String jpql3 = "update Movie set name=:name where id=:id";
			Query query3 = entityManager.createQuery(jpql3);
			query3.setParameter("name", "kite");// we can use scanner also
			query3.setParameter("id", 104);
			int result = query3.executeUpdate();
			System.out.println(result);
			transaction.commit();

		} catch (Exception e) {
			e.printStackTrace();
		}
	} 

}
