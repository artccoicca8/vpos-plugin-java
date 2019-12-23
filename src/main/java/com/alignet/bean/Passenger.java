package com.alignet.bean;

import org.apache.commons.lang.builder.ToStringBuilder;

public class Passenger {
	private String passengerFirstName;

	private String passengerLastName;
	private String passengerDocumentType;
	private String passengerDocumentNumber;
	private String passengerAgencyCode;

	public String getPassengerFirstName() {
		return this.passengerFirstName;
	}

	public void setPassengerFirstName(String passengerFirstName) {
		this.passengerFirstName = passengerFirstName;
	}

	public String getPassengerLastName() {
		return this.passengerLastName;
	}

	public void setPassengerLastName(String passengerLastName) {
		this.passengerLastName = passengerLastName;
	}

	public String getPassengerDocumentType() {
		return this.passengerDocumentType;
	}

	public void setPassengerDocumentType(String passengerDocumentType) {
		this.passengerDocumentType = passengerDocumentType;
	}

	public String getPassengerDocumentNumber() {
		return this.passengerDocumentNumber;
	}

	public void setPassengerDocumentNumber(String passengerDocumentNumber) {
		this.passengerDocumentNumber = passengerDocumentNumber;
	}

	public String getPassengerAgencyCode() {
		return this.passengerAgencyCode;
	}

	public void setPassengerAgencyCode(String passengerAgencyCode) {
		this.passengerAgencyCode = passengerAgencyCode;
	}

	public String toString() {
		ToStringBuilder builder = new ToStringBuilder(this);
		builder.append("passengerFirstName", this.passengerFirstName)
				.append("passengerLastName", this.passengerLastName)
				.append("passengerDocumentType", this.passengerDocumentType)
				.append("passengerDocumentNumber", this.passengerDocumentNumber)
				.append("passengerAgencyCode", this.passengerAgencyCode);
		return builder.getStringBuffer().toString();
	}

}
