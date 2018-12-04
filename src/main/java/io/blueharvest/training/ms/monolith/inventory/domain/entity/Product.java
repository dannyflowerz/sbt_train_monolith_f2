package io.blueharvest.training.ms.monolith.inventory.domain.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;

@Getter
@Entity
public class Product {

    @Id
    @GeneratedValue
    private Long productId;
    @NotNull
    private String name;
    @Setter
    private String reservationCode;

}
