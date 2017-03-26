package org.github.npathai.acceptance_tests.stepdefs;

import java.util.List;

import org.fest.assertions.Assertions;
import org.github.npathai.acceptance_tests.domain.Airport;
import org.github.npathai.acceptance_tests.pages.HomePage;
import org.github.npathai.acceptance_tests.rest.RestClient;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

public class AirportStepUIDefinitions {

	private HomePage homePage;
	private RestClient restClient = new RestClient();

	@When("I go to the home page")
	public void openHomePage() {
		homePage.open();
	}
	
	@Then("I should see the list of possible destinations")
	public void seeListOfPossibleDestinations() {
		List<Airport> expectedAirports = restClient.findAllAirports();
		
		List<Airport> displayedAirports = homePage.getDisplayedAirports();
		
		Assertions.assertThat(displayedAirports.size()).isEqualTo(expectedAirports.size());
		Assertions.assertThat(displayedAirports).contains(expectedAirports.toArray());
	}
}
