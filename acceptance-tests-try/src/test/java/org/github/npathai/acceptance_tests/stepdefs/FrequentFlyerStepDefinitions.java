package org.github.npathai.acceptance_tests.stepdefs;

import org.github.npathai.acceptance_tests.domain.FrequentFlyer;
import org.github.npathai.acceptance_tests.steps.MyAccountUISteps;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.When;

import net.thucydides.core.annotations.Pending;
import net.thucydides.core.annotations.Steps;

public class FrequentFlyerStepDefinitions {
	
	@Steps
	private MyAccountUISteps account;
	
	@Pending
	@Given("$frequentFlyer is a Frequent Flyer member")
	public void givenAFrequentFlyerMember(FrequentFlyer frequentFlyer) {
		
	}
	
	@Pending
	@When("she views her account details")
	public void viewsAccountDetails() {
		account.openAccountPage();
	}
}
