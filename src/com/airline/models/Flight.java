package com.airline.models;

import java.io.Serializable;
import java.util.*;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;


@NamedQuery(name="Flight.findById",query="SELECT f FROM Flight f WHERE f.id = :id")
@Entity
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Flight implements Serializable {

	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	@Enumerated(EnumType.STRING)
	private FlightDestinations flightOrigin;
	
	@Enumerated(EnumType.STRING)
	private FlightDestinations flightDestination;
	
	private Integer price;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date flightTime;
	
	@OneToOne(cascade= {CascadeType.PERSIST,CascadeType.REMOVE})
	@JoinColumn(name="airplane_fk")
	@XmlTransient
	private Airplane airplaneDetail;

	@OneToMany(mappedBy="flightForPilot", fetch =FetchType.EAGER)
	@XmlTransient
	private List<Pilot> pilots;
	

	@ManyToMany
	@JoinTable(name="f_p_join",joinColumns=@JoinColumn(name="flight_fk"),inverseJoinColumns=@JoinColumn(name="passenger_fk"))
	@XmlTransient
	private List<Passenger> passengers;
	
	
	public Flight() {
		super();
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public FlightDestinations getFlightOrigin() {
		return flightOrigin;
	}


	public void setFlightOrigin(FlightDestinations flightOrigin) {
		this.flightOrigin = flightOrigin;
	}


	public FlightDestinations getFlightDestination() {
		return flightDestination;
	}


	public void setFlightDestination(FlightDestinations flightDestination) {
		this.flightDestination = flightDestination;
	}


	public Integer getPrice() {
		return price;
	}


	public void setPrice(Integer price) {
		this.price = price;
	}


	public Date getFlightTime() {
		return flightTime;
	}


	public void setFlightTime(Date flightTime) {
		this.flightTime = flightTime;
	}


	public Airplane getAirplaneDetail() {
		return airplaneDetail;
	}


	public void setAirplaneDetail(Airplane airplaneDetail) {
		this.airplaneDetail = airplaneDetail;
	}


	public List<Pilot> getPilots() {
		return pilots;
	}


	public void setPilots(List<Pilot> pilots) {
		this.pilots = pilots;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	

	public List<Passenger> getPassengers() {
		return passengers;
	}


	public void setPassengers(List<Passenger> passengers) {
		this.passengers = passengers;
	}


	@Override
	public String toString() {
		return "Flight [id=" + id + ", flightOrigin=" + flightOrigin + ", flightDestination=" + flightDestination
				+ ", price=" + price + ", flightTime=" + flightTime + ", airplaneDetail=" + airplaneDetail + ", pilots="
				+ pilots + ", passengers=" + passengers + "]";
	}


	
	
	
	
	
}