package com.ustglobal.lms.controller;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.ustglobal.lms.dto.Admin;
import com.ustglobal.lms.dto.AdminResponse;
import com.ustglobal.lms.dto.Users;
import com.ustglobal.lms.service.UserService;

@CrossOrigin(origins = "*" , allowedHeaders = "*",allowCredentials = "true")
@RestController

public class UserController {

	@Autowired
	private UserService service;

/**********************  Admin Login **********************/	
	@GetMapping(path="/user-login/{user_id}/{user_password}" ,produces = MediaType.APPLICATION_JSON_VALUE)
	public AdminResponse getUser(@PathVariable("user_id")int user_id,
		@PathVariable("user_password")String user_password) {
		AdminResponse response = new AdminResponse();
		Users bean = service.userLogin(user_id, user_password);
		if(bean!=null) {
			response.setStatusCode(201);
			response.setMessage("success");
			response.setDescription("Data Found");
			response.setUser(Arrays.asList(bean));
		}
		else {
			response.setStatusCode(201);
			response.setMessage("Failed");
			response.setDescription("Data Not Found ");	
		}
		return response;
	}
}
