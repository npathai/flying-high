package org.github.npathai.acceptance_tests.stepdefs;


import static org.fest.assertions.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.github.npathai.acceptance_tests.domain.Airport;
import org.github.npathai.acceptance_tests.pages.DisplayedAirport;
import org.github.npathai.acceptance_tests.steps.AirportClientSteps;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.jbehave.core.model.ExamplesTable;

import net.thucydides.core.annotations.Steps;

public class AirportStepDefinitions {

	@Steps
	private AirportClientSteps airportClientSteps;
	
	private List<Airport> retrievedAirports;

	@Given("I need to know what cities I can fly to")
	public void givenINeedToKnowWhatCitiesICanFlyTo() {
		
	}
	
	@When("I ask for a list of airports")
	public void whenIAskForTheListOfAirports() {
		retrievedAirports = airportClientSteps.listAllAirports("/rest/api/airports");
	}
	
	@Then("I should obtain at least the following: $expectedAirports")
	public void thenIShouldObtainAtleastTheFollowing(ExamplesTable expectedAirports) {
		List<Airport> expected = new ArrayList<Airport>();
		for (Map<String, String> airportFields: expectedAirports.getRows()) {
			expected.add(DisplayedAirport.fromMapValues(airportFields));
		}
		
		assertThat(retrievedAirports).isEqualTo(expected);
	}
}
