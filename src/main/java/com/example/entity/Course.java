package com.example.entity;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="course")
public class Course implements Serializable  {

	@Id
	@Column(name="course_id")
	@GeneratedValue
	private Long course_id;

	@Column(name="courseName")
	public String courseName;
		
	@JsonIgnore
	@ManyToMany(mappedBy = "courses",fetch=FetchType.EAGER,cascade=CascadeType.DETACH)
	
	private Set<Student> students;
	
	public Long getCourse_id() {
		return course_id;
	}
   
	
	public Course() {
		super();
	}


	@Override
	public String toString() {
		return "Course [course_id=" + course_id + ", courseName=" + courseName + ", students=" + students + "]";
	}

	public void setCourse_id(Long course_id) {
		this.course_id = course_id;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public Set<Student> getStudents() {
		return students;
	}

	public void setStudents(Set<Student> students) {
		this.students = students;
	}

	public Course(String courseName) {
		this.courseName = courseName;
		
	}
	
	// Getter and Setter methods
}
 