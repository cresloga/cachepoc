package com.poc.cache.repository;

import org.springframework.data.repository.CrudRepository;

import com.poc.cache.entity.Plan;

public interface  PlanRepository  extends CrudRepository<Plan, Integer>{
	
	public Plan findByVoice(String voice);
	public Plan findByData(String data);
	public Plan findByTraveler(String traveler);
	public Plan findByVoiceAndDataAndTraveler(String voice, String data, String traveler);
}
