package com.fms.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fms.dto.FlightDTO;
import com.fms.dto.FmsResponseBody;
import com.fms.entity.FlightEntity;
import com.fms.exception.UserNotFoundException;
import com.fms.mapper.FlightMapper;
import com.fms.service.FlightService;

@RestController
@RequestMapping("/api")
public class FlightController {

	@Autowired
	private FlightService flightService;

	@Autowired
	private FlightMapper flightMapper;

	@PostMapping("/addFlight")
	public FmsResponseBody<FlightEntity> addFlight(@RequestBody FlightEntity flightEntity) throws IOException {
		this.flightService.addFlight(flightEntity);
		return new FmsResponseBody<>(flightEntity, HttpStatus.OK.value());
	}

	@GetMapping("/getFlight/{id}")
	public FmsResponseBody<FlightDTO> getFlightDetailsById(@PathVariable String id) {
		FlightDTO flightDTO = null;
		try {
			FlightEntity flightDetail = this.flightService.getFlightDetailsById(id);
			flightDTO = this.flightMapper.toDto(flightDetail);
		} catch (UserNotFoundException e) {
			return new FmsResponseBody<>(e.getMessage(), HttpStatus.NOT_FOUND.value());
		}

		return new FmsResponseBody<>(flightDTO, HttpStatus.OK.value());
	}

	@DeleteMapping("/deleteFlight/{id}")
	public FmsResponseBody deleteFlightById(@PathVariable String id) {
		try {
			this.flightService.deleteFlighyById(id);
		} catch (UserNotFoundException e) {
			return new FmsResponseBody<>(e.getMessage(), HttpStatus.BAD_REQUEST.value());
		}
		return new FmsResponseBody<>(true, HttpStatus.OK.value());
	}

	@GetMapping("/getFlights")
	public FmsResponseBody<List<FlightDTO>> getAllFlight() {
		List<FlightDTO> flights = this.flightService.getFlights();
		return new FmsResponseBody<>(flights, HttpStatus.OK.value());
	}

	@PutMapping("/updateFlight")
	public FmsResponseBody updateFlight(@RequestBody FlightEntity flight) {
		FlightEntity Updated = this.flightService.updateFlight(flight);
		return new FmsResponseBody<FlightEntity>(Updated, HttpStatus.OK.value());
	}

}
