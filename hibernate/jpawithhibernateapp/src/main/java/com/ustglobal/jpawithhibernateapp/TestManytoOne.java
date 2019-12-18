package com.ustglobal.jpawithhibernateapp;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.ustglobal.jpawithhibernateapp.onetomany.Pencil;
import com.ustglobal.jpawithhibernateapp.onetomany.PencilBox;
import com.ustglobal.jpawithhibernateapp.onetoone.VoterCard;

public class TestManytoOne {
public static void main(String[] args) {

	PencilBox pencilBox = new PencilBox();
	pencilBox.setBid(2);
	pencilBox.setBname("Apsara"); 
	
	Pencil pencil = new Pencil();
	pencil.setPid(5);
	pencil.setColor("red");
	pencil.setPencilBox(pencilBox);
	
	Pencil pencil1 = new Pencil();
	pencil1.setPid(5);
	pencil1.setColor("Blue");
	
	
	
	
	
	EntityManager entityManager = null;
	EntityTransaction entityTransaction = null;

	try {

		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("TestPersistence");
		entityManager = entityManagerFactory.createEntityManager();
		entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
			/*
			 * entityManager.persist(pencil);
			 */
			/* entityManager.persist(pencilBox); */
		entityManager.persist(pencil);
		System.out.println(entityManager.find(PencilBox.class, 10)); 
	
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
