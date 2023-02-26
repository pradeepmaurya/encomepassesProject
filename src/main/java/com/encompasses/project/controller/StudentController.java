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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.encompasses.project.model.Student;
import com.encompasses.project.service.StudentService;

@RestController
public class StudentController {
	
	@Autowired
	StudentService service;
	
	//Add Student
	@PostMapping("/student")
	public Student addAstudent(@RequestBody Student data) {
		return service.addStudent(data);
	}
	
	//Get Student
	@GetMapping("/student")
	public List<Student> getAllStudent(){
		return service.getStudent();
	}
	
	//Update Student
	@PutMapping("/student")
	public ResponseEntity<String> updateStudent(@RequestBody Student data){
		return service.updateStudentById(data);
	}
	
	@PutMapping("/{student_id}/student/{course_id}")
	public ResponseEntity<String> assignCourseToStudent(@PathVariable int student_id, @PathVariable int course_id) {
		return service.assignCourseToStudent(student_id, course_id);
	}
	
	//Delete Student
	@DeleteMapping("/student/{id}")
	public ResponseEntity<String> deleteStudentById(@PathVariable("id") int id){
		return service.deleteStudent(id);
	}
}
