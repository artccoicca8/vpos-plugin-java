package com.alignet.bean;

import org.apache.commons.lang.builder.ToStringBuilder;

public class Flight {
	private String flightAirlineCode;

	private String flightDepartureAirport;
	private String flightArriveAirport;
	private String flightDepartureDate;
	private String flightDepartureTime;
	private String flightArriveDate;
	private String flightArriveTime;
	private String flightReservation;
	private String flightDepartureIata;
	private String flightArriveIata;

	public String getFlightDepartureIata() {
		return this.flightDepartureIata;
	}

	public void setFlightDepartureIata(String flightDepartureIata) {
		this.flightDepartureIata = flightDepartureIata;
	}

	public String getFlightArriveIata() {
		return this.flightArriveIata;
	}

	public void setFlightArriveIata(String flightArriveIata) {
		this.flightArriveIata = flightArriveIata;
	}

	public String getFlightAirlineCode() {
		return this.flightAirlineCode;
	}

	public void setFlightAirlineCode(String flightAirlineCode) {
		this.flightAirlineCode = flightAirlineCode;
	}

	public String getFlightDepartureAirport() {
		return this.flightDepartureAirport;
	}

	public void setFlightDepartureAirport(String flightDepartureAirport) {
		this.flightDepartureAirport = flightDepartureAirport;
	}

	public String getFlightArriveAirport() {
		return this.flightArriveAirport;
	}

	public void setFlightArriveAirport(String flightArriveAirport) {
		this.flightArriveAirport = flightArriveAirport;
	}

	public String getFlightDepartureDate() {
		return this.flightDepartureDate;
	}

	public void setFlightDepartureDate(String flightDepartureDate) {
		this.flightDepartureDate = flightDepartureDate;
	}

	public String getFlightDepartureTime() {
		return this.flightDepartureTime;
	}

	public void setFlightDepartureTime(String flightDepartureTime) {
		this.flightDepartureTime = flightDepartureTime;
	}

	public String getFlightArriveDate() {
		return this.flightArriveDate;
	}

	public void setFlightArriveDate(String flightArriveDate) {
		this.flightArriveDate = flightArriveDate;
	}

	public String getFlightArriveTime() {
		return this.flightArriveTime;
	}

	public void setFlightArriveTime(String flightArriveTime) {
		this.flightArriveTime = flightArriveTime;
	}

	public String getFlightReservation() {
		return this.flightReservation;
	}

	public void setFlightReservation(String flightReservation) {
		this.flightReservation = flightReservation;
	}

	public String toString() {
		ToStringBuilder builder = new ToStringBuilder(this);
		builder.append("flightAirlineCode", this.flightAirlineCode)
				.append("flightDepartureAirport", this.flightDepartureAirport)
				.append("flightArriveAirport", this.flightArriveAirport)
				.append("flightDepartureDate", this.flightDepartureDate)
				.append("flightDepartureTime", this.flightDepartureTime)
				.append("flightArriveDate", this.flightArriveDate).append("flightArriveTime", this.flightArriveTime)
				.append("flightReservation", this.flightReservation)
				.append("flightDepartureIata", this.flightDepartureIata)
				.append("flightArriveIata", this.flightArriveIata);
		return builder.getStringBuffer().toString();
	}
}
