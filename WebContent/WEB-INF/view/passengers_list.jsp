<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.*,com.airline.models.*" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<link rel="stylesheet" href="resources/css/jpaStyle.css" />
<title>Insert title here</title>
</head>
<body>,


<h1>List of Passengers</h1>

	<table>
	
			<tr>
				<td>Id</td>
				<td>FirstName</td>
				<td>LastName</td>
				<td>Date of birth</td>
				<td>Gender</td>
				
			</tr>
			
		
				<%
					List<Passenger> plist = (List<Passenger>) request.getAttribute("passengers_list");
					
					for(Integer i =0;i<plist.size();i++)
					{
						%>
							<tr>
								<td><%= plist.get(i).getId() %></td>
								<td><%= plist.get(i).getFirstName() %> </td>
								<td><%= plist.get(i).getLastName() %> </td>
								<td><%= plist.get(i).getDob() %> </td>
								<td> <%= plist.get(i).getGender() %> </td>
							</tr>
							
							<tr>
						<td colspan="5">
		 			<%
		 				if(plist.get(i).getFlights().size() > 0) {
		 					
		 					List<Flight> fList = (List<Flight>) plist.get(i).getFlights();
		 					
		 					for(Integer k = 0; k < fList.size(); k++) {
		 					
		 			 %>
		 			 		<%= k+1 %>) <%= fList.get(k).getFlightOrigin() %> to <%= fList.get(k).getFlightDestination() %> @ <%= fList.get(k).getFlightTime() %> <br /> 
		 			 <%
		 			 		} //for
		 			 	} else {
		 			  %>
		 			  		No flight tickets yet.
		 			  <%
		 			  	}
		 			   %>
		 		</td>

							</tr>
						
						<%
					}
					
				%>
			
		
	</table>
	
	
</body>
</html>