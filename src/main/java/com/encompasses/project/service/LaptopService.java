package com.encompasses.project.service;

import java.util.List;

import org.apache.catalina.connector.Response;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.encompasses.project.model.Laptop;
import com.encompasses.project.model.Student;
import com.encompasses.project.repository.LaptopRepo;
import com.encompasses.project.repository.StudentRepo;

@Service
public class LaptopService {
	
	@Autowired
	LaptopRepo laptopRepo;
	
	@Autowired
	StudentRepo studentRepo;
	
	
	//Get All Laptop
	public List<Laptop> getAllLaptop(){
		return laptopRepo.findAll();
	}
	
	//Add new Laptop
	public Laptop addLaptop(JSONObject json) {
		
		
		System.out.println(json);
//		JSONObject json = new JSONObject(data);
		Laptop laptop = new Laptop();
		
		laptop.setBrand(json.getString("brand"));
		laptop.setLaptop_id(json.getInt("laptop_id"));
		laptop.setName(json.getString("name"));
		laptop.setPrice(json.getInt("price"));
		
		Student student = new Student();
		student = studentRepo.findById(json.getInt("student")).get();
		System.out.println(laptop);
		
		laptop.setStudent(student);
		laptopRepo.save(laptop);
		
		
		return laptop;
	}
	
	//Update Laptop data
	public ResponseEntity<String> updateLaptop(Laptop data){
		Laptop laptop = laptopRepo.findById(data.getLaptop_id()).get();
		if(laptop != null) {
			laptop.setBrand(data.getBrand());
			laptop.setName(data.getName());
			laptop.setPrice(data.getPrice());
			laptop.setStudent(data.getStudent());
			laptop.setLaptop_id(data.getLaptop_id());
			
			return new ResponseEntity<String>("Succesfully Updated !!", HttpStatus.OK);
		}
		return new ResponseEntity<String>("Failled due to some Reason !!", HttpStatus.BAD_REQUEST);
	}
	
	//delete Laptop
	public ResponseEntity<String> deleteLaptop(int id){
		Laptop laptop = laptopRepo.findById(id).get();
		if(laptop != null) {
			laptopRepo.delete(laptop);
			return new ResponseEntity<String>("Succesfully Deleted !!", HttpStatus.OK);
		}
		
		return new ResponseEntity<String>("Failled Due to some Reason !!", HttpStatus.BAD_REQUEST);
	}

	

	
}
