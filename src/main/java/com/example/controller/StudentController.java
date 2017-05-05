package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.dao.StudentRepo;
import com.example.entity.Student;
import com.example.service.Enrollment;

@RestController
@RequestMapping(value = "v1/api/students")
public class StudentController {
	
	
	@Autowired
	Enrollment service;
	@Autowired
	StudentRepo studentrepo;
	
	@RequestMapping( method = RequestMethod.POST)
	@ResponseBody
	public void addStudent(@RequestBody  Student student ){
		//do validation on request 
		
		studentrepo.save(student);
	
	}
	
	@RequestMapping(method = RequestMethod.GET)
	@ResponseBody
	public List<Student> getStudentsList(){
		//do validation on request 
		return studentrepo.findAll();
	}
		
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	@ResponseBody
	public void deleteStudentById(@PathVariable final Long id){
		//do validation on request 
		service.deleteByStudentId(id);
	}


}
