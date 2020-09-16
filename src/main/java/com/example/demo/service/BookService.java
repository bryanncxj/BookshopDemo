package com.example.demo.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Book;
import com.example.demo.repository.BookRepository;

@Service
public class BookService {
	
	@Autowired
	BookRepository repo;
	
	public Book addBook(Book bk) {
		bk = repo.save(bk);
		System.out.println("Book created: " + bk);
		return bk;
	}
	
	public Iterable<Book> findAllBook() {
		return repo.findAll();
	}
	
	public Optional<Book> findBook(Long isbn) {
		Optional<Book> bk = repo.findById(isbn);
		System.out.println("Book found: " + bk);
		return bk;
	}

	
}
