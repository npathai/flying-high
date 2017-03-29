package org.github.narendra.flights_web_service.repository;

import java.util.List;

import org.github.narendra.flights_web_service.domain.Route;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface RouteRepository extends MongoRepository<Route, String> {
	List<Route> findByDepartureCode(String departureCode);
}
