package org.github.npathai.acceptance_tests.steps;

import java.util.List;

import org.github.npathai.acceptance_tests.domain.Airport;
import org.github.npathai.acceptance_tests.rest.RestClient;

import net.thucydides.core.annotations.Step;

public class AirportClientSteps {

	private RestClient restClient = new RestClient();

	@Step
	public List<Airport> listAllAirports(String path) {
		return restClient.findAllAirports(path);
	}
}
