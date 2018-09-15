package com.airline.controller;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.airline.service.FlightService;


@WebServlet("/AddPassengerToFlight")
public class AddPassengerToFlight extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	
	@EJB
	FlightService fs;
	
    public AddPassengerToFlight() {
        super();
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		String fid = request.getParameter("fid");
		String pid = request.getParameter("pid");
		
		fs.addPassengerToFlight(pid, fid);
		
		response.sendRedirect("Flights");
	}

}
