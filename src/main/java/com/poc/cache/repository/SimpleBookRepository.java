package com.poc.cache.repository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

import com.poc.cache.controller.SimpleController;
import com.poc.cache.entity.Book;

@Component
public class SimpleBookRepository implements BookRepository {
	
	private static final Logger logger = LoggerFactory.getLogger(SimpleBookRepository.class);
	

    @Override
    @Cacheable(value="books", key="#isbn" )
    public Book getByIsbn(String isbn) {
    	logger.info("in Simple Book Repository");
        simulateSlowService();
        return new Book(isbn, "Some book");
    }

    // Don't do this at home
    private void simulateSlowService() {
        try {
            long time = 3000L;
            Thread.sleep(time);
            logger.info("Simulating Slowness");
            System.out.println("Simulating Slowness");
        } catch (InterruptedException e) {
            throw new IllegalStateException(e);
        }
    }

}