package com.ustglobal.springrest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ustglobal.springrest.dto.EmployeeBean;
import com.ustglobal.springrest.service.EmployeeService;

@RestController
public class EmployeeController {

	@Autowired
	private EmployeeService service;

	@PostMapping(path="/add" , consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public boolean addEmployee(@RequestBody EmployeeBean bean) {//sending entire responce not logical view
		return service.addEmployee(bean);
	}


	//***********************************************************************************************	
	@PutMapping(path="/modify" , consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public boolean modifyEmployee(@RequestBody EmployeeBean bean) {
		return service.modifyEmployee(bean);
	}

	//***********************************************************************************************	
	@DeleteMapping(path= "/delete/{id}" , produces = MediaType.APPLICATION_JSON_VALUE )
	public boolean deleteEmployee(@PathVariable("id")int id) {
		return service.deleteEmployee(id);
	}

	//***********************************************************************************************	
	@GetMapping(path= "/get" ,produces = MediaType.APPLICATION_JSON_VALUE)
	public EmployeeBean getEmployee(@RequestParam("id")int id) {
		return service.getEmployee(id);
	}
	
	//***********************************************************************************************	
	@GetMapping(path= "/get-all" ,produces = MediaType.APPLICATION_JSON_VALUE)
	public List<EmployeeBean> getAllEmployee(){
		return service.getAllEmployee();
	}
}
