package com.ustglobal.jpawithhibernateapp;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.ustglobal.jpawithhibernateapp.dto.Product;

public class InsertDemo {
	public static void main(String[] args) {
		Product productInfo = new Product();
		productInfo.setPid(11);
		productInfo.setPname("Book");
		productInfo.setQuantity(10);
		
		EntityManager entityManager = null;
		EntityTransaction entityTransaction = null;

		try {

			EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("TestPersistence");
			entityManager = entityManagerFactory.createEntityManager();
			entityTransaction = entityManager.getTransaction();
			entityTransaction.begin();
			entityManager.persist(productInfo);
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