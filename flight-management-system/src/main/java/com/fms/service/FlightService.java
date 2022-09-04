package com.fms.service;

import java.io.IOException;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fms.dto.FlightDTO;
import com.fms.entity.FlightEntity;
import com.fms.exception.UserNotFoundException;
import com.fms.mapper.FlightMapper;
import com.fms.repository.FlightDao;

@Service
public class FlightService {

	@Autowired
	private FlightDao flightDao;
	
	@Autowired
	private FlightMapper mapper;
     
	@Transactional
	public FlightEntity addFlight(FlightEntity flightEntity){
		  this.flightDao.addFlight(flightEntity);
		  return flightEntity;
		
	}
	
	public FlightEntity getFlightDetailsById(String id) {
		return this.flightDao.getFlightDetailsById(id);
		
	}
	
	
	
	public void deleteFlighyById(String id) {
		 this.flightDao.deleteFlightById(id);
	}
	
	public List<FlightDTO> getFlights() {
	   List<FlightEntity> flights = this.flightDao.getFlights();
	   List<FlightDTO> dtoList = this.mapper.toDTOList(flights);
	   return dtoList;
	}
	@Transactional
	public FlightEntity updateFlight(FlightEntity flight) {
	      this.flightDao.updateFlight(flight);
	      return flight;
	}
	
}
