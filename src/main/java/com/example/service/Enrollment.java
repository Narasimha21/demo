package com.example.service;
import java.util.List;
import java.util.Set;

import com.example.EnrollmentRequest;
import com.example.entity.Course;
import com.example.entity.Student;

public interface Enrollment {
	
	public long enroll(EnrollmentRequest request);
	
	public Set<Student> getStudentsList(String course);
	
	public void deleteByStudentId(Long id);
	
	public String addCourse( Course course);

}
