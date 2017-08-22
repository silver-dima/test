package com.mabaya.test.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Entity
@Getter
@Setter
@EqualsAndHashCode
public class Campaign implements Serializable {

    public enum Status {
        waitingForStart, active, finished
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    private Category category;

    private BigDecimal bid;

    @OneToMany
    private List<Product> products = new ArrayList<>();

    private LocalDate startDate;

    private LocalDate endDate;

    private Status status = Status.waitingForStart;

    public void setProduct(Product product) {
        this.products.add(product);
    }
}
