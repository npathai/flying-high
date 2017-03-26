package org.github.narendra.flights_web_service.domain;

import org.springframework.data.annotation.Id;

public class Airport {
	@Id
	private String id;
	private String name;
	private String code;
	private String country;

	public Airport(String id, String name, String code, String country) {
		this.id = id;
		this.name = name;
		this.code = code;
		this.country = country;
	}

	public Airport(String name, String code, String country) {
		this.name = name;
		this.code = code;
		this.country = country;
	}

	public Airport() {

	}
	
	public static AirportBuilder called(String name) {
		return new AirportBuilder(name);
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}
	
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
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
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
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
		return "Airport [id=" + id + ", name=" + name + ", code=" + code + ", country=" + country + "]";
	}


	public static class AirportBuilder {
        public String name;

        public AirportBuilder(String name) {
            this.name = name;
        }

        public FinalizedAirportBuilder inCountry(String country) {
            return new FinalizedAirportBuilder(name, country);
        }
    }

    public static class FinalizedAirportBuilder {
        public String name;
        public String country;

        public FinalizedAirportBuilder(String name, String country) {
            this.name = name;
            this.country = country;
        }


        public Airport withCode(String code) {
            return new Airport(name, code, country);
        }
    }
}
