package com.ustglobal.lms.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.ustglobal.lms.dto.Book;
import com.ustglobal.lms.dto.TrackBook;
import com.ustglobal.lms.dto.Users;

@Repository
public class LibrarianDAOImpl implements LibrarianDAO{
	@PersistenceUnit
	private EntityManagerFactory factory;

	@Override
	public boolean addBook(Book bean) {

		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		try {
			transaction.begin();
			manager.persist(bean);
			transaction.commit();
			return true;
		}catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public List<Book> viewBookRequest() {

		String jpql = "SELECT b FROM Book b WHERE b.bid in(select t.bid from TrackBook t where t.status=0)";
		EntityManager manager = factory.createEntityManager();
		//Query query = manager.createQuery(jpql);
		TypedQuery<Book> query = manager.createQuery(jpql,Book.class);//to avoid downcasting
		try {
			List<Book> bean = query.getResultList();
			return bean;
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public List<Users> viewStudentRequest() {
		String jpql = "SELECT s FROM Users s WHERE s.user_id in(select t.student_id from TrackBook t)";
		EntityManager manager = factory.createEntityManager();
		//Query query = manager.createQuery(jpql);
		TypedQuery<Users> query = manager.createQuery(jpql,Users.class);//to avoid downcasting
		try {
			List<Users> bean = query.getResultList();
			return bean;
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public List<TrackBook> viewTraceBook() {
		String jpql = " FROM TrackBook";
		EntityManager manager = factory.createEntityManager();
		//Query query = manager.createQuery(jpql);
		TypedQuery<TrackBook> query = manager.createQuery(jpql,TrackBook.class);//to avoid downcasting
		try {
			List<TrackBook> bean = query.getResultList();
			return bean;
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public boolean issueBook(int bid,int status) {
		String jpql = "from TrackBook where bid=:bid";
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		try {
			transaction.begin();
			Query query = manager.createQuery(jpql);
			query.setParameter("bid", bid);
			TrackBook bean = (TrackBook) query.getSingleResult();
			TrackBook newBean = manager.find(TrackBook.class, bean.getTid());
			newBean.setStatus(status);
			//			TrackBook book = new TrackBook();
			//			int res = book.getTid();
			//			TrackBook trackBean = manager.find(TrackBook.class, res);
			//			trackBean.setBid(bid);
			//			trackBean.setStatus(status);
			transaction.commit();
			return true;
		}catch (Exception e) {
			e.printStackTrace();
			return false;
		}		
	}

	@Override
	public boolean declineBook(int bid) {
		String jpql = "from TrackBook where bid=:bid";
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		try {
			transaction.begin();
			Query query = manager.createQuery(jpql);
			query.setParameter("bid", bid);
			TrackBook bean = (TrackBook) query.getSingleResult();
			TrackBook newBean = manager.find(TrackBook.class, bean.getTid());
			if(newBean!=null) {
				manager.remove(newBean);
				transaction.commit();
				return true;
			}
			else {

				return false;
			}
			//			TrackBook book = new TrackBook();
			//			int res = book.getTid();
			//			TrackBook trackBean = manager.find(TrackBook.class, res);
			//			trackBean.setBid(bid);
			//			trackBean.setStatus(status);

		}catch (Exception e) {
			e.printStackTrace();
			return false;
		}		
	}

	@Override
	public boolean deleteBook(int bid) {
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		try {
			transaction.begin();
			Book newBean = manager.find(Book.class, bid);
			if(newBean!=null) {
				manager.remove(newBean);
				transaction.commit();
				return true;
			}
			else {
				return false;
			}
		}catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	public List<Book> viewAllBooks() {
		String jpql = "FROM Book";
		EntityManager manager = factory.createEntityManager();
		//Query query = manager.createQuery(jpql);

		TypedQuery<Book> query = manager.createQuery(jpql,Book.class);//to avoid downcasting
		try {
			List<Book> bean = query.getResultList();
			return bean;
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
/************update book*****************/
	
	@Override
	public boolean updateBook(Book bean) {
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		try {
			transaction.begin();
			Book bookBean = manager.find(Book.class, bean.getBid());
			bookBean.setBname(bean.getBname());
			bookBean.setAuthor(bean.getAuthor());
			bookBean.setEdition(bean.getEdition());
			bookBean.setVolume(bean.getVolume());
			transaction.commit();
			return true;
		}catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
}
