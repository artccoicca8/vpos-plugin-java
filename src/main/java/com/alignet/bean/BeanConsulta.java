package com.alignet.bean;

import java.io.Serializable;

public class BeanConsulta implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String acquirerId;
	private String commerceId;
	private String numOrder;
	private String cipheredSessionKey = null;
	private String cipheredXML = null;
	private String cipheredSignature = null;
	private String clearXML;
	private boolean validSign = false;
	private String authorizationCode;
	private String errorCode;
	private String errorMessage;
	private String authorizationResult;
	private String cardNumber;
	private String cardType;
	private String planCode;
	private String planName;
	private String quotaCode;
	private String quotaName;
	private String xmlResponse;

	public String getAcquirerId() {
		return acquirerId;
	}

	public void setAcquirerId(String acquirerId) {
		this.acquirerId = acquirerId;
	}

	public String getCommerceId() {
		return commerceId;
	}

	public void setCommerceId(String commerceId) {
		this.commerceId = commerceId;
	}

	public String getNumOrder() {
		return numOrder;
	}

	public void setNumOrder(String numOrder) {
		this.numOrder = numOrder;
	}

	public String getCipheredSessionKey() {
		return cipheredSessionKey;
	}

	public void setCipheredSessionKey(String cipheredSessionKey) {
		this.cipheredSessionKey = cipheredSessionKey;
	}

	public String getCipheredXML() {
		return cipheredXML;
	}

	public void setCipheredXML(String cipheredXML) {
		this.cipheredXML = cipheredXML;
	}

	public String getCipheredSignature() {
		return cipheredSignature;
	}

	public void setCipheredSignature(String cipheredSignature) {
		this.cipheredSignature = cipheredSignature;
	}

	public String getClearXML() {
		return clearXML;
	}

	public void setClearXML(String clearXML) {
		this.clearXML = clearXML;
	}

	public boolean isValidSign() {
		return validSign;
	}

	public void setValidSign(boolean validSign) {
		this.validSign = validSign;
	}

	public String getAuthorizationCode() {
		return authorizationCode;
	}

	public void setAuthorizationCode(String authorizationCode) {
		this.authorizationCode = authorizationCode;
	}

	public String getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public String getAuthorizationResult() {
		return authorizationResult;
	}

	public void setAuthorizationResult(String authorizationResult) {
		this.authorizationResult = authorizationResult;
	}

	public String getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}

	public String getCardType() {
		return cardType;
	}

	public void setCardType(String cardType) {
		this.cardType = cardType;
	}

	public String getPlanCode() {
		return planCode;
	}

	public void setPlanCode(String planCode) {
		this.planCode = planCode;
	}

	public String getPlanName() {
		return planName;
	}

	public void setPlanName(String planName) {
		this.planName = planName;
	}

	public String getQuotaCode() {
		return quotaCode;
	}

	public void setQuotaCode(String quotaCode) {
		this.quotaCode = quotaCode;
	}

	public String getQuotaName() {
		return quotaName;
	}

	public void setQuotaName(String quotaName) {
		this.quotaName = quotaName;
	}

	public String getXmlResponse() {
		return xmlResponse;
	}

	public void setXmlResponse(String xmlResponse) {
		this.xmlResponse = xmlResponse;
	}

	@Override
	public String toString() {
		return "BeanConsulta [acquirerId=" + acquirerId + ", commerceId=" + commerceId + ", numOrder=" + numOrder
				+ ", cipheredSessionKey=" + cipheredSessionKey + ", cipheredXML=" + cipheredXML + ", cipheredSignature="
				+ cipheredSignature + ", clearXML=" + clearXML + ", validSign=" + validSign + ", authorizationCode="
				+ authorizationCode + ", errorCode=" + errorCode + ", errorMessage=" + errorMessage
				+ ", authorizationResult=" + authorizationResult + ", cardNumber=" + cardNumber + ", cardType="
				+ cardType + ", planCode=" + planCode + ", planName=" + planName + ", quotaCode=" + quotaCode
				+ ", quotaName=" + quotaName + ", xmlResponse=" + xmlResponse + "]";
	}

}
