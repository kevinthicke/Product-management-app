package com.bitbox.app.dto;

import com.bitbox.app.model.entity.Product;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter @Setter
@NoArgsConstructor
public class SupplierDto {

    private Long id;
    private String name;
    private String country;
    private List<Product> products = new ArrayList<Product>();

}
