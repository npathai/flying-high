package org.github.narendra.flights_web_service.flights.web;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;

import java.util.List;

import org.github.narendra.flights_web_service.FlightsApp;
import org.github.narendra.flights_web_service.domain.Airport;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.client.RestTemplate;


@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT, classes = FlightsApp.class)
@RunWith(SpringJUnit4ClassRunner.class)
public class FindingDestinationAndDepartureAirportsTest {

	private RestTemplate rest = new RestTemplate();
	
	@Value("${local.server.port}")
	private int port;

	private String baseUrl;
	
	@Before
	public void configureBaseUrl() {
		baseUrl = "http://localhost:" + port;
		rest.getForObject(baseUrl + "/rest/api/airports/reset", Void.class);
	}
	
	@Test
	public void listsAllDestinationAirports() {
		ResponseEntity<List<Airport>> safeAirports = rest.exchange(baseUrl + "/rest/api/airports",
				HttpMethod.GET,
				null,
				new ParameterizedTypeReference<List<Airport>>(){}
		);
		Assert.assertFalse(safeAirports.getBody().isEmpty());
		Assert.assertThat(safeAirports.getBody().size(), is(equalTo(9)));
	}
}
