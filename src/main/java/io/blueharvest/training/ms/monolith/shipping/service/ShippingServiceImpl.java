package io.blueharvest.training.ms.monolith.shipping.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.blueharvest.training.ms.monolith.inventory.service.InventoryService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
class ShippingServiceImpl implements ShippingService {

    private final InventoryService inventoryService;

    @Autowired
    public ShippingServiceImpl(InventoryService inventoryService) {
        this.inventoryService = inventoryService;
    }

    @Override
    public void requestShipping(String reservationCode) {
        log.info("Shipping request received for reservation code: {}", reservationCode);
    }

    @Override
    public void confirmShipping(String reservationCode) {
        inventoryService.dispense(reservationCode);
    }

}
