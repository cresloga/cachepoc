package com.poc.cache.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "plan")
public class Plan implements Serializable {
	
  // An autogenerated id (unique for each user in the db)
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Integer id;

  @Column(name="voice")
  public String voice;
  
  @Column(name="data")
  public String data;
  
  @Column(name="traveler")
  public String traveler;
  
  @Column(name="combo_plan")
  public String comboPlan;


	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

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
