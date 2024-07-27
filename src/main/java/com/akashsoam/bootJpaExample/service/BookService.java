package com.akashsoam.bootJpaExample.service;

import java.util.*;

import org.springframework.stereotype.Service;

import com.akashsoam.bootJpaExample.entity.Book;

@Service
public class BookService {
	static List<Book> list = new ArrayList<>();
	
	static {
		list.add(new Book(1, "Java complete referecne", "Akash soam"));
		list.add(new Book(2, "just do it", "Soam baba"));       
		list.add(new Book(21, "Python complete referecne", "Akash baba"));
	}
	
	//get all books
	public List<Book> getAllBooks() {
		return list;
	}
	
	//get single book by id
	public Book getBookById(int id) {
		return list.stream().filter(e -> e.getId() == id).findFirst().get();
	}
	
	//add book
	public Book addBook(Book b) {
		list.add(b);
		return b;
	}	
}
