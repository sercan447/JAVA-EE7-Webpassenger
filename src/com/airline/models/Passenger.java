package com.airline.models;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.*;
import javax.xml.bind.annotation.*;



@Entity
@Table(name="passenger")
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Passenger implements Serializable {

	@Transient	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@XmlElement
	private Integer Id;
	@XmlElement
	private String firstName;
	@XmlElement
	private String lastName;
	
	@Temporal(TemporalType.DATE)
	@XmlElement
	private Date dob;
	
	@Enumerated(EnumType.ORDINAL)
	@XmlElement
	private Gender gender;
	
	@Enumerated(EnumType.ORDINAL)
	private FlightClass flightClass;
	
	@ManyToMany(mappedBy = "passengers",fetch = FetchType.EAGER)
	@XmlTransient
	private List<Flight> flights;
	
	public Passenger() {
		
	}


	public Integer getId() {
		return Id;
	}


	public void setId(Integer id) {
		Id = id;
	}


	public String getFirstName() {
		return firstName;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public String getLastName() {
		return lastName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	public Date getDob() {
		return dob;
	}


	public void setDob(Date dob) {
		this.dob = dob;
	}


	public Gender getGender() {
		return gender;
	}


	public void setGender(Gender gender) {
		this.gender = gender;
	}


	public FlightClass getFlightClass() {
		return flightClass;
	}


	public void setFlightClass(FlightClass flightClass) {
		this.flightClass = flightClass;
	}
	public List<Flight> getFlights() {
		return flights;
	}


	public void setFlights(List<Flight> flights) {
		this.flights = flights;
	}


	@Override
	public String toString() {
		return "Passenger [Id=" + Id + ", firstName=" + firstName + ", lastName=" + lastName + ", dob=" + dob
				+ ", gender=" + gender + ", flightClass=" + flightClass + ", flights=" + flights + "]";
	}



	
	
   
}
