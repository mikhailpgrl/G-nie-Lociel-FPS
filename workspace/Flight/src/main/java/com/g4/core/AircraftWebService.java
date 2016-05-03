package com.g4.core;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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
import com.g4.dao.AirportDao;
import com.g4.dao.DAO;
import com.g4.dao.PositionAircraftDao;
import com.g4.utils.JSonMaker;

@Path("/{a:aircrew|cco}/aircraft")
public class AircraftWebService {

	private static AircraftDao ad;

	private static PositionAircraftDao pad;
	private static AirportDao apd;

	public AircraftWebService() {
		// TODO Auto-generated constructor stub
		ad = DAO.getAircraftDao();
		pad = DAO.getPositionAircraftDao();
		apd = DAO.getAirportDao();
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
	@Path("/list-aircraft-all")
	public Response getAllAircraftForFlight(Flight flight){
		List<Aircraft> aircraft;
		aircraft = ad.getAllAircraft();
		List<PositionAircraft> position;
		List<PositionAircraft> position2 = new ArrayList<PositionAircraft>();
		List<PositionAircraft> position3 = new ArrayList<PositionAircraft>();
		PositionAircraft pa = null;
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm");
		List<Aircraft> aircraft2 = new ArrayList<Aircraft>();
		position = pad.getAllPositionAircraft();
		
		if ((position != null) && !position.isEmpty()){
			for (Aircraft ac : aircraft) {
				position2.clear();
				for (PositionAircraft p : position){
					if (p.getId_aircraft().equals(Integer.toString(ac.getId()))){
						position2.add(p);
					}
				}
				try {
					
					if (!position2.isEmpty()){
						int i = 0; 
						for (PositionAircraft pos : position2 ){
								Date d1 = formatter.parse(pos.getPosition_date() + " " + pos.getPosition_time());
								if (i == 0 ){
									pa = pos;
								}else{
									Date d2 = formatter.parse(pos.getPosition_date() + " " + pos.getPosition_time());
									if (d1.getTime() < d2.getTime()){
										pa = pos;
										d1 = d2;
									}
								}
								i++;
						}
						position3.add(pa);
					}
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			try {
				position2.clear();
				Date currentDate = formatter.parse(flight.getDeparture_date() + " " + flight.getDeparture_time());
				
				for (PositionAircraft pos : position3) {
					if (flight.getDeparture_airport().equals(apd.getAirport(pos.getId_airport()).getIcao_code())){
						Date d2 = formatter.parse(pos.getPosition_date() + " " + pos.getPosition_time());
						if (currentDate.getTime() > d2.getTime()){
							position2.add(pos);
						}
					}
	
					
				}
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			for (Aircraft aircraft3 : aircraft) {
				for (PositionAircraft positionAircraft : position2){
					if (positionAircraft.getId_aircraft().equals(Integer.toString(aircraft3.getId()))){
						aircraft2.add(aircraft3);
						break;
					}
				}
			}
		}
		
		
		
		return Response.status(200).entity(JSonMaker.getJson(aircraft2)).build();
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
