package org.github.npathai.acceptance_tests.domain;

public class Airport {

	private String name;
	private String code;
	private String country;

	public Airport() {
	}
	
	public Airport(String name, String code, String country) {
		this.name = name;
		this.code = code;
		this.country = country;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((code == null) ? 0 : code.hashCode());
		result = prime * result + ((country == null) ? 0 : country.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Airport other = (Airport) obj;
		if (code == null) {
			if (other.code != null)
				return false;
		} else if (!code.equals(other.code))
			return false;
		if (country == null) {
			if (other.country != null)
				return false;
		} else if (!country.equals(other.country))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Airport [name=" + name + ", code=" + code + ", country=" + country + "]";
	}

	public String getName() {
		return name;
	}

	public String getCode() {
		return code;
	}

	public String getCountry() {
		return country;
	}
}
