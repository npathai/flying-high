package org.github.npathai.acceptance_tests.stepdefs;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.github.npathai.acceptance_tests.steps.MyAccountUISteps;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.model.ExamplesTable;

import net.thucydides.core.annotations.Pending;
import net.thucydides.core.annotations.Steps;

public class MyAccountStepUIDefinitions {

	@Steps
	private MyAccountUISteps sarah;
	
	@Pending
	@Then("she should see a home city of $city")
	public void shouldSeeAHomeCityOf(String city) {
		sarah.shouldSeeHomeCityOf(city);
	}
	
	@Pending
	@Then("the following destination airports: $airports")
	public void shouldSeeDestinationAirports(ExamplesTable airportsTable) {
		sarah.shouldSeePossibleDestinationsOf(airportNamesFrom(airportsTable));
	}

	private List<String> airportNamesFrom(ExamplesTable airportsTable) {
		return airportsTable.getRows().stream()
				.map(row -> row.get("airport"))
				.collect(Collectors.toList());
	}
}
