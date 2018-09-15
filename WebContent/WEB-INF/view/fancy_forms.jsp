<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>


<h1 style="text-decoration:underline;">Fancy Home</h1>

<h1>Add Flight  and airplane</h1>


<form method="POST" action="AddFlight">

	From  :
	
	<select name="from_destination">
		<option value="San_Francisco">San Francisco</option>
		<option value="Los_Angeles">Los Angeles</option>
		<option value="New_York">New York</option>
		<option value="London">London</option>
		<option value="Paris">Paris</option>
		<option value="Rome">Rome</option>
		<option value="Amsterdam">Amsterdam</option>
	</select>
	
	<br/> <br/>
	
	To : 
	
	<select name="to_destination">
		<option value="San_Francisco">San Francisco</option>
		<option value="Los_Angeles">Los Angeles</option>
		<option value="New_York">New York</option>
		<option value="London">London</option>
		<option value="Paris">Paris</option>
		<option value="Rome">Rome</option>
		<option value="Amsterdam">Amsterdam</option>
	</select>
	
	<h4>Time of Flight</h4>
	
	<hr/>
	
	Year : 
	
	<select name="year">
		<option value="2015">2015</option>
		<option value="2016">2016</option>
		<option value="2017">2017</option>
		<option value="2018">2018</option>
		<option value="2019">2019</option>
		<option value="2020">2020</option>
	</select>
	
	<br/> <br/>
	
	Month : 
	
	<select name="month">
			<option value="0">January</option>
			<option value="1">February</option>
			<option value="2">March</option>
			<option value="3">April</option>
			<option value="4">May</option>
			<option value="5">June</option>
			<option value="6">July</option>
			<option value="7">August</option>
			<option value="8">September</option>
			<option value="9">October</option>
			<option value="10">November</option>
			<option value="11">December</option>
	</select>	
	
	<br/> <br/>
	
	Day of Month : 
	<input name="day"  type="text"/>
	<br/> <br/>
	
	Hour of Day(0-25) :
	<input name="hour" type="text" />
	<br/> <br/>
	
	Minute (0-59):
	<input  name="minute" type="text" />
	<br/> <br/>
	
	Price :
	<input name="price" type="text" /> 
	<hr/>
	
	<h4>Airline</h4>
	
	Plane Make :
	<input name="airplane_make" type="text" />
	<br/> <br/>
	
	Model name : 
	<input name="airplane_model" type="text" />
	<br/> <br/>
	
	Seating : 
	<input name="airplane_seating"  type="text"/>
	<hr/>
	
	<button type="submit">Add Flight and airplane</button>
	
	<hr/>
	
</form>


<h1>Add Pilot to flight</h1>
<form method="POST" action="CreatePilotAndAddToFlight">
							
	
	First Name : 
	
	<input name="first_name" type="text" />
	<br/><br/>
	
	Last Name :
	<input name="last_name" type="text" />
	<br/> <br/>
	
	License : 
	<input name="license" type="text" />
	<br/> <br/>
	
	Pilot Rank : 
	<select name="pilot_rank">
		<option value="Captain">Captain</option>
		<option value="First_Officer">First Officer</option>
		<option value="Junior_Officer">Junior Officer</option>
	</select>
	<br/> <br/>
	
	Flight Id : 
	<input name="fid" type="text" />
	<hr/>
	
	<button type="submit">Add Pilot to FLight</button>
	
</form>

<h1>Add Passenger</h1>
<form method="POST" action="AddPassenger">
	First Name :
	<input name="first_name" type="text" />
	<br/> <br/>
	
	Last Name : 
	<input  name="last_name" type="text" />
	<br/> <br/>
	
	Date of birth:
	<input  name="dob" type="text" />
	<br/> <br/>
	
	Gender :
	<select name="gender">
		<option value="Female">Female</option>
		<option value="Male">Male</option>
	</select>
	
	<hr/>
	
	
	<button type="submit">Add Passenger </button>
	<hr/>
</form>

<h1>Add Passenger to Flight</h1>
<form method="POST" action="AddPassengerToFlight">
	Add a passenger with an id of
	
	<input name="pid" type="text" />
	
	to a flight with an id of
	
	<input name="fid" type="text" />
	<hr/>
	
	<button type="submit">Add passenger to Flight</button>
	<hr/>
	</form>

<h1>Add flight to passenger <span style="font-size:16px;vertical-align:middle;">(give a passenger another flight ticket to his\her collection of flight tickets)</span></h1>
	
	<form method="POST" action="AddFlightTicketPassenger">
		
		Add a ticket for a flight with an id of
		
		<input name="fid" type="text" />
		
		to a passenger with an id of
		
		<input name="pid" type="text" />
		
		<br/> <br/>
		
		<span style="font-weight:bold;">(In real world terms - add the flight ticket to the passenger's collection of flight tickets)</span>
		
		<hr/>
		
		<button type="submit">Add flight (ticket) to passenger's flight tickets </button>
		
		<hr/>
	</form>
	

</body>
</html>