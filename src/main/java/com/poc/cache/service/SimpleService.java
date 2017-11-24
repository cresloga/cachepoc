package com.poc.cache.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.poc.cache.repository.BookRepository;
import com.poc.cache.repository.SimpleBookRepository;

@Service
public class SimpleService {
	
	private static final Logger logger = LoggerFactory.getLogger(SimpleService.class);
	
	@Autowired
	private BookRepository bookRepository;

	
	public String getMyResponse() {
		System.out.println("Printing from Service");
		logger.info("in Service");
		return bookRepository.getByIsbn("some book").getTitle();
	}
}
