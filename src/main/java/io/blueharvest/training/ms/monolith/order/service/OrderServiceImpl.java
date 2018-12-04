package io.blueharvest.training.ms.monolith.order.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.blueharvest.training.ms.monolith.Constants;
import io.blueharvest.training.ms.monolith.inventory.service.InventoryService;
import io.blueharvest.training.ms.monolith.order.domain.exception.OrderException;
import io.blueharvest.training.ms.monolith.shipping.service.ShippingService;

@Service
class OrderServiceImpl implements OrderService {

    private final InventoryService inventoryService;
    private final ShippingService shippingService;

    @Autowired
    public OrderServiceImpl(InventoryService inventoryService, ShippingService shippingService) {
        this.inventoryService = inventoryService;
        this.shippingService = shippingService;
    }

    @Override
    public void placeOrder(String productName) {
        String reservationCode = inventoryService.reserve(productName);
        if (Constants.NO_PRODUCT_AVAILABLE_CODE.equals(reservationCode)) {
            throw new OrderException("Unable to place new order, out of stock");
        }
        shippingService.requestShipping(reservationCode);
    }

}
