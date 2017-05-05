package com.example.serviceImpl;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.EnrollmentRequest;
import com.example.dao.CourseRepo;
import com.example.dao.StudentRepo;
import com.example.entity.Course;
import com.example.entity.Student;
import com.example.service.Enrollment;
@Service
public class StudentEnrollment implements Enrollment {


	@Autowired
	StudentRepo repo;
	
	@Autowired
	CourseRepo courseRepo;
	
	@Override
	public long enroll(EnrollmentRequest request) {
		// Any processing if needeed
		Set<Course> courses = new HashSet<>();
		for(String course:request.getCourses()){
			courses.add(new Course(course));
		}
		Student student = new Student();
		student.setStudentName(request.getStudentName());
		student.setCourses(courses);
		return repo.saveAndFlush(student).getStudent_id();
	 
	}

	@Override
	public Set<Student> getStudentsList(String course) {
		
		Set<Student> students = new HashSet<>();
		for(Course co : courseRepo.getByCourseName(course)){
			students.addAll(co.getStudents());
		}
		return students;
	}

	@Override
	public void deleteByStudentId(Long id) {
		repo.delete(id);
	}

	@Override
	public String addCourse(Course course) {
		return courseRepo.save(course).getCourseName();
		
	}

}
