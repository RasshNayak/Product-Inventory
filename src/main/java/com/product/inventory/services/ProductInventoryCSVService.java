package com.product.inventory.services;

import com.product.inventory.entity.ProductInventoryEntity;
import com.product.inventory.helper.ProductInventoryCSVHelper;
import com.product.inventory.repository.ProductInventoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
public class ProductInventoryCSVService {

    @Autowired
    private ProductInventoryRepository productInventoryRepository;


    public void save(MultipartFile file) {
        try {
            List<ProductInventoryEntity> productInventoryEntities =
                    ProductInventoryCSVHelper.importCSVToDatabase(file.getInputStream());
            productInventoryRepository.saveAll(productInventoryEntities);
        } catch (IOException e) {
            throw new RuntimeException("failed to store csv data: " + e.getMessage());
        }
    }

    public List<ProductInventoryEntity> getAllInventoryEntities() {

        return productInventoryRepository.findAll();
    }
}

