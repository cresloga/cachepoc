package com.poc.cache.entity;

import java.io.Serializable;

public class Plan implements Serializable {

	public String voice;
	public String data;
	public String traveler;
	public String comboPlan;
	public String getVoice() {
		return voice;
	}
	public void setVoice(String voice) {
		this.voice = voice;
	}
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	public String getTraveler() {
		return traveler;
	}
	public void setTraveler(String traveler) {
		this.traveler = traveler;
	}
	public String getComboPlan() {
		return comboPlan;
	}
	public void setComboPlan(String comboPlan) {
		this.comboPlan = comboPlan;
	}
	
}
