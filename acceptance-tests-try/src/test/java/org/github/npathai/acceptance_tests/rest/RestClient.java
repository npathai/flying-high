package org.github.npathai.acceptance_tests.rest;

import java.util.Arrays;
import java.util.List;

import org.github.npathai.acceptance_tests.domain.Airport;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class RestClient {

	private RestTemplate rest = new RestTemplate();
	
	public List<Airport> findAllAirports(String path) {
		ResponseEntity<Airport[]> airports = rest.getForEntity("http://localhost:8090/" + path, Airport[].class);
		System.out.println(">>>>>>>>>>>>>>>>> Got response from rest: " + Arrays.toString(airports.getBody()));
		return Arrays.asList(airports.getBody());
	}

	public List<Airport> findAllAirports() {
		return findAllAirports("rest/api/airports");
	}
	
	public static void main(String[] args) {
		new RestClient().findAllAirports();
	}
}
