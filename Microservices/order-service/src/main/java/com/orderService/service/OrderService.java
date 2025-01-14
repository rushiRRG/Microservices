package com.orderService.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.orderService.domain.Inventory;
import com.orderService.domain.Order;
import com.orderService.domain.OrderLineItems;
import com.orderService.domain.OrderRequest;
import com.orderService.event.OrderPlacedEvent;
import com.orderService.externalServices.InventoryProxy;
import com.orderService.repository.OrderRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class OrderService {
	
	@Autowired
	OrderRepository orderRepository;
	
	@Autowired
	private InventoryProxy inventoryProxy;
	
	@Autowired
	private KafkaTemplate<String,OrderPlacedEvent> kafkaTemplate;
	
	
	public void placeOrder(OrderRequest orderRequest) throws Exception {
		Order order = new Order();
		order.setOrderNumber(UUID.randomUUID().toString());
		order.setOrderLineItemsList(orderRequest.getOrderLineItemsDtoList());
		
		List<String> skuCodeList = order.getOrderLineItemsList().stream()
		.map(orderReq -> orderReq.getSkuCode()).toList();
		
		//call inventory service to check availability of product
		List<Inventory> itemAvailabilityList = inventoryProxy.checkStockInInventory(skuCodeList);
		
		if(itemAvailabilityList.isEmpty()) {
			throw new Exception("Products are not in stock.Please try again later.");
		}
		
		Boolean allProductInStock = itemAvailabilityList.stream().allMatch(product -> product.getInStock() == true);
		if(allProductInStock) {
			orderRepository.save(order);
		}else {
			throw new Exception("One of the product is not in stock.Please try again later.");
		}
		
		kafkaTemplate.send("notificationTopic",new OrderPlacedEvent(order.getOrderNumber()));
		
	}


	
}
