package io.blueharvest.training.ms.monolith.shipping.service;

public interface ShippingService {

    void requestShipping(String reservationCode);

    void confirmShipping(String reservationCode);

}
