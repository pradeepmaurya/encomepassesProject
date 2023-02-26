package com.encompasses.project.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.encompasses.project.model.Course;
import com.encompasses.project.model.Student;
import com.encompasses.project.repository.CourseRepo;

@Service
public class CourseService {

	@Autowired
	CourseRepo repo;
	
	// Add Course Service
	public Course addCourse(Course data) {
		return repo.save(data);
	}
	
	// Get All Courses service
	public List<Course> getAllCourse(){
		return repo.findAll();
	}
	
	
	//update Course data
	public ResponseEntity<String> updateCourseById(Course data) {
		List<Course> list = repo.findAll();
		for(Course course:list) {
			if(course.getCourse_id() == data.getCourse_id()) {
				course.setTitle(data.getTitle());
				course.setDescription(data.getDescription());
				course.setDuration(data.getDuration());
				course.setStudentList(data.getStudentList());
				repo.save(course);
				return new ResponseEntity<>("Succesfully Saved", HttpStatus.OK);
			}
		}
		return new ResponseEntity<String>("Failled Due to some Reason", HttpStatus.BAD_REQUEST);
	}
	
	
	//delete Course data
	public ResponseEntity<String> deleteCourse(int id){
		Optional<Course> findById = repo.findById(id);
		if(findById != null) {
			repo.deleteById(id);
			return new ResponseEntity<String>("Succesfully Deleted !! ", HttpStatus.OK);
		}
		
		return new ResponseEntity<String>("Failled Due to some Reason !!", HttpStatus.BAD_REQUEST);
	}
}
