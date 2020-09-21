package com.example.demo.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import com.example.demo.service.BookService;
import com.example.demo.service.Consumer;
import com.example.demo.service.Producer;
import com.fasterxml.jackson.databind.ObjectMapper;

@WebMvcTest(controllers = BookController.class)
public class BookControllerTest {
	
	@Autowired
	private MockMvc mockMvc;
	
	@Autowired
	private ObjectMapper objectMapper;
	
	@MockBean
	private BookService bookService;
	
	@MockBean
	private Producer producer;
	
	@MockBean 
	private Consumer consumer;
	
	@Test
	public void whenValidInputReturns200() throws Exception {
		mockMvc.perform(get("/book/{isbn}", 12345L)
				.contentType("application/json"))
				.andExpect(status().isOk());
	}
}
