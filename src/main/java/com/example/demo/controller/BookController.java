package com.example.demo.controller;

import javax.validation.constraints.Digits;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Book;
import com.example.demo.service.BookService;
import com.example.demo.service.Consumer;
import com.example.demo.service.Producer;

@RestController
@Validated
public class BookController {

	@Autowired
	BookService service;
	
	@Autowired
	Producer producer;
	
	@Autowired
	Consumer consumer;
	
	@GetMapping("/books")
	public ResponseEntity<Iterable<Book>> findAllBook() {
		return new ResponseEntity<>(service.findAllBook(), HttpStatus.OK);
	}

	@GetMapping("/books/{isbn}")
	public ResponseEntity<Book> findBookByIsbn(@PathVariable @Digits(integer=13, fraction=0, message = "ISBN cannot exceed 13 characters") Long isbn) {
		Book bk = service.findBook(isbn);
		if (bk != null) {
			return new ResponseEntity<>(bk, HttpStatus.OK);
		} 
		else {
			//System.out.println("No such resource");
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		}

	}

//	@PostMapping("/addBook")
//	public Book addBook(@RequestParam(value = "isbn") Long isbn,
//						@RequestParam(value = "title") String title,
//						@RequestParam(value = "author") String author) {
//		Book bk = new Book();
//		bk.setIsbn(isbn);
//		bk.setTitle(title);
//		bk.setAuthor(author);
//		return service.addBook(bk);
//	}
//	
}
