package com.g4.dao.datanucleus;

import java.util.StringTokenizer;


public class FlightPK{
	
	String commercial_number;
	int departure_airport;
	String departure_date;
	
	
	public FlightPK(){
		
	}
	
    public FlightPK(String value) {
    	
        StringTokenizer token = new StringTokenizer (value, "::");
        token.nextToken();
        this.commercial_number = token.nextToken();
        
        try{
        	
        	this.departure_airport = Integer.parseInt(token.nextToken());
        
        }catch(NumberFormatException ne){
        	
        	ne.printStackTrace();
        }
        
        this.departure_date = token.nextToken();	
    }

    public boolean equals(Object obj)
    {
        if (obj == this){
            return true;
        }
        
        if (!(obj instanceof FlightPK)){
            return false;
        }
        
        FlightPK c = (FlightPK)obj;

        return commercial_number.equals(c.commercial_number) 
        		&& departure_airport == c.departure_airport
        		&& departure_date.equals(c.departure_date);
    }

    public int hashCode ()
    {
        return this.commercial_number.hashCode() 
        		^ this.departure_airport 
        		^ this.departure_date.hashCode();
    }

    public String toString ()
    {
        // Give output expected by String constructor
        return this.getClass().getName() + "::"  + this.commercial_number 
        		+ "::" + this.departure_airport + "::" + this.departure_airport;
    }
	
	
}
