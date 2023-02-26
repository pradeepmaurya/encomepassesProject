package com.encompasses.project.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
public class Laptop {
	@Id
	private Integer laptop_id;
	private String name;
	private String brand;
	private Integer price;
	
	@OneToOne
	private Student student;

	public Integer getLaptop_id() {
		return laptop_id;
	}

	public void setLaptop_id(Integer laptop_id) {
		this.laptop_id = laptop_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public Laptop(Integer laptop_id, String name, String brand, Integer price, Student student) {
		super();
		this.laptop_id = laptop_id;
		this.name = name;
		this.brand = brand;
		this.price = price;
		this.student = student;
	}

	public Laptop() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Laptop [laptop_id=" + laptop_id + ", name=" + name + ", brand=" + brand + ", price=" + price
				+ ", student=" + student + "]";
	}
	
	
}
