package com.poc.cache.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.poc.cache.entity.Plan;
import com.poc.cache.repository.PlanRepository;


@Service
public class SimpleService {
	
	private static final Logger logger = LoggerFactory.getLogger(SimpleService.class);
	
	
	
	@Autowired
	private PlanRepository planRepository;

		
	@Cacheable(value="plans", key="#voice.concat('|').concat(#data).concat('|').concat(#traveler)" )
	public Plan getPlan(String voice, String data, String traveler) {		
		logger.info("Invoked SimpleService.getPlan");
		return planRepository.findByVoiceAndDataAndTraveler(voice, data, traveler);
	}
	
	@CacheEvict(value="plans", key="#plan.voice.concat('|').concat(#plan.data).concat('|').concat(#plan.traveler)" )
	public Plan updatePlan(Plan plan) {		
		logger.info("Invoked SimpleService.updatePlan");
		return planRepository.save(plan);		
	}
	
	@CacheEvict(value="plans", key="#plan.voice.concat('|').concat(#plan.data).concat('|').concat(#plan.traveler)" )
	public void deletePlan(Integer id) {		
		logger.info("Invoked SimpleService.deletePlan");		
		planRepository.delete(id);
	}
}
