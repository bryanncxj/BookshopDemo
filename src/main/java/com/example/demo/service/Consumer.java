package com.example.demo.service;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.example.demo.model.Book;


@Service
public class Consumer {
	
	private static final Logger logger = LoggerFactory.getLogger(Producer.class);
	
	@KafkaListener(topics = "bookTopic")
    public void consume(Book bk) throws IOException {
        logger.info(String.format("#### -> Consumed message -> %s", bk));
    }
}
