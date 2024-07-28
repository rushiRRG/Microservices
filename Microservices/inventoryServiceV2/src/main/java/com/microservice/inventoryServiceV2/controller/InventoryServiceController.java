package com.microservice.inventoryServiceV2.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.microservice.inventoryServiceV2.domain.Inventory;
import com.microservice.inventoryServiceV2.service.InventoryService;

@RestController
@RequestMapping("/inventory")
public class InventoryServiceController {
	
	@Autowired
	InventoryService inventoryService;

	@GetMapping
	@ResponseStatus(HttpStatus.OK)
	public List<Inventory> isInStock(@RequestParam List<String> skuCodeList) {
		return inventoryService.isInStock(skuCodeList);
		
	}

}
