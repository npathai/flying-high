package org.github.npathai.acceptance_tests.domain;

public enum FrequentFlyer {
	Sarah("123456");
	
	private final String number;

	private FrequentFlyer(String number) {
		this.number = number;
	}

	public String getNumber() {
		return number;
	}
}
