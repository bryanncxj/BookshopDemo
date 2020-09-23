package com.example.demo.dao;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Book;

@Repository
public interface BookRepository extends CrudRepository<Book, Long> {

	Book findByIsbn(Long isbn);
}
