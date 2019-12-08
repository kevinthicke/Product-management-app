package com.bitbox.app.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter @Setter
@NoArgsConstructor
public class ProductMinimized {

    private Long id;
    private String description;
    private boolean state;
    private float price;
    private Date createdAt;

}
