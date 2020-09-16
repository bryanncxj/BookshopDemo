package com.example.demo.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Book;
import com.example.demo.service.BookService;

@RestController
public class BookController {
	
	@Autowired
	BookService service;
	
	@RequestMapping("/home")
	public String hello(@RequestParam(value = "name", defaultValue = "User") String name) {
		return String.format("Welcome to the bookshop, %s!", name);
	}
	
	@RequestMapping("/books")
	public Iterable<Book> findAllBook() {
		return service.findAllBook();
	}
	
	@RequestMapping("/book/{isbn}")
	public Book findById(@PathVariable("isbn") Long isbn) {
		Optional<Book> bkContainer = service.findBook(isbn);
		return bkContainer.isPresent()?bkContainer.get():null;
	}

}
