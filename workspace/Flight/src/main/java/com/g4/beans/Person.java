package com.g4.beans;

public class Person {
	private int  user_id; 
	private String name;
	private String first_name;
	private int phone_tel;
	private String mail_address;
	private String user_type;
	
	public Person(int  user_id,String name,String first_name,int phone_tel,String mail_address,String user_type)
	{
		this.user_id=user_id;
		this.name=name;
		this.first_name=first_name;
		this.phone_tel=phone_tel;
		this.mail_address=mail_address;
		this.user_type=user_type;
	}
	
	public int  getuser_id()
	{
		return this.user_id;
	}
	public String getname()
	{
		return this.name;
	}
	public String getfirst_name()
	{
		return this.first_name;
	}
	public int getphone_tel()
	{
		return this.phone_tel;
	}
	public String getmail_address()
	{
		return this.mail_address;
	}
	public String getuser_type()
	{
		return this.user_type;
	}
	public void  setuser_id(int user_id)
	{
		 this.user_id=user_id;
	}
	public void setname(String name)
	{
		this.name=name;
	}
	public void setfirst_name(String first_name)
	{
		 this.first_name=first_name;
	}
	public void setphone_tel(int phone_tel)
	{
		this.phone_tel=phone_tel;
	}
	public void setmail_address(String mail_address)
	{
		 this.mail_address=mail_address;
	}
	public void  setuser_type(String user_type)
	{
		this.user_type=user_type;
	}
}
