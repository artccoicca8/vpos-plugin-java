package com.alignet.bean;

import org.apache.commons.lang.builder.ToStringBuilder;

public class Airport {
	private String airportCode;
	private String airportCity;
	private String airportCountry;

	public String getAirportCode() {
		return this.airportCode;
	}

	public void setAirportCode(String airportCode) {
		this.airportCode = airportCode;
	}

	public String getAirportCity() {
		return this.airportCity;
	}

	public void setAirportCity(String airportCity) {
		this.airportCity = airportCity;
	}

	public String getAirportCountry() {
		return this.airportCountry;
	}

	public void setAirportCountry(String airportCountry) {
		this.airportCountry = airportCountry;
	}

	public String toString() {
		ToStringBuilder builder = new ToStringBuilder(this);
		builder.append("airportCode", this.airportCode).append("airportCity", this.airportCity).append("airportCountry",
				this.airportCountry);
		return builder.getStringBuffer().toString();
	}
}