package com.product.inventory.controller;

import com.product.inventory.entity.ProductInventoryEntity;
import com.product.inventory.helper.ProductInventoryCSVHelper;
import com.product.inventory.services.ProductInventoryCSVService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;


import java.util.List;
import java.util.Map;

@RestController
public class ProductInventoryCSVController {
    @Autowired
    private ProductInventoryCSVService productInventoryCSVService;

    @RequestMapping("/")
    public String index() {
        return "uploadPage";
    }

    //@GetMapping("/product")
    public ResponseEntity<List<ProductInventoryEntity>> getAllInventoryEntities() {
        try {
            List<ProductInventoryEntity> productInventoryEntities =
                    productInventoryCSVService.getAllInventoryEntities();

            if (productInventoryEntities.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(productInventoryEntities, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    //@PostMapping("/product/upload")
    public ResponseEntity<?> upload(@RequestParam("file")MultipartFile file){
        if (ProductInventoryCSVHelper.validateCSVFormat(file)){
            this.productInventoryCSVService.save(file);
            return ResponseEntity.ok(Map.of("message","File is uploaded and data is saved to DB"));
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Please Upload Excel file");
    }

}
