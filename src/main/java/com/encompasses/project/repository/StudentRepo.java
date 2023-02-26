package com.encompasses.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.encompasses.project.model.Student;

public interface StudentRepo extends JpaRepository<Student, Integer>{

}
