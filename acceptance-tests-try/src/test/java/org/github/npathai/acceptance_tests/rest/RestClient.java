package org.github.npathai.acceptance_tests.rest;

import java.util.ArrayList;
import java.util.List;

import org.github.npathai.acceptance_tests.domain.Airport;

public class RestClient {

	public List<Airport> findAllAirports(String path) {
		ArrayList<Airport> list = new ArrayList<>();
		list.add(new Airport("Sydney", "SYD", "Australia"));
		list.add(new Airport("Melbourne", "MEL", "Australia"));
		list.add(new Airport("Brisbane", "BNE", "Australia"));
		list.add(new Airport("San Francisco", "SFO", "USA"));
		list.add(new Airport("Los Angeles", "LAX", "USA"));
		return list;
	}

	public List<Airport> findAllAirports() {
		return findAllAirports("rest/api/airports");
	}
}
