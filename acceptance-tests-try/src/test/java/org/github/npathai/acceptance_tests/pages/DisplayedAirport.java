package org.github.npathai.acceptance_tests.pages;

import java.util.Map;

import org.github.npathai.acceptance_tests.domain.Airport;

public class DisplayedAirport {

	public static Airport fromMapValues(Map<String, String> airportFields) {
		return new Airport(airportFields.get("name"),
				airportFields.get("code"),
				airportFields.get("country"));
	}

}
