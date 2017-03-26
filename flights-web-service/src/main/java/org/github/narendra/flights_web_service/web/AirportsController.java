package org.github.narendra.flights_web_service.web;

import java.util.List;

import org.github.narendra.flights_web_service.database.DatabaseSetup;
import org.github.narendra.flights_web_service.domain.Airport;
import org.github.narendra.flights_web_service.repository.AirportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AirportsController {

	@Autowired
	private AirportRepository airportRepository;
	
	@Autowired
	private DatabaseSetup databaseSetup;
	
	@RequestMapping("/rest/api/airports")
	public List<Airport> listAllAirports() {
		List<Airport> airports = airportRepository.findAll();
		return airports;
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/rest/api/airports/reset")
	public void initializeAirports() {
		databaseSetup.initializeReferenceData();
	}
}
