package com.ustglobal.lms.service;

import java.util.List;

import javax.net.ssl.SSLEngineResult.Status;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ustglobal.lms.dao.AdminDAO;
import com.ustglobal.lms.dao.LibrarianDAO;
import com.ustglobal.lms.dto.Book;
import com.ustglobal.lms.dto.TrackBook;
import com.ustglobal.lms.dto.Users;

@Service
public class LibrarianServiceImpl implements LibrarianService{
	@Autowired
	private LibrarianDAO dao;
	@Override
	public boolean addBook(Book bean) {
		// TODO Auto-generated method stub
		return dao.addBook(bean);
	}
	@Override
	public List<Book> viewBookRequest() {
		// TODO Auto-generated method stub
		return dao.viewBookRequest();
	}
	@Override
	public List<Users> viewStudentRequest() {
		// TODO Auto-generated method stub
		return dao.viewStudentRequest();
	}
	@Override
	public List<TrackBook> viewTraceBook() {
		// TODO Auto-generated method stub
		return dao.viewTraceBook();
	}
	@Override
	public boolean issueBook(int bid,int status) {
		// TODO Auto-generated method stu
		return dao.issueBook(bid,status);
	}
	@Override
	public boolean declineBook(int bid) {
	return dao.declineBook(bid);
	}
	@Override
	public boolean deleteBook(int bid) {
		// TODO Auto-generated method stub
		return dao.deleteBook(bid);
	}
	@Override
	public List<Book> viewAllBooks() {
		// TODO Auto-generated method stub
		return dao.viewAllBooks();
	}
	@Override
	public boolean updateBook(Book bean) {
		// TODO Auto-generated method stub
		return dao.updateBook(bean);
	}

}
