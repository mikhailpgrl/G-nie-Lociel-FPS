package com.g4.beans;

import java.io.Serializable;
import java.util.StringTokenizer;

import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.PrimaryKey;


@PersistenceCapable
public class FlightPer {

	@PrimaryKey
	Flight flight;

	@PrimaryKey
	User user;

	protected FlightPer() {

	}

	public FlightPer(Flight f, User u){

		flight = f;
		user = u;

	}

	public Flight getFlight(){

		return flight;
	}

	public User getUser(){

		return user;
	}


	public static class PK implements Serializable{

		private static final long serialVersionUID = 1L;
		Flight.FlightPK flight;
		User.UserPK user;

		protected PK() {

		}

		public PK(String string){

			StringTokenizer token = new StringTokenizer(string,"--");
			token.nextToken();
			this.flight = new Flight.FlightPK(token.nextToken());
			this.user = new User.UserPK(token.nextToken());

		}

        public String toString()
        {
            return (flight.toString() + "--" + user.toString());
        }

        public int hashCode()
        {
            return flight.hashCode() ^ user.hashCode();
        }

        public boolean equals(Object other)
        {
            if (other != null && (other instanceof PK))
            {
                PK otherPK = (PK)other;
                return this.flight.equals(otherPK.flight) && this.user.equals(otherPK.user);
            }
            return false;
        }
	}

}
