package org.github.narendra.flights_web_service.repository;

import org.github.narendra.flights_web_service.domain.Airport;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "airports", path = "airports")
public interface AirportRepository extends MongoRepository<Airport, String> {
	Airport findByCode(String name);
}
