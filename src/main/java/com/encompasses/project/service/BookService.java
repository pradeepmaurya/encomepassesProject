package com.encompasses.project.service;

import java.lang.StackWalker.Option;
import java.util.List;

import org.apache.catalina.connector.Response;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.encompasses.project.model.Book;
import com.encompasses.project.model.Student;
import com.encompasses.project.repository.BookRepo;
import com.encompasses.project.repository.StudentRepo;

@Service
public class BookService {
	
	@Autowired
	BookRepo bookRepo;
	
	@Autowired
	StudentRepo studentRepo;
	
	//Get All Books
	public List<Book> getAllBooks(){
		return bookRepo.findAll();
	}
	
	//Post Books
	public Book addBook(String data) {
		JSONObject json = new JSONObject(data);
		System.out.println(json);
		Book book = new Book();
		book.setAuthor(json.getString("author"));
		book.setBook_id(json.getInt("book_id"));
		book.setDescription("description");
		book.setPrice(json.getInt("price"));
		book.setTitle(json.getString("title"));
		int id = json.getInt("student");
		Student student = studentRepo.findById(id).get();
		book.setStudent(student);
		
		return bookRepo.save(book);
	}
	
	//Update Books data
	public ResponseEntity<String> updateBook(Book data) {
		Book book = bookRepo.findById(data.getBook_id()).get();
		if(book != null) {
			book.setAuthor(data.getAuthor());
			book.setDescription(data.getDescription());
			book.setPrice(data.getPrice());
			book.setTitle(data.getTitle());
			book.setStudent(data.getStudent());
			bookRepo.save(book);
			return new ResponseEntity<String>("Succesfully Saved !!", HttpStatus.OK);
		}
		return new ResponseEntity<String>("Failed due to some Reason !!", HttpStatus.BAD_REQUEST);
	}
	
	//Delete Book
	public ResponseEntity<String> deleteBook(int id){
		Book book = bookRepo.findById(id).get();
		if(book != null) {
			bookRepo.delete(book);
			return new ResponseEntity<String>("Succesfully Deleted !!", HttpStatus.OK);
		}
		return new ResponseEntity<String>("Failled Due to som reason !!", HttpStatus.BAD_REQUEST);
	}
	
}
