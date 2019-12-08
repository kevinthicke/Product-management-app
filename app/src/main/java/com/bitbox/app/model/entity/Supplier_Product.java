package com.bitbox.app.model.entity;


import com.bitbox.app.model.Supplier_Product_PK;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@IdClass(Supplier_Product_PK.class)
@Table(name = "SUPPLIER_PRODUCT")
public class Supplier_Product implements Serializable {

        @Id
        @Column(name = "PRODUCT_ID")
        private long productPk;

        @Id
        @Column(name = "SUPPLIER_ID")
        private long supplierPk;

}


