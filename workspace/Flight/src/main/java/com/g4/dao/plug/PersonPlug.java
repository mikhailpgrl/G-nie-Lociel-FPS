package com.g4.dao.plug;

import java.lang.reflect.Array;
import java.util.ArrayList;

import com.g4.beans.Person;
import com.g4.dao.PersonDao;

public class PersonPlug  implements PersonDao{
	
		Person p=new Person(0, null, null, 0, null, null);
	public String getPerson(int  id) {
		// TODO Auto-generated method stub
		if(id==p.getuser_id())
		{
			return p.getname();
		}
		else
		{
			return"pas dans la base ";
		}
		
	}

	public ArrayList<Person> getAllPerson() {
		// TODO Auto-generated method stub
		 return null;
	}

	public Person addPerson(int  user_id,String name,String first_name,int phone_tel,String mail_address,String user_type) {
		// TODO Auto-generated method stub
		return new Person( user_id, name,first_name, phone_tel, mail_address,user_type);
	}

	public Person createPerson() {
		// TODO Auto-generated method stub
		return new Person(0, null, null, 0, null, null);
	}

	public String deletePerson(int  id) {
		// TODO Auto-generated method stub
		
		if(id==p.getuser_id())
		{
			p=null;
			return "objet supprimé";
		}
		else
		{
			return "objet non supprimé";
		}
	
	}

	public void modifyPerson(int id,int  user_id,String name,String first_name,int phone_tel,String mail_address,String user_type ) {
		// TODO Auto-generated method stub
		if (id==p.getuser_id())
		{
			new Person( user_id, name,first_name, phone_tel, mail_address,user_type);
		}
		
	}

	

	

}
