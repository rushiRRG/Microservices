package com.microservice.inventoryServiceV2.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.microservice.inventoryServiceV2.domain.Inventory;


public interface InventoryRepository extends JpaRepository<Inventory, Long>{

	List<Inventory> findBySkuCodeIn(List<String> skuCode);

}
