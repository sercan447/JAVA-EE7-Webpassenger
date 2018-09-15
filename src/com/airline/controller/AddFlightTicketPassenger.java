package com.airline.controller;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.airline.service.PassengerService;

@WebServlet("/AddFlightTicketPassenger")
public class AddFlightTicketPassenger extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	@EJB
	PassengerService ps;
 
    public AddFlightTicketPassenger() {
        super();
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String fid = request.getParameter("fid");
		String pid = request.getParameter("pid");
		
		ps.addFlightTicketToPassenger(fid,pid);
				
		response.sendRedirect("Passengers");
				
		
	}

}
