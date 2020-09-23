package com.example.demo.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.example.demo.dao.BookRepository;
import com.example.demo.model.Book;

@ExtendWith(MockitoExtension.class)
public class BookServiceTest {

	@Mock
	BookRepository mockBookRepository;
	
	@Mock
	Producer producer;
	
	@InjectMocks
	BookService mockBookService;

	@Test
	public void whenValidIsbnTitleShouldBeSame() {
		Book bk = new Book(678921L, "Mock Title", "Mock Author");
		Mockito.when(mockBookRepository.findByIsbn(678921L)).thenReturn(bk);

		Assertions.assertEquals("Mock Title", mockBookService.findBook(678921L).getTitle());

	}
}
