package com.g4.core;

import java.util.ArrayList;
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

import com.g4.beans.Airport;
import com.g4.beans.Flight;
import com.g4.beans.PositionAircraft;
import com.g4.dao.AirportDao;
import com.g4.dao.DAO;
import com.g4.dao.FlightDao;
import com.g4.dao.PositionAircraftDao;
import com.g4.utils.Criteria;
import com.g4.utils.JSonMaker;

@Path("/{a:aircrew|cco}/flight")
public class FlightWebService {

	private static FlightDao fd;
	private static PositionAircraftDao pad;
	private static AirportDao aird;
	
	public FlightWebService() {
		// TODO Auto-generated constructor stub
		fd = DAO.getFlightDao();
		pad = DAO.getPositionAircraftDao();
		aird = DAO.getAirportDao();
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/list-flight")
	public Response getAllFlight(){
		List<Flight> f;
		f = fd.getAllFlight();
		return Response.status(200).entity(JSonMaker.getJson(f)).build();
	}

	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/list-flight-aircrew")
	public Response getAllFlightbyAIrCrew(@QueryParam("userId") String id){
		List<Flight> f;
		List<Flight> f1 = new ArrayList<Flight>();
		f = fd.getAllFlight();
		for (Flight flight : f) {
			if (flight.getId_co_pilote().equals(id) || flight.getId_pilote().equals(id) ||
					flight.getId_stewart_deux().equals(id) || flight.getId_stewart_trois().equals(id) ||
					flight.getId_stewart_un().equals(id)){
				f1.add(flight);
			}
		}
		return Response.status(200).entity(JSonMaker.getJson(f1)).build();
	}
	
	@PUT
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/create-flight")
	public Response createFlight(@QueryParam("userId") String id,Flight flight){
		if (id != null && id.length() > 0){
			try {
				
				
				String message = fd.putFlight(flight);
				
			if (message.contains("succes")){
				return Response.status(200).entity(JSonMaker.getJson(message)).build();
			}
			else{
				return Response.status(400).entity(message).build();
			}

			} catch (JDODataStoreException e) {
				// TODO: handle exception
				return Response.status(500).entity("Error : Already in database").build();
			}
			
		}else{
			return Response.status(400).entity("USER_MANDATORY").build();
		}	
		
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/show-flight")
	public Response getFlight(@QueryParam("id") String id){
		Flight f;
		f = fd.getFlight(id);
		if (f == null)
			return Response.status(400).entity("NO_FLIGHT").build();
		else
			return Response.status(200).entity(JSonMaker.getJson(f)).build();
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/modify-flight")
	public Response getFlight1(@QueryParam("id") String id){
		return getFlight(id);
	}
	
	@DELETE
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/show-flight")
	public Response deleteFlight(@QueryParam("userId") String id){

		if (id != null && id.length() > 0){
			Flight f;
			f = fd.getFlight(id);
			f.print();
			
			if (f!= null && !f.getId_aircraft().equals(null)){
				List<PositionAircraft> lp = pad.getAllPositionAircraft();
				for (PositionAircraft positionAircraft : lp) {
					if (positionAircraft.getId_flight().equals(Integer.toString(f.getId()))){
						pad.deletePositionAircraft(Integer.toString(positionAircraft.getId()));
						break;
					}
				}
			}
				
			String message = fd.deleteFlight(id);
			if (message.contains("succes")){
				return Response.status(200).entity(message).build();
			}
			else{
				return Response.status(400).entity(message).build();
			}
			
		}else{
			return Response.status(400).entity("USER_MANDATORY").build();
		}	
	}
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/modify-flight")
	public Response modifyFlight(Flight flight, @QueryParam("userId") String id ){
		Flight f;
		System.out.println("modify test = " + flight.getId_co_pilote());
		flight.print();
		if (id != null && id.length() > 0){
			f = fd.getFlight(id);
			if (f.getId_aircraft() ==null || !f.getId_aircraft().equals(flight.getId_aircraft())){
				List<PositionAircraft> lp = pad.getAllPositionAircraft();
				for (PositionAircraft positionAircraft : lp) {
					if (positionAircraft.getId_flight() != null && positionAircraft.getId_flight().equals(Integer.toString(f.getId()))){
						pad.deletePositionAircraft(Integer.toString(positionAircraft.getId()));
						break;
					}
				}
				PositionAircraft pa = new PositionAircraft();
				pa.setId_aircraft(flight.getId_aircraft());
				pa.setId_airport(flight.getDeparture_airport());
				pa.setPosition_date(flight.getArrival_date());
				pa.setPosition_time(flight.getArrival_time());
				pa.setId_flight(Integer.toString(flight.getId()));
				pad.putPositionAircraft(pa);
			}
			f.print();
			System.out.println("-----------");
			flight.print();
			fd.modifyFlight(id,flight);
			return Response.status(200).entity("OK").build();
			
		}else{
			return Response.status(400).entity("USER_MANDATORY").build();
		}	
	}
	

	@GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/getFlightBy")
    public Response sortFlight(@QueryParam("criteria") String criteria, @QueryParam("value") String value){
        if (criteria != null && criteria.length() > 0 && value != null && value.length() > 0){
            List<Flight> f;
            Criteria c;
            	if(criteria.equals("ATC"))
            		c = Criteria.ATC;
            	else if(criteria.equals("com_number"))
            		c = Criteria.COM_NUMBER;
            	else if(criteria.equals("dep_airport"))
            		c = Criteria.DEP_AIRPORT;
            	else if(criteria.equals("arr_airport"))
            		c = Criteria.ARR_AIRPORT;
            	else if(criteria.equals("dep_date"))
            		c = Criteria.DEP_DATE;
            	else if(criteria.equals("arr_date"))
            		c = Criteria.ARR_DATE;
            	else
            		return Response.status(400).entity(JSonMaker.getJson("CRITERIA_ERROR")).build();
            
             f = fd.getByCriteria(c,value);
            return Response.status(200).entity(JSonMaker.getJson(f)).build();
             
        }else{
            return Response.status(400).entity("USER_MANDATORY").build();
        }   
    }
}
	