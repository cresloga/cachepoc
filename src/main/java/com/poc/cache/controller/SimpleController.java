package com.poc.cache.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.poc.cache.Application;
import com.poc.cache.entity.Plan;
import com.poc.cache.service.SimpleService;

@RestController
public class SimpleController {
	
	private static final Logger logger = LoggerFactory.getLogger(SimpleController.class);
	
	@Autowired
	SimpleService service;

    @RequestMapping("/")
    String home() {
    	//return bookRepository.getByIsbn("new book").getTitle();
    	logger.info("In Controller");
    	return service.getMyResponse();
    }
    
    @RequestMapping(method=RequestMethod.POST, value="/more")
    String getMoreDetails(@RequestBody Plan plan) {
    	//return bookRepository.getByIsbn("new book").getTitle();
    	logger.info("get More Details :"+plan.getVoice()+" "+plan.getData()+" "+plan.getTraveler()+" "+plan.getComboPlan());
    	return service.getMyResponse();
    }

}
