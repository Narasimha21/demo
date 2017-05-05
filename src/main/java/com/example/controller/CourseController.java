package com.example.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.dao.CourseRepo;
import com.example.entity.Course;
import com.example.service.Enrollment;

@RestController
@RequestMapping(value = "v1/api/courses")
public class CourseController {
	
	
	@Autowired
	Enrollment service;
	@Autowired
	CourseRepo courserepo;
	
	@RequestMapping(method = RequestMethod.POST)
	@ResponseBody
	public String Course(@RequestBody  Course course ){
		//do validation on request
		
		return service.addCourse(course);
	
	}
	
	@RequestMapping( method = RequestMethod.GET)
	@ResponseBody
	public List<Course> getCoursesList(){
		//do validation on request 
		return courserepo.findAll();
	}
		
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	@ResponseBody
	public void deleteCourseById(@PathVariable final Long id){
		//do validation on request
		courserepo.delete(id);
		//service.deleteByStudentId(id);;
	}


}
