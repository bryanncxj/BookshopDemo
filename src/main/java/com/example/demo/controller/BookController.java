package com.example.demo.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Book;
import com.example.demo.service.BookService;

@Validated
@RestController
public class BookController {
	
	@Autowired
	BookService service;
	
	@Autowired
	private KafkaTemplate<String, Book> kafkaTemplate;
	
	private static final String topic = "bookTopic";
	
	@RequestMapping("/addBook")
	public Book addBook(@RequestParam(value = "isbn") Long isbn,
						@RequestParam(value = "title") String title,
						@RequestParam(value = "author") String author) {
		Book bk = new Book();
		bk.setIsbn(isbn);
		bk.setTitle(title);
		bk.setAuthor(author);
		return service.addBook(bk);
	}
	
	@GetMapping("/books")
	public Iterable<Book> findAllBook() {
		return service.findAllBook();
	}
	
	@GetMapping("/book/{isbn}")
	public String findById(@PathVariable("isbn") Long isbn) {
		Optional<Book> bkContainer = service.findBook(isbn);
		if (bkContainer.isPresent()) {
			kafkaTemplate.send(topic, bkContainer.get());
			return "Result sent to consumer successfully";
		}
		else {
			return "";
		}
		
	}

}
