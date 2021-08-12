package com.gradle.project.model;

import java.math.BigDecimal;
import java.sql.Timestamp;

public class Product {

	int id;
	BigDecimal productNumber;
	String productName;
	BigDecimal productCost;
	String productCategory;
	Timestamp lastUpdateTimestamp;

	public Product(BigDecimal productNumber, String productName, BigDecimal productCost, String productCategory) {

		this.productNumber = productNumber;
		this.productName = productName;
		this.productCost = productCost;
		this.productCategory = productCategory;

	}

	public Product(int id, BigDecimal productNumber, String productName, BigDecimal productCost, String productCategory, Timestamp lastUpdateTimestamp) {

		this.id = id;
		this.productNumber = productNumber;
		this.productName = productName;
		this.productCost = productCost;
		this.productCategory = productCategory;
		this.lastUpdateTimestamp = lastUpdateTimestamp;

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public BigDecimal getProductNumber() {
		return productNumber;
	}

	public void setProductNumber(BigDecimal productNumber) {
		this.productNumber = productNumber;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public BigDecimal getProductCost() {
		return productCost;
	}

	public void setProductCost(BigDecimal productCost) {
		this.productCost = productCost;
	}

	public String getProductCategory() {
		return productCategory;
	}

	public void setProductCategory(String productCategory) {
		this.productCategory = productCategory;
	}

	public Timestamp getLastUpdateTimestamp() {
		return lastUpdateTimestamp;
	}

	public void setLastUpdateTimestamp(Timestamp lastUpdateTimestamp) {
		this.lastUpdateTimestamp = lastUpdateTimestamp;
	}
}
