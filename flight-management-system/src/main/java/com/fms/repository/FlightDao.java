package com.fms.repository;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.fms.entity.FlightEntity;
import com.fms.exception.UserNotFoundException;

@Repository
public class FlightDao {

	@Autowired
	private EntityManager entityManager;

	public FlightEntity addFlight(FlightEntity flightEntity)  {
		this.entityManager.persist(flightEntity);
		return flightEntity;
	}

	public FlightEntity getFlightDetailsById(String id) throws UserNotFoundException {
		TypedQuery<FlightEntity> query = this.entityManager.createQuery("select f from FlightEntity f where id = : id ",
				FlightEntity.class);
		query.setParameter("id", id);
		FlightEntity flightDetails = null;
		try {
		  flightDetails = query.getSingleResult();
		}

		catch (NoResultException e) {
            throw  new UserNotFoundException("data is not fount for"+ ""+id);
		}
		return flightDetails;
	}

	public void deleteFlightById(String id) {
       FlightEntity forDeleteitem = this.getFlightDetailsById(id);
       this.entityManager.remove(forDeleteitem);
	}
	
	public  List<FlightEntity> getFlights() {
		TypedQuery<FlightEntity> query = this.entityManager.createQuery("select f from FlightEntity  f join fetch f.user", FlightEntity.class);
		List<FlightEntity> flights = query.getResultList();
		return flights;
	}
	public FlightEntity updateFlight(FlightEntity flight) {
		flight.setCreatedOn(LocalDateTime.now());
		this.entityManager.merge(flight);
		return flight;
	}
}
