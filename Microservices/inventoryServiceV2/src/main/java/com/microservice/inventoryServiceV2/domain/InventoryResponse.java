package com.microservice.inventoryServiceV2.domain;

public class InventoryResponse {
	 private String skuCode;
	 private boolean isInStock;
	public String getSkuCode() {
		return skuCode;
	}
	public void setSkuCode(String skuCode) {
		this.skuCode = skuCode;
	}
	public boolean isInStock() {
		return isInStock;
	}
	public void setInStock(boolean isInStock) {
		this.isInStock = isInStock;
	}
	public InventoryResponse(String skuCode, boolean isInStock) {
		super();
		this.skuCode = skuCode;
		this.isInStock = isInStock;
	}
	public InventoryResponse() {
		super();
	}
	@Override
	public String toString() {
		return "InventoryResponse [skuCode=" + skuCode + ", isInStock=" + isInStock + "]";
	}
	 
	 

}
