package org.github.narendra.flights_web_service.flights

import org.github.narendra.flights_web_service.domain.Airport

import spock.lang.Specification

class WhenManagingAirportsTest extends Specification {

	def "airports have a name and code"() {
		when:
			def airport = new Airport("Sydney", "SYD", "Australia")
		then:
			airport.name == "Sydney"
		and:
			airport.code == "SYD"
	}
	
	def "Should be able to create airports easiy"() {
		when:
			def airport = Airport.called("Sydney").inCountry("Australia").withCode("SYD");
		then:
			airport.name == "Sydney"
		and:
			airport.code == "SYD"
	}
}
