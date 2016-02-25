package com.g4.dao.datanucleus;

import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.PrimaryKey;
import javax.jdo.annotations.Unique;

@PersistenceCapable
public class User {

	@PrimaryKey
	int user_id;
	String name;
	String first_name;
	@Unique
	String phone_number;
	@Unique
	String mail_address;
	String user_type;	// "CCO" or "CREW"
	
	protected User(){
		
	}
	
	public User(String name,String first_name, String phone_number, String mail_address, String user_type){
		
		this.name = name;
		this.first_name = first_name;
		this.phone_number = phone_number;
		this.mail_address = mail_address;
		this.user_type = user_type;
	}
	
	public String getUserName(){
		
		return name;
	}
	
	public String getUserFisrtName(){
		
		return first_name;
	}
	
	public String getPhoneNumber(){
		
		return phone_number;
	}
	
	public String getMailAddress(){
		
		return mail_address;
	}
	
	public String getType(){
		
		return user_type;
	}
}
