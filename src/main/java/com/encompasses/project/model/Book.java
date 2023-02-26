package com.encompasses.project.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;


@Entity
public class Book {

	@Id
	private Integer book_id;
	private String title;
	private String author;
	private String description;
	private Integer price;
	
	@ManyToOne
	private Student student;

	public Integer getBook_id() {
		return book_id;
	}

	public void setBook_id(Integer book_id) {
		this.book_id = book_id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
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

	public Book(Integer book_id, String title, String author, String description, Integer price, Student student) {
		super();
		this.book_id = book_id;
		this.title = title;
		this.author = author;
		this.description = description;
		this.price = price;
		this.student = student;
	}

	public Book() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Book [book_id=" + book_id + ", title=" + title + ", author=" + author + ", description=" + description
				+ ", price=" + price + ", student=" + student + "]";
	}
	
	
}
