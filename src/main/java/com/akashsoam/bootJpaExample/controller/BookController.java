package com.akashsoam.bootJpaExample.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.*;

import com.akashsoam.bootJpaExample.entity.Book;
import com.akashsoam.bootJpaExample.service.BookService;
@Controller
//agr RestController use kroge to @ResponseBody nhi lgani pdegi methods me
@RestController
public class BookController {
	// This is a controller class
	// This class will handle all the requests related to books
	// This class will have methods to handle requests like
	// 1. Get all books
	// 2. Get book by id
	// 3. Add book
	// 4. Update book
	// 5. Delete book
	// 6. Search book by title
	// 7. Search book by author
	
	@Autowired
	private BookService bookService;
	
	@GetMapping("/books")
//	@ResponseBody
	public List<Book> getBooks() {
		return this.bookService.getAllBooks();
	}
	
	@GetMapping("/books/{id}")
	public Book getBookById(@PathVariable int id) {
		return this.bookService.getBookById(id);
	}
	
	@PostMapping("/books")
	public Book addBook(@RequestBody Book book) {
		return this.bookService.addBook(book);
	}

}
