package org.github.npathai.acceptance_tests.pages;

import java.util.Map;

import org.github.npathai.acceptance_tests.domain.Airport;

import net.serenitybdd.core.pages.WebElementFacade;

public class DisplayedAirport {

	public static Airport fromMapValues(Map<String, String> airportFields) {
		return new Airport(
				airportFields.get("name"),
				airportFields.get("code"),
				airportFields.get("country")
				);
	}
	
	public static Airport fromWebElement(WebElementFacade airportElement) {
		return new Airport(
				airportElement.findBy(".airport-name").getText(),
				airportElement.findBy(".airport-code").getText(),
				airportElement.findBy(".airport-country").getText()
				);
	}
}
