package io.blueharvest.training.ms.monolith.shipping.presentation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.blueharvest.training.ms.monolith.shipping.domain.model.ShippingConfirmation;
import io.blueharvest.training.ms.monolith.shipping.service.ShippingService;

@RequestMapping("/api/shipping-service")
@RestController
public class ShippingController {

    private final ShippingService shippingService;

    @Autowired
    public ShippingController(ShippingService shippingService) {
        this.shippingService = shippingService;
    }

    @PostMapping(path = "/confirmations")
    public void receiveConfirmation(@RequestBody ShippingConfirmation shippingConfirmation) {
        shippingService.confirmShipping(shippingConfirmation.getReservationCode());
    }

}
