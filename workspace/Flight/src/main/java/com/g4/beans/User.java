package com.g4.beans;

import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.PrimaryKey;

@PersistenceCapable
public class User {

	@PrimaryKey
	private String id;
	private String login;
	private String password;
	private String type;

	public User(){
	}

	public User(String id){
		this.id = id;
	}

	public void print (){
		System.out.println(id);
		System.out.println(login);
		System.out.println(password);
		System.out.println(type);
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

	// Internal class for primary key and asociation with flight
	public static class UserPK implements Serializable{

		private static final long serialVersionUID = 1L;
		String id;

		public UserPK(){

		}

	    public UserPK(String value) {

	        StringTokenizer token = new StringTokenizer (value, "::");
	        token.nextToken();
	        this.id = token.nextToken();
	    }

	    public boolean equals(Object obj)
	    {
	        if (obj == this){
	            return true;
	        }

	        if (!(obj instanceof UserPK)){
	            return false;
	        }

	        UserPK c = (UserPK)obj;

	        return this.user_id == c.user_id;
	    }

	    public int hashCode ()
	    {
	        return id.hashCode();
	    }

	    public String toString ()
	    {
	        // Give output expected by String constructor
	        return this.getClass().getName() + "::"  + this.id;
	    }

	}

}
