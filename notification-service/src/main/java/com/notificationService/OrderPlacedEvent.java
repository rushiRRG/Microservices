package com.notificationService;

public class OrderPlacedEvent {
	 public OrderPlacedEvent() {
		super();
	}

	public OrderPlacedEvent(String orderNumber) {
		super();
		this.orderNumber = orderNumber;
	}

	private String orderNumber;

	public String getOrderNumber() {
		return orderNumber;
	}

	public void setOrderNumber(String orderNumber) {
		this.orderNumber = orderNumber;
	}

}
