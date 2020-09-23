package com.example.demo.service;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.BookRepository;
import com.example.demo.model.Book;

@Service
public class BookService {
	
	@Autowired
	BookRepository repo;
	
	@Autowired
	Producer producer;
	
	public Book addBook(Book bk) {
		bk = repo.save(bk);
		System.out.println("[Service] Book created: " + bk);
		return bk;
	}
	
	public Iterable<Book> findAllBook() {
		
		return repo.findAll();
	}
	
	public Book findBook(Long isbn) {
		Book bk = repo.findByIsbn(isbn);
		if (bk != null) {
			this.producer.sendMessage(bk);
			System.out.println("[Service] Book found: " + bk);			
			return bk;
		}
		else { 
			return null;
		}
	}

	
}
