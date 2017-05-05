/**
 * 
 */
package com.example.test;

import static org.junit.Assert.*;

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
public class SampleTest {
  @ Autowired
	CourseRepo courserepo;
  @ Autowired
	StudentRepo studentRepo;

	@Test
	public void testEnroll(){
		//StudentEnrollment studentEnrollment = Mockito.mock(StudentEnrollment.class);
		Set<Course> courses = new HashSet<>();
		courses.add(new Course("b"));
		courses.add(new Course("d"));
		Student student = new Student();
		student.setStudentName("Narasimha");
		student.setCourses(courses);
		assertTrue(studentRepo.saveAndFlush(student).getStudentName().equals("Narasimha"));
	}
	
	@Test
	public void deleteByStudentId() {
		Long id = 17L;
		studentRepo.delete(id);
		assertFalse(studentRepo.exists(id));
	}

	@Test
	public void addCourse(){
		Course course = new Course();
		course.setCourseName("MCA");
	//	courserepo.save(course);
		assertTrue(courserepo.save(course).getCourseName().equals("MCA"));
	}
}
