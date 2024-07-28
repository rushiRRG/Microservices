package com.invetoryService.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.invetoryService.domain.Inventory;
import com.invetoryService.domain.InventoryResponse;
import com.invetoryService.repository.InventoryRepository;

import jakarta.transaction.Transactional;

@Service
public class InventoryService {
	
	@Autowired
	InventoryRepository inventoryRepository;
	
	@Transactional
	public List<Inventory> isInStock(List<String> skuCodeList) {
		
		List<Inventory> inventoryList = inventoryRepository.findBySkuCodeIn(skuCodeList);
		
		for(Inventory inventory : inventoryList) {
			
			inventory.setInStock(inventory.getQuantity() > 0 );
		}
		
		return inventoryList;				
		
	}

}
