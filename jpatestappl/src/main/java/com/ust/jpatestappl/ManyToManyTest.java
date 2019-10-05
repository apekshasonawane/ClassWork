package com.ust.jpatestappl;

import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.ust.manytomany.dto.Course;
import com.ust.manytomany.dto.Student;

public class ManyToManyTest {

	public static void main(String[] args) {
		Course c1=new Course();
		c1.setCourseId(112);
		c1.setCourseName("CSS");
		
		
		
		Course c2=new Course();
		c2.setCourseId(113);
		c2.setCourseName("Spring");
		//c2.setStudentId();
	
		
		
		ArrayList<Course> arrayList=new ArrayList<Course>();
		arrayList.add(c1);
		arrayList.add(c2);
		
		Student s1=new Student();
		s1.setStudentId(12);
		s1.setStudentName("Stephen");
		s1.setCourseId(arrayList);
		
		
		Student s2=new Student();
		s2.setStudentId(13);
		s2.setStudentName("John");
		s2.setCourseId(arrayList);
		
		
		
		EntityManagerFactory emf=null;
		EntityManager em=null;
		EntityTransaction et=null;
		
		try {
			emf=Persistence.createEntityManagerFactory("TestPersistence");
			em=emf.createEntityManager();
			et=em.getTransaction();
			et.begin();
			System.out.println("unidirectional");
			em.persist(s1);
			em.persist(s2);
			et.commit();
		} catch (Exception e) {
	
			e.printStackTrace();
		}
	}
}
