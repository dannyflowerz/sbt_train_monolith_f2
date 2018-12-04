package io.blueharvest.training.ms.monolith.inventory.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import io.blueharvest.training.ms.monolith.Constants;
import io.blueharvest.training.ms.monolith.inventory.data.ProductRepository;
import io.blueharvest.training.ms.monolith.inventory.domain.entity.Product;

@Service
class InventoryServiceImpl implements InventoryService {

    private final ProductRepository productRepository;

    @Autowired
    public InventoryServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public void add(Product product) {
        productRepository.save(product);
    }

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    @Transactional
    public String reserve(String productName) {
        Product product = productRepository.getFirstByNameAndReservationCodeIsNull(productName);
        if (product == null) {
            return Constants.NO_PRODUCT_AVAILABLE_CODE;
        }
        String reservationCode = UUID.randomUUID().toString();
        product.setReservationCode(reservationCode);
        productRepository.save(product);
        return reservationCode;
    }

    @Override
    @Transactional
    public void dispense(String reservationCode) {
        productRepository.deleteByReservationCode(reservationCode);
    }

}
