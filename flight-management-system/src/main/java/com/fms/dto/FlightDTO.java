package com.fms.dto;

import java.time.LocalDateTime;

import com.fms.enums.FlightStatus;

public class FlightDTO {

	private String flightId;

	private String name;

	private LocalDateTime arrivalTime;

	private LocalDateTime departureTime;

	private String source;

	private String destination;

	private LocalDateTime createdOn;

	private LocalDateTime updatedOn;

	private Integer availableSeats;

	private FlightStatus flightStatus;
	
	private String createdById;
	
	public String getCreatedById() {
		return createdById;
	}

	public String getCreatedByName() {
		return createdByName;
	}

	public void setCreatedById(String createdById) {
		this.createdById = createdById;
	}


	private String createdByName;

	public String getFlightId() {
		return flightId;
	}

	public void setFlightId(String flightId) {
		this.flightId = flightId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public LocalDateTime getArrivalTime() {
		return arrivalTime;
	}

	public void setArrivalTime(LocalDateTime arrivalTime) {
		this.arrivalTime = arrivalTime;
	}

	public LocalDateTime getDepartureTime() {
		return departureTime;
	}

	public void setDepartureTime(LocalDateTime departureTime) {
		this.departureTime = departureTime;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public LocalDateTime getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(LocalDateTime createdOn) {
		this.createdOn = createdOn;
	}

	public LocalDateTime getUpdatedOn() {
		return updatedOn;
	}

	public void setUpdatedOn(LocalDateTime updatedOn) {
		this.updatedOn = updatedOn;
	}

	public Integer getAvailableSeats() {
		return availableSeats;
	}

	public void setAvailableSeats(Integer availableSeats) {
		this.availableSeats = availableSeats;
	}

	public FlightStatus getFlightStatus() {
		return flightStatus;
	}

	public void setFlightStatus(FlightStatus flightStatus) {
		this.flightStatus = flightStatus;
	}


	public void setCreatedByName(String createdByName) {
		this.createdByName = createdByName;
	}
	
	
	
}
