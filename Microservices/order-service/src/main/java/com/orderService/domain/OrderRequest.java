package com.orderService.domain;

import java.util.List;

public class OrderRequest {
	
	    private List<OrderLineItems> orderLineItemsDtoList;

		public List<OrderLineItems> getOrderLineItemsDtoList() {
			return orderLineItemsDtoList;
		}

		public void setOrderLineItemsDtoList(List<OrderLineItems> orderLineItemsDtoList) {
			this.orderLineItemsDtoList = orderLineItemsDtoList;
		}

		public OrderRequest(List<OrderLineItems> orderLineItemsDtoList) {
			super();
			this.orderLineItemsDtoList = orderLineItemsDtoList;
		}

		public OrderRequest() {
			super();
		}

		@Override
		public String toString() {
			return "OrderRequest [orderLineItemsDtoList=" + orderLineItemsDtoList + "]";
		}
	    
	    
}
