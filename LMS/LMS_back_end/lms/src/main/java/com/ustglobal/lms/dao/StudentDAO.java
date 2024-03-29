package com.ustglobal.lms.dao;

import java.util.List;

import com.ustglobal.lms.dto.Book;
import com.ustglobal.lms.dto.TrackBook;
import com.ustglobal.lms.dto.Users;

public interface StudentDAO {
	public List<Book> viewAllBook();
	public boolean requestBook(TrackBook bean);
	public Book searchBook(String name);
}
