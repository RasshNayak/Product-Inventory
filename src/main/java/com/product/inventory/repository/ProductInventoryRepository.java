package com.product.inventory.repository;

import com.product.inventory.entity.ProductInventoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductInventoryRepository extends JpaRepository <ProductInventoryEntity,String> {

}
