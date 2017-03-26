package org.github.npathai.acceptance_tests.pages;

import java.util.List;
import java.util.stream.Collectors;

import org.github.npathai.acceptance_tests.domain.Airport;

import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.annotations.DefaultUrl;

@DefaultUrl("http://localhost:4200/#/home")
public class HomePage extends PageObject {

	public List<Airport> getDisplayedAirports() {
		findBy(".destinations > button").click();
		waitFor(".serviced-airport");
		return findAll(".serviced-airport").stream()
				.map(DisplayedAirport::fromWebElement)
				.collect(Collectors.toList());
	}

	
}
