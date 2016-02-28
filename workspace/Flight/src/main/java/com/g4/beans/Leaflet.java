package com.g4.beans;

import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.PrimaryKey;

@PersistenceCapable
public class Leaflet {

	@PrimaryKey
	private String id;
	private String content;

	public Leaflet(){

	}
	public Leaflet(String s){
		this.content = s;
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
