package org.github.narendra.accounts_web_service.domain;
import org.springframework.data.annotation.Id;

public class FrequentFlyerMember {
	@Id
	private String id;
	private String accountNumber;
	private String firstName;
	private String lastName;
	private String homeAirportCode;

	public FrequentFlyerMember() {

	}

	protected FrequentFlyerMember(String id,
			String accountNumber,
			String firstName,
			String lastName,
			String homeAirportCode) {
		this.id = id;
		this.accountNumber = accountNumber;
		this.firstName = firstName;
		this.lastName = lastName;
		this.homeAirportCode = homeAirportCode;
	}

	public FrequentFlyerMember(String accountNumber,
			String firstName,
			String lastName,
			String homeAirportCode) {
		this.accountNumber = accountNumber;
		this.firstName = firstName;
		this.lastName = lastName;
		this.homeAirportCode = homeAirportCode;
	}

	public String getId() {
		return id;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public java.lang.String getLastName() {
		return lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getHomeAirportCode() {
		return homeAirportCode;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public void setHomeAirportCode(String homeAirportCode) {
		this.homeAirportCode = homeAirportCode;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((accountNumber == null) ? 0 : accountNumber.hashCode());
		result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
		result = prime * result + ((homeAirportCode == null) ? 0 : homeAirportCode.hashCode());
		result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
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
		FrequentFlyerMember other = (FrequentFlyerMember) obj;
		if (accountNumber == null) {
			if (other.accountNumber != null)
				return false;
		} else if (!accountNumber.equals(other.accountNumber))
			return false;
		if (firstName == null) {
			if (other.firstName != null)
				return false;
		} else if (!firstName.equals(other.firstName))
			return false;
		if (homeAirportCode == null) {
			if (other.homeAirportCode != null)
				return false;
		} else if (!homeAirportCode.equals(other.homeAirportCode))
			return false;
		if (lastName == null) {
			if (other.lastName != null)
				return false;
		} else if (!lastName.equals(other.lastName))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "FrequentFlyerMember [accountNumber=" + accountNumber + ", firstName=" + firstName + ", lastName="
				+ lastName + ", homeAirportCode=" + homeAirportCode + "]";
	}
}
