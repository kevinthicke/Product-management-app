package com.bitbox.app.dto;

import com.bitbox.app.model.entity.PriceReduction;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Getter @Setter
@NoArgsConstructor
public class ProductDto {

    private Long id;
    private String Description;
    private Boolean state = true;
    private Date createdAt;
    private List<PriceReduction> priceReductions = new ArrayList<PriceReduction>();
    private List<SupplierDto> suppliersDto = new ArrayList<SupplierDto>();

}
