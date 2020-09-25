package com.example.demo.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import com.example.demo.model.Book;
import com.example.demo.service.BookService;
import com.example.demo.service.Consumer;
import com.example.demo.service.Producer;

@WebMvcTest(controllers = BookController.class)
public class BookControllerTest {
	
	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private BookService bookService;
	
	@MockBean
	private Producer producer;
	
	@MockBean 
	private Consumer consumer;
	
	@Test
	public void expectUnauthorisedTest() throws Exception {
		// Arrange
		Book bk = new Book(224466L, "Mock Title", "Mock Author");
		
		// Act
		Mockito.when(bookService.findBook(224466L)).thenReturn(bk);
		
		// Assert
		mockMvc.perform(get("/books/{isbn}", 224466L))
				.andExpect(status().is(401));
	}
}
