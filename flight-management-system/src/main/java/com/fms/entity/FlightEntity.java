package com.fms.entity;

import java.io.IOException;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.Table;

import com.fms.entity.UserEntity;

import com.fms.enums.FlightStatus;
import com.ruishanio.Ksuid;

@Entity
@Table(name = "flight_details")
public class FlightEntity {
	
	@Id
	@Column(name = "ID")
	private String id;

	@Column(name = "NAME" , nullable = false)
	private String name;

	@Column(name = "ARRIVAL_TIME" , nullable = false)
	private LocalDateTime arrivalTime;

	@Column(name = "DEPARTURE_TIME" , nullable = false)
	private LocalDateTime departureTime;

	@Column(name = "SOURCE" , nullable = false)
	private String source;

	@Column(name = "DESTINATION" , nullable = false)
	private String destination;

	@Column(name = "CREATED_ON" , nullable = false)
	private LocalDateTime createdOn;

	@Column(name = "UPDATED_ON" , nullable = false)
	private LocalDateTime updatedOn;

	@Column(name = "AVAILABLE_SEAT")
	private Integer availableSeats;

	@Column(name = "FLIGHT_STATUS" , nullable = false)
	@Enumerated(EnumType.STRING)
	private FlightStatus flightStatus;
	@ManyToOne
	@JoinColumn(name = "USER_ID" , nullable = false)
	private UserEntity user;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
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
		return this.source;
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

	public UserEntity getUser() {
		return user;
	}

	public void setUser(UserEntity user) {
		this.user = user;
	}

	@PrePersist
	public void beforeInsert() throws IOException {
		Ksuid ksuid = new Ksuid();
		this.id = ksuid.generate();
		this.createdOn = LocalDateTime.now();
		this.updatedOn = LocalDateTime.now();
	}

}
