package com.poc.cache.controller;



import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.PathVariable;
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
    
    @RequestMapping(method=RequestMethod.POST, value="/new")
    @ResponseBody Plan addPlan(@RequestBody Plan plan) {
    	//return bookRepository.getByIsbn("new book").getTitle();
    	logger.info("Invoked SimpleController.addPlan :"+plan.getVoice()+" "+plan.getData()+" "+plan.getTraveler()+" "+plan.getComboPlan());
    	return service.addPlan(plan);
    }
    
    @RequestMapping(method=RequestMethod.POST, value="/plan")
    @ResponseBody Plan getPlan(@RequestBody Plan plan) {
    	//return bookRepository.getByIsbn("new book").getTitle();
    	logger.info("Invoked SimpleController.getPlan :"+plan.getVoice()+" "+plan.getData()+" "+plan.getTraveler()+" "+plan.getComboPlan());
    	return service.getPlan(plan.getVoice(), plan.getData(), plan.getTraveler());
    }
    
    @RequestMapping(method=RequestMethod.PUT, value="/plan/{id}")
    @ResponseBody Plan updatePlan(@PathVariable Integer id, @RequestBody Plan plan) {
    	//return bookRepository.getByIsbn("new book").getTitle();
    	logger.info("Invoked SimpleController.updatePlan :"+id+ " "+plan.getVoice()+" "+plan.getData()+" "+plan.getTraveler()+" "+plan.getComboPlan());
    	if (id!=null)	plan.setId(id);
    	return service.updatePlan(plan);
    }
    
    @RequestMapping(method=RequestMethod.DELETE, value="/plan/{id}")
    void deletePlan(@PathVariable Integer id, @RequestBody Plan plan) {
    	//return bookRepository.getByIsbn("new book").getTitle();
    	logger.info("Invoked SimpleController.deletePlan :"+id+ " "+plan.getVoice()+" "+plan.getData()+" "+plan.getTraveler()+" "+plan.getComboPlan());
    	plan.setId(id);
    	service.deletePlan(plan);
    }

}
