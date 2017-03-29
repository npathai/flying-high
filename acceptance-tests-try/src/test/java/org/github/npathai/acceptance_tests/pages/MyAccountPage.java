package org.github.npathai.acceptance_tests.pages;

import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.WebElement;

import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.annotations.DefaultUrl;

@DefaultUrl("http://localhost:4200/myaccount")
public class MyAccountPage extends PageObject {

	public String getHomeCity() {
		return findBy("#home-city").getText();
	}

	public List<String> getPossibleDestinations() {
		waitFor(".destinations");
		findBy(".destinations > button").click();
		return findAll(".possible-destination-name")
				.stream()
				.map(WebElement::getText)
				.collect(Collectors.toList());
	}

	
}
