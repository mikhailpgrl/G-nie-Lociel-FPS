package com.g4.dao.datanucleus;

import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.PrimaryKey;

@PersistenceCapable
public class Leaflet {

	@PrimaryKey
	int id_notice;
	String notice_content;
	
	protected Leaflet(){
		
	}
	
	public Leaflet(String notice){
		
		notice_content = notice;
	}
	
	public String getNotice(){
		
		return notice_content;
	}
	
}
