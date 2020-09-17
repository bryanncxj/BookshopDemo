package com.example.demo.repository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.demo.model.Book;

@Configuration
public class LoadDatabase {
	
	private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

	@Bean
	CommandLineRunner initDatabase(BookRepository repository) {
		return args -> {
			log.info("Preloading " + repository.save(new Book(12345L, "Book One", "John")));
			log.info("Preloading " + repository.save(new Book(12346L, "Book Two", "Tommy")));
			log.info("Preloading " + repository.save(new Book(12347L, "Book Three", "Tim")));
			log.info("Preloading " + repository.save(new Book(12348L, "Book Four", "Sally")));
			log.info("Preloading " + repository.save(new Book(12349L, "Book Five", "Brenda")));
		};
	}
}
