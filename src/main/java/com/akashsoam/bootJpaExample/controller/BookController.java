package com.akashsoam.bootJpaExample.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;	

import com.akashsoam.bootJpaExample.entity.Book;
import java.util.Optional;
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
	public ResponseEntity<List<Book>> getBooks() {
		List<Book> list = bookService.getAllBooks();
		if (list.size() <= 0) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		} else {
			return ResponseEntity.of(Optional.of(list));
		}
	}	
	
	@GetMapping("/books/{id}")
	public ResponseEntity<Book> getBookById(@PathVariable int id) {
		Book b = this.bookService.getBookById(id);
		if (b == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}else {
			return ResponseEntity.of(Optional.of(b));
		}
	}
	
	@PostMapping("/books")
	public ResponseEntity<Book> addBook(@RequestBody Book book) {
		Book b= null;
		try{
			b = bookService.addBook(book);
			System.out.println(book);
			return ResponseEntity.of(Optional.of(b));
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
	
	@DeleteMapping("/books/{id}")
	public ResponseEntity<Void> deleteBook(@PathVariable int id) {
		try {
			this.bookService.deleteBook(id);
			return ResponseEntity.status(HttpStatus.OK).build();
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
	
	//update book handler
	@PutMapping("/books/{id}")
	public ResponseEntity<Book> updateBook(@RequestBody Book book, @PathVariable int id) {
		try {
			this.bookService.updateBook(book, id);
			return ResponseEntity.of(Optional.of(book));
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}


}
