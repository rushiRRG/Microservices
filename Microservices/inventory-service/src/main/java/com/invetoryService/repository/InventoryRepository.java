package com.invetoryService.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.invetoryService.domain.Inventory;

public interface InventoryRepository extends JpaRepository<Inventory, Long>{

	List<Inventory> findBySkuCodeIn(List<String> skuCode);

}
