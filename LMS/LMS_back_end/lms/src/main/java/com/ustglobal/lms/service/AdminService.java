package com.ustglobal.lms.service;

import java.util.List;

import com.ustglobal.lms.dto.Admin;
import com.ustglobal.lms.dto.Librarian;
import com.ustglobal.lms.dto.Student;
import com.ustglobal.lms.dto.Users;

public interface AdminService {
	
	public Admin adminLogin(int id, String password);
	public boolean addUser(Users bean);
	public boolean updateUser(Users bean);
	public List<Users> viewStudent(int userType);
	public List<Users> viewAllUsers();
	public boolean deleteUser(int user_id);
	
}
