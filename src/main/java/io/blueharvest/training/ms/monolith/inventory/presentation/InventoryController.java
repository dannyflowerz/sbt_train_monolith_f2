package io.blueharvest.training.ms.monolith.inventory.presentation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import io.blueharvest.training.ms.monolith.inventory.domain.entity.Product;
import io.blueharvest.training.ms.monolith.inventory.service.InventoryService;

@RestController
public class InventoryController {

    private final InventoryService inventoryService;

    @Autowired
    public InventoryController(InventoryService inventoryService) {
        this.inventoryService = inventoryService;
    }

    @PostMapping(path = "/products")
    public void addProduct(@RequestBody Product product) {
        inventoryService.add(product);
    }

    @GetMapping(path = "/products")
    public List<Product> getProducts() {
        return inventoryService.getAllProducts();
    }

}
