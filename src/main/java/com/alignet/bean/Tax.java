package com.alignet.bean;

import org.apache.commons.lang.builder.ToStringBuilder;


public class Tax {
	private String name;

	private String amount;
	final VPOS20Bean vpos20Bean;

	public Tax(VPOS20Bean vpos20Bean) {
		this.vpos20Bean = vpos20Bean;
	}

	public final String getAmount() {
		return this.amount;
	}

	public final void setAmount(String paramString) {
		this.amount = paramString;
	}

	public final String getName() {
		return this.name;
	}

	public final void setName(String paramString) {
		this.name = paramString;
	}

	public final boolean equals(Object paramObject) {
		if (this == paramObject) {
			return true;
		}
		if (this != null && paramObject != null && paramObject instanceof Tax) {
			Tax localTax = (Tax) paramObject;
			if (this == localTax) {
				return true;
			}
			return (localTax.getName().equals(getName()) && localTax.getAmount().equals(getAmount()));
		}
		return false;
	}

	public final String toString() {
		ToStringBuilder localToStringBuilder = new ToStringBuilder(this);
		localToStringBuilder.append("name", this.name).append("amount", this.amount);
		return localToStringBuilder.getStringBuffer().toString();
	}
}