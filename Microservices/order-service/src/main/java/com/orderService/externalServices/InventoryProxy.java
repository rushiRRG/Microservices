package com.orderService.externalServices;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.orderService.domain.Inventory;


@FeignClient(name = "inventoryServiceV2",url = "localhost:8082")
public interface InventoryProxy {
	
	@GetMapping("/inventory")
	public List<Inventory> checkStockInInventory(@RequestParam List<String> skuCodeList);

}
