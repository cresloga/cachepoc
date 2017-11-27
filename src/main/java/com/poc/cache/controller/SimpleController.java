package com.poc.cache.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
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
    	return "Welcome to Cache POC Test";
    }
    
    @RequestMapping(method=RequestMethod.POST, value="/plan")
    @ResponseBody Plan getPlan(@RequestBody Plan plan) {
    	//return bookRepository.getByIsbn("new book").getTitle();
    	logger.info("Invoked SimpleController.getPlan :"+plan.getVoice()+" "+plan.getData()+" "+plan.getTraveler()+" "+plan.getComboPlan());
    	return service.getPlan(plan.getVoice(), plan.getData(), plan.getTraveler());
    }
    
    @RequestMapping(method=RequestMethod.PUT, value="/plan")
    @ResponseBody Plan updatePlan(@RequestBody Plan plan) {
    	//return bookRepository.getByIsbn("new book").getTitle();
    	logger.info("Invoked SimpleController.updatePlan :"+plan.getVoice()+" "+plan.getData()+" "+plan.getTraveler()+" "+plan.getComboPlan());
    	return service.updatePlan(plan);
    }
    
    @RequestMapping(method=RequestMethod.DELETE, value="/plan")
    void deletePlan(@RequestBody Plan plan) {
    	//return bookRepository.getByIsbn("new book").getTitle();
    	logger.info("Invoked SimpleController.deletePlan :"+plan.getVoice()+" "+plan.getData()+" "+plan.getTraveler()+" "+plan.getComboPlan());
    	service.deletePlan(plan);
    }

}
