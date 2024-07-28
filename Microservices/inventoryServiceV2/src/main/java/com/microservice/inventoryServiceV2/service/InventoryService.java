package com.microservice.inventoryServiceV2.service;

import java.util.List;
import com.microservice.inventoryServiceV2.domain.Inventory;
import com.microservice.inventoryServiceV2.repository.InventoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;

@Service
public class InventoryService {
	
	@Autowired
	InventoryRepository inventoryRepository;
	
	@Transactional
	public List<Inventory> isInStock(List<String> skuCodeList) {
		
		List<Inventory> inventoryList = inventoryRepository.findBySkuCodeIn(skuCodeList);
		System.out.println(inventoryList);
		
		for(Inventory inventory : inventoryList) {
			
			inventory.setInStock(inventory.getQuantity() > 0 );
		}
		
		return inventoryList;				
		
	}

}
