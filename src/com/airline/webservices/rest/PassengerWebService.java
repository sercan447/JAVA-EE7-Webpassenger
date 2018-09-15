package com.airline.webservices.rest;


import java.net.URI;
import java.util.List;

import javax.ejb.EJB;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;
import javax.ws.rs.core.UriInfo;

import com.airline.models.Passenger;
import com.airline.service.PassengerService;

@Path("/passengers")
public class PassengerWebService {
	
	@PersistenceContext(unitName="uretmeli")
	EntityManager em;
	
	@EJB
	PassengerService ps;
	
	@Context
	UriInfo pUriInfo;
	
	public PassengerWebService() {}
	
	
	@GET
	@Path("/listele")
	@Produces(MediaType.APPLICATION_XML)
	public List<Passenger> getPassengers(){
		
		List<Passenger> plist = ps.getPassengers();
		
		return plist;
	}
	
	@GET
	@Produces(MediaType.APPLICATION_XML)
	@Path("{passenger_id}")
	public Passenger getPassenger(@PathParam("passenger_id")Integer passengerId) {
		Passenger p = ps.getPassenger(passengerId);
		
		if(p == null) {	
			throw new NotFoundException("The passenger with an id of "+passengerId+"was not found");
		}
		
		return p;
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response addPassenger(Passenger p) {
		p = ps.addPassenger(p);
		
		UriBuilder pUriBuilder = pUriInfo.getAbsolutePathBuilder();
		URI pUri = pUriBuilder.path(String.valueOf(p.getId())).build();
		
		return Response.created(pUri).build();
	}
	
	
	@PUT
	@Path("/edit/{pId}")
	@Consumes("application/json")
	public Response updatePassenger(@PathParam("pId") Integer passengerId,Passenger pUpdated) {
		pUpdated = ps.updatePassenger(passengerId, pUpdated);
		
		
		if(pUpdated == null) {
			throw new NotFoundException("The passenger with an id of "+passengerId+"was not found");
		}
		
		return Response.ok(pUpdated).build();
	}
	
	@PUT
	@Path("/edit2/{pId}")
	@Consumes("application/json")
	public Response updatePassenger2(@PathParam("pId")Integer passengerId,Passenger pUpdated) {
		
		pUpdated = ps.updatePassenger2(passengerId, pUpdated);
		
		if(pUpdated == null) {
			throw new NotFoundException("the passenger with  an id of "+passengerId+"as not found");
		}
		return Response.ok(pUpdated).build();
	}
	
	
	@GET
	@Path(value="/sinav")
	@Produces(MediaType.TEXT_HTML)
	public Response deneme() {
		
		//UriBuilder pUriBuilder = pUriInfo.getAbsolutePathBuilder();
		//URI uri = pUriBuilder.path("1").build();
		
		
		return Response.ok("mesalar").build();
	}
	
}
