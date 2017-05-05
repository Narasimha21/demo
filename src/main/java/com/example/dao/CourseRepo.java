package com.example.dao;

import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.entity.Course;

@Repository
@Transactional
public interface CourseRepo extends JpaRepository<Course,Long>{

	Set<Course> getByCourseName(String course);
   
     
   }
