package com.airline.controller;

import java.io.IOException;
import java.util.Calendar;
import java.util.Date;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.airline.models.FlightClass;
import com.airline.models.Gender;
import com.airline.models.Passenger;
import com.airline.service.PassengerService;


@WebServlet("/AddPassenger")
public class AddPassenger extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    @EJB
	PassengerService ps;
	
    public AddPassenger() {
        super();
      
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
			
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String fName = request.getParameter("first_name");
		String lName = request.getParameter("last_name");
		String dob_row = request.getParameter("dob");
		String gender = request.getParameter("gender");
		
		
		
		Passenger p = new Passenger();
		  p.setFirstName(fName);
		  p.setLastName(lName);
		  
		  String[] dobArr = dob_row.split("\\/");
		  
		  
		  
		  p.setGender(Gender.Female);
		  p.setFlightClass(FlightClass.First);
		  
		  Calendar cl = Calendar.getInstance();
		  
		  cl.set(Calendar.YEAR, Integer.parseInt(dobArr[2]));
		  cl.set(Calendar.MONTH, Integer.parseInt(dobArr[0]));
		  cl.set(Calendar.DAY_OF_MONTH, Integer.parseInt(dobArr[1]));
		  
		  Date dob = cl.getTime();
		  
		  p.setDob(dob);
		  p.setGender(Gender.valueOf(gender));
		  
		  System.out.println(p);
		  
		  ps.addPassenger(p);

		  response.sendRedirect("Passengers");

	}

}
