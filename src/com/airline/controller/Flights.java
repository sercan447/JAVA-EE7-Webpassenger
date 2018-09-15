package com.airline.controller;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;

import com.airline.models.Flight;
import com.airline.service.FlightService;


@WebServlet("/Flights")
public class Flights extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	@EJB
	FlightService fs;
    
    public Flights() {
        super();
        
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		List<Flight> fList = (List<Flight>) fs.getFlights();
		
		
		request.setAttribute("flight_list", fList);
		
		RequestDispatcher view = request.getRequestDispatcher("WEB-INF/view/flights_list.jsp");
		
		view.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
