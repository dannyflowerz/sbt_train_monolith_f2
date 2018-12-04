package io.blueharvest.training.ms.monolith.inventory.data;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import io.blueharvest.training.ms.monolith.inventory.domain.entity.Product;

public interface ProductRepository extends CrudRepository<Product, Long> {

    List<Product> findAll();

    Product getFirstByNameAndReservationCodeIsNull(String name);

    void deleteByReservationCode(String reservationCode);

}
