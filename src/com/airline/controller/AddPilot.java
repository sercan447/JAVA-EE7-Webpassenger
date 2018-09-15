package com.airline.controller;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.airline.models.Pilot;
import com.airline.models.PilotRank;
import com.airline.service.PilotService;

@WebServlet("/AddPilot")
public class AddPilot extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	@EJB
	PilotService ps;
	
    public AddPilot() {
        super();
      
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		Pilot p = new Pilot();
			  p.setFirstName("Grivesilda");
			  p.setLastName("Cavendish");
			  p.setPilotRank(PilotRank.Captain);
			  p.setPilotLicense(123455);
			  
			  ps.addPilot(p);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		doGet(request, response);
	}

}
