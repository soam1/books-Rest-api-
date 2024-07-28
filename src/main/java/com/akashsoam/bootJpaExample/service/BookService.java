package com.akashsoam.bootJpaExample.service;

import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import com.akashsoam.bootJpaExample.dao.BookRepository;

import org.springframework.stereotype.Service;

import com.akashsoam.bootJpaExample.entity.Book;

@Service
public class BookService {
	@Autowired
	private BookRepository bookRepository;
//	static List<Book> list = new ArrayList<>();
//	
//	static {
//		list.add(new Book(1, "Java complete referecne", "Akash soam"));
//		list.add(new Book(2, "just do it", "Soam baba"));       
//		list.add(new Book(21, "Python complete referecne", "Akash baba"));
//	}
	
	//get all books
	public List<Book> getAllBooks() {
		List<Book> list = (List<Book>)this.bookRepository.findAll();
		return list;
	}
	
	//get single book by id
	public Book getBookById(int id) {
		Book book = null;
		try {
			// book = list.stream().filter(e -> e.getId() == id).findFirst().get();
			book = this.bookRepository.findById(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return book;
	}
	
	//add book
	public Book addBook(Book b) {
		return this.bookRepository.save(b);
	}	
	
	//delete book
	public void deleteBook(int bid) {
		bookRepository.deleteById(bid);
//		list = list.stream().filter(book -> book.getId()!= bid).collect(Collectors.toList());
	}
	
	//update the book
	public void updateBook(Book book, int id) {
		book.setId(id);
		bookRepository.save(book);
	}
}
