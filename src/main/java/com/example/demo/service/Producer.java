package com.example.demo.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.example.demo.model.Book;

@Service
public class Producer {

	private static final Logger logger = LoggerFactory.getLogger(Producer.class);
    private static final String TOPIC = "bookTopic";
    
    @Autowired
    private KafkaTemplate<String, Book> kafkaTemplate;

    public void sendMessage(Book bk) {
        logger.info(String.format("#### -> Producing message -> %s", bk));
        this.kafkaTemplate.send(TOPIC, bk);
    }
}
