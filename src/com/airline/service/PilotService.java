package com.airline.service;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import com.airline.models.Flight;
import com.airline.models.Pilot;

@Stateless
@LocalBean
public class PilotService {

	@PersistenceContext(unitName="uretmeli")
	EntityManager em;
	
	
	public PilotService() {}
	
	public void addPilot(Pilot p) {
		
		em.persist(p);
		em.flush();
	}
	
	public void addNewPilotToFlight(Pilot p,String flightId) {
		
		em.persist(p);
		
		TypedQuery<Flight> fQuery = em.createNamedQuery("Flight.findById",Flight.class);
						   fQuery.setParameter("id", Integer.parseInt(flightId));
		
			Flight f = fQuery.getSingleResult();
			
			List<Pilot> pList = f.getPilots();
			
			pList.add(p);
			
			f.setPilots(pList);
			
			p.setFlightForPilot(f);
						   
			
			
	}
}
