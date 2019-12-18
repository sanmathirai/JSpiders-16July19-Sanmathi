package com.ustglobal.jpawithhibernateapp;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.ustglobal.jpawithhibernateapp.manytomany.Course;
import com.ustglobal.jpawithhibernateapp.manytomany.Student;


public class TestManyToMany {

	public static void main(String[] args) {

		Course c= new Course();
		c.setCid(2);
		c.setCname("java");


		List<Course> l = new ArrayList<Course>();
		l.add(c);
	
		Student s = new Student();		
		s.setSid(5);
		s.setSname("Sanmathi");
		s.setCourse(l);


		EntityManager entityManager = null;
		EntityTransaction entityTransaction = null;

		try {

			EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("TestPersistence");
			entityManager = entityManagerFactory.createEntityManager();
			entityTransaction = entityManager.getTransaction();
			entityTransaction.begin();
			 entityManager.persist(s);
			 entityTransaction.commit();
		
		}
		catch (Exception e) {
			e.printStackTrace();
			entityTransaction.rollback();

		}
		entityManager.close();
		System.out.println("Record saved");

	}

}
