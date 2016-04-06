package com.g4.beans;


import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.Unique;

@PersistenceCapable
public class Users {

	@Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
	@Unique
	private int id;
	private String login;
	private String password;
	private String type;
	
	public void print (){
		System.out.println(id);
		System.out.println(login);
		System.out.println(password);
		System.out.println(type);
	}

	public Users(String id){
		this.login = id;
	}
	public Users(){
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
}
