package org.github.narendra.flights_web_service.web;

import java.util.List;
import java.util.stream.Collectors;

import org.github.narendra.flights_web_service.database.DatabaseSetup;
import org.github.narendra.flights_web_service.domain.Airport;
import org.github.narendra.flights_web_service.domain.Route;
import org.github.narendra.flights_web_service.repository.RouteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rest/api/routes")
public class RoutesController {

	@Autowired
	private DatabaseSetup databaseSetup;
	
	@Autowired
	private RouteRepository routeRepository;
	
	@RequestMapping("/from")
	public List<Airport> airportsWithFlightsFrom(@RequestParam("departureCode") String departureCode) {
		return routeRepository.findByDepartureCode(departureCode)
				.stream()
				.map(Route::getDestination)
				.collect(Collectors.toList());
	}
	
	@RequestMapping("/reset")
	public void initializeRoutes() {
		databaseSetup.initializeReferenceData();
	}
}
