package com.g4.beans;


import javax.jdo.annotations.PersistenceCapable;

@PersistenceCapable
public class Leaflet {

	private String id;
	private String content;

	private Leaflet(){
		
	}
	public Leaflet(String s){
		this.id = s;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
	
}
