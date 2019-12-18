package com.ustglobal.jpawithhibernateapp;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.ustglobal.jpawithhibernateapp.manytomany.Course;
import com.ustglobal.jpawithhibernateapp.manytomany.Student;
import com.ustglobal.jpawithhibernateapp.onetoone.EmployeeInfo;
import com.ustglobal.jpawithhibernateapp.onetoone.TrainingInfo;

public class TrainingManyToMany {
public static void main(String[] args) {
	


	

	EmployeeInfo e = new EmployeeInfo();		
	e.setEmail("sanm");
	e.setId(12);
	e.setName("sanm");

	List<EmployeeInfo> l = new ArrayList<EmployeeInfo>();
	l.add(e);
	

	
	TrainingInfo t1= new TrainingInfo();
	t1.setTid(3);
	t1.setTrainingtype("mean-stack");
	t1.setEmpinfo(l);
	
	EntityManager entityManager = null;
	EntityTransaction entityTransaction = null;

	try {

		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("TestPersistence");
		entityManager = entityManagerFactory.createEntityManager();
		entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		 entityManager.persist(t1);
		 entityTransaction.commit();
	
	}
	catch (Exception e1) {
		e1.printStackTrace();
		entityTransaction.rollback();

	}
	entityManager.close();
	System.out.println("Record saved");
}
}
