package com.alignet.bean;

import org.apache.commons.lang.builder.ToStringBuilder;

public class Product {
	private String productItem;

	private String productCode;

	private String productAmount;

	private String productPromotionCode;

	public String getProductItem() {
		return this.productItem;
	}

	public void setProductItem(String productItem) {
		this.productItem = productItem;
	}

	public String getProductCode() {
		return this.productCode;
	}

	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}

	public String getProductAmount() {
		return this.productAmount;
	}

	public void setProductAmount(String productAmount) {
		this.productAmount = productAmount;
	}

	public String getProductPromotionCode() {
		return this.productPromotionCode;
	}

	public void setProductPromotionCode(String productPromotionCode) {
		this.productPromotionCode = productPromotionCode;
	}

	public final String toString() {
		ToStringBuilder localToStringBuilder = new ToStringBuilder(this);
		localToStringBuilder.append("productItem", this.productItem).append("productCode", this.productCode)
				.append("productAmount", this.productAmount)
				.append("productPromotionCode", this.productPromotionCode);
		return localToStringBuilder.getStringBuffer().toString();
	}
}