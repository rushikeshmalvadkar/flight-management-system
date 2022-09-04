package com.fms.mapper;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.fms.dto.FlightDTO;
import com.fms.entity.FlightEntity;
import com.fms.entity.UserEntity;

@Component
public class FlightMapper {
	
	public FlightDTO toDto(FlightEntity flightEntity) {
		FlightDTO flightDTO = new FlightDTO();
		flightDTO.setFlightId(flightEntity.getId());
		flightDTO.setName(flightEntity.getName());
		flightDTO.setArrivalTime(flightEntity.getArrivalTime());
		flightDTO.setDepartureTime(flightEntity.getDepartureTime());
		flightDTO.setCreatedOn(flightEntity.getCreatedOn());
		flightDTO.setUpdatedOn(flightEntity.getUpdatedOn());
		flightDTO.setFlightStatus(flightEntity.getFlightStatus());
		flightDTO.setSource(flightEntity.getSource());
		flightDTO.setDestination(flightEntity.getDestination());
		UserEntity userEntity = flightEntity.getUser();
		flightDTO.setCreatedById(userEntity.getId());
		flightDTO.setCreatedByName(userEntity.getName());
		return flightDTO;
	}
	
	public  List<FlightDTO> toDTOList(List<FlightEntity> flightEntities) {
		return flightEntities.stream()
					   .map(flightEntity -> this.toDto(flightEntity)).collect(Collectors.toList());
	}

}
