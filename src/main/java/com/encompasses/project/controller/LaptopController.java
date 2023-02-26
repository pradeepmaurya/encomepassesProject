package com.encompasses.project.controller;

import java.util.List;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.service.annotation.PatchExchange;

import com.encompasses.project.model.Laptop;
import com.encompasses.project.repository.LaptopRepo;
import com.encompasses.project.service.LaptopService;

@RestController
public class LaptopController {

	@Autowired
	LaptopService service;
	
	//Get All Laptop
	@GetMapping("/laptop")
	public List<Laptop> getAllLaptop(){
		return service.getAllLaptop();
	}
	
	//Add new Laptop
	@PostMapping("/laptop")
	public Laptop addLaptop(@RequestBody String data) {
		JSONObject json = new JSONObject(data);
		return service.addLaptop(json);
	}
	//Add one to one relationship in laptop and student
//	@PutMapping("{student_id}/laptop/{laptop_id}")
//	public ResponseEntity<String> joinStudentLaptop(@PathVariable int student_id, @PathVariable int laptop_id){
//		service.joinStudentLaptop(student_id, laptop_id);
//	}
	//Update Laptop data
	@PutMapping("/laptop")
	public ResponseEntity<String> updateLaptop(@RequestBody Laptop data){
		return service.updateLaptop(data);
	}
	
	//Delete Laptop data
	@DeleteMapping("/laptop/{id}")
	public ResponseEntity<String> deleteLaptop(@PathVariable int id){
		return service.deleteLaptop(id);
	}
}
