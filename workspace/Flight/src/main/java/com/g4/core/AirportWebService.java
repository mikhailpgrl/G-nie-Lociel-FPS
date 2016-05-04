package com.g4.core;

import java.util.List;

import javax.jdo.JDODataStoreException;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.g4.beans.Aircraft;
import com.g4.beans.Airport;
import com.g4.beans.Flight;
import com.g4.beans.Leaflet;
import com.g4.beans.Users;
import com.g4.dao.AircraftDao;
import com.g4.dao.AirportDao;
import com.g4.dao.DAO;
import com.g4.dao.UserDao;
import com.g4.utils.JSonMaker;

@Path("/{a:aircrew|cco}/airport")
public class AirportWebService {

	private static AirportDao ad;

	public AirportWebService() {
		// TODO Auto-generated constructor stub
		ad = DAO.getAirportDao();
	}

	

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/list-airport")
	public Response getAllAirport(){
		List<Airport> airport;
		airport= ad.getAllAirport();
		
		
		return Response.status(200).entity(JSonMaker.getJson(airport)).build();
	}
	@PUT
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/create-airport")
	public Response createLeaflet(Airport airport){
		try {
			String message = ad.putAirport(airport);
			if (message.contains("success")) {
				return Response.status(200).entity(message).build();
			} else {
				return Response.status(400).entity(message).build();
			}
		} catch (JDODataStoreException e) {
			// TODO: handle exception
			return Response.status(500).entity("Error : Already in database").build();
		}
			
	}
	
	@DELETE
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/delete-airport")
	public Response deleteLeaflet(@QueryParam("id") String id){
		if (id != null && id.length() > 0){
			String message = ad.deleteAirport(id);
			if (message.contains("succes")){
				return Response.status(200).entity(message).build();
			}
			else{
				return Response.status(400).entity(message).build();
			}
			
		}else{
			return Response.status(400).entity("Airport_ID_MANDATORY").build();
		}	
	}
	
	
	

}
