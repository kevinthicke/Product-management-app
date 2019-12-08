package com.bitbox.app.model;

import lombok.*;

import java.io.Serializable;

@Getter @Setter
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class Supplier_Product_PK implements Serializable {

    private static final long serialVersionUID = -851696929159570973L;

    private long productPk;
    private long supplierPk;

}
