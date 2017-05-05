package com.example.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.EnrollmentRequest;
import com.example.dao.CourseRepo;
import com.example.dao.StudentRepo;
import com.example.entity.Course;
import com.example.entity.Student;
import com.example.service.Enrollment;

@RestController
@RequestMapping(value = "v1/api/")
public class EnrollController {
	
	
	@Autowired
	Enrollment service;

	
	@RequestMapping(value = "/enroll", method = RequestMethod.POST)
	@ResponseBody
	public Map<String,Long> enrollCourse(@RequestBody final EnrollmentRequest request){
		//do validation on request 
		Map<String,Long> map = new HashMap<>();
		map.put("Created student with id :",service.enroll(request));
		return map;
	}
		
	@RequestMapping( method = RequestMethod.GET)
	@ResponseBody
	public Set<Student> getStudentsBySubject(@RequestParam final String sub){
		//do validation on request 
		return service.getStudentsList(sub);
	}
	
	
}
