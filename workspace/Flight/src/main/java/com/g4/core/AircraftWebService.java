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
import com.g4.beans.Flight;
import com.g4.beans.PositionAircraft;
import com.g4.dao.AircraftDao;
import com.g4.dao.DAO;
import com.g4.dao.PositionAircraftDao;
import com.g4.utils.JSonMaker;

@Path("/{a:aircrew|cco}/aircraft")
public class AircraftWebService {

	private static AircraftDao ad;

	private static PositionAircraftDao pad;

	public AircraftWebService() {
		// TODO Auto-generated constructor stub
		ad = DAO.getAircraftDao();
		pad = DAO.getPositionAircraftDao();
	}

	

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/list-aircraft")
	public Response getAllAircraft(){
		List<Aircraft> aircraft;
		aircraft = ad.getAllAircraft();
		return Response.status(200).entity(JSonMaker.getJson(aircraft)).build();
	}
	

	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/list-aircraft")
	public Response getAllAircraftForFlight(Flight flight){
		List<Aircraft> aircraft;
		aircraft = ad.getAllAircraft();
		List<PositionAircraft> position;
		position = pad.getAllPositionAircraft();
		
		
		
		return Response.status(200).entity(JSonMaker.getJson(aircraft)).build();
	}
	
	
	@PUT
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/create-aircraft")
	public Response createLeaflet(Aircraft aircraft){
		try {
			String message = ad.putAircraft(aircraft);
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
	@Path("/delete-aircraft")
	public Response deleteLeaflet(@QueryParam("id") String id){
		if (id != null && id.length() > 0){
			String message = ad.deleteAircraft(id);
			if (message.contains("succes")){
				return Response.status(200).entity(message).build();
			}
			else{
				return Response.status(400).entity(message).build();
			}
			
		}else{
			return Response.status(400).entity("Aircraft_ID_MANDATORY").build();
		}	
	}
	
	
	

}
