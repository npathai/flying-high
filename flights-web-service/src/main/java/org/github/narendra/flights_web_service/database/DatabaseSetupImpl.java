package org.github.narendra.flights_web_service.database;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.github.narendra.flights_web_service.domain.Airport;
import org.github.narendra.flights_web_service.repository.AirportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DatabaseSetupImpl implements DatabaseSetup {

	private final static Airport sydney = Airport.called("Sydney").inCountry("Australia").withCode("SYD");
	private final static Airport melbourne = Airport.called("Melbourne").inCountry("Australia").withCode("MEL");
	private final static Airport brisbane = Airport.called("Brisbane").inCountry("Australia").withCode("BNE");
	private final static Airport perth = Airport.called("Perth").inCountry("Australia").withCode("PER");
	private final static Airport sanfrancisco = Airport.called("San Francisco").inCountry("USA").withCode("SFO");
	private final static Airport losangeles = Airport.called("Los Angeles").inCountry("USA").withCode("LAX");
	private final static Airport auckland = Airport.called("Auckland").inCountry("New Zealand").withCode("AKL");
	private final static Airport wellington = Airport.called("Wellington").inCountry("New Zealand").withCode("WLG");
	private final static Airport christchurch = Airport.called("Christchurch").inCountry("New Zealand").withCode("CHC");

	private final static List<Airport> DEFAULT_AIRPORTS = Collections.unmodifiableList(Arrays.asList(
			sydney, melbourne, brisbane, perth, auckland, wellington, christchurch, sanfrancisco, losangeles
	));

	@Autowired
	private AirportRepository airportRepository;
	
	public void initializeReferenceData() {
		airportRepository.deleteAll();
		airportRepository.insert(DEFAULT_AIRPORTS);
	}
}
