package com.alignet.bean;

import java.io.Serializable;
import java.util.List;
import java.util.Vector;

import com.alignet.plugin.exception.InvalidVPOSParameterException;
import com.alignet.plugin.exception.PlugInVPOSException;

public class VPOS20Bean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String acquirerId;
	private String commerceId;
	private String purchaseOperationNumber;
	private String purchaseAmount;
	private String purchaseCurrencyCode;
	private String purchaseTerminalCode;
	private String purchasePlanId;
	private String purchaseQuotaId;
	private String purchaseShippingCharges;
	private String purchaseShipperCode;
	private String purchaseIva;
	private String purchaseIvaReturn;
	private String purchaseLanguage;
	private String purchaseIpAddress;
	private String billingFirstName;
	private String billingLastName;
	private String billingCountry;
	private String billingCity;
	private String billingState;
	private String billingPostalCode;
	private String billingPhoneNumber;
	private String billingCelPhoneNumber;
	private String billingGender;
	private String billingEmail;
	private String billingAddress;
	private String billingBirthday;
	private String billingOutIdentifierCity;
	private String billingDateIdentifierDate;
	private String billingNationality;
	private String shippingReceptionMethod;
	private String shippingReceiverName;
	private String shippingReceiverLastName;
	private String shippingReceiverIdentifier;
	private String shippingCountry;
	private String shippingCity;
	private String shippingState;
	private String shippingPostalCode;
	private String shippingAddress;
	private List taxes;
	private List products;
	private List flight;
	private List passenger;
	private List good;
	private List airport;
	private List administrativeRate;
	private String transactionTrace;
	private String fingerPrint;
	private String additionalObservations;
	private String reserved1;
	private String reserved2;
	private String reserved3;
	private String reserved4;
	private String reserved5;
	private String reserved6;
	private String reserved7;
	private String reserved8;
	private String reserved9;
	private String reserved10;
	private String reserved11;
	private String reserved12;
	private String reserved13;
	private String reserved14;
	private String reserved15;
	private String reserved16;
	private String reserved17;
	private String reserved18;
	private String reserved19;
	private String reserved20;
	private String reserved21;
	private String reserved22;
	private String reserved23;
	private String reserved24;
	private String reserved25;
	private String reserved26;
	private String reserved27;
	private String reserved28;
	private String reserved29;
	private String reserved30;
	private String reserved31;
	private String reserved32;
	private String reserved33;
	private String reserved34;
	private String reserved35;
	private String reserved36;
	private String reserved37;
	private String reserved38;
	private String reserved39;
	private String reserved40;
	private String authorizationCode;
	private String errorCode;
	private String errorMessage;
	private String authorizationResult;
	private String authorizationCodeAR;
	private String errorCodeAR;
	private String errorMessageAR;
	private String authorizationResultAR;
	private String authenticationECI;
	private String authenticationVCI;
	private String HTTPSessionId;
	private String cipheredSessionKey = null;
	private String cipheredXML = null;
	private String cipheredSignature = null;
	private String clearXML;
	private boolean validSign = false;
	private String xmlSend;
	private String xmlResponse;

	public String getShippingState() {
		return this.shippingState;
	}

	public void setShippingState(String shippingState) {
		this.shippingState = shippingState;
	}

	public String getShippingPostalCode() {
		return this.shippingPostalCode;
	}

	public void setShippingPostalCode(String shippingPostalCode) {
		this.shippingPostalCode = shippingPostalCode;
	}

	public String getPurchaseLanguage() {
		return this.purchaseLanguage;
	}

	public void setPurchaseLanguage(String purchaseLanguage) {
		this.purchaseLanguage = purchaseLanguage;
	}

	public String getPurchaseIpAddress() {
		return this.purchaseIpAddress;
	}

	public void setPurchaseIpAddress(String purchaseIpAddress) {
		this.purchaseIpAddress = purchaseIpAddress;
	}

	public List getFlight() {
		return this.flight;
	}

	public void setFlight(List flight) {
		this.flight = flight;
	}

	public List getPassenger() {
		return this.passenger;
	}

	public void setPassenger(List passenger) {
		this.passenger = passenger;
	}

	public List getGood() {
		return this.good;
	}

	public void setGood(List good) {
		this.good = good;
	}

	public List getAirport() {
		return this.airport;
	}

	public void setAirport(List airport) {
		this.airport = airport;
	}

	public List getAdministrativeRate() {
		return this.administrativeRate;
	}

	public void setAdministrativeRate(List administrativeRate) {
		this.administrativeRate = administrativeRate;
	}

	public final String getAcquirerId() {
		return this.acquirerId;
	}

	public final void setAcquirerId(String paramString) throws InvalidVPOSParameterException {
		try {
			if (paramString == null || paramString.equals(""))
				throw new InvalidVPOSParameterException("Valor requerido: Cde Adquirente");
			long l = Long.parseLong(paramString);
			if (l < 0L)
				throw new InvalidVPOSParameterException("Valor negativo invCde Adquirente");
		} catch (NumberFormatException localNumberFormatException) {
			throw new InvalidVPOSParameterException("Fomato invde Cde Adquirente");
		}
		this.acquirerId = paramString;
	}

	public final String getCommerceId() {
		return this.commerceId;
	}

	public String getTransactionTrace() {
		return this.transactionTrace;
	}

	public void setTransactionTrace(String transactionTrace) {
		this.transactionTrace = transactionTrace;
	}

	public final void setCommerceId(String paramString) throws InvalidVPOSParameterException {
		try {
			if (paramString == null || paramString.equals(""))
				throw new InvalidVPOSParameterException("Valor requerido: Cde Comercio");
			long l = Long.parseLong(paramString);
			if (l < 0L)
				throw new InvalidVPOSParameterException("Valor negativo invCde Comercio");
		} catch (NumberFormatException localNumberFormatException) {
			throw new InvalidVPOSParameterException("Fomato invde Cde Comercio");
		}
		this.commerceId = paramString;
	}

	public String getPurchasePlanId() {
		return this.purchasePlanId;
	}

	public void setPurchasePlanId(String purchasePlanId) {
		try {
			if (purchasePlanId == null || purchasePlanId.equals(""))
				throw new InvalidVPOSParameterException("Valor requerido: Plan de cobranza");
		} catch (NumberFormatException localNumberFormatException) {
			throw new InvalidVPOSParameterException("Fomato invde Plan de cobranza");
		}
		this.purchasePlanId = purchasePlanId;
	}

	public String getPurchaseQuotaId() {
		return this.purchaseQuotaId;
	}

	public void setPurchaseQuotaId(String purchaseQuotaId) {
		try {
			if (purchaseQuotaId == null || purchaseQuotaId.equals(""))
				throw new InvalidVPOSParameterException("Valor requerido: Identificador de cuotas");
		} catch (NumberFormatException localNumberFormatException) {
			throw new InvalidVPOSParameterException("Fomato invde Identificador de cuotas");
		}
		this.purchaseQuotaId = purchaseQuotaId;
	}

	public final String getPurchaseCurrencyCode() {
		return this.purchaseCurrencyCode;
	}

	public final void setPurchaseCurrencyCode(String paramString) throws InvalidVPOSParameterException {
		try {
			if (paramString == null || paramString.equals(""))
				throw new InvalidVPOSParameterException("Valor requerido: Cde Moneda");
			long l = Long.parseLong(paramString);
			if (l < 0L)
				throw new InvalidVPOSParameterException("Valor negativo invCde Moneda");
		} catch (NumberFormatException localNumberFormatException) {
			throw new InvalidVPOSParameterException("Fomato invde Cde Moneda");
		}
		this.purchaseCurrencyCode = paramString;
	}

	public final String getPurchaseOperationNumber() {
		return this.purchaseOperationNumber;
	}

	public final void setPurchaseOperationNumber(String paramString) throws InvalidVPOSParameterException {
		if (paramString == null || paramString.trim().equals(""))
			throw new InvalidVPOSParameterException("Valor requerido: purchaseOperationNumber");
		this.purchaseOperationNumber = paramString;
	}

	public String getPurchaseTerminalCode() {
		return this.purchaseTerminalCode;
	}

	public void setPurchaseTerminalCode(String purchaseTerminalCode) throws InvalidVPOSParameterException {
		if (purchaseTerminalCode == null || purchaseTerminalCode.equals("")) {
			throw new InvalidVPOSParameterException("Valor requerido: Cde Terminal");
		}
		this.purchaseTerminalCode = purchaseTerminalCode;
	}

	public final String getPurchaseAmount() {
		return this.purchaseAmount;
	}

	public final void setPurchaseAmount(String paramString) throws InvalidVPOSParameterException {
		Long localLong = null;
		try {
			localLong = new Long(paramString);
		} catch (NumberFormatException localNumberFormatException) {
			throw new InvalidVPOSParameterException("Error al leer monto", localNumberFormatException);
		}
		if (localLong.longValue() == -1L)
			throw new InvalidVPOSParameterException("Valor requerido: Monto");
		if (localLong.longValue() < 0L)
			throw new InvalidVPOSParameterException("Valor negativo invMonto");
		this.purchaseAmount = paramString;
	}

	public final String getBillingFirstName() {
		return this.billingFirstName;
	}

	public final void setBillingFirstName(String paramString) {
		this.billingFirstName = paramString;
	}

	public final String getReserved1() {
		return this.reserved1;
	}

	public final void setReserved1(String paramString) {
		this.reserved1 = paramString;
	}

	public final String getReserved10() {
		return this.reserved10;
	}

	public final void setReserved10(String paramString) {
		this.reserved10 = paramString;
	}

	public final String getReserved11() {
		return this.reserved11;
	}

	public final void setReserved11(String paramString) {
		this.reserved11 = paramString;
	}

	public final String getReserved12() {
		return this.reserved12;
	}

	public final void setReserved12(String paramString) {
		this.reserved12 = paramString;
	}

	public final String getReserved13() {
		return this.reserved13;
	}

	public final void setReserved13(String paramString) {
		this.reserved13 = paramString;
	}

	public final String getReserved14() {
		return this.reserved14;
	}

	public final void setReserved14(String paramString) {
		this.reserved14 = paramString;
	}

	public final String getReserved15() {
		return this.reserved15;
	}

	public final void setReserved15(String paramString) {
		this.reserved15 = paramString;
	}

	public final String getReserved2() {
		return this.reserved2;
	}

	public final void setReserved2(String paramString) {
		this.reserved2 = paramString;
	}

	public final String getReserved3() {
		return this.reserved3;
	}

	public final void setReserved3(String paramString) {
		this.reserved3 = paramString;
	}

	public final String getReserved4() {
		return this.reserved4;
	}

	public final void setReserved4(String paramString) {
		this.reserved4 = paramString;
	}

	public final String getReserved5() {
		return this.reserved5;
	}

	public final void setReserved5(String paramString) {
		this.reserved5 = paramString;
	}

	public final String getReserved6() {
		return this.reserved6;
	}

	public final void setReserved6(String paramString) {
		this.reserved6 = paramString;
	}

	public final String getReserved7() {
		return this.reserved7;
	}

	public final void setReserved7(String paramString) {
		this.reserved7 = paramString;
	}

	public final String getReserved8() {
		return this.reserved8;
	}

	public final void setReserved8(String paramString) {
		this.reserved8 = paramString;
	}

	public final String getReserved9() {
		return this.reserved9;
	}

	public final void setReserved9(String paramString) {
		this.reserved9 = paramString;
	}

	public final String getBillingLastName() {
		return this.billingLastName;
	}

	public final void setBillingLastName(String paramString) {
		this.billingLastName = paramString;
	}

	public final String getCipheredSessionKey() {
		return this.cipheredSessionKey;
	}

	public final void setCipheredSessionKey(String paramString) {
		this.cipheredSessionKey = paramString;
	}

	public final String getCipheredSignature() {
		return this.cipheredSignature;
	}

	public final void setCipheredSignature(String paramString) {
		this.cipheredSignature = paramString;
	}

	public final String getCipheredXML() {
		return this.cipheredXML;
	}

	public final void setCipheredXML(String paramString) {
		this.cipheredXML = paramString;
	}

	public final String getAuthorizationCode() {
		return this.authorizationCode;
	}

	public final void setAuthorizationCode(String paramString) {
		this.authorizationCode = paramString;
	}

	public final String getErrorCode() {
		return this.errorCode;
	}

	public final void setErrorCode(String paramString) {
		this.errorCode = paramString;
	}

	public final String getAuthorizationResult() {
		return this.authorizationResult;
	}

	public final void setAuthorizationResult(String paramString) {
		this.authorizationResult = paramString;
	}

	public final String getErrorMessage() {
		return this.errorMessage;
	}

	public final void setErrorMessage(String paramString) {
		this.errorMessage = paramString;
	}

	public String getAuthorizationCodeAR() {
		return this.authorizationCodeAR;
	}

	public void setAuthorizationCodeAR(String authorizationCodeAR) {
		this.authorizationCodeAR = authorizationCodeAR;
	}

	public String getErrorCodeAR() {
		return this.errorCodeAR;
	}

	public void setErrorCodeAR(String errorCodeAR) {
		this.errorCodeAR = errorCodeAR;
	}

	public String getErrorMessageAR() {
		return this.errorMessageAR;
	}

	public void setErrorMessageAR(String errorMessageAR) {
		this.errorMessageAR = errorMessageAR;
	}

	public String getAuthorizationResultAR() {
		return this.authorizationResultAR;
	}

	public void setAuthorizationResultAR(String authorizationResultAR) {
		this.authorizationResultAR = authorizationResultAR;
	}

	public final String getClearXML() {
		return this.clearXML;
	}

	public final void setClearXML(String paramString) {
		this.clearXML = paramString;
	}

	public final boolean isValidSign() {
		return this.validSign;
	}

	public final void setValidSign(boolean paramBoolean) {
		this.validSign = paramBoolean;
	}

	public final String getAdditionalObservations() {
		return this.additionalObservations;
	}

	public final void setAdditionalObservations(String paramString) {
		this.additionalObservations = paramString;
	}

	public final String getAuthenticationECI() {
		return this.authenticationECI;
	}

	public final void setAuthenticationECI(String paramString) {
		this.authenticationECI = paramString;
	}

	public final String getAuthenticationVCI() {
		return this.authenticationVCI;
	}

	public final void setAuthenticationVCI(String paramString) {
		this.authenticationVCI = paramString;
	}

	public final String getBillingAddress() {
		return this.billingAddress;
	}

	public final void setBillingAddress(String paramString) {
		this.billingAddress = paramString;
	}

	public String getBillingState() {
		return this.billingState;
	}

	public void setBillingState(String billingState) {
		this.billingState = billingState;
	}

	public String getBillingPostalCode() {
		return this.billingPostalCode;
	}

	public void setBillingPostalCode(String billingPostalCode) {
		this.billingPostalCode = billingPostalCode;
	}

	public final String getBillingCity() {
		return this.billingCity;
	}

	public final void setBillingCity(String paramString) {
		this.billingCity = paramString;
	}

	public final String getBillingCountry() {
		return this.billingCountry;
	}

	public final void setBillingCountry(String paramString) {
		this.billingCountry = paramString;
	}

	public String getBillingEmail() {
		return this.billingEmail;
	}

	public void setBillingEmail(String billingEmail) {
		this.billingEmail = billingEmail;
	}

	public String getBillingPhoneNumber() {
		return this.billingPhoneNumber;
	}

	public void setBillingPhoneNumber(String billingPhoneNumber) {
		this.billingPhoneNumber = billingPhoneNumber;
	}

	public final String getHTTPSessionId() {
		return this.HTTPSessionId;
	}

	public final void setHTTPSessionId(String paramString) {
		this.HTTPSessionId = paramString;
	}

	public final String getReserved16() {
		return this.reserved16;
	}

	public final void setReserved16(String paramString) {
		this.reserved16 = paramString;
	}

	public final String getReserved17() {
		return this.reserved17;
	}

	public final void setReserved17(String paramString) {
		this.reserved17 = paramString;
	}

	public final String getReserved18() {
		return this.reserved18;
	}

	public final void setReserved18(String paramString) {
		this.reserved18 = paramString;
	}

	public final String getReserved19() {
		return this.reserved19;
	}

	public final void setReserved19(String paramString) {
		this.reserved19 = paramString;
	}

	public final String getReserved20() {
		return this.reserved20;
	}

	public final void setReserved20(String paramString) {
		this.reserved20 = paramString;
	}

	public final String getReserved21() {
		return this.reserved21;
	}

	public final void setReserved21(String paramString) {
		this.reserved21 = paramString;
	}

	public final String getReserved22() {
		return this.reserved22;
	}

	public final void setReserved22(String paramString) {
		this.reserved22 = paramString;
	}

	public final String getReserved23() {
		return this.reserved23;
	}

	public final void setReserved23(String paramString) {
		this.reserved23 = paramString;
	}

	public final String getReserved24() {
		return this.reserved24;
	}

	public final void setReserved24(String paramString) {
		this.reserved24 = paramString;
	}

	public final String getReserved25() {
		return this.reserved25;
	}

	public final void setReserved25(String paramString) {
		this.reserved25 = paramString;
	}

	public final String getReserved26() {
		return this.reserved26;
	}

	public final void setReserved26(String paramString) {
		this.reserved26 = paramString;
	}

	public final String getReserved27() {
		return this.reserved27;
	}

	public final void setReserved27(String paramString) {
		this.reserved27 = paramString;
	}

	public final String getReserved28() {
		return this.reserved28;
	}

	public final void setReserved28(String paramString) {
		this.reserved28 = paramString;
	}

	public final String getReserved29() {
		return this.reserved29;
	}

	public final void setReserved29(String paramString) {
		this.reserved29 = paramString;
	}

	public final String getReserved30() {
		return this.reserved30;
	}

	public final void setReserved30(String paramString) {
		this.reserved30 = paramString;
	}

	public final String getReserved31() {
		return this.reserved31;
	}

	public final void setReserved31(String paramString) {
		this.reserved31 = paramString;
	}

	public final String getReserved32() {
		return this.reserved32;
	}

	public final void setReserved32(String paramString) {
		this.reserved32 = paramString;
	}

	public final String getReserved33() {
		return this.reserved33;
	}

	public final void setReserved33(String paramString) {
		this.reserved33 = paramString;
	}

	public final String getReserved34() {
		return this.reserved34;
	}

	public final void setReserved34(String paramString) {
		this.reserved34 = paramString;
	}

	public final String getReserved35() {
		return this.reserved35;
	}

	public final void setReserved35(String paramString) {
		this.reserved35 = paramString;
	}

	public final String getReserved36() {
		return this.reserved36;
	}

	public final void setReserved36(String paramString) {
		this.reserved36 = paramString;
	}

	public final String getReserved37() {
		return this.reserved37;
	}

	public final void setReserved37(String paramString) {
		this.reserved37 = paramString;
	}

	public final String getReserved38() {
		return this.reserved38;
	}

	public final void setReserved38(String paramString) {
		this.reserved38 = paramString;
	}

	public final String getReserved39() {
		return this.reserved39;
	}

	public final void setReserved39(String paramString) {
		this.reserved39 = paramString;
	}

	public final String getReserved40() {
		return this.reserved40;
	}

	public final void setReserved40(String paramString) {
		this.reserved40 = paramString;
	}

	public final List getTaxes() {
		return this.taxes;
	}

	public final void setTaxes(List paramList) {
		this.taxes = paramList;
	}

	public final List getProducts() {
		return this.products;
	}

	public final void setProducts(List paramList) {
		this.products = paramList;
	}

	public final void addProduct(String productItem, String productCode, String productAmount,
			String productPromotionCode) {
		if (this.products == null) {
			this.products = new Vector();
		}
		Product localProduct = new Product();
		localProduct.setProductCode(productCode);
		localProduct.setProductItem(productItem);
		localProduct.setProductAmount(productAmount);
		localProduct.setProductPromotionCode(productPromotionCode);
		this.products.add(localProduct);
	}

	public void addAirport(String airportCode, String airportCity, String airportCountry) {
		if (this.airport == null) {
			this.airport = new Vector();
		}
		Airport airp = new Airport();
		airp.setAirportCode(airportCode);
		airp.setAirportCity(airportCity);
		airp.setAirportCountry(airportCountry);
		this.airport.add(airp);
	}

	public void addAdministrativeRate(String administrativeRateAmount, String administrativeRateIva,
			String administrativeRateIvaReturn, String administrativeRateCode) {
		if (this.administrativeRate == null) {
			this.administrativeRate = new Vector();
		}
		AdministrativeRate admRate = new AdministrativeRate();
		admRate.setAdministrativeRateAmount(administrativeRateAmount);
		admRate.setAdministrativeRateIva(administrativeRateIva);
		admRate.setAdministrativeRateIvaReturn(administrativeRateIvaReturn);
		admRate.setAdministrativeRateCode(administrativeRateCode);
		this.administrativeRate.add(admRate);
	}

	public void addFlight(String flightAirlineCode, String flightDepartureAirport, String flightArriveAirport,
			String flightDepartureDate, String flightDepartureTime, String flightArriveDate, String flightArriveTime,
			String flightReservation, String flightDepartureIata, String flightArriveIata) {
		if (this.flight == null) {
			this.flight = new Vector();
		}
		Flight flig = new Flight();
		flig.setFlightAirlineCode(flightAirlineCode);
		flig.setFlightDepartureAirport(flightDepartureAirport);
		flig.setFlightArriveAirport(flightArriveAirport);
		flig.setFlightDepartureDate(flightDepartureDate);
		flig.setFlightDepartureTime(flightDepartureTime);
		flig.setFlightArriveDate(flightArriveDate);
		flig.setFlightArriveTime(flightArriveTime);
		flig.setFlightReservation(flightReservation);
		flig.setFlightDepartureIata(flightDepartureIata);
		flig.setFlightArriveIata(flightArriveIata);
		this.flight.add(flig);
	}

	public void addGood(String goodName, String goodDescription, String goodQuantity, String goodUnitprice) {
		if (this.good == null) {
			this.good = new Vector();
		}
		Good goo = new Good();
		goo.setGoodName(goodName);
		goo.setGoodDescription(goodDescription);
		goo.setGoodQuantity(goodQuantity);
		goo.setGoodUnitprice(goodUnitprice);
		this.good.add(goo);
	}

	public void addPassenger(String passengerFirstName, String passengerLastName, String passengerDocumentType,
			String passengerDocumentNumber, String passengerAgencyCode) {
		if (this.passenger == null) {
			this.passenger = new Vector();
		}
		Passenger pass = new Passenger();
		pass.setPassengerFirstName(passengerFirstName);
		pass.setPassengerLastName(passengerLastName);
		pass.setPassengerDocumentType(passengerDocumentType);
		pass.setPassengerDocumentNumber(passengerDocumentNumber);
		pass.setPassengerAgencyCode(passengerAgencyCode);
		this.passenger.add(pass);
	}

	public final void addTax(String name, String amount) {
		if (this.taxes == null) {
			this.taxes = new Vector();
		}
		Tax localTax = new Tax(this);
		localTax.setName(name);
		localTax.setAmount(amount);
		this.taxes.add(localTax);
	}

	public final Product getProduct(int paramInt) {
		if (this.products == null) {
			return null;
		}
		Product localProduct = null;
		try {
			localProduct = (Product) this.products.get(paramInt);
			return localProduct;
		} catch (IndexOutOfBoundsException localIndexOutOfBoundsException) {
			throw new PlugInVPOSException("No existe ese producto", localIndexOutOfBoundsException);
		}
	}

	public final Tax getTax(int paramInt) {
		if (this.taxes == null) {
			return null;
		}
		Tax localTax = null;
		try {
			localTax = (Tax) this.products.get(paramInt);
			return localTax;
		} catch (IndexOutOfBoundsException localIndexOutOfBoundsException) {
			throw new PlugInVPOSException("No existe ese impuesto", localIndexOutOfBoundsException);
		}
	}

	public Airport getAirport(int i) {
		if (this.airport == null) {
			return null;
		}
		Airport resp = null;
		try {
			resp = (Airport) this.airport.get(i);
			return resp;
		} catch (IndexOutOfBoundsException e) {
			throw new PlugInVPOSException("No existe ese aeropuerto", e);
		}
	}

	public AdministrativeRate getAdministrativeRate(int i) {
		if (this.administrativeRate == null) {
			return null;
		}
		AdministrativeRate resp = null;
		try {
			resp = (AdministrativeRate) this.administrativeRate.get(i);
			return resp;
		} catch (IndexOutOfBoundsException e) {
			throw new PlugInVPOSException("No existe esa tasa administrativa", e);
		}
	}

	public Passenger getPassenger(int i) {
		if (this.passenger == null) {
			return null;
		}
		Passenger resp = null;
		try {
			resp = (Passenger) this.passenger.get(i);
			return resp;
		} catch (IndexOutOfBoundsException e) {
			throw new PlugInVPOSException("No existe ese pasajero", e);
		}
	}

	public Flight getFlight(int i) {
		if (this.flight == null) {
			return null;
		}
		Flight resp = null;
		try {
			resp = (Flight) this.flight.get(i);
			return resp;
		} catch (IndexOutOfBoundsException e) {
			throw new PlugInVPOSException("No existe ese vuelo", e);
		}
	}

	public Good getGood(int i) {
		if (this.good == null) {
			return null;
		}
		Good resp = null;
		try {
			resp = (Good) this.good.get(i);
			return resp;
		} catch (IndexOutOfBoundsException e) {
			throw new PlugInVPOSException("No existe ese bien", e);
		}
	}

	public final int countProducts() {
		if (this.products == null) {
			return 0;
		}
		return this.products.size();
	}

	public final int countTaxes() {
		if (this.taxes == null) {
			return 0;
		}
		return this.taxes.size();
	}

	public String getPurchaseShippingCharges() {
		return this.purchaseShippingCharges;
	}

	public void setPurchaseShippingCharges(String purchaseShippingCharges) {
		this.purchaseShippingCharges = purchaseShippingCharges;
	}

	public String getPurchaseShipperCode() {
		return this.purchaseShipperCode;
	}

	public void setPurchaseShipperCode(String purchaseShipperCode) {
		this.purchaseShipperCode = purchaseShipperCode;
	}

	public String getPurchaseIva() {
		return this.purchaseIva;
	}

	public void setPurchaseIva(String purchaseIva) {
		this.purchaseIva = purchaseIva;
	}

	public String getPurchaseIvaReturn() {
		return this.purchaseIvaReturn;
	}

	public void setPurchaseIvaReturn(String purchaseIvaReturn) {
		this.purchaseIvaReturn = purchaseIvaReturn;
	}

	public String getBillingCelPhoneNumber() {
		return this.billingCelPhoneNumber;
	}

	public void setBillingCelPhoneNumber(String billingCelPhoneNumber) {
		try {
			if (billingCelPhoneNumber == null || billingCelPhoneNumber.equals("")) {
				throw new InvalidVPOSParameterException("Valor requerido: Celular del titular");
			}
		} catch (NumberFormatException localNumberFormatException) {
			throw new InvalidVPOSParameterException("Fomato invde Celular del titular");
		}
		this.billingCelPhoneNumber = billingCelPhoneNumber;
	}

	public String getBillingGender() {
		return this.billingGender;
	}

	public void setBillingGender(String billingGender) {
		this.billingGender = billingGender;
	}

	public String getBillingBirthday() {
		return this.billingBirthday;
	}

	public void setBillingBirthday(String billingBirthday) {
		this.billingBirthday = billingBirthday;
	}

	public String getBillingOutIdentifierCity() {
		return this.billingOutIdentifierCity;
	}

	public void setBillingOutIdentifierCity(String billingOutIdentifierCity) {
		this.billingOutIdentifierCity = billingOutIdentifierCity;
	}

	public String getBillingDateIdentifierDate() {
		return this.billingDateIdentifierDate;
	}

	public void setBillingDateIdentifierDate(String billingDateIdentifierDate) {
		this.billingDateIdentifierDate = billingDateIdentifierDate;
	}

	public String getBillingNationality() {
		return this.billingNationality;
	}

	public void setBillingNationality(String billingNationality) {
		this.billingNationality = billingNationality;
	}

	public String getXmlSend() {
		return this.xmlSend;
	}

	public void setXmlSend(String xmlSend) {
		this.xmlSend = xmlSend;
	}

	public String getXmlResponse() {
		return this.xmlResponse;
	}

	public void setXmlResponse(String xmlResponse) {
		this.xmlResponse = xmlResponse;
	}

	public String getShippingReceptionMethod() {
		return this.shippingReceptionMethod;
	}

	public String getFingerPrint() {
		return this.fingerPrint;
	}

	public void setFingerPrint(String fingerPrint) {
		this.fingerPrint = fingerPrint;
	}

	public void setShippingReceptionMethod(String shippingReceptionMethod) {
		this.shippingReceptionMethod = shippingReceptionMethod;
	}

	public String getShippingReceiverName() {
		return this.shippingReceiverName;
	}

	public void setShippingReceiverName(String shippingReceiverName) {
		this.shippingReceiverName = shippingReceiverName;
	}

	public String getShippingReceiverLastName() {
		return this.shippingReceiverLastName;
	}

	public void setShippingReceiverLastName(String shippingReceiverLastName) {
		this.shippingReceiverLastName = shippingReceiverLastName;
	}

	public String getShippingReceiverIdentifier() {
		return this.shippingReceiverIdentifier;
	}

	public void setShippingReceiverIdentifier(String shippingReceiverIdentifier) {
		this.shippingReceiverIdentifier = shippingReceiverIdentifier;
	}

	public String getShippingCountry() {
		return this.shippingCountry;
	}

	public void setShippingCountry(String shippingCountry) {
		this.shippingCountry = shippingCountry;
	}

	public String getShippingCity() {
		return this.shippingCity;
	}

	public void setShippingCity(String shippingCity) {
		this.shippingCity = shippingCity;
	}

	public String getShippingAddress() {
		return this.shippingAddress;
	}

	public void setShippingAddress(String shippingAddress) {
		this.shippingAddress = shippingAddress;
	}

}
