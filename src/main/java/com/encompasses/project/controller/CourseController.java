package com.encompasses.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.encompasses.project.model.Course;
import com.encompasses.project.service.CourseService;

@RestController
public class CourseController {

	@Autowired
	CourseService service;
	
	//Add Student
	@PostMapping("/course")
	public Course addCourse(@RequestBody Course data) {
		return service.addCourse(data);
	}
	
	//Get Course
	@GetMapping("/course")
	public List<Course> getAllCourse(){
		return service.getAllCourse();
	}
	
	//Update Course
	@PutMapping("/course")
	public ResponseEntity<String> updateCourse(@RequestBody Course data){
		return service.updateCourseById(data);
	}
	
	//Delete Student
	@DeleteMapping("/course/{id}")
	public ResponseEntity<String> deleteStudentById(@PathVariable("id") int id){
		return service.deleteCourse(id);
	}
}
