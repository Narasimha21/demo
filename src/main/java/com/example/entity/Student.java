package com.example.entity;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="student")
public class Student implements Serializable  {
	@Id
	@Column(name ="student_id")
	@GeneratedValue
private long student_id;
@Column(name="student_name")	
private String studentName;


public Long getStudent_id() {
	return student_id;
}
public void setStudent_id(Long student_id) {
	this.student_id = student_id;
}
public String getStudentName() {
	return studentName;
}
public void setStudentName(String studentName) {
	this.studentName = studentName;
}

@JsonIgnore
@ManyToMany(cascade ={CascadeType.PERSIST, CascadeType.MERGE},fetch=FetchType.LAZY)
@JoinTable(name="enrollment", 
			joinColumns={@JoinColumn(name="student_id",nullable = false, updatable = false)}, 
			inverseJoinColumns={@JoinColumn(name="course_id",nullable = false, updatable = false)})

private Set<Course> courses;

public Student() {
}

public Student(String firstname) {
	this.studentName = firstname;
}

public void setCourses(Set<Course> courses) {
	this.courses = courses;
}

}
