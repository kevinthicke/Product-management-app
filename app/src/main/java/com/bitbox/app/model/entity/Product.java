package com.bitbox.app.model.entity;

import com.bitbox.app.model.entity.PriceReduction;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "PRODUCT")
@Getter @Setter
public class Product {

    @Id
    @Column(name = "ID", unique = true)
    private Long id;

    @Column(name = "DESCRIPTION")
    private String Description;

    @Column(name = "STATE")
    private boolean state = true;

    @Column(name = "PRICE")
    private float price;

    @Column(name = "CREATED_AT")
    private Date createdAt;

    @JoinColumn(name = "PRODUCT_ID")
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private List<PriceReduction> priceReductions = new ArrayList<PriceReduction>();

}
