package com.alignet.bean;

import org.apache.commons.lang.builder.ToStringBuilder;

public class Good {
	private String goodName;
	private String goodDescription;
	private String goodQuantity;
	private String goodUnitprice;

	public String getGoodName() {
		return this.goodName;
	}

	public void setGoodName(String goodName) {
		this.goodName = goodName;
	}

	public String getGoodDescription() {
		return this.goodDescription;
	}

	public void setGoodDescription(String goodDescription) {
		this.goodDescription = goodDescription;
	}

	public String getGoodQuantity() {
		return this.goodQuantity;
	}

	public void setGoodQuantity(String goodQuantity) {
		this.goodQuantity = goodQuantity;
	}

	public String getGoodUnitprice() {
		return this.goodUnitprice;
	}

	public void setGoodUnitprice(String goodUnitprice) {
		this.goodUnitprice = goodUnitprice;
	}

	public String toString() {
		ToStringBuilder builder = new ToStringBuilder(this);
		builder.append("goodName", this.goodName).append("goodDescription", this.goodDescription)
				.append("goodQuantity", this.goodQuantity).append("goodUnitprice", this.goodUnitprice);
		return builder.getStringBuffer().toString();
	}
}