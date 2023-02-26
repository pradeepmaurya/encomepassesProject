package com.encompasses.project.service;

import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.encompasses.project.model.Course;
import com.encompasses.project.model.Student;
import com.encompasses.project.repository.CourseRepo;
import com.encompasses.project.repository.StudentRepo;

@Service
public class StudentService {
	
	@Autowired
	private StudentRepo repo;
	
	@Autowired
	private CourseRepo courseRepo;
	
	//Add Student data
	public Student addStudent(Student data) {	
		
		Student student = repo.save(data);
		return student;
	}
	
	//Get Student data
	public List<Student> getStudent() {
		return repo.findAll();
	}
	
	//update Student data
	public ResponseEntity<String> updateStudentById(Student data) {
		List<Student> list = repo.findAll();
		for(Student student:list) {
			if(student.getId() == data.getId()) {
				student.setName(data.getName());
				student.setAge(data.getAge());
				student.setPhoneNumber(data.getPhoneNumber());
				student.setBranch(data.getBranch());
				student.setDepartment(data.getBranch());
				student.setAddress(data.getAddress());
				
				repo.save(student);
				return new ResponseEntity<>("Succesfully Saved", HttpStatus.OK);
			}
		}
		return new ResponseEntity<String>("Failled Due to some Reason", HttpStatus.BAD_REQUEST);
	}
	
	
	//delete Student data
	public ResponseEntity<String> deleteStudent(int id){
		Optional<Student> findById = repo.findById(id);
		if(findById != null) {
			repo.deleteById(id);
			return new ResponseEntity<String>("Succesfully Deleted !! ", HttpStatus.OK);
		}
		
		return new ResponseEntity<String>("Failled Due to some Reason !!", HttpStatus.BAD_REQUEST);
	}

	public ResponseEntity<String> assignCourseToStudent(int student_id, int course_id) {
		List<Student> list1 = new ArrayList<>();
		List<Course> list2 = new ArrayList<>();
		Student student = repo.findById(student_id).get();
		list1.add(student);
		Course course = courseRepo.findById(course_id).get();
		list2.add(course);
		student.setCourseList(list2);
		course.setStudentList(list1);
		repo.save(student);
		courseRepo.save(course);
		return new ResponseEntity<String>("Succes", HttpStatus.OK);
	}
}
