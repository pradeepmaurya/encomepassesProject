package com.encompasses.project.model;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;



@Entity
public class Course {

	@Id
	private Integer course_id;
	private String title;
	private String description;
	private String duration;
	
	@ManyToMany
	@JsonIgnore
	List<Student> studentList =new ArrayList<>();

	public Integer getCourse_id() {
		return course_id;
	}

	public void setCourse_id(Integer course_id) {
		this.course_id = course_id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getDuration() {
		return duration;
	}

	public void setDuration(String duration) {
		this.duration = duration;
	}

	public List<Student> getStudentList() {
		return studentList;
	}

	public void setStudentList(List<Student> studentList) {
		this.studentList = studentList;
	}

	public Course(Integer course_id, String title, String description, String duration, List<Student> studentList) {
		super();
		this.course_id = course_id;
		this.title = title;
		this.description = description;
		this.duration = duration;
		this.studentList = studentList;
	}

	public Course() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Course [course_id=" + course_id + ", title=" + title + ", description=" + description + ", duration="
				+ duration + ", studentList=" + studentList + "]";
	}
	
	
	
}
