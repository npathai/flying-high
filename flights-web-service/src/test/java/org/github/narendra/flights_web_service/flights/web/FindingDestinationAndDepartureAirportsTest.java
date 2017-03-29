package org.github.narendra.flights_web_service.flights.web;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThat;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.assertj.core.api.Assertions;
import org.github.narendra.flights_web_service.FlightsApp;
import org.github.narendra.flights_web_service.domain.Airport;
import org.github.narendra.flights_web_service.domain.Route;
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
	
	private final static Airport sydney = Airport.called("Sydney").inCountry("Australia").withCode("SYD");
	private final static Airport melbourne = Airport.called("Melbourne").inCountry("Australia").withCode("MEL");
	private final static Airport brisbane = Airport.called("Brisbane").inCountry("Australia").withCode("BNE");
	private final static Airport perth = Airport.called("Perth").inCountry("Australia").withCode("PER");
	private final static Airport sanfrancisco = Airport.called("San Francisco").inCountry("USA").withCode("SFO");
	private final static Airport losangeles = Airport.called("Los Angeles").inCountry("USA").withCode("LAX");
	private final static Airport auckland = Airport.called("Auckland").inCountry("New Zealand").withCode("AKL");
	private final static Airport wellington = Airport.called("Wellington").inCountry("New Zealand").withCode("WLG");
	private final static Airport christchurch = Airport.called("Christchurch").inCountry("New Zealand").withCode("CHC");

	private final static List<Airport> EXPECTED_AIRPORTS = Collections.unmodifiableList(Arrays.asList(
			sydney, melbourne, brisbane, perth, auckland, wellington, christchurch, sanfrancisco, losangeles
	));
	
	private static final List<Route> DEFAULT_ROUTES = Arrays.asList(
            Route.from(sydney).to(melbourne).withDistanceOf(850).km(),
            Route.from(sydney).to(brisbane).withDistanceOf(1200).km(),
            Route.from(sydney).to(perth).withDistanceOf(3000).km(),
            Route.from(sydney).to(auckland).withDistanceOf(1800).km(),
            Route.from(sydney).to(wellington).withDistanceOf(2000).km(),
            Route.from(sydney).to(christchurch).withDistanceOf(2500).km(),
            Route.from(sydney).to(sanfrancisco).withDistanceOf(6500).km(),
            Route.from(sydney).to(losangeles).withDistanceOf(6000).km(),

            Route.from(melbourne).to(sydney).withDistanceOf(850).km(),
            Route.from(melbourne).to(brisbane).withDistanceOf(2000).km(),
            Route.from(melbourne).to(perth).withDistanceOf(2700).km(),
            Route.from(melbourne).to(auckland).withDistanceOf(2500).km(),
            Route.from(melbourne).to(wellington).withDistanceOf(2200).km(),
            Route.from(melbourne).to(christchurch).withDistanceOf(2800).km(),
            Route.from(melbourne).to(sanfrancisco).withDistanceOf(6800).km(),
            Route.from(melbourne).to(losangeles).withDistanceOf(6200).km(),

            Route.from(brisbane).to(sydney).withDistanceOf(850).km(),
            Route.from(brisbane).to(melbourne).withDistanceOf(2000).km(),
            Route.from(brisbane).to(perth).withDistanceOf(2700).km(),
            Route.from(brisbane).to(auckland).withDistanceOf(2500).km(),
            Route.from(brisbane).to(wellington).withDistanceOf(2200).km(),
            Route.from(brisbane).to(christchurch).withDistanceOf(2800).km(),
            Route.from(brisbane).to(sanfrancisco).withDistanceOf(6800).km(),
            Route.from(brisbane).to(losangeles).withDistanceOf(6200).km(),

            Route.from(perth).to(sydney).withDistanceOf(850).km(),
            Route.from(perth).to(melbourne).withDistanceOf(2000).km(),
            Route.from(perth).to(brisbane).withDistanceOf(2700).km(),
            Route.from(perth).to(auckland).withDistanceOf(2500).km(),
            Route.from(perth).to(wellington).withDistanceOf(2200).km(),
            Route.from(perth).to(christchurch).withDistanceOf(2800).km(),
            Route.from(perth).to(sanfrancisco).withDistanceOf(6800).km(),
            Route.from(perth).to(losangeles).withDistanceOf(6200).km()
            );

	private RestTemplate rest = new RestTemplate();
	
	@Value("${local.server.port}")
	private int port;

	private String baseUrl;
	
	@Before
	public void initializeTestDatabase() {
		baseUrl = "http://localhost:" + port;
		rest.getForObject(baseUrl + "/rest/api/airports/reset", Void.class);
		rest.getForObject(baseUrl + "/rest/api/routes/reset", Void.class);
	}
	
	@Test
	public void listsAllDestinationAirports() {
		ResponseEntity<List<Airport>> safeAirports = rest.exchange(baseUrl + "/rest/api/airports",
				HttpMethod.GET,
				null,
				new ParameterizedTypeReference<List<Airport>>(){}
		);
		Assertions.assertThat(safeAirports.getBody()).isEqualTo(EXPECTED_AIRPORTS);
	}
	
	@Test
	public void findsAirportByAirportCode() {
		ResponseEntity<Airport> airport = rest.getForEntity(urlForFindByCode(sydney.getCode()), Airport.class);
		assertThat(airport.getBody(), is(equalTo(sydney)));
		
		airport = rest.getForEntity(urlForFindByCode(melbourne.getCode()), Airport.class);
		assertThat(airport.getBody(), is(equalTo(melbourne)));
	}

	@Test
	public void findsAirportsWithFlightsFromAGivenDestinationCode() {
		ResponseEntity<List<Airport>> airports = rest.exchange(baseUrl + "/rest/api/routes/from?departureCode={departureCode}" , HttpMethod.GET,
				null,
				new ParameterizedTypeReference<List<Airport>>() {},
				"SYD");

		assertFalse(airports.getBody().isEmpty());
		airports.getBody().forEach((airport) -> {
			assertThat(airport.getCode(), is(not(equalTo("SYD"))));
		});
	}
	
	private String urlForFindByCode(String code) {
		return baseUrl + "/rest/api/airports/search/findByCode?code=" + code;
	}
}
