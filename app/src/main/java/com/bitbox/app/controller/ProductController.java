package com.bitbox.app.controller;

import com.bitbox.app.model.entity.Product;
import com.bitbox.app.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated
@RestController
@RequestMapping(value = "/api")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping(value = "/products/{id}")
    public ResponseEntity<Product> findById(@PathVariable(name = "id") long id) {
        return new ResponseEntity<>(
                this.productService.findById(id),
                HttpStatus.OK
        );
    }

}
