/**
 * 
 */
package com.example.test;

import static org.junit.Assert.assertTrue;

import java.util.HashSet;
import java.util.Set;

import javax.transaction.Transactional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.test.context.web.WebAppConfiguration;

import com.example.DemoApplication;
import com.example.dao.CourseRepo;
import com.example.dao.StudentRepo;
import com.example.entity.Course;
import com.example.entity.Student;
import com.example.serviceImpl.StudentEnrollment;

import junit.framework.TestCase;
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = {DemoApplication.class})
@WebAppConfiguration
public class SampleTest2 {
  @ Autowired
	CourseRepo courserepo;
  @ Autowired
	StudentRepo studentRepo;
  String course = "maths";
	@Test
	public void testGetStudentsList(){
		 String course = "maths";
		Set<Student> students = new HashSet<>();
		Set<Course> courses = new HashSet<>();
		courses = courserepo.getByCourseName(course);
		for(Course co : courses){
			students.addAll(co.getStudents());
			
		}
		System.out.println(students);
		 Student[] student=students.toArray(new Student[students.size()] );
		assertTrue(student[0].getStudentName().equals("Anish"));
	}
	

}
