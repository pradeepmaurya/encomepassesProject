package com.encompasses.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.encompasses.project.model.Book;

public interface BookRepo extends JpaRepository<Book, Integer>{

}
