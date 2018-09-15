<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.*,com.airline.models.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>

<link rel="stylesheet" href="resources/css/jpaStyle.css" />
</head>
<body>

<table>

	<tr>
		<th>Id</th>
		<th>From</th>
		<th>To</th>
		<th>Time</th>
		<th>Price</th>
		<th>Airplane</th>
		<th>Seating</th>
		<th>Nmber of pilots</th>
		<th>Pilot names</th>
	</tr>
	
	<tr>
		<%
			List<Flight> flist = (List<Flight>)request.getAttribute("flight_list");
			
			for(Integer i=0; i < flist.size();i++){	
		%>
					
					<tr>
						<td><%=flist.get(i).getId() %> </td>
						<td><%=flist.get(i).getFlightOrigin() %> </td>
						<td><%=flist.get(i).getFlightDestination() %></td>
						<td><%=flist.get(i).getFlightTime() %> </td>
						<td><%=flist.get(i).getPrice() %> </td>
						<td><%=flist.get(i).getAirplaneDetail().getPlaneMake() + " "+flist.get(i).getAirplaneDetail().getModelName() %>
						<td><%=flist.get(i).getAirplaneDetail().getSeatingCapacity() %>
						
						<td>
							
							<%
								if(flist.get(i).getPilots() != null){
							%>
									<%=flist.get(i).getPilots().size() %> pilots
							<%
								}else{
							%>
								No Pilots yet		
							<%		
								}
							%>
							
						</td>
						
						<td>
							
							<%
								if(flist.get(i).getPilots() != null){
									
									List<Pilot> plist = (List<Pilot>) flist.get(i).getPilots();
									
									for(Integer j = 0; j < plist.size(); j++){
								%>
										
									<%=(j+1) + ") "+plist.get(j).getFirstName()+" "+plist.get(j).getLastName()+ " ("+plist.get(j).getPilotRank()+")"+"<br/>" %>	
								<%		
									}//for
								}//if
							
							%>
							
						</td>
					</tr>
		<% 
			}//for
		%>
	</tr>
</table>

</body>
</html>