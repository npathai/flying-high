package org.github.npathai.acceptance_tests.steps;

import static org.fest.assertions.Assertions.assertThat;

import java.util.List;

import org.github.npathai.acceptance_tests.pages.MyAccountPage;

import net.thucydides.core.annotations.Step;

public class MyAccountUISteps {

	private MyAccountPage myAccountPage;
	
	@Step
	public void openAccountPage() {
		myAccountPage.open();
	}

	@Step
	public void shouldSeeHomeCityOf(String city) {
		assertThat(myAccountPage.getHomeCity()).isEqualTo(city);
	}

	@Step
	public void shouldSeePossibleDestinationsOf(List<String> possibleDestinations) {
		List<String> displayedPossibleDestinations = myAccountPage.getPossibleDestinations();
		assertThat(displayedPossibleDestinations).contains(possibleDestinations.toArray());
	}
}
