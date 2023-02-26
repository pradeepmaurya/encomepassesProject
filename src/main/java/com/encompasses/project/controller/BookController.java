package com.encompasses.project.controller;

import java.util.List;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.encompasses.project.model.Book;
import com.encompasses.project.repository.BookRepo;
import com.encompasses.project.service.BookService;

@RestController
public class BookController {

	@Autowired
	BookService service;
	
	//Get All Books
	@GetMapping("/book")
	public List<Book> getAllBooks(){
		return service.getAllBooks();
	}
	
	//Add Book
	@PostMapping("/book")
	public Book addBook(@RequestBody String data){
//		System.out.println(data);
		return service.addBook(data);
	}
	
	//Update Book
	@PutMapping("/book")
	public ResponseEntity<String> updateBook(@RequestBody Book data){
		return service.updateBook(data);
	}
	
	//Delete Book
	@DeleteMapping("/book/{id}")
	public ResponseEntity<String> deleteBook(@PathVariable int id){
		return service.deleteBook(id);
	}
}
