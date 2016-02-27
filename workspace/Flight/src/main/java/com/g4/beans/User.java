package com.g4.beans;


import javax.jdo.annotations.PersistenceCapable;

@PersistenceCapable
public class User {
	
	private String id;
	private String login;
	private String password;
	private String type;
<<<<<<< HEAD

	
	public User(){
	}

	
	public User(String id){
		this.id = id;
	}
	
=======
>>>>>>> 7d53fb47e5629b5cfab22c2f2378cead8f923edd
	
	public void print (){
		System.out.println(id);
		System.out.println(login);
		System.out.println(password);
		System.out.println(type);
	}

<<<<<<< HEAD


=======
	public User(String id){
		this.id = id;
	}
	public User(){
	}
>>>>>>> 7d53fb47e5629b5cfab22c2f2378cead8f923edd
	
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
<<<<<<< HEAD

	// Intarnal class for primary key and asociation with flight
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
=======
>>>>>>> 7d53fb47e5629b5cfab22c2f2378cead8f923edd
	
}
