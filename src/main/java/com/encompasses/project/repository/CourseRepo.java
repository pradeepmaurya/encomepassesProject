package com.encompasses.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.encompasses.project.model.Course;

public interface CourseRepo extends JpaRepository<Course, Integer>{

}
