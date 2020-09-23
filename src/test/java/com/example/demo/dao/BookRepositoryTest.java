package com.example.demo.dao;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.example.demo.model.Book;

@DataJpaTest
public class BookRepositoryTest {
	
	@Autowired
	BookRepository mockBookRepository;
	
	@Test
	public void whenSavedFindByIsbnNotNull() {
		// Arrange
		Book bk = new Book(1234567L, "Mock Book", "Mock Author");
		
		// Act
		mockBookRepository.save(bk);
		
		// Assert 
		assertThat(mockBookRepository.findByIsbn(1234567L)).isNotNull();
	}

}
