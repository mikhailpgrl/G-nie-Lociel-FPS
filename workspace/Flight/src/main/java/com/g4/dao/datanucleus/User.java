package com.g4.dao.datanucleus;

import java.io.Serializable;
import java.util.StringTokenizer;

import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.PrimaryKey;
import javax.jdo.annotations.Unique;

@PersistenceCapable
public class User {

	@PrimaryKey
	private int user_id;
	private String name;
	private String first_name;
	@Unique
	private String phone_number;
	@Unique
	private String mail_address;
	private String user_type;	// "CCO" or "CREW"
	
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
	
	public static class UserPK implements Serializable{
		
		private static final long serialVersionUID = 1L;
		int user_id;
		
		
		public UserPK(){
			
		}
		
	    public UserPK(String value) {
	    	
	        StringTokenizer token = new StringTokenizer (value, "::");
	        token.nextToken();
	        
	        try{
	        	
	        	this.user_id = Integer.parseInt(token.nextToken());
	        
	        }catch(NumberFormatException ne){
	        	
	        	ne.printStackTrace();
	        }
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
	        return Integer.hashCode(user_id);
	    }

	    public String toString ()
	    {
	        // Give output expected by String constructor
	        return this.getClass().getName() + "::"  + this.user_id;
	    }
		
	}
}
