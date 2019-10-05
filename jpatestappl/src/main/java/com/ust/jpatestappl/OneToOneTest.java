package com.ust.jpatestappl;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.ust.onetoone.dto.Person;
import com.ust.onetoone.dto.VotingCard;

public class OneToOneTest {

	public static void main(String[] args) {

		Person person = new Person();
		person.setId(102);
		person.setName("Aps");

		VotingCard vc = new VotingCard();
		vc.setV_id(10002);
		vc.setName("Aps");
		person.setVoterId(vc);

		EntityManagerFactory emf = null;
		EntityManager em = null;
		EntityTransaction et = null;

		try {
			emf = Persistence.createEntityManagerFactory("TestPersistence");
			em = emf.createEntityManager();
			et = em.getTransaction();
			et.begin();
			VotingCard vc1 = em.find(VotingCard.class, 10002);
			System.out.println(vc1.getId().getId());
			em.persist(person);
			em.persist(vc);
			System.out.println("Saved");
			et.commit();
		} catch (Exception e) {
			et.rollback();
			e.printStackTrace();
		} finally {
			em.close();
		}
	}
	

}
