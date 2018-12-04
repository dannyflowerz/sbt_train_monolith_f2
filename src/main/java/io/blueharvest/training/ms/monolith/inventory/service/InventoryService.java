package io.blueharvest.training.ms.monolith.inventory.service;

import java.util.List;

import io.blueharvest.training.ms.monolith.inventory.domain.entity.Product;

public interface InventoryService {

    void add(Product product);

    List<Product> getAllProducts();

    String reserve(String productName);

    void dispense(String reservationCode);

}
