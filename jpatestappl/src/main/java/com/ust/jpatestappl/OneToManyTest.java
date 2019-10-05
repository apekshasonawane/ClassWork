package com.ust.jpatestappl;

import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.ust.onetomany.dto.Pencil;
import com.ust.onetomany.dto.PencilBox;

public class OneToManyTest {

	public static void main(String[] args) {
	EntityManagerFactory emf=null;
	EntityManager em=null;
	EntityTransaction et=null;
	
	Pencil p=new Pencil();
	p.setpId(101);
	p.setpName("Hb");
	
	Pencil p1=new Pencil();
	p1.setpId(102);
	p1.setpName("Hb");
	
	ArrayList<Pencil> pen=new ArrayList<Pencil>();
	pen.add(p1);
	pen.add(p);
	
	PencilBox pb=new PencilBox();
	pb.setBoxId(11);
	pb.setBoxName("apsara");
	pb.setpId(pen);
	
	emf=Persistence.createEntityManagerFactory("TestPersistence");
	em=emf.createEntityManager();
	et=em.getTransaction();
	et.begin();
	em.persist(pb);
	et.commit();
	}
}


