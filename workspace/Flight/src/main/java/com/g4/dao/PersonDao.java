package com.g4.dao;

import java.util.ArrayList;

import com.g4.beans.Person;



public interface PersonDao {
	String  getPerson(int  id);

	ArrayList<Person> getAllPerson();
	
	Person addPerson(int  user_id,String name,String first_name,int phone_tel,String mail_address,String user_type);
	
	Person createPerson();

	String deletePerson(int id);

	void modifyPerson(int id,int  user_id,String name,String first_name,int phone_tel,String mail_address,String user_type);

}
