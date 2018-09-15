package com.airline.webservices.rest;

import java.util.List;

import javax.ejb.EJB;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import com.airline.models.Flight;
import com.airline.service.FlightService;

@Path("/flights")
public class FlightWebService {

	@PersistenceContext(unitName="uretmeli")
	EntityManager em;
	
	@EJB
	FlightService fs;
	
	@Context
	UriInfo fUriInfo;
	
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Flight> getFlights(){
		
		List<Flight> flist = fs.getFlights();
		
		return flist;
	}
	
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{flight_id}")
	public Flight getFlight(@PathParam("flight_id")Integer flightId) {
		
		Flight f = fs.getFlight(flightId);
		
		if(f == null) {
			throw new NotFoundException("the flight with an id of "+flightId+ " was not found");
		}
		
			return f;
	}
	
	
	@DELETE
	@Path("{flight_id}")
	public Response deleteFlight(@PathParam("flight_id")Integer flightId) {
		
		Flight  flightToRemove = em.find(Flight.class, flightId);
		
		if(flightToRemove == null) {
			throw new NotFoundException("the flight with an id of "+flightId+" was not found.");
		}
		
		em.remove(flightToRemove);
		
		return Response.noContent().build();
	}
	
}
