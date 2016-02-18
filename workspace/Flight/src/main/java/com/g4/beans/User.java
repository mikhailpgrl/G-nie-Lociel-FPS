package com.g4.beans;


import javax.jdo.annotations.PersistenceCapable;

@PersistenceCapable
public class User {
	
	private String id;
	private String login;
	private String password;
	private String type;
	
	public void print (){
		System.out.println(id);
		System.out.println(login);
		System.out.println(password);
		System.out.println(type);
	}

	public User(String id){
		this.id = id;
	}
	public User(){
	}
	
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
}
