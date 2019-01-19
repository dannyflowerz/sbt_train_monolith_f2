package io.blueharvest.training.ms.monolith.order.presentation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import io.blueharvest.training.ms.monolith.order.domain.model.OrderRequest;
import io.blueharvest.training.ms.monolith.order.service.OrderService;

@RestController
public class OrderController {

    private final OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping(path = "/orders")
    public void placeOrder(@RequestBody OrderRequest orderRequest) {
        orderService.placeOrder(orderRequest.getProductName());
    }

}
