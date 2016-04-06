package com.g4.beans;


import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.Unique;

@PersistenceCapable
public class Leaflet {

	@Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
	@Unique
	private int id;
	private String content;

	public Leaflet(){
		
	}
	public Leaflet(String s){
		this.content = s;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
	
}
