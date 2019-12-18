package com.ustglobal.lms.controller;

import java.security.Provider.Service;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.web.bind.annotation.RestController;

import com.ustglobal.lms.dto.Admin;
import com.ustglobal.lms.dto.AdminResponse;

import com.ustglobal.lms.dto.Users;
import com.ustglobal.lms.service.AdminService;

@CrossOrigin(origins = "*" , allowedHeaders = "*",allowCredentials = "true")
@RestController
public class AdminController {

	@Autowired
	private AdminService service;


	/**********************  Admin Login **********************/	
	@GetMapping(path="/login/{admin_id}/{admin_password}" ,produces = MediaType.APPLICATION_JSON_VALUE,
			consumes = MediaType.APPLICATION_JSON_VALUE)
	public AdminResponse getAdmin(@PathVariable("admin_id")int admin_id,
			@PathVariable("admin_password")String admin_password) {
		AdminResponse response = new AdminResponse();
		Admin bean = service.adminLogin(admin_id, admin_password);
		if(bean!=null) {
			response.setStatusCode(201);
			response.setMessage("success");
			response.setDescription("Data Found");
			response.setAdmin(Arrays.asList(bean));
		}
		else {
			response.setStatusCode(201);
			response.setMessage("Failed");
			response.setDescription("Data Not Found ");
		}
		return response;
	}
	/********************** Adding Student **********************/
	@PostMapping(path="/add-user" , consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public AdminResponse addUser(@RequestBody Users bean) {
		AdminResponse response = new AdminResponse();
		if(service.addUser(bean)) {
			response.setStatusCode(201);
			response.setMessage("success");
			response.setDescription("User Added");
		}
		else {
			response.setStatusCode(401);
			response.setMessage("Failure");
			response.setDescription("Data Not added to db");
		}
		return response;
	}
	/**********************Modifiying user*************************/
	@PutMapping(path="/update-user" , consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public AdminResponse modifyEmployee(@RequestBody Users bean) {
		AdminResponse response = new AdminResponse();
		if(service.updateUser(bean)) {
			response.setStatusCode(201);//if successfully added then success status code
			response.setMessage("success");
			response.setDescription("Data Modified");
		}else
		{
			response.setStatusCode(401);//if successfully added then success status code
			response.setMessage("Failure");
			response.setDescription("Data Not modified");
		}
		return response;
	}

	/************************ Remove user *************************/

	@DeleteMapping(path= "/delete-user/{user_id}" , produces = MediaType.APPLICATION_JSON_VALUE )
	public AdminResponse deleteUser(@PathVariable("user_id")int user_id) {
		AdminResponse response = new AdminResponse();
		if(service.deleteUser(user_id)) {
			response.setStatusCode(201);//if successfully added then success status code
			response.setMessage("success");
			response.setDescription("Data Modified ");
		}else
		{
			response.setStatusCode(401);//if successfully added then success status code
			response.setMessage("Failure");
			response.setDescription("Data Not modified");
		}
		return response;
	}

	/**********************  View student **********************/
	@GetMapping(path="/view-user/{userType}", produces = MediaType.APPLICATION_JSON_VALUE)
	public AdminResponse viewUser(@PathVariable("userType") int userType) {//sending entire responce not logical view
		AdminResponse response = new AdminResponse();
		List<Users> beans = service.viewStudent(userType);
		if(!beans.isEmpty()) {
			response.setStatusCode(201);
			response.setMessage("success");
			response.setDescription("ALL Data Found");
			response.setUser(beans);
		}
		else {
			response.setStatusCode(401);//if successfully added then success status code
			response.setMessage("Failure");
			response.setDescription("Data Not found");

		}
		return response;
	}
	
	
	@GetMapping(path="/view-all-users", produces = MediaType.APPLICATION_JSON_VALUE)
	public AdminResponse viewAllUsers() {//sending entire responce not logical view
		AdminResponse response = new AdminResponse();
		List<Users> beans = service.viewAllUsers();
		if(!beans.isEmpty()) {
			response.setStatusCode(201);
			response.setMessage("success");
			response.setDescription("ALL Data Found");
			response.setUser(beans);
		
		}
		else {
			response.setStatusCode(401);//if successfully added then success status code
			response.setMessage("Failure");
			response.setDescription("Data Not found");

		}
		return response;
	}
	/************************ Remove Librarian *************************/

	

}



